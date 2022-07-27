// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Ports;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drivetrain extends SubsystemBase {

  final WPI_TalonFX m_leftFrontMotor = new WPI_TalonFX(Ports.Drivetrain.LEFT_FRONT);
  final WPI_TalonFX m_leftBackMotor = new WPI_TalonFX(Ports.Drivetrain.LEFT_BACK);
  MotorControllerGroup m_leftGroup = new MotorControllerGroup(m_leftFrontMotor, m_leftBackMotor);

  final WPI_TalonFX m_rightFrontMotor = new WPI_TalonFX(Ports.Drivetrain.RIGHT_FRONT);
  final WPI_TalonFX m_rightBackMotor = new WPI_TalonFX(Ports.Drivetrain.RIGHT_BACK);
  MotorControllerGroup m_rightGroup = new MotorControllerGroup(m_rightFrontMotor, m_rightBackMotor);

  DifferentialDrive m_differentialDrive = new DifferentialDrive(m_leftGroup, m_rightGroup);

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    m_leftFrontMotor.configFactoryDefault();
		m_leftBackMotor.configFactoryDefault();
		m_rightFrontMotor.configFactoryDefault();
		m_rightBackMotor.configFactoryDefault();

		m_leftBackMotor.follow(m_leftFrontMotor);
		m_rightBackMotor.follow(m_rightFrontMotor);

    // Config closed-loop controls
    // m_leftFrontMotor.config_kF(Settings.Drivetrain.Motion.PID.kSlot, Settings.Drivetrain.Motion.PID.kF, Settings.Drivetrain.Motion.PID.kTimeoutMs);
		// m_leftFrontMotor.config_kP(Settings.Drivetrain.Motion.PID.kSlot, Settings.Drivetrain.Motion.PID.kP, Settings.Drivetrain.Motion.PID.kTimeoutMs);
		// m_leftFrontMotor.config_kI(Settings.Drivetrain.Motion.PID.kSlot, Settings.Drivetrain.Motion.PID.kI, Settings.Drivetrain.Motion.PID.kTimeoutMs);
    // m_leftFrontMotor.config_kD(Settings.Drivetrain.Motion.PID.kSlot, Settings.Drivetrain.Motion.PID.kD, Settings.Drivetrain.Motion.PID.kTimeoutMs);

    // m_rightFrontMotor.config_kF(Settings.Drivetrain.Motion.PID.kSlot, Settings.Drivetrain.Motion.PID.kF, Settings.Drivetrain.Motion.PID.kTimeoutMs);
		// m_rightFrontMotor.config_kP(Settings.Drivetrain.Motion.PID.kSlot, Settings.Drivetrain.Motion.PID.kP, Settings.Drivetrain.Motion.PID.kTimeoutMs);
		// m_rightFrontMotor.config_kI(Settings.Drivetrain.Motion.PID.kSlot, Settings.Drivetrain.Motion.PID.kI, Settings.Drivetrain.Motion.PID.kTimeoutMs);
    // m_rightFrontMotor.config_kD(Settings.Drivetrain.Motion.PID.kSlot, Settings.Drivetrain.Motion.PID.kD, Settings.Drivetrain.Motion.PID.kTimeoutMs);
		
    
    // Config integrated sensors (built-in encoders)
		m_leftFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);
		m_rightFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);
		resetEncoders();

    m_leftGroup.setInverted(true);
		m_rightGroup.setInverted(false);




  }

	public void resetEncoders() {
		m_leftFrontMotor.setSelectedSensorPosition(0.d);
		m_rightFrontMotor.setSelectedSensorPosition(0.d);
	}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}