package com.freelemon.julycourse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hongbin
 * Date: 14-8-10
 * Time: 下午5:37
 * To change this template use File | Settings | File Templates.
 */
public class StringArrangement {
    private static String str = "12345";

    private static String strWithRepeatChars = "12335";

    public static void main(String[] args){
        //StringArrangement.arrangement(0, str.length() - 1); // for "12345"
        StringArrangement.arrangementWithRepeatChars(0, strWithRepeatChars.length()-1); // can handle the case "12335"
    }

    private static boolean isSwap(int from, int to){
        boolean isCan = true;

        for (int i = from; i < to; i++) {
            if (strWithRepeatChars.toCharArray()[to] == strWithRepeatChars.toCharArray()[i]){
                isCan = false;
                break;
            }
        }

        return isCan;
    }

    public static void arrangementWithRepeatChars(int from, int to){
        if ( from == to ) {
            for (int i = 0; i <= to ; i++) {
                System.out.print(strWithRepeatChars.toCharArray()[i]);
            }
            System.out.println();
            return;
        }

        for (int i = from; i <= to ; i++) {
            if (!isSwap(from, i))
                continue;
            swapRepeat(i, from);
            arrangementWithRepeatChars(from+1, to);
            swapRepeat(i, from);
        }
    }

    public static void arrangement(int from, int to){
        if ( from == to ) {
            for (int i = 0; i <= to ; i++) {
              System.out.print(str.toCharArray()[i]);
            }
            System.out.println();
            return;
        }

        for (int i = from; i <= to ; i++) {
            swap(i, from);
            arrangement(from+1, to);
            swap(i, from);
        }
    }

    // swap the value of index i and index j for the string str
    // it will change the value of str
    private static void swap(int i, int j){

        char c;
        char[] result = str.toCharArray();

        c = result[i];
        result[i] = result[j];
        result[j] = c;

        str = String.valueOf(result);

    }

    private static void swapRepeat(int i, int j){

        char c;
        char[] result = strWithRepeatChars.toCharArray();

        c = result[i];
        result[i] = result[j];
        result[j] = c;

        strWithRepeatChars = String.valueOf(result);

    }


}
