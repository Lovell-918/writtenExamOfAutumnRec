package yuanfudao;

import java.util.Scanner;

public class TearPaper {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=0; i<num; ++i){
            String s1=sc.next(), s2=sc.next(), s3=sc.next();
            int k=sc.nextInt();
            if(s1.length()+s2.length()!=s3.length()){
                System.out.println(0);
                continue;
            }
            int count=0;
            int[] ptr=pat(s1,s3,0,0);
            if(ptr[0]==-1){
                ptr=pat(s2,s3,0,0);
                count++;
                int t=0;
                while (ptr[1]!=-1&&ptr[1]<s3.length()){
                    if(t%2==0){
                        ptr=pat(s1,s3,ptr[0],ptr[1]);
                        count++;
                    }else {
                        ptr=pat(s2,s3,ptr[0],ptr[1]);
                        count++;
                    }
                    t++;
                }
                if(ptr[1]!=-1&&count<=k){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }else {
                count++;
                int t=0;
                while (ptr[1]!=-1&&ptr[1]<s3.length()){
                    if(t%2==1){
                        ptr=pat(s1,s3,ptr[0],ptr[1]);
                        count++;
                    }else {
                        ptr=pat(s2,s3,ptr[0],ptr[1]);
                        count++;
                    }
                    t++;
                }
                if(ptr[1]!=-1&&count<=k){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }
        }
    }

    static int[] pat(String s, String s3, int p1, int p2){
        int[] ans=new int[]{-1,-1};
        int t1=p1,t2=p2;
        while (p1<s.length()&&p2<s3.length()&&s.charAt(p1)==s3.charAt(p2)){
            p1++;
            p2++;
        }
        if(t1==p1) return ans;
        return new int[]{p1,p2};
    }
}
