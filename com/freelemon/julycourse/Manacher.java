package com.freelemon.julycourse;

/**
 * Created by admin on 8/11/14.
 */
public class Manacher {
    /*
    // the code below is translated from C code in july course, but it doesn't work.
    // maybe double check if necessary

    public static void main(String[] args){

        // this class has not been verified yet!!!
        // checked in for code synchronization
        int[] lens = new int[40];
        Manacher.manacher("$#1#2#3#2#1#5#".toCharArray(), lens);
    }


    public static void manacher(char[] str, int[] p){
        int size = str.length;

        p[0] = 1;
        int id = 0;
        int mx = 1;

        for (int i = 1; i < size; i++) {
            if ( mx > i) {
                p[i] = Math.min(p[2*id-i], mx-i);
            } else {
                p[i] = 1;
            }

            for(; str[i+p[i]] == str[i-p[i]]; p[i]++);

            if (mx<i+p[i]){
                mx = i + p[i];
                id = i;
            }
        }

    } */

    public static void main(String[] args){
        //Manacher.testPreProcess("abcdefeda");
        //Manacher.testGetLongestPalindrome("abcdefeda");
        Manacher.testGetLongestPalindrome("babcbabcbabcxa");
    }

    private static String preProcess(String s){
        int n = s.length();

        if (n == 0) return "^$";
        String result = "^";

        for (int i = 0; i < n; i++) {
            result += "#" + s.charAt(i);
        }

        result += "#$";
        return  result;
    }

    public static void testPreProcess(String testStr){
        String result = Manacher.preProcess(testStr);
        System.out.print(result);
    }

    public static void testGetLongestPalindrome(String testStr){
        String result = Manacher.getLongestPalindrome(testStr);
        System.out.print(result);
    }

    public static String getLongestPalindrome(String s){
        char[] T = preProcess(s).toCharArray();

        int n = T.length;
        int[] P = new int[n];

        int C = 0, R = 0;

        for (int i = 1; i < n-1; i++) {
            int i_mirror = 2*C - i; // equals to i' = C - (i-C)

            if ( i < R ) {
                P[i] = Math.min(R-i, P[i_mirror]);
            } else{
                P[i] = 0;
            }

            // Attempt to expand palindrome centered at i
            while( T[i+1+P[i]] == T[i-1-P[i]] )
                P[i]++;

            // if palindrome centered at i expand past R
            // adjust center based on expanded palindrome

            System.out.println("i="+i +", P[i]="+P[i] + ", R="+R);

            if ( i + P[i] > R) {
                C = i;
                R = i + P[i];

                System.out.println("Updated C="+C +", R="+R);
            }



        }

        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n-1 ; i++) {
            if (P[i] >  maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        //System.out.println("centerIndex: " + centerIndex);
        //System.out.println("maxLen: " + maxLen);
        int beginIndex = (centerIndex-1-maxLen)/2;

        return s.substring(beginIndex, beginIndex+maxLen);

    }


}
