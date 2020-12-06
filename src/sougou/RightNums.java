package sougou;

public class RightNums {


    public static void main(String[] args){
        RightNums solution=new RightNums();
        Interval ans=solution.solve(3,0,"ABC","DDD");
        System.out.println(ans.start+" "+ans.end);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回Interval类，start代表汪仔最少做对了多少道题，end代表汪仔最多做对了多少道题。
     * @param n int整型 选择题总数
     * @param k int整型 朋友做对的题数
     * @param str1 string字符串 长度为n只包含ABCD的字符串，其中第i个代表汪仔第i题做出的选择
     * @param str2 string字符串 长度为n只包含ABCD的字符串，其中第i个代表朋友第i题做出的选择
     * @return Interval类
     */
    public Interval solve (int n, int k, String str1, String str2) {
        // write code here
        Interval ans=new Interval();
        ans.start=Integer.MAX_VALUE;
        ans.end=Integer.MIN_VALUE;
        if(k==0){
            int count=0;
            for(int i=0; i<n; ++i){
                if(str1.charAt(i)==str2.charAt(i)) count++;
            }
            ans.start=0;
            ans.end=n-count;
            return ans;
        }
        for(int i=0; i<n; ++i){
            if(n-i<=k-1) break;
            if(str2.charAt(i)!=str1.charAt(i)){
                backtrack(str1,str2,k-1,1,0,i+1,ans);
            }else {
                backtrack(str1,str2,k-1,0,1,i+1,ans);
            }
        }
        return ans;
    }

    void backtrack(String str1, String str2, int last, int wrong, int right, int index, Interval ans){
        int n=str2.length();
        if(last==0){
            ans.start=Math.min(right,ans.start);
            ans.end=Math.max(n-wrong,ans.end);
            return;
        }
        for(int i=index; i<n; ++i){
            if(n-i<=last-1) break;
            if(str2.charAt(i)!=str1.charAt(i)){
                backtrack(str1,str2,last-1,wrong+1,right,i+1,ans);
            }else {
                backtrack(str1,str2,last-1,wrong,right+1,i+1,ans);
            }

        }
    }

    class Interval {
    int start;
    int end;
  }
}
