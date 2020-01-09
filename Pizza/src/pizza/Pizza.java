/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza;

import java.util.Scanner;

/**
 *
 * @author Belle
 */
public class Pizza {

    public static double area(double diameter) {
        return (diameter / 2) * (diameter / 2) * Math.PI;

    }

    public static double pricePerSquare(double diameter, double price) {
        return ((area(diameter)) / price);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int count = 1;
        double min = Integer.MAX_VALUE;

        while (count <= 10) {

            System.out.println("What is the size of your pizza in inches?");
            double diameter = keyboard.nextDouble();
            System.out.println("The area of your pizza is " + area(diameter) + " square inches");

            System.out.println("What is the price of your pizza?");
            double price = keyboard.nextDouble();
            System.out.println("The price per square inch is " + pricePerSquare(diameter, price));

            count = count + 1;

            if (count == 1) {
                min = pricePerSquare(diameter, price);
            } else if (pricePerSquare(diameter, price) < min) {
                min = pricePerSquare(diameter, price);
            }
        }
        System.out.println("The cheapest value pizza of all entered options is " + min + " dollars");
    }
}
