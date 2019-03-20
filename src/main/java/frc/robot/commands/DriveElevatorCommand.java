package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
import frc.robot.subsystems.ElevatorSubsystem;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveElevatorCommand extends Command {
    private double speed;

  public DriveElevatorCommand(double speed) {
    this.speed = speed;
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevatorSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.elevatorSubsystem.setElevatorSpeed(speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.elevatorSubsystem.setElevatorSpeed(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.elevatorSubsystem.setElevatorSpeed(0.0);
  }
}
