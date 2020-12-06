package meituan;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphWays {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int len=sc.nextInt();
            int bor=sc.nextInt();
            boolean[][] matrix=new boolean[len][len];
            for(int i=0; i<len-1; ++i){
                int f=sc.nextInt()-1; int t=sc.nextInt()-1;
                matrix[f][t]=true;
                matrix[t][f]=true;
            }
            int[] levels=new int[len];
            for (int i=0; i<len; ++i){
                levels[i]=sc.nextInt();
            }
            long ans=0;
            for(int i=0; i<len; ++i){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    ans++;
                    for (int j = 0; j < len; ++j) {
                        int min = levels[i], max = levels[i];
                        boolean canAdd=false;
                        if (!list.contains(j)){
                            for(int temp:list){
                                if(matrix[temp][j]){
                                    int tempMax=Math.max(max,levels[j]);
                                    int tempMin=Math.min(min,levels[j]);
                                    if(tempMax-tempMin<bor){
                                        ans++;
                                        max=tempMax;
                                        min=tempMin;
                                        canAdd=true;
                                    }
                                }
                            }
                        }
                        if(canAdd) list.add(j);
                    }
            }
            System.out.println((int)(ans%(Math.pow(10,9)+7)));
        }
    }
}
