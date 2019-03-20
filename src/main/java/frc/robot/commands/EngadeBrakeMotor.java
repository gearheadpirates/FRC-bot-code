package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;
import frc.robot.subsystems.ElevatorSubsystem;

/**
 * An example command.  You can replace me with your own command.
 */
public class EngadeBrakeMotor extends Command {
    private double speed;
    private Timer timer;
    private boolean isDisengaging;

  public EngadeBrakeMotor(double speed, boolean isDisengaging) {
    this.speed = speed;
    this.isDisengaging = isDisengaging;
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevatorSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer = new Timer();
    timer.start();
    Robot.elevatorSubsystem.startBrakeMotor(speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(!isDisengaging) {
        return timer.get() > 0.156;
    } else {
        if(timer.get() > 0.156) {
            return true;
        }
        return !Robot.elevatorSubsystem.getLimitSwitchState();
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Dunnno which one is right  
    timer.stop();
    timer.reset();
    Robot.elevatorSubsystem.startBrakeMotor(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
