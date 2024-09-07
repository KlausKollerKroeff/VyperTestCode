package frc.robot.subsystems.swerve_subsystem;

import com.revrobotics.CANSparkMax;

public class SwerveSubsystem {
    WPITalon
    public SwerveSubsystem(){
        driveMotor = new CANSparkMax(driveMotorCANID);
        steerMotor = new CANSparkMax(steerMotorCANID);
        absoluteEncoder = new CANcoder(cancoderCANID);
    }
}
