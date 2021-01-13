package utils;

import java.awt.geom.Point2D;

public class Utils {
    public static String parsePoint2D(Point2D.Double point){
        return "x: " + point.x + ", y: " + point.y;
    }
}
