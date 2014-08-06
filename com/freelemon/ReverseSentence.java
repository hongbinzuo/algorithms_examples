package com.freelemon;

/**
 * Created by admin on 8/4/14.
 */
public class ReverseSentence {

    /// reverse a sentence
    /// This is a sentence
    /// result: sentence a is This

    public static void main(String[] args){
        String test = "This is a sentence";

        int j = 0;
        StringBuffer sbTest = new StringBuffer();
        for (int i = 0; i < test.length() ; i++) {

            if ( ' ' == test.charAt(i) ){
                sbTest.append(reverseWord(test.substring(j, i).toCharArray()));
                sbTest.append(" ");
                j = i+1;
            }

            if ( i == test.length() - 1){
                sbTest.append(reverseWord(test.substring(j,i+1).toCharArray()));
                //sbTest.append(" ");
            }

        }

        String testResult = reverseWord(sbTest.toString().toCharArray());

        System.out.println(testResult);


    }

    public static String reverseWord(char[] word){
        System.out.println("The input is: " + String.valueOf(word));
        if ( null == word ) return null;

        // in place exchange
        int p = 0;
        int q = word.length - 1;
        while ( p  < q ){
            //System.out.println(word[p]);
            //System.out.println(word[q]);
            char tmp;
            tmp = word[p];
            word[p] = word[q];
            word[q] = tmp;

            p++;
            q--;

        }

        System.out.println("Each::::" + String.valueOf(word));

        return String.valueOf(word);

    }


}
