package com.freelemon.julycourse;

/**
 * Created by admin on 8/14/14.
 */
public class KMP {

    public static void main(String[] args){
        String text = "ABCABCDABCEBACAAB";
        int[] next = KMP.getNext(text);


        for (int i = 0; i < text.length() ; i++) {
            System.out.print(text.charAt(i) + "\t");
        }

        System.out.println();

        for (int i = 1; i < next.length ; i++) {
            System.out.print(next[i] + "\t");
        }
    }

    public static int[] getNext(String b) {
        int len = b.length();
        int j = 0;

        int next[] = new int[len + 1];
        next[0] = next[1] = 0;

        for (int i = 1; i < len; i++) {
            while (j > 0 && b.charAt(i) != b.charAt(j))
                j = next[j];

            if (b.charAt(i) == b.charAt(j)) j++;
            next[i+1] = j;
        }

        return next;

    }
}
