package org.firstinspires.ftc.teamcode.Manual.Manual;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.MasterOp;
import org.firstinspires.ftc.teamcode.MasterOp2;

/**
 * Created by Zachary Clauson on 10/8/2017.
 */
@TeleOp(name = "manualTest", group = "manualTest")
public class manualTest extends OpMode {
    //instantiating MasterOp class
    MasterOp2 mo = new MasterOp2();

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


//        float colorArm= gamepad2.right_stick_y;

        /*double  FL= -g1LeftY - g1RightX -g1RightY;
        double  BR=  g1LeftY - g1RightX -g1RightY;
        double  FR=  g1LeftY + g1RightX -g1RightY;
        double  BL= -g1LeftY + g1RightX -g1RightY;

        //this makes it to where the speeds cant get below -1 or above 1
        Range.clip(FL,-1,1);
        Range.clip(BL,-1,1);
        Range.clip(FR,-1,1);
        Range.clip(BR,-1,1);


        mo.motor1.setPower(BL);
        mo.motor2.setPower(BR);
        mo.motor3.setPower(FL);
        mo.motor4.setPower(FR);
        mo.motor5.setPower(armpower);
        mo.motor7.setPower(colorArm);
        */
        float g1LeftY = -gamepad1.left_stick_y;
        float g1RightX = gamepad1.right_stick_x;
        float g1RightY = gamepad1.right_stick_y;

        float armpower = -gamepad2.right_stick_y;
        // I switched the plus and minus signs for g1RightX
        float FL = -g1LeftY + g1RightX - g1RightY;
        float BR = g1LeftY + g1RightX - g1RightY;
        float FR = g1LeftY - g1RightX - g1RightY;
        float BL = -g1LeftY - g1RightX - g1RightY;

        //this makes it to where the speeds cant get below -1 or above
        Range.clip(FL, -1, 1);
        Range.clip(BL, -1, 1);
        Range.clip(FR, -1, 1);
        Range.clip(BR, -1, 1);


//        mo.motor1.setPower(BL);
//        mo.motor2.setPower(BR);
//        mo.motor3.setPower(FL);
//        mo.motor4.setPower(FR);
        mo.motor5.setPower(armpower/19.5);

        //Ext
        if (gamepad2.a) {
            mo.servo1.setPosition(1);
        }
        //flat
        if (gamepad2.b) {
            mo.servo2.setPosition(0);
        }
        //Flat
        if (gamepad2.x) {
            mo.servo1.setPosition(0);
        }
        //Flat
        if (gamepad2.y){
            mo.servo2.setPosition(.9);
        }
        if(gamepad1.right_trigger >.1){
            mo.motor1.setPower(BL/2);
            mo.motor2.setPower(BR/2);
            mo.motor3.setPower(FL/2);
            mo.motor4.setPower(FR/2);
        }else{
            mo.motor1.setPower(FL);
            mo.motor2.setPower(FR);
            mo.motor3.setPower(BL);
            mo.motor4.setPower(BR);
        }

        telemetry.update();
        telemetry.addData("g1LeftY:",-gamepad1.left_stick_y);
        telemetry.addData("g1RightX",gamepad1.right_stick_x);
        telemetry.addData("g1RightY",gamepad1.right_stick_y);
        telemetry.addData("motor1: ", BL);
        telemetry.addData("motor2: ", BR);
        telemetry.addData("motor3: ", FL);
        telemetry.addData("motor4: ", FR);
//        telemetry.addData("clawServo: ", mo.servo1.getPosition());
//        telemetry.addData("colorServo: ", mo.servo2.getPosition());
//        telemetry.addData("colorArm: ", mo.motor7.getCurrentPosition());
//        telemetry.addData("armMotor: ", mo.motor5.getCurrentPosition());
    }
}

