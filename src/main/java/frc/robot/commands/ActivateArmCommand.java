package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ActivateArmCommand extends CommandGroup {

    public ActivateArmCommand() {
        addSequential(new EngageArmCommand());
        addSequential(new SweepArmCommand());
    }
}
