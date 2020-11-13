package com.example.notificationscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/* JobScheduler runs background services for API 21 and higher.
To use the JobScheduler, you need two parts: JobService and JobInfo.
1. JobInfo is a set of conditions that trigger the job to run.
2. JobService implements the job to run under the conditions specified by JobInfo.
Need onStartJob() and onStopJob() callback methods,
The onStartJob() method returns a boolean value that indicates whether the service needs to process the work in a separate thread.
If onStartJob() returns true, you must explicitly call jobFinished(). If onStartJob() returns false, the runtime calls jobFinished() on your behalf.
JobService is processed on the main thread, so you should avoid lengthy calculations or I/O.
JobScheduler is the manager class responsible for scheduling the task.
JobScheduler batches tasks to maximize the efficiency of system resources, which means that you do not have exact control of when tasks are executed.
 */
public class MainActivity extends AppCompatActivity {

    private static final int JOB_ID = 0;
    private JobScheduler mScheduler;

    // Switches for setting job options.
    private Switch mDeviceIdleSwitch;
    private Switch mDeviceChargingSwitch;

    // Override deadline seekbar.
    private SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDeviceIdleSwitch = findViewById(R.id.idleSwitch);
        mDeviceChargingSwitch = findViewById(R.id.chargingSwitch);
        mSeekBar = findViewById(R.id.seekBar);

        final TextView seekBarProgress = findViewById(R.id.seekBarProgress);

        //use getSystemService() to initialize mScheduler
        mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        // Updates the TextView with the value from the seekbar.
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i > 0) {
                    seekBarProgress.setText(getString(R.string.seconds, i));
                } else {
                    seekBarProgress.setText(R.string.not_set);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    /*schedules the jobs based on the parameters set.
     */
    public void scheduleJob(View view) {
        RadioGroup networkOptions = findViewById(R.id.networkOptions);

        int selectedNetworkID = networkOptions.getCheckedRadioButtonId();

        int selectedNetworkOption = JobInfo.NETWORK_TYPE_NONE;

        int seekBarInteger = mSeekBar.getProgress();
        boolean seekBarSet = seekBarInteger > 0;
        
        switch (selectedNetworkID) {
            case R.id.noNetwork:
                selectedNetworkOption = JobInfo.NETWORK_TYPE_NONE;//the job will run with or without a network connection. This is the default value.
                break;
            case R.id.anyNetwork:
                selectedNetworkOption = JobInfo.NETWORK_TYPE_ANY;//the job will run as long as a network (cellular, Wi-Fi) is available.
                break;
            case R.id.wifiNetwork:
                selectedNetworkOption = JobInfo.NETWORK_TYPE_UNMETERED; //the job will run as long as the device is connected to Wi-Fi that does not use a HotSpot.
                break;
        }

        /*create a JobInfo.Builder object
        The first parameter is the JOB_ID. The second parameter is the ComponentName for the JobService you created.
        The ComponentName is used to associate the JobService with the JobInfo object.
         */
        ComponentName serviceName = new ComponentName(getPackageName(), NotificationJobService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, serviceName)
                .setRequiredNetworkType(selectedNetworkOption)
                .setRequiresDeviceIdle(mDeviceIdleSwitch.isChecked())
                .setRequiresCharging(mDeviceChargingSwitch.isChecked());

        if (seekBarSet) {
            builder.setOverrideDeadline(seekBarInteger * 1000);
        }
        boolean constraintSet = selectedNetworkOption
                != JobInfo.NETWORK_TYPE_NONE
                || mDeviceChargingSwitch.isChecked()
                || mDeviceIdleSwitch.isChecked()
                || seekBarSet;

        if (constraintSet) {
            //Call schedule() on the JobScheduler object. Use the build() method to pass in the JobInfo object.
            JobInfo myJobInfo = builder.build();
            mScheduler.schedule(myJobInfo);
            Toast.makeText(this, R.string.job_scheduled, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.no_constraint_toast, Toast.LENGTH_SHORT).show();
        }
    }

    /*In the cancelJobs() method, check whether the JobScheduler object is null.
    If not, call cancelAll() on the object to remove all pending jobs. Also reset the JobScheduler to null
    and show a toast message to tell the user that the job was canceled.*/
    public void cancelJobs(View view) {

        if (mScheduler != null) {
            mScheduler.cancelAll();
            mScheduler = null;
            Toast.makeText(this, R.string.jobs_canceled, Toast.LENGTH_SHORT).show();
        }
    }
}