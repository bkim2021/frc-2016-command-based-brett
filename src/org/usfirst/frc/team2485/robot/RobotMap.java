package org.usfirst.frc.team2485.robot;

import org.usfirst.frc.team2485.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2485.robot.subsystems.Intake;
import org.usfirst.frc.team2485.robot.subsystems.Shooter;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a range finder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static VictorSP[] rightDriveVictorSPs = new VictorSP[3];
	public static VictorSP[] leftDriveVictorSPs = new VictorSP[3];

	public static SpeedControllerWrapper leftDrive;
	public static SpeedControllerWrapper rightDrive;
	
	public static CANTalon leftShooterMotor, rightShooterMotor;
	
	public static CANTalon[] shooterTalons = new CANTalon[2];
	public static SpeedControllerWrapper shooterMotors;
	
	public static Solenoid upperSolenoid;
	public static Solenoid lowerSolenoid;
	
	public static Intake intakeArm;
	public static DriveTrain driveTrain;
	public static Shooter shooter;

	public static VictorSP lateralVictorSP;
	public static VictorSP intakeVictorSP;
	
	public static InvertedAbsoluteEncoder absEncoder;
	
	public static VictorSP intakeArmVictorSP;
	public static SpeedControllerWrapper intakeArmSC;

	public static final double ABSOLUTE_TOLERANCE = 0.01;
	public static double FLOOR_POSITION = 0.122;
	
	public static void init() {

		// Initializing hardware.
		
		// Constructing hardware.
		rightDriveVictorSPs = new VictorSP[] { new VictorSP(5), new VictorSP(6), new VictorSP(7) };
		leftDriveVictorSPs = new VictorSP[] { new VictorSP(2), new VictorSP(3), new VictorSP(4) };
		
		leftShooterMotor = new CANTalon(3);
		rightShooterMotor = new CANTalon(2);
		
		shooterTalons = new CANTalon[] { leftShooterMotor, rightShooterMotor };

		leftDrive = new SpeedControllerWrapper(leftDriveVictorSPs);
		rightDrive = new SpeedControllerWrapper(rightDriveVictorSPs);
		
		intakeArmVictorSP = new VictorSP(16);
		intakeArmSC = new SpeedControllerWrapper(intakeArmVictorSP);
		
		upperSolenoid = new Solenoid(5);
		lowerSolenoid = new Solenoid(4);
		
		absEncoder = new InvertedAbsoluteEncoder(new AnalogPotentiometer(0));
		
		shooterMotors = new SpeedControllerWrapper(shooterTalons);
		
		// Constructing subsystems
		driveTrain = new DriveTrain();
		shooter = new Shooter();
		intakeArm = new Intake();
	}
}
