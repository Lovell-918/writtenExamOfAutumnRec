package aiqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SamePos {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String input=sc.next();
            List<List<Integer>> posList=new ArrayList<>();
            int x=0, y=0;
            //加原点！
            posList.add(Arrays.asList(0,0));
            boolean ans=false;
            for(char c:input.toCharArray()){
                List<Integer> temp=new ArrayList<>(2);
                switch (c){
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                        break;
                    default:
                        break;
                }
                temp.add(x); temp.add(y);
                if(posList.contains(temp)){
                    ans=true;
                    break;
                }else {
                    posList.add(temp);
                }
            }
            if(ans) System.out.println("True");
            else System.out.println("False");
        }
        sc.close();
    }
}
