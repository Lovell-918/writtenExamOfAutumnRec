package meituan;

import java.util.Scanner;

public class TeamSplit {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int x=sc.nextInt();
            int y=sc.nextInt();
            for(int i=0; i<x+y; ++i){
                sc.nextInt();
            }
            for(int i=0; i<x; ++i){
                System.out.print("A");
            }
            for(int i=0; i<y; ++i){
                System.out.print("B");
            }
            System.out.println();
        }
    }
}
