package xiaohongshu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//时间限制： 3000MS
//内存限制： 589824KB
//题目描述：
//一个二叉树深度为k，节点取值为自然数,k<=5，找出不在树中的最小自然数，需要给出O(N)的算法。
// bool exist(Tree tree, int n)
//
//
//
//输入描述
//[4,32,34,11,22,33,5,15,16,17,18]
//
//输出描述
//1
public class BinTreeFind {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int findMin(int[] tree) {
        Arrays.sort(tree);
        int ans=1;
        while (exist(tree,ans)){
            ans++;
        }
        return ans;
        }
    static boolean exist(int[] tree, int i){
        for(int t:tree){
            if(t==i) return true;
            if(t>i) return false;
        }
        return false;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _tree_size = 0;
        _tree_size = Integer.parseInt(in.nextLine().trim());
        int[] _tree = new int[_tree_size];
        int _tree_item;
        for(int _tree_i = 0; _tree_i < _tree_size; _tree_i++) {
            _tree_item = Integer.parseInt(in.nextLine().trim());
            _tree[_tree_i] = _tree_item;
        }

        res = findMin(_tree);
        System.out.println(String.valueOf(res));

    }
}

