package main.java.roaringutils;
public class DeadzoneUtils {
    public static double SquaredDeadband(double axis_value) {
        final double SCALE_EXPONENT = 2;
        final double DEADZONE_SIZE = 0.3;

        // creates scale factor based on deadzone size, so entire output area is still
        // usable
        double ScaleFactor = 1 / (1 - DEADZONE_SIZE);

        // x/|x| = 1 or -1 depending on sign of x
        double axis_sign = axis_value / Math.abs(axis_value);

        double unsigned_return_value = Math.abs(axis_value);

        unsigned_return_value = unsigned_return_value - DEADZONE_SIZE;

        if (unsigned_return_value < 0) { // set value to 0 if it's within the DEADZONE
          unsigned_return_value = 0;
        }
        unsigned_return_value = unsigned_return_value * ScaleFactor;

        unsigned_return_value = Math.pow(unsigned_return_value, SCALE_EXPONENT);
        if (Math.abs(axis_value) > DEADZONE_SIZE) {
        return axis_sign * unsigned_return_value;
        } else return 0;
    }
    
    public static double SquaredDeadband(double axis_value, double deadzone) {
        
        final double SCALE_EXPONENT = 2;
        final double DEADZONE_SIZE = Math.abs(deadzone);

        // creates scale factor based on deadzone size, so entire output area is still
        // usable
        double ScaleFactor = 1 / (1 - DEADZONE_SIZE);

        // x/|x| = 1 or -1 depending on sign of x
        double axis_sign = axis_value / Math.abs(axis_value);

        double unsigned_return_value = Math.abs(axis_value);

        unsigned_return_value = unsigned_return_value - DEADZONE_SIZE;

        if (unsigned_return_value < 0) { // set value to 0 if it's within the DEADZONE
          unsigned_return_value = 0;
        }
        unsigned_return_value = unsigned_return_value * ScaleFactor;

        unsigned_return_value = Math.pow(unsigned_return_value, SCALE_EXPONENT);
        if (Math.abs(axis_value) > DEADZONE_SIZE) {
        return axis_sign * unsigned_return_value;
        } else return 0;
    }
    
    public static double SquaredDeadband(double axis_value, double deadzone, double exp) {
        final double SCALE_EXPONENT = Math.abs(exp);
        final double DEADZONE_SIZE = Math.abs(deadzone);

        // creates scale factor based on deadzone size, so entire output area is still
        // usable
        double ScaleFactor = 1 / (1 - DEADZONE_SIZE);

        // x/|x| = 1 or -1 depending on sign of x
        double axis_sign = axis_value / Math.abs(axis_value);

        double unsigned_return_value = Math.abs(axis_value);

        unsigned_return_value = unsigned_return_value - DEADZONE_SIZE;

        if (unsigned_return_value < 0) { // set value to 0 if it's within the DEADZONE
          unsigned_return_value = 0;
        }
        unsigned_return_value = unsigned_return_value * ScaleFactor;

        unsigned_return_value = Math.pow(unsigned_return_value, SCALE_EXPONENT);
        if (Math.abs(axis_value) > DEADZONE_SIZE) {
        return axis_sign * unsigned_return_value;
        } else return 0;
    }
    
    public static double GenericDeadband(double raw, double deadzone) {

        if (Math.abs(raw)<deadzone) {
            return 0;
        } else {
            return raw;
        }
    }

     public static double LinearDeadband(double raw, double deadzone) {
        double c = deadzone;
        double slope = 1/(1-c);
        double sign = raw/Math.abs(raw);
        if (Math.abs(raw)>c) {
          return slope*(raw - (sign*c));
        } else {
          return 0;
        }
        
        //TODO add in linear deadband using slope claculation
    }
}

