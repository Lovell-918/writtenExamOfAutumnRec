package tengxun;

import java.util.Scanner;

public class KthSmallSubString {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String input=sc.next();
            int k=sc.nextInt();
            int[] counts=new int[26];
            for(char c:input.toCharArray()){
                counts[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<26; ++i){
                int co=0;
                while (sb.length()<k&&co<counts[i]){
                    sb.append((char)(i+'a'));
                    co++;
                }
                if(sb.length()==k) break;
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
