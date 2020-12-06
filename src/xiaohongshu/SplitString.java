package xiaohongshu;

import java.util.*;

//时间限制： 3000MS
//内存限制： 589824KB
//题目描述：
//给定一个非空的字符串s ，将s切割成若干个非空子串，要求每个子串头尾是相同字符 ，给出切割的子串的数量最少的方法。
//
//
//
//输入描述
//一个非空的字符串s
//
//输出描述
//满足要求的切割结果的子串数量
public class SplitString {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(String s) {
        int[] dp=new int[s.length()+1];
        for(int i=1; i<=s.length(); ++i){
            dp[i]=i-1;
        }
        for(int i=1; i<s.length(); ++i){
            dp[i+1]=dp[i]+1;
            for (int j=0; j<i; ++j){
                if(s.charAt(j)==s.charAt(i)){
                    if(j==0) dp[i+1]=Math.min(dp[i+1],dp[j]);
                    else dp[i+1]=Math.min(dp[i+1],1+dp[j]);
                }
            }
        }
        return dp[s.length()]+1;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = solution(_s);
        System.out.println(String.valueOf(res));

    }
}
