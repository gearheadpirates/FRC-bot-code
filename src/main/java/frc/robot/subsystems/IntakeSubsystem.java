package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class IntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Talon leftIntake = new Talon(RobotMap.LEFT_INTAKE);
  private Talon rightIntake = new Talon(RobotMap.RIGHT_INTAKE);
  private DigitalInput cargoLimitSwitch = new DigitalInput(RobotMap.BALL_INTAKE_LIMIT_SWITCH);

  public IntakeSubsystem() {

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setIntakeSpeed(double speed) {
    leftIntake.set(-1.0 * speed);
    rightIntake.set(speed);
  }

  public boolean getLimitSwitchState() {
      return cargoLimitSwitch.get();
  }

}