package xinlang;

import java.util.Arrays;
import java.util.Scanner;

public class DulChar {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        char[] chars=input.toCharArray();
        Arrays.sort(chars);
        boolean isTrue=true;
        for(int i=1; i<chars.length; ++i){
            if(chars[i]==chars[i-1]){
                isTrue=false;
                break;
            }
        }
        if (isTrue) System.out.println("true");
        else System.out.println("false");
    }
}
