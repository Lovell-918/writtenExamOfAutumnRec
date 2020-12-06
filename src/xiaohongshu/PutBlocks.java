package xiaohongshu;

import java.util.Scanner;
//叠箱子
//时间限制： 3000MS
//内存限制： 589824KB
//题目描述：
//有多个长方体的箱子需要叠放起来，使得叠放的高度最大。叠放的原则是上面箱子的接触面严格小于下面箱子的接触面。叠放时箱子可以改变方向。
//
//例如，边长为1，3，6的箱子，可以放在1，2，7的箱子上，接触的面是1，3和2，7，总高度是7；1，2，7的箱子也可以叠放在1，3，6的箱子上，接触面是1，2和3，6，总高度是8。
//
//每个盒子在叠放时可以使用多次，但是每次都必须以一个不同的方向（所以最多只能使用3次，分别是三个方向）。
//输入描述
//第一行是一个数字N，表示后面有N个长方体，接下来是N行，每行3个正整数，分别表示长方体的三个边长。可能有M个这样的输入。
//
//0<N<10000
//
//0<M<10000
//
//输出描述
//输出M个整数，分别表示得到的M个最大高度。
public class PutBlocks {
    static int ans;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[][] blocks=new int[n][3];
            for(int i=0; i<n; ++i){
                blocks[i][0]=sc.nextInt();
                blocks[i][1]=sc.nextInt();
                blocks[i][2]=sc.nextInt();
            }
            boolean[] used=new boolean[n];
            ans=0;
            for(int i=0; i<n; ++i){
                used[i]=true;
                backtrack(blocks,used,blocks[i][0],blocks[i][1],blocks[i][2],1);
                backtrack(blocks,used,blocks[i][1],blocks[i][0],blocks[i][2],1);
                backtrack(blocks,used,blocks[i][0],blocks[i][2],blocks[i][1],1);
                backtrack(blocks,used,blocks[i][2],blocks[i][0],blocks[i][1],1);
                backtrack(blocks,used,blocks[i][2],blocks[i][1],blocks[i][0],1);
                backtrack(blocks,used,blocks[i][1],blocks[i][2],blocks[i][0],1);
                used[i]=false;
            }
            System.out.println(ans);
        }
    }

    static void backtrack(int[][] blocks, boolean[] visited,int x, int y, int tmp, int count){
        ans=Math.max(ans,tmp);
        if(count==blocks.length){
            return;
        }
        for(int i=0; i<blocks.length; ++i){
            if(visited[i]) continue;
            visited[i]=true;
            if(blocks[i][0]<x&&blocks[i][1]<y){
                backtrack(blocks,visited,blocks[i][0],blocks[i][1],tmp+blocks[i][2],count+1);
            }
            if(blocks[i][1]<x&&blocks[i][0]<y){
                backtrack(blocks,visited,blocks[i][1],blocks[i][0],tmp+blocks[i][2],count+1);
            }
            if(blocks[i][2]<x&&blocks[i][1]<y){
                backtrack(blocks,visited,blocks[i][2],blocks[i][1],tmp+blocks[i][0],count+1);
            }
            if(blocks[i][1]<x&&blocks[i][2]<y){
                backtrack(blocks,visited,blocks[i][1],blocks[i][2],tmp+blocks[i][0],count+1);
            }
            if(blocks[i][0]<x&&blocks[i][2]<y){
                backtrack(blocks,visited,blocks[i][0],blocks[i][2],tmp+blocks[i][1],count+1);
            }
            if(blocks[i][2]<x&&blocks[i][0]<y){
                backtrack(blocks,visited,blocks[i][2],blocks[i][0],tmp+blocks[i][1],count+1);
            }
            visited[i]=false;
        }
    }
}
