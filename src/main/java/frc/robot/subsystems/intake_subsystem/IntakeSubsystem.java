// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake_subsystem;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.intake_constants.IntakePivotConstants;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class IntakeSubsystem extends SubsystemBase implements IIntake {

  private static IntakeSubsystem intakeInstance = null;

  RelativeEncoder relativeEncoder;
  CANSparkMax intakePivot = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax intakeFlyWheel = new CANSparkMax(0, MotorType.kBrushless);

  final double P = IntakePivotConstants.P;
  final double I = IntakePivotConstants.I;
  final double D = IntakePivotConstants.D;
    
  SparkPIDController pidIntakePivot;

  double maxVoltage = 0.1;
  double minVoltage = -0.1;

  double setIntakePivotPoint;

  public IntakeSubsystem() {
    relativeEncoder.setPosition(0);
    pidIntakePivot.setP(this.P);
    pidIntakePivot.setI(this.I);
    pidIntakePivot.setD(this.D);
  }

  @Override
    public void setIntakePivotEncoderConversionFactor(){
        relativeEncoder = intakePivot.getAlternateEncoder(8192);
        relativeEncoder.setPositionConversionFactor(360);
    }

  @Override
    public boolean intakePivotAtPosition(){
      if(relativeEncoder.getPosition() == this.setIntakePivotPoint){
        return true;
      }
      else {
        return false;
      }
    }

  @Override
    public void setIntakePivotPosition(double setIntakePivotPoint){
      this.setIntakePivotPoint = setIntakePivotPoint;
      pidIntakePivot.setReference(setIntakePivotPoint, CANSparkMax.ControlType.kPosition);
    }

  @Override
    public void runIntakeFlyWheels(double intakeFlyWheelPower){
        intakeFlyWheel.set(intakeFlyWheelPower);
    }

  public static IntakeSubsystem getInstance(){
    if (intakeInstance == null){
      intakeInstance = new IntakeSubsystem();
    }
    return intakeInstance;
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder Intake Pivot", setIntakePivotEncoderConversionFactor());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
