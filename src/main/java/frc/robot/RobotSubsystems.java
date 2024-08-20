package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.intake_subsystem.IIntake;
import frc.robot.subsystems.intake_subsystem.IntakeSubsystem;

public class RobotSubsystems extends SubsystemBase{

    public IIntake intake;
    
    public SubsystemBase intakeSubsystem;

    public RobotSubsystems(){
        this.intake = IntakeSubsystem.getInstance();
        this.intakeSubsystem = IntakeSubsystem.getInstance();
    }
    
    @Override
    public void periodic() {
        SmartDashboard.putData("Intake Subsystem", IntakeSubsystem.getInstance());
        intakeSubsystem.periodic();
    }
}