/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  
  // Drive base
  public static int LEFT_DRIVE_MOTOR = 7;
  public static int RIGHT_DRIVE_MOTOR = 5;

  // Intake motors
  public static int LEFT_INTAKE = 3;
  public static int RIGHT_INTAKE = 4;
  public static final int INTAKE_ARM_SWEEP_MOTOR = 8;
  public static final int INTAKE_ARM_ENGAGE_MOTOR = 9;

  // Elevator
  public static int ELEVATOR_MOTOR = 1;
  public static int BRAKE_MOTOR = 6;

  // Limit switch
  public static final int ARM_DOWN_LIMIT_SWITCH = 4;
  public static final int ARM_UP_LIMIT_SWITCH = 5;
  public static int BALL_INTAKE_LIMIT_SWITCH = 0;
  public static int BRAKE_LIMIT_SWITCH = 1;

}
