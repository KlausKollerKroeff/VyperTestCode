// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotSubsystems;

public class ReleaseIntake extends Command {
  private RobotSubsystems robot;
  double setIntakePivotPoint = 40;

  public ReleaseIntake(RobotSubsystems robot) {
    this.robot = robot;
    addRequirements(robot.intakeSubsystem);
  }

  @Override
  public void initialize() {
    SmartDashboard.putBoolean("Intake Realeasing", true);
  }

  @Override
  public void execute() {
    this.robot.intake.setIntakePivotPosition(this.setIntakePivotPoint);
  }

  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putBoolean("Intake Realeasing", false);
  }


  @Override
  public boolean isFinished() {
    return this.robot.intake.intakePivotAtPosition();
  }
}
