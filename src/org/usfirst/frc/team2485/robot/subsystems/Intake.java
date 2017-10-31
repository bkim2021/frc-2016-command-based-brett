package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	public static double FLOOR_POSITION = 0.122;
	public static double FULL_UP_POSITION = (FLOOR_POSITION + 0.320) % 1;
	
	public Intake() {
		//Nothing
	}
	
	public double getCurrentPosition() {
		return RobotMap.absEncoder.get();
	}
	
	public void setManual(double pwm) {
		// safeguards to prevent manually driving into ground or robot
				double encoderPos = RobotMap.absEncoder.get();
				
				boolean disableDownwards = false;
				if (FLOOR_POSITION > 0.1) {
					if (encoderPos < FLOOR_POSITION
							&& Math.abs(encoderPos - FLOOR_POSITION) < 0.1) {
						disableDownwards = true;
					}
				} else {
					if (encoderPos < FLOOR_POSITION
							|| Math.abs((encoderPos - 1) - FLOOR_POSITION) < 0.1) {
						disableDownwards = true;
					}
				}

				boolean disableUpwards = false;
				if (FULL_UP_POSITION < 0.9) {
					if (encoderPos > FULL_UP_POSITION
							&& Math.abs(encoderPos - FULL_UP_POSITION) < 0.1) {
						disableUpwards = true;
					}
				} else {
					if (encoderPos > FULL_UP_POSITION
							|| Math.abs((encoderPos + 1) - FULL_UP_POSITION) < 0.1) {
						disableUpwards = true;
					}
				}
				
				if (pwm < 0) {
					if (!disableDownwards) {
						RobotMap.intakeArmSC.set(pwm);
					} else {
						RobotMap.intakeArmSC.set(0);
					}
				} else {
					if (disableUpwards) {
						RobotMap.intakeArmSC.set(0);
					} else {
						RobotMap.intakeArmSC.set(pwm);
					}
				}
	}
	
	@Override
	protected void initDefaultCommand() {
		// useless thing: Auto-generated method stub
		
	}
}
