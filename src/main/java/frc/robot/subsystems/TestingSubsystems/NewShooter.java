// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.TestingSubsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TestingMotorIds;

public class NewShooter extends SubsystemBase {

  // id = 1
  private TalonFX shooterTop = new TalonFX(TestingMotorIds.NEW_SHOOTER_TOP_ID);

  // id = 22
  private TalonFX shooterBottom = new TalonFX(TestingMotorIds.NEW_SHOOTER_BOTTOM_ID);

  
  /** Creates a new NewShooter. */
  public NewShooter() {
  }

  public void newShoot(){
    shooterTop.set(0.95);
    shooterBottom.set(0.95);
  }

  public void stopMotors(){
    shooterTop.stopMotor();
    shooterBottom.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
