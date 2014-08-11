package com.freelemon.julycourse;

/**
 * Created by admin on 8/11/14.
 */
public class Manacher {
    public static void main(String[] args){

        // this class has not been verified yet!!!
        // checked in for code synchronization
        int[] lens = new int[20];
        Manacher.manacher("1254345231".toCharArray(), lens);
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

    }
}
