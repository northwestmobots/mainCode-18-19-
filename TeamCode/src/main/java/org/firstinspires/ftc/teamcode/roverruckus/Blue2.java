package org.firstinspires.ftc.teamcode.roverruckus;
import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.MasterOp;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name = "Blue2", group = "Blue2")
//  Blue2 is the name of the Java Class. This file must be named to class name with .JAVA extension
//  The eecond line of the program consists of the left brace which must be matched with the
//  second right brace (the very last brace). These braces together mark the beginning and end (the
//  body of) the class Blue2.
//
//  A class that extends another class inherits all the methods and properties of the extended
//  class and you are creating a subclass of the class you are extending

public class Blue2 extends OpMode
    {
    MasterOp mo = new MasterOp();
    @Override
    public void init()
        {
        mo.init(hardwareMap);
        }

    @Override
    public void loop()
        {
        switch (mo.v_state)
            {
//  resetEncoders is a method called from OpMode that stops motors and resets encoders.
//  shutdownALLMotors sets the power of all motors to zero
//  v_state is a public int v_state=0 within the OpMode
//  When a break statement is encountered inside a loop, the loop is immediately terminated
//  and the program control resumes at the next statement following the loop.

            case 0:
                mo.resetEncoders();
                mo.shutdownAllMotors();
                mo.v_state++;

                break;

//  lower robot from lander
            case 1:
// move robot away from lander hook
                break;

//  move robot forwards
            case 2:
                mo.PowerF(.3, 6000);
                break;

//  move robot to the left
            case 3:
                mo.PowerL(.3, 10800);
                break;

//  turn left toward depot
            case 4:
                mo.motor4.setPower(.3);
                if (mo.motor4.getCurrentPosition() > 1000) {
                    mo.shutdownAllMotors();
                    mo.resetEncoders();
                    mo.v_state++;
                }
                break;

//  move forward
            case 5:
                mo.PowerF(.3, 11700);
                break;

//  drop marker
            case 6:
                //drop marker in depot
                break;

//  move backward
            case 7:
                mo.PowerB(.3, 21900);
                break;

//  park
            case 8:
                mo.shutdownAllMotors();
                mo.resetEncoders();
                break;

//  This is the endo of the switch.
            }
//  This is the end of the loop.
        }


    }


