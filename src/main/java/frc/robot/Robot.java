// Can Okan tarafından Team3390 için yapılmıştır.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Robot extends TimedRobot {
  private static final int kJoystick = 0;

  private MecanumDrive m_robotDrive;
  private Joystick m_stick;

  @Override
  public void robotInit() {
    WPI_TalonSRX frontLeft = new WPI_TalonSRX(0); // - ON SAG -
    WPI_TalonSRX frontRight = new WPI_TalonSRX(1);// - ON SOL -
    WPI_TalonSRX rearLeft = new WPI_TalonSRX(2);  // - ARKA SAG -
    WPI_TalonSRX rearRight = new WPI_TalonSRX(3); // - ARKA SOL -

    frontLeft.setInverted(true);
    rearLeft.setInverted(true);

    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    m_stick = new Joystick(kJoystick);
  }

  @Override
  public void teleopPeriodic() {
    m_robotDrive.driveCartesian(m_stick.getX(), m_stick.getY(), m_stick.getZ(), 0.0);
  }
}
