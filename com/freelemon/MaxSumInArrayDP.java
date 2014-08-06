package com.freelemon;

/**
 * Created by admin on 8/6/14.
 */
public class MaxSumInArrayDP {

    //

    public static void main(String[] args){
        int[] a = {12, 11, 0, 9, -1, -23, -29, 26, 123, -90, -9, 8, 0, 23, 34, 56, -90 };

        int result = a[0];
        int sum = a[0];

        for (int i = 1; i < a.length ; i++) {

            System.out.println("Sum is: " + sum + " and a[i] is: " + a[i]);

            if ( sum > 0 ){
                sum += a[i];
            } else {
                sum = a[i];
            }



            if ( sum > result ){
                result = sum;
            }
        }

        System.out.println(result);


    }
}
