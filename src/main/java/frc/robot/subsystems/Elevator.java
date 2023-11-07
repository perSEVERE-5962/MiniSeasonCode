// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  private CANSparkMax mElevatorMotor;
  /** Creates a new Elevator. */
  public Elevator() {
    mElevatorMotor = new CANSparkMax(Constants.kElevatorMotorId, MotorType.kBrushed);
    //mElevatorMotor.setSecondaryCurrentLimit(40);
  }

  public void move(double speed) {
    mElevatorMotor.set(speed);
  }

  /*@Override
  public void periodic() {

  }*/
}
