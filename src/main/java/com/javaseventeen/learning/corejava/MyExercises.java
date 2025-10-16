package com.javaseventeen.learning.corejava;

import java.util.Scanner;

public class MyExercises {
    public void run() {
        System.out.println("Running Java exercises...");

        Scanner input = new Scanner(System.in); // create scanner object

        System.out.print("Enter a number A: ");
        int a = input.nextInt();

        System.out.print("Enter a number B: ");
        int b = input.nextInt();

        System.out.printf("The sum of %d and %d = %d ", a, b, a+b );
    }

}
