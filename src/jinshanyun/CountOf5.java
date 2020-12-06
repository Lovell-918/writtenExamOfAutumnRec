package jinshanyun;

import java.util.Scanner;

//输入一个正整数n，输出从数字1到数字n中，一共出现了多少个5。
public class CountOf5 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=0;
        for(int i=5;i<=n;++i){
            ans+=count(i);
        }
        System.out.println(ans);
    }

    static int count(int n){
        char[] chars=String.valueOf(n).toCharArray();
        int ans=0;
        for (char c:chars){
            if(c=='5') ans++;
        }
        return ans;
    }
}
