package oppo;

import java.io.*;

public class Main {
    public static void main(String[] args){

    }

    double solution1(double a, double b){
        return a+b;
    }

    void solution2(){
        try(FileReader fileReader=new FileReader("d:\\readme.md")){
            int c;
            while ((c=fileReader.read())!=-1){
                System.out.print((char)c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
