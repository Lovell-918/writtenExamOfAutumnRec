package tengxun;

import java.util.Scanner;

public class BrushThePlank {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int len=sc.nextInt();
            int[] nums=new int[len];
            for(int i=0; i<len; ++i){
                nums[i]=sc.nextInt();
            }
            System.out.println(dfs(nums,0,len-1));
        }
        sc.close();
    }

    static int dfs(int[] nums, int left, int right){
        if(left==right){
            if(nums[left]==0) return 0;
            else return 1;
        }
        int ans=right-left+1;
        int min=Integer.MAX_VALUE;
        for (int i=left; i<=right; ++i){
            min=Math.min(nums[i],min);
        }
        int ans1=min;
        int curL=-1;
        for(int i=left; i<=right; ++i){
            nums[i]-=min;
            if(nums[i]>0){
                if(i==0||nums[i-1]==0){
                    curL=i;
                }
                if(i==right){
                    ans1+=dfs(nums,curL,i);
                }
            }else {
                if(i>0&&nums[i-1]>0){
                    ans1+=dfs(nums,curL,i-1);
                }
            }
        }
        return Math.min(ans,ans1);
    }

//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNext()){
//            int len=sc.nextInt();
//            int[] nums=new int[len];
//            for(int i=0; i<len; ++i){
//                nums[i]=sc.nextInt();
//            }
//            long ans=0;
//            int i;
//            while ((i=completed(nums))!=nums.length){
//                for(;i<len;++i){
//                    nums[i]--;
//                    if(i==len-1||(i<len-1&&nums[i+1]==0)){
//                        ans++;
//                        break;
//                    }
//                }
//            }
//            System.out.println(Math.min(ans,len));
//        }
//        sc.close();
//    }
//
//    static int completed(int[] nums){
//        for(int i=0; i<nums.length; ++i){
//            if(nums[i]!=0) return i;
//        }
//        return nums.length;
//    }
}
