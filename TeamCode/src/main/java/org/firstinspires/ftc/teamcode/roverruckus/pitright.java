package org.firstinspires.ftc.teamcode.roverruckus;
import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.MasterOp;

@Autonomous(name = "pitright", group = "pitright")

public class pitright extends OpMode {
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
//                mo.motor6.setPower(.8);
//                if (mo.motor6.getCurrentPosition()> 500){
//                    mo.shutdownAllMotors();
//                    mo.resetEncoders();
//                    mo.v_state++;
//                }
                mo.v_state++;
                break;

            case 2:
                mo.PowerL(.3,220);
                break;

            case 3:
                mo.run_using_encoders();
                mo.PowerF(.3,2100);
                break;

            case 4:
                mo.zeroTurnR(.3,1700);
                break;

            case 5:
                mo.PowerF(.5,4000);
                break;

            case 6:
                mo.zeroTurnL(.3,2200);
                break;

            case 7:
                mo.PowerF(1,3200);
                break;

            case 8:
                mo.shutdownAllMotors();
                mo.resetEncoders();
        }}}