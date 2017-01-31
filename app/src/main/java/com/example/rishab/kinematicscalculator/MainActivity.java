package com.example.rishab.kinematicscalculator;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity
        extends Activity
        implements InputFragment.OnFragmentInteractionListener, KinematicEquationsFragment.OnFragmentInteractionListener {


    private SensorEventListener mSensorListener;

    private SensorManager mSensorManager;
    private float mAccel; // acceleration apart from gravity
    private float mAccelCurrent; // current acceleration including gravity
    private float mAccelLast; // last acceleration including gravity
    private InputFragment inputFragInstance;

    public MainActivity() {


        mSensorListener = new SensorEventListener() {

            public void onSensorChanged(SensorEvent se) {
                float x = se.values[0];
                float y = se.values[1];
                float z = se.values[2];
                mAccelLast = mAccelCurrent;
                mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
                float delta = mAccelCurrent - mAccelLast;
                mAccel = mAccel * 0.9f + delta; // perform low-cut filter

                if (mAccel > 12) {
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                    Toast toast = Toast.makeText(getApplicationContext(), "Clearing...", Toast.LENGTH_SHORT);
                    toast.show();

                    inputFragInstance.clearAllInputs();

                    vibrator.vibrate(17);
                    }
                }


            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };

        //


    }





    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        mAccel = 0.00f;
        mAccelCurrent = SensorManager.GRAVITY_EARTH;
        mAccelLast = SensorManager.GRAVITY_EARTH;


        Log.d("MyTag", "My First log message....");
        setContentView(R.layout.activity_main);
        FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
        inputFragInstance = InputFragment.newInstance("", "");
        localFragmentTransaction.replace(R.id.frame_container,inputFragInstance );
        localFragmentTransaction.commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void onFragmentInteraction(Uri paramUri) {
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
    }
}