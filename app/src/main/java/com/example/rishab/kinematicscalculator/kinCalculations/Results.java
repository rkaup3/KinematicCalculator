package com.example.rishab.kinematicscalculator.kinCalculations;

/**
 * Created by Rishab on 2/8/2015.
 */
public class Results {
    public static final int TYPE_ACC_AND_DISP  = 1;
    public static final int TYPE_ACC_AND_TIME = 2;
    public static final int TYPE_ACC_AND_INITVEL  = 3;
    public static final int TYPE_ACC_AND_FINALVEL = 4;
    public static final int TYPE_DISP_AND_TIME  = 5;
    public static final int TYPE_DISP_AND_INITVEL = 6;
    public static final int TYPE_DISP_AND_FINALVEL  = 7;
    public static final int TYPE_TIME_AND_INITVEL = 8;
    public static final int TYPE_TIME_AND_FINALVEL  = 9;
    public static final int TYPE_INITVEL_AND_FINALVEL = 10;


    public int resultType;
    public double time;
    public double displacement;
    public double acc;
    public double initVel;
    public double finalVel;

}
