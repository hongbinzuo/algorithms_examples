package com.freelemon;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by admin on 8/4/14.
 */
public class MaxSumInArray {
    public static void main(String[] args){
        //int[] test = new int[]{12, 1, 0, 3, 0, -9, 11, 9, 8, 10, 9, 13, 2, 45,1, 1};
        int[] test = {9, 2, 1, -9, -8, -7, 11, 2, 5, 11, 89, 0, 90, -9}; // 11,2,5,11,89,0,90

        //

        int result = findMax(test);

        System.out.println("Result is: " + result);
    }


    // Divide and Conquer
    public static int findMax(int[] a)
    {

        if (a.length == 0) return 0;

        int m = a.length/2;

        if (m <1) return a[0];

        // it's better to use index

        int[] left = Arrays.copyOfRange(a, 0, m-1);
        int[] right = Arrays.copyOfRange(a, m, a.length-1);

        int maxLeft = findMax(left);
        int maxRight = findMax(right);

        int maxLast = 0;
        for (int i = m; i >= 0 ; i--) {
            if ( maxLast <= maxLast +a[i])
                maxLast += a[i];
            else
                break;

        }

        int maxFirst = 0;
        for (int i = m+1; i < a.length ; i++) {
            if ( maxFirst <= maxFirst +a[i])
                maxFirst += a[i];
            else
                break;

        }

        return Math.max(Math.max(maxLeft, maxRight), maxFirst+maxLast);

    }


}
