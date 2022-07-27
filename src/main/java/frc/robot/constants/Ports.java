package frc.robot.constants;

/** This file contains the different ports of motors, solenoids and sensors */
public interface Ports {

    public interface Gamepad {
        int DRIVER = 0;
        int OPERATOR = 1;
    }

    public interface Drivetrain {
        // Motors
        int LEFT_FRONT = 10;
        int LEFT_BACK = 11;

        int RIGHT_FRONT = 13;
        int RIGHT_BACK = 14;
    }

    public interface Shooter {
        // Motors
        int TOP = 20;
        int BOTTOM = 21;
        int FEEDER = 22;
    }
}
