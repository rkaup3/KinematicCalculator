package com.example.rishab.kinematicscalculator;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rishab.kinematicscalculator.calculations.Calculations;
import com.example.rishab.kinematicscalculator.kinCalculations.KinCalculations;
import com.example.rishab.kinematicscalculator.kinCalculations.Results;

public class InputFragment
        extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Calculations kinCalculations;
    private OnFragmentInteractionListener mListener;
    private String mParam1;
    private String mParam2;





    EditText accText;
    EditText dispText;
    EditText finalVelText;
    EditText initVelText;
    EditText timeText;


    public InputFragment() {
        Calculations calculations = new Calculations();
        this.kinCalculations = calculations;
    }

    public static InputFragment newInstance(String paramString1, String paramString2) {
        InputFragment inputFragmentVw = new InputFragment();
        Bundle localBundle = new Bundle();
        localBundle.putString("param1", paramString1);
        localBundle.putString("param2", paramString2);
        inputFragmentVw.setArguments(localBundle);
        return inputFragmentVw;
    }

    public void onAttach(Activity paramActivity) {
        super.onAttach(paramActivity);
        try {
            this.mListener = ((OnFragmentInteractionListener) paramActivity);

        } catch (ClassCastException localClassCastException1) {
            StringBuilder localStringBuilder = new StringBuilder();
            ClassCastException localClassCastException = new ClassCastException(paramActivity.toString() + " must implement OnFragmentInteractionListener");
            throw localClassCastException;
        }


    }

    public void clearAllInputs() {
        initVelText.setText("");
        finalVelText.setText("");
        accText.setText("");
        dispText.setText("");
        timeText.setText("");
    }

    public void onButtonPressed(Uri paramUri) {
        if (this.mListener != null) {
            this.mListener.onFragmentInteraction(paramUri);
        }
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString("param1");
            this.mParam2 = getArguments().getString("param2");
        }
    }


    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        View inputFragmentVw = paramLayoutInflater.inflate(R.layout.activity_input, paramViewGroup, false);

        this.initVelText = ((EditText) inputFragmentVw.findViewById(R.id.initialVelocity));
        this.finalVelText = ((EditText) inputFragmentVw.findViewById(R.id.finalVelocity));
        this.accText = ((EditText) inputFragmentVw.findViewById(R.id.acceleration));
        this.dispText = ((EditText) inputFragmentVw.findViewById(R.id.displacement));
        this.timeText = ((EditText) inputFragmentVw.findViewById(R.id.time));


        Button Solve = (Button) inputFragmentVw.findViewById(R.id.solve);
        Button Equation = (Button) inputFragmentVw.findViewById(R.id.equations);
        Button Clear = (Button) inputFragmentVw.findViewById(R.id.clear);


        View.OnClickListener clear = new View.OnClickListener() {


            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(17);

                Log.d("KIN_CLEAR", "clear onClick called...");
                clearAllInputs();
                Log.d("KIN_CLEAR", "values cleared");
            }
        };
        Clear.setOnClickListener(clear);

        View.OnClickListener equations = new View.OnClickListener() {
            public void onClick(View view) {
                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(17);
                Log.d("KIN_EQUATIONS", "equations onClick called...");
                FragmentTransaction localFragmentTransaction = InputFragment.this.getFragmentManager().beginTransaction();
                localFragmentTransaction.replace(R.id.frame_container, KinematicEquationsFragment.newInstance("", ""));
                localFragmentTransaction.commit();

            }
        };

        Equation.setOnClickListener(equations);


        View.OnClickListener solve = new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(17);
                Log.d("KIN_SOLVE", "solve onClick called...");
                double initVelDbl = 0;
                String initVelStr = InputFragment.this.initVelText.getText().toString();
                double finalVelDbl = 0;
                String finalVelStr = InputFragment.this.finalVelText.getText().toString();
                double accDbl = 0;
                String accStr = InputFragment.this.accText.getText().toString();
                double dispDbl = 0;
                String dispStr = InputFragment.this.dispText.getText().toString();
                double timeDbl = 0;
                String timeStr = InputFragment.this.timeText.getText().toString();


                if (!initVelStr.isEmpty()) {
                    initVelDbl = Double.parseDouble(initVelStr);
                    StringBuilder localStringBuilder = new StringBuilder();
                    Log.d("KIN_SOLVE", "Val entered for init Vel : " + initVelStr);
                }
                if (!finalVelStr.isEmpty()) {
                    finalVelDbl = Double.parseDouble(finalVelStr);
                    StringBuilder localStringBuilder14 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Val entered for fin Vel : " + finalVelStr);
                }
                if (!accStr.isEmpty()) {
                    accDbl = Double.parseDouble(accStr);
                    StringBuilder localStringBuilder13 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Val entered for acc : " + accStr);
                }
                if (!dispStr.isEmpty()) {
                    dispDbl = Double.parseDouble(dispStr);
                    StringBuilder localStringBuilder12 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Val entered for disp : " + dispStr);
                }
                if (!timeStr.isEmpty()) {
                    timeDbl = Double.parseDouble(timeStr);
                    StringBuilder localStringBuilder11 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Val entered for time : " + timeStr);
                }


                //************************************************************** Situations For Calculations***************************************************************

                if ((accStr.isEmpty()) && (dispStr.isEmpty()) && (!initVelStr.isEmpty()) && (!finalVelStr.isEmpty()) && (!timeStr.isEmpty())) {
                    Results results = KinCalculations.findAccelerationAndDisplacement(initVelDbl, finalVelDbl, timeDbl);
                    InputFragment.this.showResult(results);
                    Log.d("KIN_SOLVE", "called 1");
                    StringBuilder localStringBuilder10 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Acc =" + results.acc + " Disp =" + results.displacement);
                    return;
                }
                if ((accStr.isEmpty()) && (timeStr.isEmpty()) && (!initVelStr.isEmpty()) && (!finalVelStr.isEmpty()) && (!dispStr.isEmpty())) {
                    Results results = KinCalculations.findAccelerationAndTime(initVelDbl, finalVelDbl, dispDbl);
                    InputFragment.this.showResult(results);
                    Log.d("KIN_SOLVE", "called 2");
                    StringBuilder localStringBuilder9 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Acc =" + results.acc + " Time =" + results.time);
                    return;
                }
                if ((accStr.isEmpty()) && (initVelStr.isEmpty()) && (!timeStr.isEmpty()) && (!finalVelStr.isEmpty()) && (!dispStr.isEmpty())) {
                    Results results = KinCalculations.findAccelerationAndInitialVelocity(dispDbl, timeDbl, finalVelDbl);
                    InputFragment.this.showResult(results);
                    Log.d("KIN_SOLVE", "called 3");
                    StringBuilder localStringBuilder8 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Acc =" + results.acc + " InitVel =" + results.initVel);
                    return;
                }
                if ((accStr.isEmpty()) && (finalVelStr.isEmpty()) && (!initVelStr.isEmpty()) && (!timeStr.isEmpty()) && (!dispStr.isEmpty())) {
                    Results results = KinCalculations.findAccelerationAndFinalVelocity(dispDbl, timeDbl, initVelDbl);
                    InputFragment.this.showResult(results);
                    Log.d("KIN_SOLVE", "called 4");
                    StringBuilder localStringBuilder7 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Acc =" + results.acc + " FinalVel =" + results.finalVel);
                    return;
                }
                if ((dispStr.isEmpty()) && (timeStr.isEmpty()) && (!initVelStr.isEmpty()) && (!finalVelStr.isEmpty()) && (!accStr.isEmpty())) {
                    Results results = KinCalculations.findDisplacementAndTime(finalVelDbl, initVelDbl, accDbl);
                    InputFragment.this.showResult(results);
                    Log.d("KIN_SOLVE", "called 5");
                    StringBuilder localStringBuilder6 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Disp =" + results.displacement + " Time =" + results.time);
                    return;
                }
                if ((dispStr.isEmpty()) && (initVelStr.isEmpty()) && (!accStr.isEmpty()) && (!finalVelStr.isEmpty()) && (!timeStr.isEmpty())) {
                    Results results = KinCalculations.findDisplacementAndInitialVelocity(finalVelDbl, accDbl, timeDbl);
                    InputFragment.this.showResult(results);
                    Log.d("KIN_SOLVE", "called 6");
                    StringBuilder localStringBuilder5 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Disp =" + results.displacement + " Init Vel =" + results.initVel);
                    return;
                }
                if ((dispStr.isEmpty()) && (finalVelStr.isEmpty()) && (!initVelStr.isEmpty()) && (!timeStr.isEmpty()) && (!accStr.isEmpty())) {
                    Results results = KinCalculations.findDisplacementAndFinalVelocity(initVelDbl, timeDbl, accDbl);
                    InputFragment.this.showResult(results);
                    Log.d("KIN_SOLVE", "called 7");
                    StringBuilder localStringBuilder4 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Disp =" + results.displacement + " Fin Vel =" + results.finalVel);
                    return;
                }
                if ((timeStr.isEmpty()) && (initVelStr.isEmpty()) && (!accStr.isEmpty()) && (!finalVelStr.isEmpty()) && (!dispStr.isEmpty())) {
                    Results results = KinCalculations.findTimeAndInitialVelocity(finalVelDbl, accDbl, dispDbl);
                    InputFragment.this.showResult(results);
                    Log.d("KIN_SOLVE", "called 8");
                    StringBuilder localStringBuilder3 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Time =" + results.time + " Init Vel =" + results.initVel);
                    return;
                }
                if ((timeStr.isEmpty()) && (finalVelStr.isEmpty()) && (!initVelStr.isEmpty()) && (!accStr.isEmpty()) && (!dispStr.isEmpty())) {
                    Results results = KinCalculations.findTimeAndFinalVelocity(initVelDbl, accDbl, dispDbl);
                    InputFragment.this.showResult(results);
                    Log.d("KIN_SOLVE", "called 9");
                    StringBuilder localStringBuilder2 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Time =" + results.time + " Fin Vel =" + results.finalVel);
                    return;
                }
                if ((initVelStr.isEmpty()) && (finalVelStr.isEmpty()) && (!accStr.isEmpty()) && (!timeStr.isEmpty()) && (!dispStr.isEmpty())) {
                    Results results = KinCalculations.findInitialVelocityAndFinalVelocity(dispDbl, accDbl, timeDbl);
                    InputFragment.this.showResult(results);
                    Log.d("KIN_SOLVE", "called 10");
                    StringBuilder localStringBuilder1 = new StringBuilder();
                    Log.d("KIN_SOLVE", "Init Vel =" + results.initVel + " Fin Vel =" + results.finalVel);
                    return;
                }

                Log.d("KIN_SOLVE", "There are less or more than 3 values entered");
                InputFragment.this.showMessage("Please enter exactly 3 values", 1);
            }
        };
        Solve.setOnClickListener(solve);
        return inputFragmentVw;
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = null;
    }

    public void showMessage(String paramString, int paramInt) {
        Toast.makeText(getActivity(), paramString, paramInt).show();
    }

    public void showResult(final Results Results) {
        Log.d("KIN_SOLVE", "showResult called");
        Handler localHandler = new Handler();
        Runnable local4 = new Runnable() {
            public void run() {
                Log.d("KIN_SOLVE", " Updating UI ...");
                String accStr;
                String dispStr;
                String finVelStr;
                String initVelStr;
                String timeStr;

                switch (Results.resultType) {

                    case 1:
                        accStr = Double.toString(Results.acc);
                        dispStr = Double.toString(Results.displacement);
                        InputFragment.this.accText.setText(accStr);
                        InputFragment.this.dispText.setText(dispStr);
                        return;

                    case 4:
                        accStr = Double.toString(Results.acc);
                        finVelStr = Double.toString(Results.finalVel);
                        InputFragment.this.accText.setText(accStr);
                        InputFragment.this.finalVelText.setText(finVelStr);
                        return;
                    case 3:
                        accStr = Double.toString(Results.acc);
                        initVelStr = Double.toString(Results.initVel);
                        InputFragment.this.accText.setText(accStr);
                        InputFragment.this.initVelText.setText(initVelStr);
                        return;
                    case 2:
                        accStr = Double.toString(Results.acc);
                        timeStr = Double.toString(Results.time);
                        InputFragment.this.accText.setText(accStr);
                        InputFragment.this.timeText.setText(timeStr);
                        return;
                    case 7:
                        dispStr = Double.toString(Results.displacement);
                        finVelStr = Double.toString(Results.finalVel);
                        InputFragment.this.dispText.setText(dispStr);
                        InputFragment.this.finalVelText.setText(finVelStr);
                        return;
                    case 6:
                        dispStr = Double.toString(Results.displacement);
                        initVelStr = Double.toString(Results.initVel);
                        InputFragment.this.dispText.setText(dispStr);
                        InputFragment.this.initVelText.setText(initVelStr);
                        return;
                    case 5:
                        dispStr = Double.toString(Results.displacement);
                        timeStr = Double.toString(Results.time);
                        InputFragment.this.dispText.setText(dispStr);
                        InputFragment.this.timeText.setText(timeStr);
                        return;
                    case 9:
                        finVelStr = Double.toString(Results.finalVel);
                        timeStr = Double.toString(Results.time);
                        InputFragment.this.finalVelText.setText(finVelStr);
                        InputFragment.this.timeText.setText(timeStr);
                        return;
                    case 8:
                        initVelStr = Double.toString(Results.initVel);
                        timeStr = Double.toString(Results.time);
                        InputFragment.this.initVelText.setText(initVelStr);
                        InputFragment.this.timeText.setText(timeStr);
                        return;
                    case 10:
                        initVelStr = Double.toString(Results.initVel);
                        finVelStr = Double.toString(Results.finalVel);
                        InputFragment.this.initVelText.setText(initVelStr);
                        InputFragment.this.finalVelText.setText(finVelStr);
                        return;
                    default:
                        return;
                }

            }

        };
        localHandler.post(local4);
    }

    public static abstract interface OnFragmentInteractionListener {
        public abstract void onFragmentInteraction(Uri paramUri);
    }
}