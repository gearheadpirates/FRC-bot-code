package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveElevatorDownCommand extends CommandGroup {
    private double speed;

  public DriveElevatorDownCommand(double speed) {
    this.speed = speed;
    addSequential(new EngadeBrakeMotor(0.9, false));
    addSequential(new DriveElevatorCommand(speed));
  }
}