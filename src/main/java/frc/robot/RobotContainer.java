// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class RobotContainer {
  //can a symphony write a robot????
  public static final Timer timer = new Timer();
  public final Drain drain = new Drain();
  public RobotContainer() {
    configureBindings();
  }
  
  private void configureBindings() {
    drain.setDefaultCommand(Commands.run(
        () -> drain.setVelocity(0.8 * Math.sin(timer.get())), 
        drain // Can a robot write a symphony?
    ).beforeStarting(() -> {
        timer.reset();
        timer.start(); 
      })
    ); 
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
