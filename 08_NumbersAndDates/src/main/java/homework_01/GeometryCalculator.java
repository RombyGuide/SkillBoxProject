package homework_01;

public class GeometryCalculator {

    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        if (radius >= 0) {
            return Math.abs(Math.PI * Math.pow(radius, 2));
        } else {
            return -1;
        }
    }

    // если значение radius меньше 0, метод должен вернуть -1
    public static double getSphereVolume(double radius) {
        if (radius >= 0) {
            return (4 * Math.PI * Math.pow(radius, 3))/3;
        } else {
            return -1;
        }
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if ((a + b > c) && (b + c > a) && (a + c > b)) {
            return true;
        }
        else {
            return false;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double p = ((a + b + c) / 2);

        if (isTrianglePossible(a, b, c)) {
            return Math.sqrt(p * ((p - a) * (p - b) * (p - c)));
        }

        return -1.0;
    }
}
