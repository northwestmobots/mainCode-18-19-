package org.firstinspires.ftc.teamcode.roverruckus;
        import com.qualcomm.robotcore.eventloop.opmode.*;

        import org.firstinspires.ftc.teamcode.MasterOp;

@Autonomous(name = "pitleft", group = "pitleft")

public class pitleft extends OpMode {
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
                mo.PowerL(.3,200);
                break;

            case 3:
                mo.run_using_encoders();
                mo.PowerF(.3,2100);
                break;

            case 4:
                mo.zeroTurnR(.3,1700);
                break;

            case 5:
                mo.PowerB(.5,-3700);
                break;

            case 6:
                mo.zeroTurnL(.3,930);
                break;

            case 7:
                mo.PowerB(.5,-3200);
                break;

            case 8:
                mo.run_using_encoders();
                mo.motor8.setPower(.2);
                if (mo.motor8.getCurrentPosition()> 300){
                    mo.shutdownAllMotors();
                    mo.resetEncoders();
                    mo.v_state++;}
                break;
            case 9:
                mo.PowerF(1,7500);
                break;

            case 10:
                mo.shutdownAllMotors();
                mo.resetEncoders();

        }}}