package xiaomi;

import java.util.Scanner;

//    时间限制： 3000MS
//    内存限制： 589824KB
//    题目描述：
//    给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格,
//    同一个单元格内的字母不允许被重复使用。
//    输入描述
//    需要查询的单词
//    输出描述
//    true 代表单词存在，false表示不存在
//
//
//    样例输入
//    SEE
//    样例输出
//    true
public class TwoDimensionalGrid {
    //上下左右回溯 https://leetcode-cn.com/problems/word-search-ii/solution/dan-ci-sou-suo-ii-by-leetcode/
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(), n=sc.nextInt();
        char[][] matrix=new char[m][n];
        for (int i=0; i<m; ++i){
            for (int j=0; j<n; ++j){
                matrix[i][j]=sc.next().charAt(0);
            }
        }
        String s=sc.next();
        if(solution(matrix,s)) System.out.println("true");
        else System.out.println("false");
    }

    static boolean solution(char[][] matrix, String s){
        for(int i=0; i<matrix.length; ++i){
            for (int j=0; j<matrix[0].length; ++j){
                if(s.charAt(0)==matrix[i][j]){
                    if(matchOnRow(matrix,s,i,j)||matchOnCol(matrix,s,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean matchOnRow(char[][] matrix, String s, int row, int col){
        if(col+s.length()>matrix[0].length) return false;
        for(int i=col,j=0; i<matrix[0].length; ++i,++j){
            if(s.charAt(j)!=matrix[row][i]) return false;
        }
        return true;
    }

    static boolean matchOnCol(char[][] matrix, String s, int row, int col){
        if(row+s.length()>matrix.length) return false;
        for(int i=row,j=0; i<matrix.length; ++i,++j){
            if(s.charAt(j)!=matrix[i][col]) return false;
        }
        return true;
    }
}
