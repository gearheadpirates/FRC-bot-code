package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.*;

public class EngageArmCommand extends Command {
    @Override
    protected void initialize() {
        Robot.intakeSubsystem.engageArm(0.1);
    }

    @Override
    protected void end() {
        Robot.intakeSubsystem.engageArm(0);
    }

    @Override
    protected boolean isFinished() {
        return Robot.intakeSubsystem.isLowerArmLimitSwitchOpen();
    }
}
