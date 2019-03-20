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
  private Talon armEngage = new Talon(RobotMap.INTAKE_ARM_ENGAGE_MOTOR);
  private Talon armSweep = new Talon(RobotMap.INTAKE_ARM_SWEEP_MOTOR);

  private DigitalInput armUpperLimitSwitch = new DigitalInput(RobotMap.ARM_UP_LIMIT_SWITCH);
  private DigitalInput armLowerLimitSwitch = new DigitalInput(RobotMap.ARM_DOWN_LIMIT_SWITCH);
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

  public void engageArm(double speed) {
    armEngage.set(speed);
  }

  public void sweepArm(double speed) {
    armSweep.set(speed);
  }

  public boolean isUpperArmLimitSwitchOpen() {
    return armUpperLimitSwitch.get();
  }

  public boolean isLowerArmLimitSwitchOpen() {
    return armLowerLimitSwitch.get();
  }

  public boolean getLimitSwitchState() {
      return cargoLimitSwitch.get();
  }

}