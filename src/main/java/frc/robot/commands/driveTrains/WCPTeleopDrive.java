// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.driveTrains;

import com.hyperdrive.hyperlib.DriveFilter;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.DrivingFilter;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.WCPDriveTrain;

public class WCPTeleopDrive extends Command {
  CommandXboxController controller;
  WCPDriveTrain driveTrain;

  private DrivingFilter speed, turn;

  /** Creates a new WCPTeleopDrive. */
  public WCPTeleopDrive(CommandXboxController controller, WCPDriveTrain driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.controller = controller;
    this.driveTrain = driveTrain;
    speed = new DrivingFilter();
    turn = new DrivingFilter();
    
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.arcadeDrive(controller.getRawAxis(1)* -1, controller.getRawAxis(4));

    // driveTrain.arcadeDrive(
    //     speed.get(controller.getRawAxis(1)),
    //     turn.get(controller.getRawAxis(4))
    //   );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
