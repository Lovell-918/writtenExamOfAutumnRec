package baidu;

import java.util.Arrays;
import java.util.Scanner;

public class NumModNinety {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int len=sc.nextInt();
            int[] nums=new int[len];
            for(int i=0;i<len;++i) nums[i]=sc.nextInt();
            Arrays.sort(nums);
            int j=0;
            long num=-1;
            while (j<len){
                int i=j;
                while (i<len){
                    swap(nums,i,j);
                    num=toNum(nums);
                    if(num%90==0) break;
                    num=-1;
                    i++;
                }
                j++;
            }
            System.out.println(num);
        }
        sc.close();
    }

    static long toNum(int[] nums){
        StringBuilder sb=new StringBuilder();
        for(int i:nums) sb.append(i);
        return Long.parseLong(sb.reverse().toString());
    }

    static void swap(int[] nums, int i, int j){
        if(i==j) return;
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=nums[i];
    }
}
