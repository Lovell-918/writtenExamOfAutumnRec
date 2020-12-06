package tengxun;

import java.util.Scanner;

public class DeleteList {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] nums=new int[n];
            for(int i=0; i<n; ++i){
                nums[i]=sc.nextInt();
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<n; ++i){
                if(i+1!=k){
                    sb.append(nums[i]).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
        sc.close();
    }
}
