import com.sun.javafx.collections.MappingChange;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
//    public static void main(String[] args){
//        Scanner scanner=new Scanner(System.in);
//        String input=scanner.nextLine();
//        long ans=solution(input);
//
//        if(ans==-2){
//            System.out.println("Invalid input");
//        }else {
//            System.out.println(ans);
//        }
//    }
//
//    private static long solution(String input){
//        if(!isValid(input)) return -2;
//        String[] strings=input.split("\\.");
//        StringBuilder bin=new StringBuilder();
//        for(String s:strings){
//            StringBuilder t= new StringBuilder(Integer.toBinaryString(Integer.parseInt(s)));
//            while (t.length()<8){
//                t.insert(0, '0');
//            }
//            bin.append(t);
//        }
//        return transBin(bin.toString());
//    }
//
//    private static long transBin(String s){
//        int i=31;
//        long ans=0;
//        for(char c:s.toCharArray()){
//            ans+=(long) (c-'0')*Math.pow(2,i);
//            i--;
//        }
//        return ans;
//    }
//
//    private static boolean isValid(String input){
//        String[] strings=input.split("\\.");
//        if(strings.length!=4) return false;
//        for(String s:strings){
//            int i=toNum(s);
//            if(i<0||i>255) return false;
//        }
//        return true;
//    }
//
//    private static int toNum(String s){
//        try {
//            int ans=Integer.parseInt(s);
//            return ans;
//        }catch (Exception e){
//            return -1;
//        }
//    }
    private boolean filter(Request request){
        User u=Factory.getUser(request.uType);
        return u.isContains(request.url);
    }

    class Request{
        String url;
        int uType;
    }

    static class Factory{
        static Map<Integer,User> map;
        static User getUser(int type){
            if(map.get(type)==null){
                switch (type){
                    case 1:
                        map.put(1,new Tea());
                        break;
                    case 2:
                        map.put(2,new Stu());
                        break;
                }
            }
            return map.get(type);
        }
    }

    static class User{
        String uId;
        Set<String> urlSet;
        public boolean isContains(String url){
            return urlSet.contains(url);
        }
    }

    static class Tea extends User{
        public Tea(){
            urlSet=new HashSet<>();
            urlSet.add("url1");
        }
    }

    static class Stu extends User{
        public Stu(){
            urlSet=new HashSet<>();
            urlSet.add("url7");
        }
    }
}
