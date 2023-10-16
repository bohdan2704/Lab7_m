package org.example;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

public class Lagrange {
    public static void Calculate() {
        // Given data points
        int n = 4;
        double[] xList = {-0.5, 	0, 	0.5, 	1 };
        double[] yList = {2, 	-1, 	1, 	0};

        TablePrint(xList, yList);
        int shift = 1;

        System.out.println("\nNext Lagrange Polynomials 1th");
        PolynomialFunction[] polynomialFirstFormList = new PolynomialFunction[n - shift];
        for (int i = 0; i < polynomialFirstFormList.length; i++) {
            polynomialFirstFormList[i] = createLagrangePolynomialFromTwoPoints(xList[i], yList[i], xList[i + 1], yList[i + 1]);
            System.out.printf("[%d] Polynomial: %s\n", i, polynomialFirstFormList[i].toString());
//            System.out.println("x | f(x): " + xList[i] + " -- " + polynomialFirstFormList[i].value(xList[i]));
        }
        System.out.println("\nNext Lagrange Polynomials 2th");
        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
        PolynomialFunction[] polynomialSecondFormList = new PolynomialFunction[n - shift];
        for (int i = 0; i < polynomialSecondFormList.length; i++) {
            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});
//            System.out.println("AdditionalPolynom1 polynomial: " + additionalPolynom1.toString());
//            System.out.println("AdditionalPolynom2 polynomial: " + additionalPolynom2.toString());

            PolynomialFunction tempPositive = polynomialFirstFormList[i].multiply(additionalPolynom2);
            PolynomialFunction tempNegative = polynomialFirstFormList[i+1].multiply(additionalPolynom1);
            polynomialSecondFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
            System.out.printf("[%d] Polynomial: %s\n", i, polynomialSecondFormList[i].toString());
//            System.out.println("x | f(x): " + xList[i] + " -- " + polynomialSecondFormList[i].value(xList[i]));
//            System.out.println("x-next | f(x-next): " + xList[i+1] + " -- " + polynomialSecondFormList[i].value(xList[i+1]));
//            System.out.println("x-next | f(x-next): " + xList[i+2] + " -- " + polynomialSecondFormList[i].value(xList[i+2]));
        }
        System.out.println("\nNext Lagrange Polynomials 3th");

        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
        PolynomialFunction[] polynomialThirdFormList = new PolynomialFunction[n - shift];
        for (int i = 0; i < polynomialThirdFormList.length; i++) {
            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});
//            System.out.println("AdditionalPolynom1 polynomial: " + additionalPolynom1.toString());
//            System.out.println("AdditionalPolynom2 polynomial: " + additionalPolynom2.toString());

            PolynomialFunction tempPositive = polynomialSecondFormList[i].multiply(additionalPolynom2);
            PolynomialFunction tempNegative = polynomialSecondFormList[i+1].multiply(additionalPolynom1);
            polynomialThirdFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
            System.out.printf("[%d] Polynomial: %s\n", i, polynomialThirdFormList[i].toString());
//            System.out.println("x | f(x): " + xList[i] + " -- " + polynomialThirdFormList[i].value(xList[i]));
//            System.out.println("x-next | f(x-next): " + xList[i+1] + " -- " + polynomialThirdFormList[i].value(xList[i+1]));
//            System.out.println("x-next | f(x-next): " + xList[i+2] + " -- " + polynomialThirdFormList[i].value(xList[i+2]));
//            System.out.println("x-next | f(x-next): " + xList[i+3] + " -- " + polynomialThirdFormList[i].value(xList[i+3]));
        }
//        System.out.println("\nNext Lagrange Polynomials 4th");
//
//        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
//        PolynomialFunction[] polynomialForthFormList = new PolynomialFunction[n - shift];
//        for (int i = 0; i < polynomialForthFormList.length; i++) {
//            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
//            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});
////            System.out.println("AdditionalPolynom1 polynomial: " + additionalPolynom1.toString());
////            System.out.println("AdditionalPolynom2 polynomial: " + additionalPolynom2.toString());
//
//            PolynomialFunction tempPositive = polynomialThirdFormList[i].multiply(additionalPolynom2);
//            PolynomialFunction tempNegative = polynomialThirdFormList[i+1].multiply(additionalPolynom1);
//            polynomialForthFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
//            System.out.printf("[%d] Polynomial: %s\n", i, polynomialForthFormList[i].toString());
////            System.out.println("x | f(x): " + xList[i] + " -- " + polynomialForthFormList[i].value(xList[i]));
////            System.out.println("x-next | f(x-next): " + xList[i+1] + " -- " + polynomialForthFormList[i].value(xList[i+1]));
////            System.out.println("x-next | f(x-next): " + xList[i+2] + " -- " + polynomialForthFormList[i].value(xList[i+2]));
////            System.out.println("x-next | f(x-next): " + xList[i+3] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
////            System.out.println("x-next | f(x-next): " + xList[i+4] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
//        }
//        System.out.println("\nNext Lagrange Polynomials 5th");
//        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
//        PolynomialFunction[] polynomialFifthFormList = new PolynomialFunction[n - shift];
//        for (int i = 0; i < polynomialFifthFormList.length; i++) {
//            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
//            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});
////            System.out.println("AdditionalPolynom1 polynomial: " + additionalPolynom1.toString());
////            System.out.println("AdditionalPolynom2 polynomial: " + additionalPolynom2.toString());
//
//            PolynomialFunction tempPositive = polynomialForthFormList[i].multiply(additionalPolynom2);
//            PolynomialFunction tempNegative = polynomialForthFormList[i+1].multiply(additionalPolynom1);
//            polynomialFifthFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
//            System.out.printf("[%d] Polynomial: %s\n", i, polynomialFifthFormList[i].toString());
////            System.out.println("x | f(x): " + xList[i] + " -- " + polynomialForthFormList[i].value(xList[i]));
////            System.out.println("x-next | f(x-next): " + xList[i+1] + " -- " + polynomialForthFormList[i].value(xList[i+1]));
////            System.out.println("x-next | f(x-next): " + xList[i+2] + " -- " + polynomialForthFormList[i].value(xList[i+2]));
////            System.out.println("x-next | f(x-next): " + xList[i+3] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
////            System.out.println("x-next | f(x-next): " + xList[i+4] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
//        }
//        System.out.println("\nNext Lagrange Polynomials 6th");
//        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
//        PolynomialFunction[] polynomialSixthFormList = new PolynomialFunction[n - shift];
//        for (int i = 0; i < polynomialSixthFormList.length; i++) {
//            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
//            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});
////            System.out.println("AdditionalPolynom1 polynomial: " + additionalPolynom1.toString());
////            System.out.println("AdditionalPolynom2 polynomial: " + additionalPolynom2.toString());
//
//            PolynomialFunction tempPositive = polynomialFifthFormList[i].multiply(additionalPolynom2);
//            PolynomialFunction tempNegative = polynomialFifthFormList[i+1].multiply(additionalPolynom1);
//            polynomialSixthFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
//            System.out.printf("[%d] Polynomial: %s\n", i, polynomialSixthFormList[i].toString());
////            System.out.println("x | f(x): " + xList[i] + " -- " + polynomialForthFormList[i].value(xList[i]));
////            System.out.println("x-next | f(x-next): " + xList[i+1] + " -- " + polynomialForthFormList[i].value(xList[i+1]));
////            System.out.println("x-next | f(x-next): " + xList[i+2] + " -- " + polynomialForthFormList[i].value(xList[i+2]));
////            System.out.println("x-next | f(x-next): " + xList[i+3] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
////            System.out.println("x-next | f(x-next): " + xList[i+4] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
//        }
//        System.out.println("\nNext Lagrange Polynomials 7th");
//        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
//        PolynomialFunction[] polynomialSeventhFormList = new PolynomialFunction[n - shift];
//        for (int i = 0; i < polynomialSeventhFormList.length; i++) {
//            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
//            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});
////            System.out.println("AdditionalPolynom1 polynomial: " + additionalPolynom1.toString());
////            System.out.println("AdditionalPolynom2 polynomial: " + additionalPolynom2.toString());
//
//            PolynomialFunction tempPositive = polynomialSixthFormList[i].multiply(additionalPolynom2);
//            PolynomialFunction tempNegative = polynomialSixthFormList[i+1].multiply(additionalPolynom1);
//            polynomialSeventhFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
//            System.out.printf("[%d] Polynomial: %s\n", i, polynomialSeventhFormList[i].toString());
////            System.out.println("x | f(x): " + xList[i] + " -- " + polynomialForthFormList[i].value(xList[i]));
////            System.out.println("x-next | f(x-next): " + xList[i+1] + " -- " + polynomialForthFormList[i].value(xList[i+1]));
////            System.out.println("x-next | f(x-next): " + xList[i+2] + " -- " + polynomialForthFormList[i].value(xList[i+2]));
////            System.out.println("x-next | f(x-next): " + xList[i+3] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
////            System.out.println("x-next | f(x-next): " + xList[i+4] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
//        }
//        System.out.println("\nNext Lagrange Polynomials 8th");
//        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
//        PolynomialFunction[] polynomialEighthFormList = new PolynomialFunction[n - shift];
//        for (int i = 0; i < polynomialEighthFormList.length; i++) {
//            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
//            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});
////            System.out.println("AdditionalPolynom1 polynomial: " + additionalPolynom1.toString());
////            System.out.println("AdditionalPolynom2 polynomial: " + additionalPolynom2.toString());
//
//            PolynomialFunction tempPositive = polynomialSeventhFormList[i].multiply(additionalPolynom2);
//            PolynomialFunction tempNegative = polynomialSeventhFormList[i+1].multiply(additionalPolynom1);
//            polynomialEighthFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
//            System.out.printf("[%d] Polynomial: %s\n", i, polynomialEighthFormList[i].toString());
////            System.out.println("x | f(x): " + xList[i] + " -- " + polynomialForthFormList[i].value(xList[i]));
////            System.out.println("x-next | f(x-next): " + xList[i+1] + " -- " + polynomialForthFormList[i].value(xList[i+1]));
////            System.out.println("x-next | f(x-next): " + xList[i+2] + " -- " + polynomialForthFormList[i].value(xList[i+2]));
////            System.out.println("x-next | f(x-next): " + xList[i+3] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
////            System.out.println("x-next | f(x-next): " + xList[i+4] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
//        }
//        System.out.println("\nNext Lagrange Polynomials 9th");
//        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
//        PolynomialFunction[] polynomialNinthFormList = new PolynomialFunction[n - shift];
//        for (int i = 0; i < polynomialNinthFormList.length; i++) {
//            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
//            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});
////            System.out.println("AdditionalPolynom1 polynomial: " + additionalPolynom1.toString());
////            System.out.println("AdditionalPolynom2 polynomial: " + additionalPolynom2.toString());
//
//            PolynomialFunction tempPositive = polynomialEighthFormList[i].multiply(additionalPolynom2);
//            PolynomialFunction tempNegative = polynomialEighthFormList[i+1].multiply(additionalPolynom1);
//            polynomialNinthFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
//            System.out.printf("[%d] Polynomial: %s\n", i, polynomialNinthFormList[i].toString());
////            System.out.println("x | f(x): " + xList[i] + " -- " + polynomialForthFormList[i].value(xList[i]));
////            System.out.println("x-next | f(x-next): " + xList[i+1] + " -- " + polynomialForthFormList[i].value(xList[i+1]));
////            System.out.println("x-next | f(x-next): " + xList[i+2] + " -- " + polynomialForthFormList[i].value(xList[i+2]));
////            System.out.println("x-next | f(x-next): " + xList[i+3] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
////            System.out.println("x-next | f(x-next): " + xList[i+4] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
//        }
//        System.out.println("\nNext Lagrange Polynomials 10th");
//        shift++; // INCREMENT DIFFERENCE BETWEEN POLYNOMS
//        PolynomialFunction[] polynomialTenthFormList = new PolynomialFunction[n - shift];
//        for (int i = 0; i < polynomialTenthFormList.length; i++) {
//            PolynomialFunction additionalPolynom1 = new PolynomialFunction(new double[]{-xList[i], 1});
//            PolynomialFunction additionalPolynom2 = new PolynomialFunction(new double[]{-xList[i+shift], 1});
////            System.out.println("AdditionalPolynom1 polynomial: " + additionalPolynom1.toString());
////            System.out.println("AdditionalPolynom2 polynomial: " + additionalPolynom2.toString());
//
//            PolynomialFunction tempPositive = polynomialNinthFormList[i].multiply(additionalPolynom2);
//            PolynomialFunction tempNegative = polynomialNinthFormList[i+1].multiply(additionalPolynom1);
//            polynomialTenthFormList[i] = tempNegative.subtract(tempPositive).multiply(new PolynomialFunction(new double[] {1/(xList[i+shift]-xList[i])} ) );
//            System.out.printf("[%d] Polynomial: %s\n", i, polynomialTenthFormList[i].toString());
////            System.out.println("x | f(x): " + xList[i] + " -- " + polynomialForthFormList[i].value(xList[i]));
////            System.out.println("x-next | f(x-next): " + xList[i+1] + " -- " + polynomialForthFormList[i].value(xList[i+1]));
////            System.out.println("x-next | f(x-next): " + xList[i+2] + " -- " + polynomialForthFormList[i].value(xList[i+2]));
////            System.out.println("x-next | f(x-next): " + xList[i+3] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
////            System.out.println("x-next | f(x-next): " + xList[i+4] + " -- " + polynomialForthFormList[i].value(xList[i+3]));
//        }

//        System.out.println("\nTo find our root we should take 4th form of polynomial based on 0.772 point. And pass 0.775 parameter to find cos(x) value");
//        PolynomialFunction[] aproximateFunctions = {polynomialFirstFormList[2], polynomialSecondFormList[2], polynomialThirdFormList[2], polynomialForthFormList[2]};
//        double tablY = Math.cos(val);
//        for (int i = 0; i < 4; i++) {
//            System.out.printf("Working with Lagrange [%dth] f(x): %s\n", i, aproximateFunctions[i].toString());
//            double calcY = aproximateFunctions[i].value(val);
//            System.out.printf("x = %f f(x) = %f e = %.15f\n", val, aproximateFunctions[i].value(val), Math.abs(calcY-tablY));
//        }
        System.out.println("Виконав студент групи ОІ-26 Харитонов Артур");

    }

    private static PolynomialFunction createLagrangePolynomialFromTwoPoints(double x0, double y0, double x1, double y1) {
        double b = (y0*x1 - y1*x0)/(x1-x0);
        double k = (y1-y0)/(x1-x0);

        double[] coefficients = {b,k};
        return new PolynomialFunction(coefficients);
    }
    public static void TablePrint(double[] xList, double[] yList) {
        // Print the table header
        System.out.printf("%-10s%-15s%n", "x", "f(x)");
        System.out.println("----------------------------");

        // Print the values in a table format
        for (int i = 0; i < xList.length; i++) {
            System.out.printf("%-10.3f | \t%-15.6f%n", xList[i], yList[i]);
        }
    }
}
