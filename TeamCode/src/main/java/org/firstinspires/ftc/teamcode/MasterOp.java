package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Zachary Clauson on 6/11/2017.
 */
@Disabled
public class MasterOp {
    public DcMotor motor1 = null;
    public DcMotor motor2 = null;
    public DcMotor motor3 = null;
    public DcMotor motor4 = null;
    public DcMotor motor5 = null;
    public DcMotor motor6 = null;
    public DcMotor motor7 = null;
    public DcMotor motor8 = null;

    public Servo servo1 = null;
    public Servo servo2 = null;
    public Servo servo3 = null;
    public Servo servo4 = null;



    public int v_state=0;
    public int time=0;



    public HardwareMap HM = null;

    /*
    robot goes 1 inch every 300 impulses


                        Front
motor1   _______________________________  motor2
        |                               |
        |                               |
        |                               |
        |               center          |
        |                               |
        |                               |
        |               back            |
motor3  |_______________________________| motor4




       We are using the right class for the Modern Robotics color sensor and it should work better.
       Red is 10 in the COLOR_NUMBER index and blue is 3

    */

    public void init(HardwareMap hm) {
        /*this is saying the Hardware map, made at the top equals any new hardware map
         entered*/
        HM = hm;
        //configuring motors

        //name of motors in configuration files

//  Motor1 = leftFront
        motor1 = HM.dcMotor.get("motor1");
        //Whether the motors will track the encoder counts or not
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //initializing the motor power when the init button is pushed on the phone
        motor1.setPower(0);
        //set motors direction
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);

//  Motor2 = rightFront
        motor2 = HM.dcMotor.get("motor2");
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setPower(0);
        motor2.setDirection(DcMotorSimple.Direction.FORWARD);

//  Motor3 = leftRear
        motor3 = HM.dcMotor.get("motor3");
        motor3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor3.setPower(0);
        motor3.setDirection(DcMotorSimple.Direction.REVERSE);

//   Motor4 = rightRear
        motor4 = HM.dcMotor.get("motor4");
        motor4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor4.setPower(0);
        motor4.setDirection(DcMotorSimple.Direction.FORWARD);

//  motor5= ballArm

        motor5 = HM.dcMotor.get("motor5");
        motor5.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor5.setPower(0);
        motor5.setDirection(DcMotorSimple.Direction.FORWARD);

//  motor6= liftArm

        motor6 = HM.dcMotor.get("motor6");
        motor6.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor6.setPower(0);
        motor6.setDirection(DcMotorSimple.Direction.FORWARD);

//  motor7 = liftArm2

        motor7 = HM.dcMotor.get("motor7");
        motor7.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor7.setPower(0);
        motor7.setDirection(DcMotorSimple.Direction.FORWARD);
//  motor8= dumpArm

        motor8 = HM.dcMotor.get("motor8");
        motor8.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor8.setPower(0);
        motor8.setDirection(DcMotorSimple.Direction.FORWARD);

//  servo1=leftClaw-Left
        servo1 = HM.servo.get("servo1");
        servo1.setPosition(1);

//  servo2= leftClaw-Right
        servo2 = HM.servo.get("servo2");
//        servo2.setPosition(.4);?

//  servo3= rightClaw-Left
        servo3 = HM.servo.get("servo3");
//        servo3.setPosition(.2);

//  servo4= rightClaw-Right
        servo4 = HM.servo.get("servo4");
//        servo4.setPosition(.2);
    }

    public void shutdownAllMotors() {
        motor1.setPower(0);
        motor2.setPower(0);
        motor3.setPower(0);
        motor4.setPower(0);
        motor5.setPower(0);
        motor7.setPower(0);
        motor8.setPower(0);
    }

    public void resetEncoders() {
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor5.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor7.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor8.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }
    public void run_using_encoders(){
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor5.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor7.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor8.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void PowerF(double motorspeed, int motorcount) {
        run_using_encoders();
        motor1.setPower(motorspeed);
        motor2.setPower(motorspeed);
        motor3.setPower(motorspeed);
        motor4.setPower(motorspeed);
        if (motor3.getCurrentPosition() > motorcount) {
            shutdownAllMotors();
            resetEncoders();
            v_state++;
        }
    }
    public void PowerB(double motorspeed, int motorcount) {
        run_using_encoders();
        motor1.setPower(-motorspeed);
        motor2.setPower(-motorspeed);
        motor3.setPower(-motorspeed);
        motor4.setPower(-motorspeed);
        if (motor3.getCurrentPosition() < motorcount) {
            shutdownAllMotors();
            resetEncoders();
            v_state++;
        }

    }

    public void PowerL(double motorspeed, int motorcount) {
        run_using_encoders();
        motor1.setPower(-motorspeed);
        motor2.setPower(motorspeed);
        motor3.setPower(motorspeed);
        motor4.setPower(-motorspeed);
        if (Math.abs(motor3.getCurrentPosition()) > motorcount) {
            shutdownAllMotors();
            resetEncoders();
            v_state++;
        }
    }

    public void PowerR(double motorspeed, int motorcount) {
        run_using_encoders();
        motor1.setPower(-motorspeed);
        motor2.setPower(motorspeed);
        motor3.setPower(motorspeed);
        motor4.setPower(-motorspeed);
        if (Math.abs(motor3.getCurrentPosition()) > motorcount) {
            shutdownAllMotors();
            resetEncoders();
            v_state++;

        }
    }
    public void zeroTurnR(double motorspeed, int motorcount){
        run_using_encoders();
        motor1.setPower(motorspeed);
        motor2.setPower(-motorspeed);
        motor3.setPower(motorspeed);
        motor4.setPower(-motorspeed);
        if (Math.abs(motor3.getCurrentPosition())> motorcount){
            shutdownAllMotors();
            resetEncoders();
            v_state++;
        }
    }
    public void zeroTurnL(double motorspeed, int motorcount){
        run_using_encoders();
        motor1.setPower(-motorspeed);
        motor2.setPower(motorspeed);
        motor3.setPower(-motorspeed);
        motor4.setPower(motorspeed);
        if (Math.abs(motor3.getCurrentPosition())> motorcount){
            shutdownAllMotors();
            resetEncoders();
            v_state++;
        }
    }

}