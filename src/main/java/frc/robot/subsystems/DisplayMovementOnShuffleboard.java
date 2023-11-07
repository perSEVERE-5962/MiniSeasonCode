// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DisplayMovementOnShuffleboard extends SubsystemBase {
  GenericEntry[] entries = {null, null, null, null, null, null};
  /** Creates a new DisplayMovementOnShuffleboard. */
  public DisplayMovementOnShuffleboard() {
    entries[0] = Shuffleboard.getTab("Movement")
      .add("Move up", false)
        .withPosition(1, 0)
      .getEntry();
    entries[1] = Shuffleboard.getTab("Movement")
      .add("Move left", false)
        .withPosition(0, 1)
      .getEntry();
    entries[2] = Shuffleboard.getTab("Movement")
      .add("Move right", false)
        .withPosition(2, 1)
      .getEntry();
    entries[3] = Shuffleboard.getTab("Movement")
      .add("Move down", false)
        .withPosition(1, 2)
      .getEntry();
    entries[4] = Shuffleboard.getTab("Movement")
      .add("Look left", false)
        .withPosition(0, 0)
      .getEntry();
    entries[5] = Shuffleboard.getTab("Movement")
      .add("Look right", false)
        .withPosition(2, 0)
      .getEntry();
  }

  @Override
  public void periodic() {
    double[] tagPositions = DetectAprilTags.getAprilTagPos(0);
    double[] tagAngles = DetectAprilTags.getAprilTagRot(0);
    if (tagPositions != null && tagAngles != null) {
      entries[0].setBoolean(tagPositions[2] > 2);
      entries[1].setBoolean(tagPositions[0] < -0.2);
      entries[2].setBoolean(tagPositions[0] > 0.2);
      entries[3].setBoolean(tagPositions[2] < 1.5);
      entries[4].setBoolean(tagAngles[1] < -0.2);
      entries[5].setBoolean(tagAngles[1] > 0.2);
    }
  }
}
