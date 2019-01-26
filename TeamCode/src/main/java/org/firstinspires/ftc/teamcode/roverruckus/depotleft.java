package org.firstinspires.ftc.teamcode.roverruckus;
import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.MasterOp;

@Autonomous(name = "depotleft", group = "depotleft")

public class depotleft extends OpMode {
    MasterOp mo = new MasterOp();
    @Override
    public void init() {
        mo.init(hardwareMap);
    }

    @Override
    public void loop() {
        switch (mo.v_state) {
            case 0:
                mo.resetEncoders();
                mo.shutdownAllMotors();
                mo.v_state++;
                mo.shutdownAllMotors();
                mo.resetEncoders();
                break;

            case 1:
                mo.run_using_encoders();
                mo.motor5.setPower(.1);
                if (mo.motor5.getCurrentPosition()> 26000){
                    mo.shutdownAllMotors();
                    mo.resetEncoders();
                    mo.v_state++;
                }
                break;

            case 2:
                mo.run_using_encoders();
                mo.PowerL(.3,1000);
                break;

            case 3:
                mo.run_using_encoders();
                mo.PowerB(.3,-1360);
                break;

            case 4:
                mo.zeroTurnL(.3,1500);
                break;

            case 5:
                mo.PowerB(.5,-3500);
                break;

            case 6:
                mo.zeroTurnR(.3,3000);
                break;

            case 7:
                mo.PowerB(.5,-5500);
                break;

            case 8:
                mo.servo1.setPosition(0);
                break;
                //

            case 9:
//                mo.PowerF(1,3600);
                mo.v_state++;
                break;

            case 10:
                mo.shutdownAllMotors();
                mo.resetEncoders();
                break;
        }}}