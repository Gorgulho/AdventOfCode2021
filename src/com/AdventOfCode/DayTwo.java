package com.AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwo {

    public static int[] CalculatePosition(Scanner scan) {
        int[] result = new int[2];
        int horizontalPosition = 0;
        int depth = 0;

        while (scan.hasNextLine()) {
            String command = scan.next();
            int value = scan.nextInt();
            switch (command) {
                case "forward" -> horizontalPosition += value;
                case "down" -> depth += value;
                case "up" -> depth -= value;
            }
        }
        result[0] = horizontalPosition;
        result[1] = depth;
        return result;
    }

    public static int[] CalculatePositionAim(Scanner scan) {
        int[] result = new int[2];
        int horizontalPosition = 0;
        int aim = 0;
        int depth = 0;

        while (scan.hasNextLine()){
            String command = scan.next();
            int value = scan.nextInt();
            switch (command) {
                case "forward" -> {
                    horizontalPosition += value;
                    depth += aim * value;
                }
                case "down" -> aim += value;
                case "up" -> aim -= value;
            }
        }
        result[0] = horizontalPosition;
        result[1] = depth;
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("../input2.txt");

        Scanner scan = new Scanner(file);
        
        //Problem 1/2 from day 2
        int[] res = CalculatePosition(scan);

        System.out.println("Horizontal Position: " + res[0]);
        System.out.println("Depth: " + res[1]);
        System.out.println("Multiply: " + res[0] * res[1]);
        
        //Problem 2/2 from day 2
        scan = new Scanner(file);

        int[] res2 = CalculatePositionAim(scan);

        System.out.println("Horizontal Position: " + res2[0]);
        System.out.println("Depth: " + res2[1]);
        System.out.println("Multiply: " + res2[0] * res2[1]);
    }
}
