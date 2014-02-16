package tv.ouya.gol.Ouya;

import tv.ouya.console.api.OuyaController;

public class OuyaControllUtil {
    static private float stickMag(float axisX, float axisY) {
        float stickMag = (float) Math.sqrt(axisX * axisX + axisY * axisY);
        return stickMag;
    }

    static public boolean isStickNotCentered(float axisX, float axisY) {
        float stickMag = stickMag(axisX, axisY);
        return (stickMag >= OuyaController.STICK_DEADZONE);
    }
}
