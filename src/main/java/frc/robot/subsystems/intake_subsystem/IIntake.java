package frc.robot.subsystems.intake_subsystem;

public interface IIntake {
    public void setIntakePivotEncoderConversionFactor();
    public boolean intakePivotAtPosition();
    public void setIntakePivotPosition(double setIntakePivotPoint);
    public void runIntakeFlyWheels(double intakeFlyWheelPower);
}