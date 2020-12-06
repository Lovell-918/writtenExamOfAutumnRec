package qunaer;

import java.util.Scanner;

//最长重复子序列
public class MostLenDulSub {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        char[] array1=new char[len];
        char[] array2=new char[len];
        for(int i=0; i<len; ++i){
            array1[i]=sc.next().charAt(0);
        }
        for(int i=0; i<len; ++i){
            array2[i]=sc.next().charAt(0);
        }
        int[][] dp=new int[len+1][len+1];
        for(int i=1; i<=len; ++i){
            for (int j=1; j<=len; ++j){
                if(array1[i-1]==array2[j-1]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[len][len]);
    }
}
