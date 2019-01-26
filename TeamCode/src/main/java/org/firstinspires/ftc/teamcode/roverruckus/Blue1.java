package org.firstinspires.ftc.teamcode.roverruckus;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.MasterOp;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Blue1", group = "Blue1")

public class Blue1 extends OpMode {
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
                 mo.PowerF(.3, 4800);

                 break;

             //*move to the right
             case 3:
                 mo.PowerR(.3,12000);
                 break;

             //*turn left toward depot
             case 4:
                 mo.motor4.setPower(.3);
                    if (mo.motor4.getCurrentPosition() > 500){
                 mo.shutdownAllMotors();
                 mo.resetEncoders();
                 mo.v_state++; }
                 break;

             //*move forward
             case 5:
                 mo.PowerF(.3,13200);
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

