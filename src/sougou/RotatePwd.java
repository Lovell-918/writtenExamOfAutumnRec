package sougou;

import java.util.Arrays;

public class RotatePwd {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一行字符串，表示原文。
     * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
     * @param s2 string字符串一维数组 字符矩阵，表示密文
     * @return string字符串
     */
    public String rotatePassword (String[] s1, String[] s2) {
        // write code here
        StringBuilder ans=new StringBuilder();
        for(int t=0; t<4; ++t){
            for(int i=0; i<s1.length; ++i){
                for (int j=0; j<s1[i].length(); ++j){
                    if(s1[i].charAt(j)=='0'){
                        ans.append(s2[i].charAt(j));
                    }
                }
            }
            rotate(s1);
        }
        return ans.toString();
    }

    void rotate(String[] s){
        String[] temp= Arrays.copyOf(s,s.length);
        for(int index=0,y=0; index<temp.length; ++index,++y) {
            StringBuilder sb=new StringBuilder();
            for (int i = temp.length - 1; i >= 0; --i) {
                sb.append(temp[i].charAt(y));
            }
            s[index]=sb.toString();
        }
    }
}
