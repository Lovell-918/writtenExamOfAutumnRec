package sougou;

import java.util.ArrayList;
import java.util.List;

public class SimplifyWords {

    public static void main(String[] args){
        Interval[] conn=new Interval[4];
        conn[0]=new Interval(0,1);
        conn[1]=new Interval(0,2);
        conn[2]=new Interval(2,-1);
        conn[3]=new Interval(2,1);
        SimplifyWords so=new SimplifyWords();
        Interval i=so.trim(3,4,conn);
        System.out.println(i.start+" "+i.end);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 在Interval类中返回结果，其中start表示有效字的个数，end表示全部有效字编号的和除以100000007的余数。
     * @param N int整型 字的总数
     * @param M int整型 连接关系的总数
     * @param conn Interval类一维数组 全部连接关系
     * @return Interval类
     */
    public Interval trim (int N, int M, Interval[] conn) {
        // write code here
        boolean[] visited=new boolean[M];
        boolean[] valid=new boolean[N+1];
        List<Integer> temp=new ArrayList<>();
        for(int i=0; i<conn.length; ++i){
            if(!visited[i]&&conn[i].start==0){
                visited[i]=true;
                temp.add(conn[i].end);
                dfs(conn,temp,visited,i,valid);
                visited[i]=false;
                temp.remove(temp.size()-1);
            }
        }
        int count=0;
        long sum=0;
        for(int i=1; i<valid.length; ++i){
            if(valid[i]){
                count++;
                sum+=i;
                sum%=100000007;
            }
        }
        return new Interval(count,(int)sum);
    }

    void dfs(Interval[] conn, List<Integer> temp, boolean[] visited, int index, boolean[] valid){
        int start=conn[index].end;
        if(start==-1){
            for(int i:temp){
                if(i!=-1) valid[i]=true;
            }
            return;
        }
        for(int i=0; i<conn.length; ++i){
            if(conn[i].start!=start) continue;
            if(visited[i]) continue;
            temp.add(conn[i].end);
            visited[i]=true;
            dfs(conn,temp,visited,i,valid);
            visited[i]=false;
            temp.remove(temp.size()-1);
        }
    }

    static class Interval {
    int start;
    int end;
    public Interval(int i, int j){
        start=i;
        end=j;
    }
  }
}
