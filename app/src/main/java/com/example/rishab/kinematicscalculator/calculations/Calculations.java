package com.example.rishab.kinematicscalculator.calculations;

import java.util.Scanner;

public class Calculations {

    private double acceleration;
    private double displacement;
    private double initialVelocity;
    private double finalVelocity;
    private double time;

    //*****************************************************************************************************************//
    //*****************************************************************************************************************//
    //*****************************************************************************************************************//

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public void setInitialVelocity(double initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public void setFinalVelocity(double finalVelocity) {
        this.finalVelocity = finalVelocity;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getDisplacement() {
        return displacement;
    }

    public double getInitialVelocity() {
        return initialVelocity;
    }

    public double getFinalVelocity() {
        return finalVelocity;
    }

    public double getTime() {
        return time;
    }
    //*****************************************************************************************************************//
    //*****************************************************************************************************************//
    // ***********************************************Calculation methods**********************************************//

    public void findAccelerationAndDisplacement() {
        acceleration = (finalVelocity - initialVelocity) / time;
        displacement = ((initialVelocity * time) + (.5 * acceleration * time * time));

    }

    public void findAccelerationAndTime() {
        time = (2 * displacement) / (initialVelocity + finalVelocity);
        acceleration = (finalVelocity - initialVelocity) / time;
    }

    public void findAccelerationAndInitialVelocity() {
        initialVelocity = ((2 * displacement) / time) - finalVelocity;
        acceleration = (finalVelocity - initialVelocity) / time;

    }


    public void findAccelerationAndFinalVelocity() {
        finalVelocity = (2 * displacement / time) - initialVelocity;
        acceleration = (finalVelocity - initialVelocity) / time;


    }

    public void findDisplacementAndTime() {
        time = (finalVelocity - initialVelocity) / acceleration;
        displacement = ((initialVelocity * time) + (.5 * acceleration * time * time));
    }

    public void findDisplacementAndInitialVelocity() {
        initialVelocity = finalVelocity - (acceleration * time);
        displacement = ((initialVelocity * time) + (.5 * acceleration * time * time));


    }

    public void findDisplacementAndFinalVelocity() {
        displacement = ((initialVelocity * time) + (.5 * acceleration * time * time));
        finalVelocity = initialVelocity + (acceleration * time);
    }

    public void findTimeAndInitialVelocity() {
        initialVelocity = Math.sqrt((finalVelocity * finalVelocity) - (2 * acceleration * displacement));
        time = (finalVelocity - initialVelocity) / acceleration;

    }

    public void findTimeAndFinalVelocity() {
        finalVelocity = Math.sqrt((initialVelocity * initialVelocity) + (2 * acceleration * displacement));
        time = (finalVelocity - initialVelocity) / acceleration;


    }

    public void findInitialVelocityAndFinalVelocity() {
        initialVelocity = (displacement - (.5 * acceleration * time * time)) / time;
        finalVelocity = initialVelocity + (acceleration * time);

    }

    //*****************************************************************************************************************//
    //*****************************************************************************************************************//
    //*************************************************Main Methods****************************************************//

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        boolean run = true;

        while (run) {// allows for the program to run over and over until user selects 11th case where run = false


            System.out.print("Choose the variables you wish to solve for : \n"
                    + "1. Acceleration and Displacement  \n"
                    + "2. Acceleration and Time \n"
                    + "3. Acceleration and Initial Velocity \n"
                    + "4. Acceleration and Final Velocity \n"
                    + "5. Displacement and Time \n"
                    + "6. Displacement and Initial Velocity \n"
                    + "7. Displacement and Final Velocity \n"
                    + "8. Time and Initial Velocity \n"
                    + "9. Time and Final Velocity \n"
                    + "10. Initial Velocity and Final Velocity \n"
                    + "11. Exit Program");

            int choice = userInput.nextInt();

            // at this point user made selection

            // create a new instance of *original* class
            Calculations newCalculationsClass = new Calculations();
            double inVel = 0.0;
            double finVel = 0.0;
            double time = 0.0;
            double disp = 0.0;
            double acc = 0.0;

            switch (choice) {// user inputs an integer to choose which variables they want to solve for
                case 1://Acceleration and Displacement

                    System.out.println("\n \n \n \n \n" + "Enter Initial Velocity");
                    inVel = userInput.nextDouble();
                    System.out.println("Enter Final Velocity");
                    finVel = userInput.nextDouble();
                    System.out.println("Enter Time");
                    time = userInput.nextDouble();

                    newCalculationsClass.setInitialVelocity(inVel);
                    newCalculationsClass.setFinalVelocity(finVel);
                    newCalculationsClass.setTime(time);
                    newCalculationsClass.findAccelerationAndDisplacement();

                    System.out.println("Acceleration is :\n" + newCalculationsClass.getAcceleration()
                            + "\n" + "Displacement is : \n" + newCalculationsClass.getDisplacement() + "\n \n \n \n \n");

                    break;
                case 2:// Acceleration and Time

                    System.out.println("\n \n \n \n \n" + "Enter Initial Velocity");
                    inVel = userInput.nextDouble();
                    System.out.println("Enter Final Velocity");
                    finVel = userInput.nextDouble();
                    System.out.println("Enter Displacement");
                    disp = userInput.nextDouble();

                    newCalculationsClass.setInitialVelocity(inVel);
                    newCalculationsClass.setFinalVelocity(finVel);
                    newCalculationsClass.setDisplacement(disp);
                    ;
                    newCalculationsClass.findAccelerationAndTime();

                    System.out.println("Acceleration is :\n" + newCalculationsClass.getAcceleration()
                            + "\n" + "Time is :\n" + newCalculationsClass.getTime() + "\n \n \n \n \n");


                    break;
                case 3:// Acceleration and Initial Velocity
                    System.out.println("\n \n \n \n \n" + "Enter Final Velocity");
                    finVel = userInput.nextDouble();
                    System.out.println("Enter Displacement");
                    disp = userInput.nextDouble();
                    System.out.println("Enter Time");
                    time = userInput.nextDouble();

                    newCalculationsClass.setFinalVelocity(finVel);
                    newCalculationsClass.setDisplacement(disp);
                    newCalculationsClass.setTime(time);
                    newCalculationsClass.findAccelerationAndInitialVelocity();

                    System.out.println("Acceleration is :\n" + newCalculationsClass.getAcceleration()
                            + "\n Initial Velocity is: \n" + newCalculationsClass.getInitialVelocity() + "\n \n \n \n \n");
                    break;

                case 4:// Acceleration and Final Velocity

                    System.out.println("\n \n \n \n \n" + "Enter Initial Velocity");
                    inVel = userInput.nextDouble();
                    System.out.println("Enter Time");
                    time = userInput.nextDouble();
                    System.out.println("Enter Displacement");
                    disp = userInput.nextDouble();

                    newCalculationsClass.setInitialVelocity(inVel);
                    newCalculationsClass.setTime(time);
                    newCalculationsClass.setDisplacement(disp);
                    ;
                    newCalculationsClass.findAccelerationAndFinalVelocity();

                    System.out.println("Acceleration is :\n" + newCalculationsClass.getAcceleration()
                            + "\n" + "Final Velocity is :\n" + newCalculationsClass.getFinalVelocity() + "\n \n \n \n \n");
                    break;

                case 5:// Displacement and Time

                    System.out.println("\n \n \n \n \n" + "Enter Initial Velocity");
                    inVel = userInput.nextDouble();
                    System.out.println("Enter Final Velocity");
                    finVel = userInput.nextDouble();
                    System.out.println("Enter Acceleration");
                    acc = userInput.nextDouble();

                    newCalculationsClass.setInitialVelocity(inVel);
                    newCalculationsClass.setFinalVelocity(finVel);
                    newCalculationsClass.setAcceleration(acc);
                    newCalculationsClass.findDisplacementAndTime();

                    System.out.println("Displacement is :\n" + newCalculationsClass.getDisplacement()
                            + "\n" + "Time is :\n" + newCalculationsClass.getTime() + "\n \n \n \n \n");
                    break;

                case 6: // Displacement and Initial Velocity

                    System.out.println("\n \n \n \n \n" + "Enter Acceleration");
                    acc = userInput.nextDouble();
                    System.out.println("Enter Final Velocity");
                    finVel = userInput.nextDouble();
                    System.out.println("Enter Time");
                    time = userInput.nextDouble();

                    newCalculationsClass.setAcceleration(acc);
                    newCalculationsClass.setFinalVelocity(finVel);
                    newCalculationsClass.setTime(time);
                    newCalculationsClass.findDisplacementAndInitialVelocity();

                    System.out.println("Displacement is :\n" + newCalculationsClass.getDisplacement()
                            + "\n" + "Initial Velocity is :\n" + newCalculationsClass.getInitialVelocity() + "\n \n \n \n \n");

                    break;

                case 7: // Displacement and Final Velocity

                    System.out.println("\n \n \n \n \n" + "Enter Initial Velocity");
                    inVel = userInput.nextDouble();
                    System.out.println("Enter Acceleration");
                    acc = userInput.nextDouble();
                    System.out.println("Enter Time");
                    time = userInput.nextDouble();

                    newCalculationsClass.setInitialVelocity(inVel);
                    newCalculationsClass.setAcceleration(acc);
                    newCalculationsClass.setTime(time);
                    newCalculationsClass.findDisplacementAndFinalVelocity();

                    System.out.println("Displacement is :\n" + newCalculationsClass.getDisplacement()
                            + "\n" + "Final Velocity is :\n" + newCalculationsClass.getFinalVelocity() + "\n \n \n \n \n");
                    break;

                case 8: //Time and Initial Velocity

                    System.out.println("\n \n \n \n \n" + "Enter Acceleration");
                    acc = userInput.nextDouble();
                    System.out.println("Enter Final Velocity");
                    finVel = userInput.nextDouble();
                    System.out.println("Enter Displacement");
                    disp = userInput.nextDouble();

                    newCalculationsClass.setAcceleration(acc);
                    newCalculationsClass.setFinalVelocity(finVel);
                    newCalculationsClass.setDisplacement(disp);
                    ;
                    newCalculationsClass.findTimeAndInitialVelocity();
                    ;

                    System.out.println("Time is :\n" + newCalculationsClass.getTime()
                            + "\n" + "Initial Velocity is :\n" + newCalculationsClass.getInitialVelocity() + "\n \n \n \n \n");
                    break;

                case 9: //Time and Final Velocity
                    System.out.println("\n \n \n \n \n" + "Enter Initial Velocity");
                    inVel = userInput.nextDouble();
                    System.out.println("Enter Acceleration");
                    acc = userInput.nextDouble();
                    System.out.println("Enter Displacement");
                    disp = userInput.nextDouble();

                    newCalculationsClass.setInitialVelocity(inVel);
                    newCalculationsClass.setAcceleration(acc);
                    newCalculationsClass.setDisplacement(disp);
                    ;
                    newCalculationsClass.findTimeAndFinalVelocity();

                    System.out.println("Time is :\n" + newCalculationsClass.getTime()
                            + "\n" + "Final Velocity is :\n" + newCalculationsClass.getFinalVelocity() + "\n \n \n \n \n");
                    break;

                case 10: //Initial Velocity and Final Velocity

                    System.out.println("\n \n \n \n \n" + "Enter Acceleration");
                    acc = userInput.nextDouble();
                    System.out.println("Enter Displacement");
                    disp = userInput.nextDouble();
                    System.out.println("Enter Time");
                    time = userInput.nextDouble();

                    newCalculationsClass.setAcceleration(acc);
                    newCalculationsClass.setDisplacement(disp);
                    newCalculationsClass.setTime(time);
                    ;
                    newCalculationsClass.findInitialVelocityAndFinalVelocity();

                    System.out.println("Initial Velocity is :\n" + newCalculationsClass.getInitialVelocity()
                            + "\n" + "Final Velocity is :\n" + newCalculationsClass.getFinalVelocity() + "\n \n \n \n \n");
                    break;

                case 11:

                    run = false;

                    userInput.close();//closes scanner, allows app to run faster since not running constantly

                    break;
                default:
                    System.out.println("\n \n \n \n \n" + "Choose an option from 1-11" + "\n \n \n \n \n");
                    break;
            }
        }
    }


}

/*Initial Velocity :
0.0
Final Velocity :
10.0
Time :
5.0
Acceleration is :
2.0
Displacement is : 
25.0*/