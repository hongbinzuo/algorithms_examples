package com.freelemon;

public class StrToInt{
    public static void main(String[] args){
        String testStr = "123";
        int result = StrToInt.convertToInt(testStr);

        // print the result
        System.out.println("The result is:" + result);
    }

    public static int convertToInt(String str){
        char[] strArr = str.toCharArray();
        int result = 0;
        int N = strArr.length;
        for(int i=0;i<N;i++){
            result = result*10 + strArr[i] - '0'; // key statement
        }

        return result;
    }
}
