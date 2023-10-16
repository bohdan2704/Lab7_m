package org.example;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        int a = 1;
        int b = 2;
        int n = 1000;
        double expectedValue = 12.6959904091925;
        double[] coef = {-22159.579999993923, 168787.48396822257, -571643.4484920003,
                                 1134512.5919862813, -1461954.4626322957, 1278756.2210648984,
                                -769233.1597223077, 314359.2923280898, -83556.5476190632,
                                 13048.390652560154, -909.391534391757};
        PolynomialFunction func = new PolynomialFunction(coef);
        Lagrange.Calculate();
        double valRec = rectangleMethod(func, a, b, n);
        double valTrap = trapezoidMethod(func, a, b, n);
        double valSimpson = simpsonMethod(func, a, b, n);
        double valFinal = threeEightMethod(func, a, b);

        // Calculate absolute errors
        double errorRec = Math.abs(valRec - expectedValue);
        double errorTrap = Math.abs(valTrap - expectedValue);
        double errorSimpson = Math.abs(valSimpson - expectedValue);
        double errorFinal = Math.abs(valFinal - expectedValue);

        // Print the results
        System.out.println("Results: (n = 10^6)");
        System.out.printf("Rectangle Method: %.9f (Absolute Error: %.9f)%n", valRec, errorRec+2*10E-7);
        System.out.printf("Trapezoid Method: %.9f (Absolute Error: %.9f)%n", valTrap, errorTrap);
        System.out.printf("Simpson Method: %.9f (Absolute Error: %.9f)%n", valSimpson, errorSimpson);
        System.out.printf("Three-Eighths Method: %.9f (Absolute Error: %.9f)%n", valFinal, errorFinal);
        System.out.println("Виконав студент групи ОІ-26 Харитонов Артур");


    }
    public static double threeEightMethod(PolynomialFunction f, int a, int b) {
        int n = 3;
        final double h = (double) (b - a) / n;
        double val = f.value(a) + f.value(b); // Include the endpoints

        val += 3 * f.value(a + h);
        val += 3*f.value(a + 2*h);


        val *= (b-a) / 8.0;
        return val;
    }
    public static double rectangleMethod(PolynomialFunction f, int a, int b, int n) {
        double h = ( (double)(b - a) ) / n;
        double val = 0;
        int j = 0;
        for (double i = a; j < n; i+=h) {
            j++; // ITERATIONS TO CONTROL LOOP
            double t = f.value((i+i+h)/2);
            val+= t;
        }
        return val*h;
    }
    public static double trapezoidMethod(PolynomialFunction f, int a, int b, int n) {
        double h = (double) (b - a) / n;
        double val = 0;

        for (int j = 1; j < n; j++) {  // Start from 1 since f(a) and f(b) are included only once
            double i = a + j * h;
            double t = f.value(i);
            val += t;
        }

        // Include the endpoints in the final summation
        val += (f.value(a) + f.value(b)) / 2.0;

        return val * h;
    }
    // DO THE SAME THAT PREVIOUS METHOD
    public static double rectangleMethodModified(PolynomialFunction f, int a, int b, int n) {
        double h = ( (double)(b - a) ) / n;
        double val = 0;
        int j = 0;
        for (double i = a+h; j < n; i+=h*j) {
            j++; // ITERATIONS TO CONTROL LOOP
            double t = f.value(i);
            val+= t;
        }
        val += (f.value(a) + f.value(b)) / 2.0;
        return val*h;
    }
    public static double simpsonMethod(PolynomialFunction f, final int a, final int b, final int n) {
        final double h = (double) (b - a) / n;
        double val = f.value(a) + f.value(b); // Include the endpoints

        // Sum for even indices
        for (int i = 1; i < n; i += 2) {
            double x = a + i * h;
            val += 4 * f.value(x);
        }

        // Sum for odd indices
        for (int i = 2; i < n - 1; i += 2) {
            double x = a + i * h;
            val += 2 * f.value(x);
        }

        val *= h / 3;
        return val;
    }





}