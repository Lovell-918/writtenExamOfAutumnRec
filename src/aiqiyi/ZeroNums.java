package aiqiyi;

import java.util.Scanner;

public class ZeroNums {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int i=0;
            /*
              ret=n/5+n/5^2+n/5^3+⋯
             */
            while (Math.pow(5,i)<=n){
                i++;
            }
            int m=n/5;
            System.out.println(i+m-2);
        }
        sc.close();
    }
}
