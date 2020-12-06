package baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodCaw {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        for(int i=0; i<count; ++i){
            int len=sc.nextInt();
            int need=sc.nextInt();
            int[] caws=new int[len];
            for(int j=0; j<need; ++j){
                int nums=sc.nextInt();
                for(int k=0; k<nums; ++k){
                    int start=sc.nextInt()-1, end=sc.nextInt()-1;
                    for(int n=start; n<=end; ++n){
                        caws[n]++;
                    }
                }
            }
            List<Integer> ans=new ArrayList<>();
            for(int j=0; j<len;++j){
                if(caws[j]==need) ans.add(j+1);
            }
            System.out.println(ans.size());
            for(int j=0; j<ans.size(); ++j){
                if(j<ans.size()-1) System.out.print(ans.get(j)+" ");
                else System.out.println(ans.get(j));
            }
        }
    }
}
