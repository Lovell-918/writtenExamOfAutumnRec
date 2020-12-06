package tengxun;

import java.util.Scanner;

public class PalindromeSubstring {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String input=sc.next();
            int times=sc.nextInt();
            for (int i=0; i<times; ++i){
                int l=sc.nextInt(), r=sc.nextInt();
                char[] sub=input.substring(l-1,r).toCharArray();
                System.out.println(countNums(sub));
            }
        }
        sc.close();
    }

    static int countNums(char[] chars){
        int[] dp=new int[chars.length+1];
        for (int i=0; i<dp.length; ++i){
            dp[i]=i;
        }
        for(int i=1; i<=chars.length; ++i){
            for(int j=1; j<i; ++j){
                if(isNeed(chars,j-1,i-1)){
                    dp[i]=Math.min(dp[i-1]+1,dp[j-1]+1);
                    break;
                }
            }
            dp[i]=Math.min(dp[i-1]+1,dp[i]);
        }
        return dp[dp.length-1];
    }

    static boolean isNeed(char[] chars, int l, int r){
        while (l<r){
            if(chars[l]!=chars[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
