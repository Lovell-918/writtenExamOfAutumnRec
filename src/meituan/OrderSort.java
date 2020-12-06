package meituan;

import java.util.*;

public class OrderSort {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int len=sc.nextInt();
            int need=sc.nextInt();
            List<order> orderList=new ArrayList<>();
            for(int i=1; i<=len; ++i){
                orderList.add(new order(sc.nextInt(),sc.nextInt(),i));
            }
            orderList.sort(new Comparator<order>() {
                @Override
                public int compare(order o1, order o2) {
                    int n1 = o1.v + 2 * o1.w;
                    int n2 = o2.v + 2 * o2.w;
                    if(n1!=n2)
                        return n1 - n2;
                    else return o2.o-o1.o;
                }
            });
            int[] ans=new int[need];
            for(int i=len-1,j=0; i>=len-need; --i,j++){
                ans[j]=orderList.get(i).o;
            }
            Arrays.sort(ans);
            for(int i=0; i<need-1; ++i){
                System.out.print(ans[i]+" ");
            }
            System.out.println(ans[need-1]);
        }


        sc.close();
    }

    static class order{
        int v,w,o;
        public order(int v, int w, int o){
            this.v=v;
            this.w=w;
            this.o=o;
        }
    }
}
