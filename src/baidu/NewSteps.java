package baidu;

import java.util.LinkedList;
import java.util.Scanner;

public class NewSteps {
    static int ans=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt(), m=sc.nextInt();
            LinkedList<Integer> steps=new LinkedList<>();
            backtrack(n,m,steps,0);
            System.out.println(ans%1000000007);
        }
    }

    static void backtrack(int n, int m, LinkedList<Integer> steps, int curLen){
        if(curLen>=n){
            ans++;
            return;
        }
        for (int i=1; i<=m; ++i){
            if(!steps.contains(i)){
                if(curLen+i>n) break;
                int temp=-1;
                if(steps.size()==2){
                    temp=steps.removeFirst();
                }
                steps.addLast(i);
                curLen+=i;
                backtrack(n,m,steps,curLen);
                curLen-=i;
                steps.removeLast();
                if(temp!=-1) steps.addFirst(temp);
            }
        }
    }
}
