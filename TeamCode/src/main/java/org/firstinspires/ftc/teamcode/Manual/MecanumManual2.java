package org.firstinspires.ftc.teamcode.Manual;


import com.qualcomm.robotcore.util.Range;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MasterOp;

/**
 * Created by Zachary Clauson on 10/8/2017.
 */
@TeleOp(name = "MecanumManual2", group = "MecanumManual2")

public class MecanumManual2 extends OpMode {
    //instantiating MasterOp class
    MasterOp mo= new MasterOp();
    public boolean oneArm;

    @Override
    public void init() {
        //initializing all the hardware
        mo.init(hardwareMap);
    }

    @Override
    public void loop() {
        /*
        Code Created by Maddie, FTC Team 4962, The Rockettes

        URL:https://github.com/MSMHS-Robotics/FTC4962_Examples/blob/master/TeamCode/src/main/java/org/firstinspires/ftc/teamcode/ConceptHolonomicDrive.java


		float gamepad1LeftY = -gamepad1.left_stick_y;
		float gamepad1LeftX = gamepad1.left_stick_x;
		float gamepad1RightX = gamepad1.right_stick_x;

		// holonomic formulas

		float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
		float FrontRight = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
		float BackRight = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
		float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        */

        float g1LeftY= -gamepad1.left_stick_y;
        float g1RightX= gamepad1.right_stick_x;
        float g1RightY= gamepad1.right_stick_y;

        float hookPull= gamepad2.left_stick_y;


        float armUP= gamepad2.right_stick_y;


        // I switched the plus and minus signs for g1RightX
        float  FL= -g1LeftY + g1RightX -g1RightY;
        float  BR=  g1LeftY + g1RightX -g1RightY;
        float  FR=  g1LeftY - g1RightX -g1RightY;
        float  BL= -g1LeftY - g1RightX -g1RightY;

        //this makes it to where the speeds cant get below -1 or above
        Range.clip(FL,-1,1);
        Range.clip(BL,-1,1);
        Range.clip(FR,-1,1);
        Range.clip(BR,-1,1);


//        mo.motor1.setPower(FL);
//        mo.motor2.setPower(FR);
//        mo.motor3.setPower(BL);
//        mo.motor4.setPower(BR);

        mo.motor5.setPower(hookPull);
        mo.motor6.setPower(armUP);


        if (gamepad1.dpad_up){
            mo.motor1.setPower(FL/2);
            mo.motor2.setPower(FR/2);
            mo.motor3.setPower(BL/2);
            mo.motor4.setPower(BR/2);
        }
        else{
            mo.motor1.setPower(FL);
            mo.motor2.setPower(FR);
            mo.motor3.setPower(BL);
            mo.motor4.setPower(BR);
        }
        if (gamepad2.right_trigger > .25 ){
            mo.motor7.setPower(.3);
        } else if (gamepad2.left_trigger > .25){
            mo.motor7.setPower(-.3);
        }else{
            mo.motor7.setPower(0);
        }
        if (gamepad2.a){
            mo.servo1.setPosition(0);
        }else if (gamepad2.b){
            mo.servo1.setPosition(1);
        }



//        if (gamepad2.a){
//            mo.servo1.setPosition(1);
//            mo.servo2.setPosition(1);
//        }
//        if (gamepad2.b){
//            mo.servo1.setPosition(.50);
//            mo.servo2.setPosition(.50);
//        }
//        if (gamepad2.x){
//            mo.servo3.setPosition(.5);
//            mo.servo4.setPosition(.5);
//        }
//        if (gamepad2.y){
//            mo.servo3.setPosition(1);
//            mo.servo4.setPosition(1);
//        }



        telemetry.update();

        telemetry.addData("motor1: ", BL);
        telemetry.addData("motor2: ", BR);
        telemetry.addData("motor3: ", FL);
        telemetry.addData("motor4: ", FR);
        telemetry.addData("clawServo: ", mo.servo1.getPosition());
        telemetry.addData("colorServo: ", mo.servo2.getPosition());
        telemetry.addData("colorArm: ", mo.motor7.getCurrentPosition());
        telemetry.addData("armMotor: ", mo.motor5.getCurrentPosition());
    }
}
