import static java.lang.Float.NaN;

/**
 * class calcuates quadratic equation roots
 */
public class QuadraticEquation {
    /**
     * x^2 factor
     */
    float a;
    /**
     * x factor
     */
    float b;
    /**
     * free member
     */
    float c;
    /**
     * first root
     */
    String x1 = null;
    /**
     * second root
     */
    String x2 = null;

    /**
     * Constructor with factors parameters
     */
    QuadraticEquation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;

        findroots();
    }

    /**
     * class calcuates quadratic equation discriminant
     */
    private class Discriminant {
        float D = NaN;

        Discriminant() {
            this.D = (float) (b * b - 4 * a * c);
        }

        float getValue() {
            return D;
        }

        float getSqrtValue() {
            if (D >= 0) {
                return (float) Math.sqrt(D);
            } else {
                return NaN;
            }
        }
    }

    /**
     * method which searches x1 and x2
     */
    private void findroots() {
        Float root1;
        Float root2;

        //Check if equation is linear
        if (a == 0.0) {
            x1 = findLinearRoot();
            x2 = "None";

            return;
        }

        Discriminant Disc = new Discriminant();
        float D = Disc.getValue();

        if (D >= 0.0) {
            float SqrtD = Disc.getSqrtValue();

            root1 = (-b - SqrtD) / (2 * a);
            root2 = (-b + SqrtD) / (2 * a);

            x1 = root1.toString();
            x2 = root2.toString();

            return;
        }

        if (D < 0) {
            x1 = "None";
            x2 = "None";
            return;
        }

    }

    /**
     * method which searches Linear of bx + c = 0 equation
     */
    private String findLinearRoot() {
        Float root = NaN;

        if (b == 0.0 && c != 0.0) {
            return "NoRoot";
        }

        if (b == 0.0 && c == 0.0) {
            return "Any";
        }

        root = -c / b;

        return root.toString();
    }

    /**
     * method which returns firsst root
     */
    public String getFirstRoot() {
        return x1;
    }

    /**
     * method which returns second root
     */
    public String getSecondRoot() {
        return x2;
    }

    public String toString() {
        return a + "x^2 + " + b + "x + " + c + " = 0";
    }

}

