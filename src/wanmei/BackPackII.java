package wanmei;

import java.util.Scanner;

public class BackPackII {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int knapsackCapacity = Integer.parseInt(input.nextLine().trim());

        String[] volumesStr = input.nextLine().split(" ");
        int[] volumes = new int[volumesStr.length];
        for (int i = 0; i < volumesStr.length; i++) {
            volumes[i] = Integer.parseInt(volumesStr[i].trim());
        }

        String[] valuesStr = input.nextLine().split(" ");
        int[] values = new int[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            values[i] = Integer.parseInt(valuesStr[i].trim());
        }

        if (volumes.length == values.length) {
            System.out.println(method(knapsackCapacity, volumes, values));
        }else {
            System.out.println("道具数量不一致。");
        }
        input.close();
    }

    public static int method(int knapsackCapacity, int[] volumes, int[] values){
        int nums=volumes.length;
        int[] dp=new int[knapsackCapacity+1];
        for(int i=1; i<=nums; ++i){
            for (int j=volumes[i-1]; j<=knapsackCapacity; ++j){
                dp[j]=Math.max(dp[j],dp[j-volumes[i-1]]+values[i-1]);
            }
        }
        return dp[knapsackCapacity];
    }

//    public static int method(int knapsackCapacity, int[] volumes, int[] values){
//        int nums=volumes.length;
//        //前i个物品，装入j背包 最大价值
//        int[][] dp=new int[nums+1][knapsackCapacity+1];
//        for(int i=1; i<=nums; ++i){
//            for(int j=0; j<=knapsackCapacity; ++j){
//                dp[i][j]=dp[i-1][j];
//                if(j-volumes[i-1]>0){
//                    dp[i][j]=Math.max(dp[i-1][j-volumes[i-1]]+values[i-1],dp[i-1][j]);
//                }
//            }
//        }
//        return dp[nums][knapsackCapacity];
//    }

//    public static int method(int knapsackCapacity, int[] volumes, int[] values){
//        int nums=volumes.length;
//        int[][] dp=new int[knapsackCapacity+1][nums];
//        if(values[0]<=knapsackCapacity) dp[values[0]][0]=values[0];
//        for(int i=0; i<=knapsackCapacity; ++i){
//            for(int j=0; j<nums; ++j){
//                if(j==0) {
//                    if(i>=volumes[0]) dp[i][j]=values[0];
//                    continue;
//                }
//                if(i-volumes[j]>0) {
//                    dp[i][j] = Math.max(dp[i - volumes[j]][j - 1] + values[j], dp[i][j-1]);
//                }
//                else dp[i][j]=dp[i][j-1];
//            }
//        }
//        return dp[knapsackCapacity][nums-1];
//    }
}
