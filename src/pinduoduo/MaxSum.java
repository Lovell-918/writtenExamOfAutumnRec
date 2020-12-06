package pinduoduo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MaxSum {
    static int max;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int times=sc.nextInt();
        for(int ti=0; ti<times; ++ti){
            max=-1;
            int len=sc.nextInt();
            int need=sc.nextInt();
            int[] nums=new int[len];
            for(int i=0; i<len; ++i){
                nums[i]=sc.nextInt();
            }
            HashSet<Integer>[] hate=new HashSet[len];
            for(int i=0; i<len; ++i){
                hate[i]=new HashSet<>();
            }
            for(int i=0; i<len-1; ++i){
                int m=sc.nextInt()-1, n=sc.nextInt()-1;
                hate[m].add(n);
                hate[n].add(m);
            }
            boolean[] visited=new boolean[len];
            boolean[] unValid=new boolean[len];
            while (!isAllUnValid(unValid)){
                int maxIndex=getMax(nums,visited,hate);
                visited[maxIndex]=true;
                backtrack(nums,visited,hate,need-1,nums[maxIndex],unValid);
                if(max!=-1) break;
                visited[maxIndex]=false;
                unValid[maxIndex]=true;
            }
            System.out.println(max);
        }
    }

    static void backtrack(int[] nums, boolean[] visited, HashSet<Integer>[] hate, int last,
                          int sum, boolean[] unValid){
        if(last==0){
            max=Math.max(sum,max);
            return;
        }
        boolean[] un= Arrays.copyOf(unValid,unValid.length);
        while (!isAllUnValid(un)){
            int maxIndex=getMax(nums,visited,hate);
            visited[maxIndex]=true;
            backtrack(nums,visited,hate,last-1,sum+nums[maxIndex],un);
            if(max!=-1) break;
            visited[maxIndex]=false;
            un[maxIndex]=true;
        }
    }

    static boolean canAttend(boolean[] visited, HashSet<Integer>[] hate, int num){
        for(int i=0; i<visited.length; ++i){
            if(!visited[i]) continue;
            if(hate[i].contains(num)) return false;
        }
        return true;
    }

    static int getMax(int[] nums, boolean[] visited, HashSet<Integer>[] hate){
        int m=-1;
        int index=0;
        for(int i=0; i<nums.length; ++i){
            if(visited[i]) continue;
            if(!canAttend(visited,hate,i)) continue;
            if(nums[i]>m){
                m=nums[i];
                index=i;
            }
        }
        return index;
    }

    static boolean isAllUnValid(boolean[] unValid){
        for (boolean v:unValid){
            if(!v) return false;
        }
        return true;
    }
}
