package pinduoduo;

import java.util.Scanner;

public class ReadNum {
    public static void main(String[] args){
        int[][] map=new int[10][10];
        map[0]=new int[]{0,4,4,4,4,4,4,4,0,0};
        map[1]=new int[]{0,2,3,2,2,2,2,4,0,0};
        map[2]=new int[]{0,4,6,2,2,2,2,6,0,0};
        map[3]=new int[]{0,4,4,2,4,2,4,4,0,0};
        map[4]=new int[]{0,2,3,4,4,7,2,2,0,0};
        map[5]=new int[]{0,2,6,2,5,2,4,4,0,0};
        map[6]=new int[]{0,4,2,2,5,4,4,4,0,0};
        map[7]=new int[]{0,6,6,2,2,2,2,2,0,0};
        map[8]=new int[]{0,4,4,4,4,4,4,4,0,0};
        map[9]=new int[]{0,4,4,4,5,2,2,4,0,0};
        Scanner sc=new Scanner(System.in);
        int counts=sc.nextInt();
        for(int cou=0; cou<counts; ++cou){
            int N=sc.nextInt();
            int gap=N/10;
            int[] input=new int[10];
            int[] set=new int[N];
            for(int i=0,j=0,n=0; i<N; ++i){
                int times=0;
                int temp;
                for (int k=0; k<N; ++k){
                    temp=sc.nextInt();
                    if(j==4*gap){
                       set[k]=temp;
                    }
                    if (temp==1) times++;
                }
                if(i==j) {
                    input[n]=times/gap;
                    j+=gap;
                    n++;
                }
            }
            if(belong(input,map[0])&&set[N/2]==0){
                System.out.println(0);
            }else {
                for(int i=1; i<10; ++i){
                    if(belong(input,map[i])){
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }

    static boolean belong(int[] ints1, int[] ints2){
        for(int i=0; i<ints1.length; ++i){
            if(ints1[i]!=ints2[i]) return false;
        }
        return true;
    }
}
