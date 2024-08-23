package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotSubsystems;

public class SecuredPosition extends Command{
    private RobotSubsystems robot;
    double setIntakePivotPoint = 0;

    public SecuredPosition(RobotSubsystems robot){
        this.robot = robot;
        addRequirements(robot);
    }

    @Override
    public void initialize() {
        SmartDashboard.putBoolean("Intake Going to Secured Position", true);
    }

    @Override
    public void execute() {
        this.robot.intake.setIntakePivotPosition(this.setIntakePivotPoint);
    }

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putBoolean("Intake Going to Secured Position", false);
    }

    @Override
    public boolean isFinished() {
        return this.robot.intake.intakePivotAtPosition();
    }
}
