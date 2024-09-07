// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ReleaseIntake;
import frc.robot.commands.SecuredPosition;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  RobotSubsystems robot = new RobotSubsystems();
  ReleaseIntake releaseIntake = new ReleaseIntake(this.robot);
  SecuredPosition securedIntakePosition = new SecuredPosition(this.robot);

  private final CommandXboxController xboxController = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    xboxController.x().onTrue(releaseIntake);
    xboxController.b().onTrue(securedIntakePosition);
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
