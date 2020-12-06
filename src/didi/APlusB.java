package didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class APlusB {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int a,b,c;
            List<List<Integer>> ans=new ArrayList<>();
            for(a=1; a<=9; ++a){
                for(b=0; b<=9; ++b){
                    for(c=0; c<=9; ++c){
                        if(a!=b&&b!=c&&a!=c){
                            int left=a*100+b*10+c;
                            int right=a*100+c*11;
                            if(left+right==n){
                                ans.add(Arrays.asList(left,right));
                            }
                        }
                    }
                }
            }
            System.out.println(ans.size());
            for(List<Integer> list:ans){
                System.out.print(list.get(0)+" ");
                System.out.println(list.get(1));
            }
        }
        sc.close();
    }
}
