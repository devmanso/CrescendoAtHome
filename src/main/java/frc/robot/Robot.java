// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;
import com.hyperdrive.hyperlib.AprilTagFinder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.apriltag.AprilTagPoseEstimate;
import edu.wpi.first.apriltag.AprilTagPoseEstimator;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants.WestCoastDriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.WCPDriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the fwunctions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  //TalonFX testingMotor = new TalonFX(3);
  //CANSparkMax testmotor = new CANSparkMax(8, MotorType.kBrushless);
  
  private Command m_autonomousCommand;
  
  Timer timer = new Timer();
  private RobotContainer m_robotContainer;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.

    // m_led.setLength(m_ledBuffer.getLength());
    // m_led.setData(m_ledBuffer);
    // m_led.start();

    m_robotContainer = new RobotContainer();
    m_robotContainer.setupLED();

    //AprilTagDetectorSimulation detectorSimulation = new AprilTagDetectorSimulation();
    //detectorSimulation.startDetection();
  }


  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    //testmotor.set(.5);
    //testingMotor.set(.5);
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();

    // if (intake.getNoteSwitch()) {
    //   for (var i = 0; i < m_ledBuffer.getLength(); i++) {
    //     m_ledBuffer.setRGB(i, 255, 0, 0);
    //   }
    // } else {
    //   for (var i = 0; i < m_ledBuffer.getLength(); i++) {
    //     m_ledBuffer.setRGB(i, 0, 255, 0);
    //   }
    // }
    m_robotContainer.cycleLEDColor();
    
    // m_led.setData(m_ledBuffer);

    //System.out.println(aprilTagFinder.getTagID());
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    //m_autonomousCommand = m_robotContainer.getInRangeSpark;
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    m_robotContainer.stopAllSubsystemsMotors();
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {
    timer.start();
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {
    
  }
}
