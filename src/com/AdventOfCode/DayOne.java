package com.AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayOne {

    public static int sum3Cord(int[] arr){
        int n = arr.length - 3;
        int prev = arr[0] + arr[1] + arr[2];
        int count = 0;
        for (int i = 1; i <= n; i++){
            int next = arr[i] + arr[i + 1] + arr[i + 2];
            if (next > prev) ++count;

            prev = next;
        }
        return count;
    }

    public static int countIncreases(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int prev = scan.nextInt();
        int count = 0;
        while (scan.hasNextLine()) {
            int next = scan.nextInt();
            if (next > prev) ++count;

            prev = next;
        }

        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
	    File file = new File("../input1.txt");
        int res;

        //Problem 1/2 from day 1
        res = countIncreases(file);
        System.out.println(res);

        //Problem 2/2 from day 1
        Scanner scan = new Scanner(file);

        int[] arr = new int[2000];
        int i = 0;
        while (scan.hasNextLine()){
            arr[i++] = scan.nextInt();
        }
        res = sum3Cord(arr);
        System.out.println(res);
    }
}
