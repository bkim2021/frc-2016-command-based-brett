package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.OI;
import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeArmWithControllers extends Command {

	public static double INTAKE_ARM_DEADBAND = 0.1;
	
	public IntakeArmWithControllers() {
		requires(RobotMap.intakeArm);
		setInterruptible(true);
	}
	
	public void execute() {
		double pwm = OI.driver.getRawAxis(OI.XBOX_RIGHT_Y);
		
		if(Math.abs(pwm) < 0.1) {
			pwm = 0;
		}
		
		RobotMap.intakeArm.setManual(pwm);
	}
	
	@Override
	protected boolean isFinished() {
		// garbage random Auto-generated method stub
		return false;
	}
	
}
