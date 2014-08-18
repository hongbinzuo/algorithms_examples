package com.freelemon.julycourse;

/**
 * Created by admin on 8/14/14.
 */
public class KMP {

    public static void main(String[] args){
        String text = "ABCABCDABCEBACAAB";
        //int[] next = KMP.getNext(text);
        //int[] next = KMP.getNext2(text.toCharArray());
        int[] next = KMP.getNextDrZou(text.toCharArray());


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

    public static int[] getNext2(char[] p){
        int i=0, j=-1;
        int m = p.length+1;
        int[] b = new int[m];

        b[i]=j;

        while (i<m)
        {
            while (j>=0 && p[i]!=p[j]) j=b[j];
            i++; j++;
            b[i]=j;
        }

        return b;
    }

    public static int[] getNextDrZou(char[] s){
        if ( s == null || s.length == 0 ) return null;

        int size = s.length;
        int[] next = new int[size];
        next[0] = -1;

        int index, j;
        for (int i = 1; i < size ; i++) {
            j = i -1;
            index = next[j];

            while((index >=0 ) && s[index] != s[j])
                index = next[index];

            if (index<0)
                next[i] = 0;
            else
                next[i] = index + 1;
        }

        return next;
    }
}
