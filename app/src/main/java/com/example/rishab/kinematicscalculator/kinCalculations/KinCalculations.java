package com.example.rishab.kinematicscalculator.kinCalculations;

import javax.xml.transform.Result;

/**
* Created by Rishab on 2/1/2015.
*/
public class KinCalculations {



   public static Results findAccelerationAndDisplacement(double initialVelocity, double finalVelocity, double time) {
       double acceleration = (finalVelocity - initialVelocity)/ time;
       double displacement = (.5 * time * (initialVelocity + finalVelocity));

       Results results = new Results();
       results.resultType = Results.TYPE_ACC_AND_DISP;
       results.displacement = displacement;
       results.acc = acceleration;

       return results;
   }


   public static Results findAccelerationAndTime(double initialVelocity, double finalVelocity, double displacement) {
       double time = (2 * displacement) / (initialVelocity + finalVelocity);
       double acceleration = ((finalVelocity) - (initialVelocity)) / time;

       Results results = new Results();
       results.resultType = Results.TYPE_ACC_AND_TIME;
       results.time = time;
       results.acc = acceleration;

       return results;

   }

   public static Results findAccelerationAndInitialVelocity(double displacement, double time, double finalVelocity) {
       double initialVelocity = ((2 * displacement) / time) - finalVelocity;
       double acceleration = ((finalVelocity) - (initialVelocity)) / time;

       Results results = new Results();
       results.resultType = Results.TYPE_ACC_AND_INITVEL;
       results.initVel = initialVelocity;
       results.acc = acceleration;

       return results;


   }


   public static Results findAccelerationAndFinalVelocity(double displacement, double time, double initialVelocity) {
       double finalVelocity = ((2 * displacement / time)) - initialVelocity;
       double acceleration = ((finalVelocity) - (initialVelocity)) / time;

       Results results = new Results();
       results.resultType = Results.TYPE_ACC_AND_FINALVEL;
       results.finalVel = finalVelocity;
       results.acc = acceleration;

       return results;


   }

   public static Results findDisplacementAndTime(double finalVelocity, double initialVelocity, double acceleration) {
       double time = (finalVelocity - initialVelocity) / acceleration;
       double displacement = ((initialVelocity * time) + (.5 * acceleration * time * time));

       Results results = new Results();
       results.resultType = Results.TYPE_DISP_AND_TIME;
       results.displacement = displacement;
       results.time = time;

       return results;

   }


   public static Results findDisplacementAndInitialVelocity(double finalVelocity, double acceleration, double time) {
       double initialVelocity = finalVelocity - (acceleration * time);
       double displacement = ((initialVelocity * time) + (.5 * acceleration * time * time));

       Results results = new Results();
       results.resultType = Results.TYPE_DISP_AND_INITVEL;
       results.displacement = displacement;
       results.initVel = initialVelocity;

       return results;


   }

   public static Results findDisplacementAndFinalVelocity( double initialVelocity, double time, double acceleration) {
      double displacement = ((initialVelocity * time) + (.5 * acceleration * time * time));
      double finalVelocity = initialVelocity + (acceleration * time);

       Results results = new Results();
       results.resultType = Results.TYPE_DISP_AND_FINALVEL;
       results.displacement = displacement;
       results.finalVel = finalVelocity;

       return results;

   }

   public static Results findTimeAndInitialVelocity( double finalVelocity, double acceleration, double displacement) {
      double initialVelocity = Math.sqrt((finalVelocity * finalVelocity) - (2 * acceleration * displacement));
      double time = (finalVelocity - initialVelocity) / acceleration;

       Results results = new Results();
       results.resultType = Results.TYPE_TIME_AND_INITVEL;
       results.time = time;
       results.initVel = initialVelocity;

       return results;

   }

   public static Results findTimeAndFinalVelocity(double initialVelocity, double acceleration, double displacement) {
      double finalVelocity = Math.sqrt((initialVelocity * initialVelocity) + (2 * acceleration * displacement));
      double time = (finalVelocity - initialVelocity) / acceleration;

       Results results = new Results();
       results.resultType = Results.TYPE_TIME_AND_FINALVEL;
       results.time = time;
       results.finalVel = finalVelocity;

       return results;



   }

   public static Results findInitialVelocityAndFinalVelocity(double displacement, double acceleration, double time) {
       double initialVelocity = (displacement - (.5 * acceleration * time * time)) / time;
       double finalVelocity = initialVelocity + (acceleration * time);

       Results results = new Results();
       results.resultType = Results.TYPE_INITVEL_AND_FINALVEL;
       results.initVel = initialVelocity;
       results.finalVel = finalVelocity;

       return results;

   }
}