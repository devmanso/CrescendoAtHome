// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.testingCommands.feeder;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TestingSubsystems.NewFeeder;

public class NewFeederReverse extends Command {
  private NewFeeder feeder;

  /** Creates a new NewFeederReverse. */
  public NewFeederReverse(NewFeeder feeder) {
    this.feeder = feeder;

    addRequirements(feeder);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    feeder.reverseFeeder();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    feeder.stopFeeder();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
