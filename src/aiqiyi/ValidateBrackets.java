package aiqiyi;

import java.util.LinkedList;
import java.util.Scanner;

public class ValidateBrackets {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String input=sc.next();
            if(input==null||input.equals("")){
                System.out.println("True");
            }else {
                boolean ans=true;
                LinkedList<Character> stack=new LinkedList<>();
                for(char c:input.toCharArray()){
                    if(c=='('||c=='['||c=='{'){
                        stack.add(c);
                    }else {
                        if(c==')'&&!stack.isEmpty()&&stack.peek()=='('){
                            stack.pollLast();
                        }else if(c==']'&&!stack.isEmpty()&&stack.peek()=='['){
                            stack.pollLast();
                        }else if(c=='}'&&!stack.isEmpty()&&stack.peek()=='{'){
                            stack.pollLast();
                        }else {
                            ans=false;
                            break;
                        }
                    }
                }
                if(ans&&stack.size()==0){
                    System.out.println("True");
                }else {
                    System.out.println("False");
                }
            }
        }
        sc.close();
    }
}
