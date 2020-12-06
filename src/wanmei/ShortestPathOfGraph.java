package wanmei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShortestPathOfGraph {
    public static void main(String[] args) {
        int[][] weight = new int[6][];

        String[] pointsStr = { "V1", "V2", "V3", "V4", "V5","V6"};
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < pointsStr.length; i++) {
            String[] valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();

        method(weight, pointsStr);
    }
    public static void method (int[][] weight, String[] pointsStr){
        for(int i=1; i<weight.length; ++i){
            System.out.println(helper(weight,i));
        }
    }

    static int helper(int[][] weight, int end){
        List<Integer> visited=new ArrayList<>();
        visited.add(0);
        int ans=0;
        int[][] newWeight= Arrays.copyOf(weight,weight.length);
        int i;
        while (!visited.isEmpty()&&(i=visited.get(visited.size()-1))!=end){
            int min=Integer.MAX_VALUE;
            int pos=-1;
            for(int j=0; j<newWeight[i].length; ++j){
                if(i!=j&&newWeight[i][j]!=-1&&newWeight[i][j]<min){
                    min=newWeight[i][j];
                    pos=j;
                }
            }
            if(pos==-1) {
                visited.remove(visited.size()-1);
                if(visited.size()==0) break;
                ans-=newWeight[visited.get(visited.size()-1)][i];
                newWeight[visited.get(visited.size()-1)][i]=-1;
            }else {
                visited.add(pos);
                ans+=min;
            }
        }
        return ans==0?9999:ans;
    }

}
