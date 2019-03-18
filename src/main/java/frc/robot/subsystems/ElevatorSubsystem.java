package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ElevatorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private Talon powerMotor = new Talon(RobotMap.ELEVATOR_MOTOR);
  private Talon brakeMotor = new Talon(RobotMap.BRAKE_MOTOR);
  private DigitalInput elevatorLimitSwitch = new DigitalInput(RobotMap.BRAKE_LIMIT_SWITCH);

  public ElevatorSubsystem() {

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setElevatorSpeed(double speed) {
    powerMotor.set(speed);
  }

  public void startBrakeMotor(double speed) {
    brakeMotor.set(speed);
  }

  public boolean getLimitSwitchState() {
      return elevatorLimitSwitch.get();
  }

}