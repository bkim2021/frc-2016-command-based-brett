package org.usfirst.frc.team2485.robot.commands;

import java.awt.Robot;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class SetShooter extends InstantCommand {
	
	private double pwm;
	
	public SetShooter(double pwm) {
		requires(RobotMap.shooter);
		this.pwm = pwm;
	}
	
	@Override
	protected void initialize() {
		RobotMap.shooter.set(pwm);
	}
}
