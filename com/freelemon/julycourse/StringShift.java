package com.freelemon.julycourse;

/**
 * Created by admin on 8/8/14.
 * Shift a string by specific length. For example, before: "abcdefG", after: "defGabc".
 */
public class StringShift {

    // abcdef --> cdefab

    public static void main(String[] args){
        String test = "abcdefgXYZ";
        StringShift ss = new StringShift();

        ss.testShiftBruceForce(test, 4);

        ss.testThreeCopies(test, 6);

        ss.testShiftUsingMatrix(test, 3);

    }

    public void shiftBruteForce(char[] str, int shiftLen){

        // Time complexity: O(kN)
        // Space complexity: O(1)

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
        // Time complexity: O(N)
        // Space complexity: O(k)

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

    public void shiftUsingMatrix(char[] str, int length){
        // Time complexity: O(N)
        // Space complexity: O(1)

        // XY = (X'Y')'
        reverse(str, 0, length-1);
        reverse(str, length, str.length-1);
        reverse(str, 0, str.length-1);

    }

    public void reverse(char[] source, int p, int q){
        
        char c;
        while ( p < q ){
            c = source[p];
            source[p] = source[q];
            source[q] = c;
            p++;
            q--;
        }
    }

    public void testShiftUsingMatrix(String str, int length){
        char[] strArr = str.toCharArray();
        shiftUsingMatrix(strArr, length);

        System.out.println(String.valueOf(strArr));
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
