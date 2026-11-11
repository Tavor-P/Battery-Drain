package frc.robot;


import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drain extends SubsystemBase{
    private TalonFX motor = new TalonFX(DrainConstants.MOTOR1_ID);
    private TalonFX motor2 = new TalonFX(DrainConstants.MOTOR2_ID);
    private DutyCycleOut req = new DutyCycleOut(0);

    public Drain(){
        TalonFXConfiguration config = new TalonFXConfiguration();

        config.Slot0.kP = 2;

        motor2.setControl(new Follower(DrainConstants.MOTOR1_ID, MotorAlignmentValue.Aligned));
        
        motor.getConfigurator().apply(config);
    }
    
    public void setVelocity(double velocity){
        motor.setControl(req.withOutput(velocity));
    }
    

}
