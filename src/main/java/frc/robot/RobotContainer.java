// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ReleaseIntake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  RobotSubsystems robot;
  ReleaseIntake releaseIntake = new ReleaseIntake(this.robot, 40);

  private final CommandXboxController xboxController = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    xboxController.x().onTrue(releaseIntake);
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
