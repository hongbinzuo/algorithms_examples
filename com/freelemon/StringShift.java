package com.freelemon;

/**
 * Created by admin on 8/8/14.
 */
public class StringShift {

    // abcdef --> cdefab

    public static void main(String[] args){
        String test = "abcdefgXYZ";
        StringShift ss = new StringShift();

        ss.testShiftBruceForce(test, 4);

        ss.testThreeCopies(test, 6);

    }

    public void shiftBruteForce(char[] str, int shiftLen){
        char c;

        for (int i = 0; i < shiftLen; i++) {
            c = str[0];

            for (int j = 0; j < str.length-1; j++) {
                str[j] = str[j+1];
            }

            str[str.length-1]= c;
        }

    }

    public void shiftThreeCopies(char[] str, int shiftLen){
        char[] tmp = new char[shiftLen];
        int N = str.length;

        for (int i = 0; i < shiftLen ; i++) {
            tmp[i] = str[i];
        }

        for (int i = 0; i < N - shiftLen; i++) {
            str[i] = str[i+shiftLen];
        }

        for (int i = shiftLen+1; i < str.length ; i++) {
            str[i] = tmp[i-shiftLen];
        }
    }

    

    public void testThreeCopies(String input, int length){

        char[] testArray = input.toCharArray();
        shiftThreeCopies(testArray, length);

        System.out.println(String.valueOf(testArray));
    }


    public void testShiftBruceForce(String input, int length){

        char[] testArray = input.toCharArray();
        shiftBruteForce(testArray, length);

        System.out.println(String.valueOf(testArray));
    }


}
