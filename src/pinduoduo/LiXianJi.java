package pinduoduo;

import java.util.*;

public class LiXianJi {
    static int min;
    static int[][] dire=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(), M=sc.nextInt();
        char[][] map=new char[N][M];
        List<List<Integer>> startPos=new ArrayList<>();
        for(int i=0; i<N; ++i){
            map[i]=sc.next().toCharArray();
            for(int j=0; j<M; ++j){
                if(map[i][j]=='X'){
                    startPos.add(Arrays.asList(i,j));
                }
            }
        }
        min=Integer.MAX_VALUE;
        Set<List<Integer>> ans=new HashSet<>();
        for(List<Integer> list:startPos){
            char[][] tempMap=clone(map);
            dfs(tempMap,ans,list.get(0),list.get(1),0,list.get(0),list.get(1));
        }
        if(min==Integer.MAX_VALUE){
            System.out.println(0);
        }else {
            System.out.println(min);
            Iterator<List<Integer>> it=ans.iterator();
            int len=ans.size();
            int t=0;
            while (it.hasNext()){
                List<Integer> list=it.next();
                if(t<len-1){
                    System.out.print(list.get(0)+" "+list.get(1)+" ");
                }else {
                    System.out.println(list.get(0)+" "+list.get(1));
                }
                t++;
            }
        }
    }

    static void dfs(char[][] map, Set<List<Integer>> ans, int row, int col, int counts, int or, int oc){
        if(map[row][col]=='T'){
            if(counts<=min){
                if(counts<min){
                    min=counts;
                    ans.clear();
                }
                ans.add(Arrays.asList(or,oc));
            }
        }
        map[row][col]='1';
        for(int i=0; i<4; ++i){
            int r=row+dire[i][0];
            int c=col+dire[i][1];
            if(r>=0&&r<map.length &&c>=0&&c<map[0].length
            &&map[r][c]!='1'&&map[r][c]!='X'){
                char[][] tempMap=clone(map);
                dfs(tempMap,ans,r,c,counts+1,or,oc);
            }
        }
    }

    static char[][] clone(char[][] map){
        char[][] tempMap=new char[map.length][map[0].length];
        for(int i=0; i<map.length; ++i){
            tempMap[i]=Arrays.copyOf(map[i],map[i].length);
        }
        return tempMap;
    }
}
