package meituan;

import java.util.Scanner;

public class CheckName {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            for(int i=0; i<n; ++i){
                String input=sc.next();
                boolean ans=true;
                int wNum=0, nNum=0;
                char[] chars=input.toCharArray();
                if(!Character.isLetter(chars[0])) ans=false;
                else {
                    for (char c : input.toCharArray()) {
                        if(Character.isDigit(c)) nNum++;
                        else if(Character.isLetter(c)) wNum++;
                        else{
                            ans=false;
                            break;
                        }
                    }
                }
                if(ans&&nNum>0&&wNum>0) System.out.println("Accept");
                else System.out.println("Wrong");
            }
        }
        sc.close();
    }
}
