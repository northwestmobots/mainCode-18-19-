package org.firstinspires.ftc.teamcode.roverruckus;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.MasterOp;

@Autonomous(name = "depotRight", group = "depotRight")
public class depotRight extends OpMode {
    MasterOp mo = new MasterOp();

    @Override
    public void init()
    {
        mo.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("v_state: ", mo.v_state);
        telemetry.addData("motor3: ", mo.motor3.getCurrentPosition());
        telemetry.addData("motor5", mo.motor5.getCurrentPosition());
        switch (mo.v_state) {

            case 0:
                mo.resetEncoders();
                mo.shutdownAllMotors();
                mo.v_state++;
                break;

            //lower robot from lander
            case 1:
                mo.run_using_encoders();
                mo.motor5.setPower(1);
                if (mo.motor5.getCurrentPosition() > 26000) {
                    mo.shutdownAllMotors();
                    mo.resetEncoders();
                    mo.v_state++;
                }
                    break;

                    //move left
            case 2:
                mo.run_using_encoders();
                mo.PowerR(.2,1000);
                break;

            case 3:
                mo.run_using_encoders();
                mo.PowerB(.8, -1360);
                break;

            case 4:
                mo.run_using_encoders();
                mo.zeroTurnR(.4,1500);
                break;

            case 5:
                mo.run_using_encoders();
                mo.PowerB(.8,-3500);
                 break;

            case 6:
                mo.run_using_encoders();
                mo.zeroTurnL(.4,3000);
                break;

            //move forward
            case 7:
                mo.run_using_encoders();
                mo.PowerB(.8,-5500);
                break;

//            //turn left toward depot
//            case 8:
//                mo.run_using_encoders();
//                mo.zeroTurnR(.3,850);
//                break;
//
            //move forward
            case 8:
                mo.servo1.setPosition(0);
                break;
//
//            //drop marker in depot
//            case 10:
//                mo.servo1.setPosition(1);
//                mo.v_state++;
//                break;
//
//            //move forward
//            case 11:
//                mo.run_using_encoders();
//                mo.PowerB(1,7500);
//                break;
//
//            //park
//            case 12:
//                mo.run_using_encoders();
//                mo.shutdownAllMotors();
//                mo.resetEncoders();
//                break;

                }
    }
}


