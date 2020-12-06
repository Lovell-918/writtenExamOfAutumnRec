package yuanfudao;

import java.util.LinkedList;
import java.util.Scanner;

public class ValidCal {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());
        for(int n=0; n<N; ++n){
            boolean isInvalid=false;
            String input=sc.nextLine();
            if(input.length()<1||input.charAt(0)!='('||input.charAt(input.length()-1)!=')'){
                System.out.println("invalid");
                continue;
            }
            LinkedList<Character> symStack=new LinkedList<>();
            LinkedList<Integer> oprStack=new LinkedList<>();
            StringBuilder sb=new StringBuilder();
            for(int i=1; i<input.length()-1;){
                while (input.charAt(i)==' '&&i<input.length()-1){
                    i++;
                }
                while (input.charAt(i)!=' '&&i<input.length()-1) {
                    sb.append(input.charAt(i));
                    i++;
                }
                String s=sb.toString();
                sb=new StringBuilder();
                if(s.equals("(")){
                    symStack.addLast('(');
                }else if(s.equals("+")||s.equals("-")||s.equals("*")){
                    symStack.addLast(s.charAt(0));
                }else if(s.equals(")")){
                    if(symStack.isEmpty()){
                        System.out.println("invalid");
                        isInvalid=true;
                        break;
                    }
                    char c=symStack.removeLast();
                    if(c=='('||(!symStack.isEmpty()&&symStack.getLast()!='(')){
                        System.out.println("invalid");
                        isInvalid=true;
                        break;
                    }
                    symStack.removeLast();
                    if(oprStack.size()<2) {
                        System.out.println("invalid");
                        isInvalid=true;
                        break;
                    }
                    int b=oprStack.removeLast(), a=oprStack.removeLast();
                    oprStack.addLast(getResult(c,a,b));
                }else {
                    oprStack.addLast(Integer.parseInt(s));
                }
            }
            while (!symStack.isEmpty()&&!isInvalid) {
                char c=symStack.removeLast();
                if(c=='('||(!symStack.isEmpty()&&symStack.getLast()!='(')){
                    System.out.println("invalid");
                    continue;
                }
                if(!symStack.isEmpty()) symStack.removeLast();
                if(oprStack.size()<2) {
                    System.out.println("invalid");
                    continue;
                }
                int b=oprStack.removeLast(), a=oprStack.removeLast();
                oprStack.addLast(getResult(c,a,b));
            }
            if(!isInvalid) {
                if (oprStack.size() > 1) {
                    System.out.println("invalid");
                    continue;
                } else if(oprStack.size()==1) {
                    int ans = oprStack.removeLast();
                    ans = (ans % 10000000 + 10000000) % 10000000;
                    System.out.println(ans);
                } else {
                    System.out.println("invalid");
                }
            }
        }
    }

    static int getResult(char c, int i, int j){
        switch (c){
            case '+':
                return i+j;
            case '-':
                return i-j;
            case '*':
                return i*j;
            }
            return -1;
        }
    }
