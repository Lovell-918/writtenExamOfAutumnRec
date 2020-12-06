package xiaomi;

import java.util.Scanner;

//        时间限制： 3000MS
//        内存限制： 589824KB
//        题目描述：
//        注册网站时，需要使用包含不同类型（数字、符号、大写字母、小写字母）的字符，和特定长度。
//        检查一个密码内容同时包含以上 4 种类型的字符，并且长度在8-120 个字符之间。符合要求，返回 0；
//        长度不符合返回 1；类型不符合要求返还 2。
//        可以一次输入多组密码，以空格符间隔，空格符不作为密码。
//
//        输入描述
//        需要验证的密码，多个密码以空格符间隔，空格符不作为密码的一部分
//
//        输出描述
//        每个密码的检查结果，每个结果需要换行输出
public class ValidPwd {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String pwd=sc.next();
            if(pwd.length()<8||pwd.length()>120){
                System.out.println(1);
            }else {
                int[] types=new int[4];
                for (char c:pwd.toCharArray()){
                    if(Character.isDigit(c)){
                        types[0]=1;
                    }else if(c>='a'&&c<='z'){
                        types[1]=1;
                    }else if(c>='A'&&c<='Z'){
                        types[2]=1;
                    }else types[3]=1;
                }
                int sum=0;
                for(int i:types){
                    sum+=i;
                }
                if(sum==4){
                    System.out.println(0);
                }else System.out.println(2);
            }
        }
    }
}
