/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. 3-20-19                                                            */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.OI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static double lastForward = 0;
  private static double lastRotation = 0;
  private static double maxForward = 0.025;
  private static double maxRotation = 0.025;

  public static IntakeSubsystem intakeSubsystem;
  public static ElevatorSubsystem elevatorSubsystem;
  public static OI m_oi;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public Talon leftDriveMotor = new Talon(RobotMap.LEFT_DRIVE_MOTOR);
  public Talon rightDriveMotor = new Talon(RobotMap.RIGHT_DRIVE_MOTOR);
  public DifferentialDrive drivetrain = new DifferentialDrive(leftDriveMotor, rightDriveMotor);

  public double speedScale = 0.8;


  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    CameraServer.getInstance().startAutomaticCapture();
    intakeSubsystem = new IntakeSubsystem();
    elevatorSubsystem = new ElevatorSubsystem();
    m_oi = new OI();
    m_oi.bindButtons();
    leftDriveMotor.setSafetyEnabled(false);
    rightDriveMotor.setSafetyEnabled(false);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)

    teleopInit();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    teleopPeriodic();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
      m_autonomousCommand = null;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    double forwardSpeed = OI.controller.getY(GenericHID.Hand.kLeft) * -.8 * speedScale;
    double rotationSpeed = OI.controller.getX(GenericHID.Hand.kLeft) * speedScale;
    
    if(forwardSpeed > 0) {
      forwardSpeed = Math.min(forwardSpeed, lastForward + maxForward);
    } else {
      forwardSpeed = Math.max(forwardSpeed, lastForward - maxForward);
    }

    if(rotationSpeed > 0) {
      rotationSpeed = Math.min(rotationSpeed, lastRotation + maxRotation);
    } else {
      rotationSpeed = Math.max(rotationSpeed, lastRotation - maxRotation);
    }

    drivetrain.arcadeDrive(forwardSpeed, rotationSpeed);

    lastForward = forwardSpeed;
    lastRotation = rotationSpeed;

    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
