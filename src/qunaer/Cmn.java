package qunaer;

import java.math.BigInteger;
import java.util.Scanner;

//组合数
public class Cmn {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(), n=sc.nextInt();
        if(m<n){
            System.out.println(0);
        }else {
            long ans = 1;
            int t = m - n + 1;
            for (int i = m; i >= t; --i) {
                ans *= i;
            }
            long last=1;
            for (int i = n; i > 0; --i) {
                last *= i;
            }
            System.out.println(ans/last);
        }
    }
}
