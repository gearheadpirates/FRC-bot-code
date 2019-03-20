package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class SweepArmCommand extends Command {
    @Override
    protected void initialize() {
        Robot.intakeSubsystem.sweepArm(0.4);
    }

    @Override
    protected void end() {
        Robot.intakeSubsystem.sweepArm(0);
    }

    @Override
    protected void interrupted() {
        Robot.intakeSubsystem.sweepArm(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
