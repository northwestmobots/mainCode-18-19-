package org.firstinspires.ftc.teamcode.roverruckus;
import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.MasterOp;

@Autonomous(name = "pitdepot", group = "pitdepot")

public class pitdepot extends OpMode {
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

//* lower robot from lander
//  case 1:
//  lower robot from lander
//* move robot forwards

            case 1:
                mo.run_using_encoders();
                mo.PowerF(.3,1640);
                break;

            case 2:
                mo.zeroTurnL(.3,1700);
                break;

            case 3:
                mo.PowerF(.7,2500);
                break;

            case 4:
                mo.zeroTurnL(.3,1700);
                break;

            case 5:
                mo.PowerF(.7,7500);
                break;

            case 6:
                mo.zeroTurnL(.3,830);
                break;
            case 7:
                mo.PowerB(.7,-4100);
                break;
            case 8:
                mo.PowerF(1,7500);
                break;

        }}}