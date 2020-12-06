package tengxun;

import java.util.Scanner;

public class ValOfNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int T=sc.nextInt();
            for(int t=0; t<T; ++t){
                long n=sc.nextLong();
                long left=0, right=n;
                long ans=0;
                while (left<right){
                    ans=Math.max(ans,countVal(left)+countVal(right));
                    left++;
                    right--;
                }
                if((n&1)==0){
                    long mid=n/2;
                    ans=Math.max(ans,2*countVal(mid));
                }
                System.out.println(ans);
            }
        }
        sc.close();
    }
    static long countVal(long n){
        long ans=0;
        while (n!=0){
            ans+=n%10;
            n/=10;
        }
        return ans;
    }
}
