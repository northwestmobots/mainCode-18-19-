package org.firstinspires.ftc.teamcode.roverruckus;
import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.MasterOp;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Red2", group = "Red2")

public class Red2 extends OpMode {
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

            //*lower robot from lander
            case 1:
                // lower robot from lander
                break;

            //*move robot forwards
            case 2:
                mo.PowerF(.3, 6000);

                break;

            //*move to the left
            case 3:
                mo.PowerL(.3,10800);
                break;

            //*turn left toward depot
            case 4:
                mo.motor4.setPower(.3);
                if (mo.motor4.getCurrentPosition() > 1000){
                    mo.shutdownAllMotors();
                    mo.resetEncoders();
                    mo.v_state++; }
                break;

            //*move forward
            case 5:
                mo.PowerF(.3,11700);
                break;

            //*drop marker
            case 6:
                //drop marker in depot
                break;

            //* move backward
            case 7:
                mo.PowerB(.3,21900);
                break;

            //*park
            case 8:
                mo.shutdownAllMotors();
                mo.resetEncoders();
                break;


        }


    }}



