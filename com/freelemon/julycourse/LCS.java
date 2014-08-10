package com.freelemon.julycourse;

/**
 * Created by admin on 8/7/14.
 * Problem: Largest Common Sequence of two sequences.
 * For example: the LCS string of "ABCDAF" and "ABDABBC" is "ABDA"
 */
public class LCS {

    /**
     * the LCS length array
     */
    private int[][] c = null;
    /**
     * the LCS length array direction
     */
    private char[][] b = null;

    private final static char UP = 'u';
    private final static char LEFT = 'l';
    private final static char UPLEFT = 'c';


    public static void main(String[] args){
        LCS lcs = new LCS();

        String str1 = "This is a test!";
        String str2 = "This is not a Test!!";
        //This is a est!

        lcs.calLCSLength(str1.toCharArray(), str2.toCharArray());

        /*

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j]);
                System.out.print(" ");
            }
            System.out.print('\n');
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j]);
                System.out.print(" ");
            }
            System.out.print('\n');
        }*/

        lcs.getLCS(lcs.getB(), str1.toCharArray(), str1.length(), str2.length());


    }

    /**
     * Get the LCS string
     * @param b
     * @param X
     * @param i
     * @param j
     */
    public void getLCS(char[][] b, char[] X, int i, int j){
        if (i==0 || j==0) return;

        if (b[i][j] == LCS.UPLEFT ) {
            getLCS(b, X, i-1, j-1);
            System.out.print(X[i-1]);
        } else if ( b[i][j] == LCS.UP) {
            getLCS(b, X, i-1, j);
        } else {
            getLCS(b, X, i, j-1);
        }

    }

    public char[][] getB(){
        return this.b;
    }

    /**
     * calculate the LCS array length, the
     * @param X
     * @param Y
     * @return 0 for success, -1 for failure
     */

    public int calLCSLength(char[] X, char[] Y){
        if (X== null || Y == null ) return -1;

        int m = X.length;
        int n = Y.length;

        c = new int[m+1][n+1];
        b = new char[m+1][n+1];

        for (int i = 0; i < m; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            c[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i-1] == Y[j-1]){
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = LCS.UPLEFT;
                } else if (c[i-1][j]>=c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = LCS.UP;
                } else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = LCS.UPLEFT;
                }
            }
        }



        return 0;
    }
}
