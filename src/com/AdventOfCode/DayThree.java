package com.AdventOfCode;

import java.io.*;
import java.util.Arrays;
import java.lang.Math;

public class DayThree {

    public static int gamma(int[] arr, int len){
        int gamma = 0;
        int n = arr.length - 1;
        for (int i : arr) {
            gamma += (i >= len ? 1 : 0) * Math.pow(2, n--);
        }
        return gamma;
    }

    public static int epsilon(int[] arr, int len){
        int epsilon = 0;
        int n = arr.length - 1;
        for (int i : arr){
            epsilon += (i >= len ? 0 : 1) * Math.pow(2, n--);
        }
        return epsilon;
    }

    public static int countOnesInPosition (String[] str, int position){
        int count = 0;

        for (String s : str) {
            count += s.charAt(position) == '1' ? 1 : 0;
        }
        return count;
    }

    public static int countZerosInPosition (String[] str, int position){
        int count = 0;

        for (String s : str) {
            count += s.charAt(position) == '0' ? 1 : 0;
        }
        return count;
    }

    public static String oxygenGeneratorRating (int position, String[] remain){
        if (remain.length == 1) return remain[0];
        int nOnes = countOnesInPosition(remain, position);
        int nZeros = countZerosInPosition(remain, position);
        int n = Math.max(nOnes, nZeros);
        String[] next = new String[n];
        int i = 0;
        boolean control = nOnes >= nZeros;
        for (String str : remain){
            if (control && str.charAt(position) == '1') next[i++] = str;
            else if (!control && str.charAt(position) == '0') next[i++] = str;
        }
        return oxygenGeneratorRating(position+1, next);
    }

    public static String CO2ScrubberRating (int position, String[] remain){
        if (remain.length == 1) return remain[0];
        int nOnes = countOnesInPosition(remain, position);
        int nZeros = countZerosInPosition(remain, position);
        int n = Math.min(nOnes, nZeros);
        String[] next = new String[n];
        boolean control = nOnes >= nZeros;
        int i = 0;

        for (String str : remain){
            if (control && str.charAt(position) == '0') next[i++] = str;
            else if (!control && str.charAt(position) == '1') next[i++] = str;
        }

        return CO2ScrubberRating(position + 1, next);
    }
    public static void main(String[] args) throws IOException {
        String path = "inputs/input3.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));

        //Problem 1/2 from day 3

        int len = 0;
        String str;
        int[] arr = {};
        while ((str = br.readLine()) != null){
            if (len == 0) arr = new int[str.length()];
            for (int i = 0; i < arr.length; i++) arr[i] += str.charAt(i) == '1' ? 1 : 0;
            ++len;
        }
        int gamma = gamma(arr, len/2);
        int epsilon = epsilon(arr, len/2);
        System.out.println("gamma " + gamma);
        System.out.println("epsilon: " + epsilon);
        System.out.println(gamma * epsilon);

        //Problem 2/2 from day 3

        br = new BufferedReader(new FileReader(path));

        String[] report = new String[len];
        int i = 0;
        while ((str = br.readLine()) != null){
            report[i++] = str;
        }

        String oxygen = oxygenGeneratorRating(0, report);
        String CO2 = CO2ScrubberRating(0, report);

        int oxygenVal = Integer.parseInt(oxygen, 2);
        int CO2Val = Integer.parseInt(CO2, 2);
        System.out.println("Oxygen generation rating: " + oxygenVal);
        System.out.println("CO2 scrubber ratting: " + CO2Val);
        System.out.println("CO2 * Oxygen: " + CO2Val * oxygenVal);
    }
}