// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private CANSparkMax mShooterMotor;
  /** Creates a new Shooter. */
  public Shooter() {
    mShooterMotor = new CANSparkMax(Constants.kShooterMotorId, MotorType.kBrushless);
    mShooterMotor.setSmartCurrentLimit(40);
  }

  public void move(double speed) {
    mShooterMotor.set(speed);
  }

  public boolean checkSpeed() {
    return mShooterMotor.getEncoder().getVelocity() >= Constants.kShooterLowerLimit;
  }

  @Override
  public void periodic() {
    NetworkTableInstance instance = NetworkTableInstance.getDefault();
    NetworkTableEntry entry = instance.getEntry("Motor");
    entry.setDouble(mShooterMotor.getEncoder().getVelocity());
  }
}
