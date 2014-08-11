package com.freelemon.julycourse;

import java.util.Arrays;

/**
 * Created by admin on 8/11/14.
 */
public class StringArrangementWithoutRecursion {
    private static char[] strArr = "12543".toCharArray();

    public static void main(String[] args){
        Arrays.sort(strArr);

        while (nextArrangement(String.valueOf(strArr)))
            ;


    }

    private static void swap(int i, int j){
        char c = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = c;
    }

    private static void reverse(int i, int j){
        while(i < j){
            swap(i++, j--);
        }
    }


    public static boolean nextArrangement(String input){
        if ( input == null || input.length() == 0 ) return false;

        char[] inputArr = input.toCharArray();

        int p, q, pFind, pEnd= inputArr.length-1;

        p = pEnd;

        while ( p > 0 ) {
            q = p;

            --p;

            if (inputArr[p] < inputArr[q]) {
                pFind = pEnd;

                while(inputArr[pFind] <= inputArr[p]){
                    --pFind;
                }

                swap(pFind, p);
                reverse(q, pEnd);

                System.out.print(String.valueOf(strArr) + "\t");

                return true;
            }
        }

        reverse(p, pEnd);
        return false;

    }

}
