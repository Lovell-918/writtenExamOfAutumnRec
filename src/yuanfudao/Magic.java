package yuanfudao;

import java.util.Arrays;
import java.util.Scanner;

public class Magic {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), m=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0; i<n; ++i){
            nums[i]=sc.nextInt();
        }
        int mid=n/2;
        for(int i=0; i<m; ++i){
            int[] pre= Arrays.copyOf(nums,mid);
            int[] post=Arrays.copyOfRange(nums,mid,n);
            int p1=0,p2=0;
            for(int j=0; j<n; ++j){
                if(j%2==0){
                    nums[j]=post[p2];
                    p2++;
                }else {
                    nums[j]=pre[p1];
                    p1++;
                }
            }
        }
        for(int i=0; i<n-1; ++i){
            System.out.print(nums[i]+" ");
        }
        System.out.println(nums[n-1]);
    }
}
