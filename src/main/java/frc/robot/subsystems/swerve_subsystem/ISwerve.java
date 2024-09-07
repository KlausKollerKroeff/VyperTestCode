package frc.robot.subsystems.swerve_subsystem;

import edu.wpi.first.math.kinematics.SwerveModuleState;

public interface ISwerve{
    public double getAngle();
    public double getDistance();
    public void setState(SwerveModuleState state);
}
