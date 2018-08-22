package sample;

/*
 * @Author: Ihor Shevchenko
 * @Date: 22.08.2018
 * @Version: 1.0.0
 * */

public class Calculate {

    /*Addition
     * @param a The first double value
     * @param b The second double value
     * @return The result of this operation. */
    public double Add(double a, double b) {
        return a + b;
    }

    /* Substration
     * @param a The first double value
     * @param b The second double value
     * @return The result of this operation. */
    public double Sub(double a, double b) {
        return a - b;
    }

    /* Multiplication
     * @param a The first double value
     * @param b The second double value
     * @return The result of this operation. */
    public double Mul(double a, double b) {
        return a * b;
    }

    /* Division
     * @param a The first double value
     * @param b The second double value
     * @return The result of this operation. */
    public double Div(double a, double b) {
        return a / b;
    }

    /* Rise to the square
     *  @param a The first double value.
     *  @return The result of this operation.*/
    public double X2(double a) {
        return a * a;
    }

    /*SQRT
     * @param a The first double value
     * @return The result of this operation.*/
    public double Sqrt(double a) {
        return Math.sqrt(a);
    }

    /*  The procent from this double value
     *  @param a The first double value.
     *  @return The result of this operation.*/
    public double Percent(double a) {
        return a / 100;
    }
}
