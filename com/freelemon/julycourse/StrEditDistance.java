package com.freelemon.julycourse;

/**
 * Created by admin on 8/7/14.
 */
public class StrEditDistance {


    public static void main(String[] args){
        String str1 = "nice";
        String str2 = "great";

        StrEditDistance strEditDistance = new StrEditDistance();

        System.out.println(strEditDistance.getEditDistance(str1.toCharArray(), str2.toCharArray()));

    }


    public int getEditDistance(char[] str1, char[] str2){
        int m = str1.length;
        int n = str2.length;

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m ; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n ; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n ; j++) {
                if ( str1[i-1] == str2[j-1] ){
                    dp[i][j] = dp[i-1][j-1];
                }  else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]); //?? @TODO understand it
                }
            }
        }


        return dp[m][n];
    }
}
