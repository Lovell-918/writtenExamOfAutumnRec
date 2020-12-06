package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodsSplit {
    static List<List<Good>> ansList=new ArrayList<>();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            List<Good> goods=new ArrayList<>();
            for(int i=1; i<=n; ++i){
                goods.add(new Good(i,sc.nextInt()));
            }
            ansList.add(goods);
            for(int i=0; i<n; ++i){
                split(sc.nextInt());
            }
        }
        sc.close();
    }

    static void split(int num){
        List<List<Good>> newAnsList=new ArrayList<>();
        int i=0;
        for(; i<ansList.size(); ++i){
            List<Good> temp=ansList.get(i);
            boolean isSplit=false;
            for(int j=0; j<temp.size(); ++j){
                Good good=temp.get(j);
                if(good.order==num){
                    isSplit= true;
                    if(j>0)
                        newAnsList.add(new ArrayList<>(temp.subList(0,j)));
                    if(temp.size()>j+1)
                        newAnsList.add(new ArrayList<>(temp.subList(j+1,temp.size())));
                    i++;
                    break;
                }
            }
            if(isSplit) break;
            else newAnsList.add(temp);
        }
        for(;i<ansList.size();++i){
            newAnsList.add(ansList.get(i));
        }
        ansList=newAnsList;
        int max=0;
        for(int j=0; j<ansList.size(); ++j){
            int temp=0;
            for(Good g:ansList.get(j)){
                temp+=g.weight;
            }
            max=Math.max(max,temp);
        }
        System.out.println(max);
    }

    static class Good{
        int order,weight;
        public Good(int order, int weight){
            this.order=order;
            this.weight=weight;
        }
    }
}
