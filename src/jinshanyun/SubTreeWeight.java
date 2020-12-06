package jinshanyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//子树的权重
//时间限制： 3000MS
//内存限制： 589824KB
//题目描述：
//首先按照从上到下、从左到右的顺序输入一棵满二叉树中每一个结点对应的权重，
// 例如输入1、1、2表示二叉树的根结点的权重为1，它的左、右两个子节点的权重分别为1和2。
//然后判断该满二叉树中是否存在这样的非叶子结点：它的左子树上所有结点的权重之和等于右子树上所有结点的权重之和。
//现在给你一棵满二叉树的所有结点的权重，请编写一个程序，寻找是否存在满足要求的非叶子结点，如果存在输出“Yes”，否则输出“No”。
//输入描述
//多组输入。
//第1行输入一个正整数T表示测试数据的数量。(T<=100)
//接下来T行对应T组输入，每组输入数据占一行，该行包含n个正整数（n满足2^k-1），两两之间用空格隔开，1<n<=1000。
//
//输出描述
//对于每组输入数据，如果能够找到满足要求的非叶子结点（左子树上所有结点的权重之和等于右子树上所有结点的权重之和）,
//输出“Yes”，否则输出“No”。

public class SubTreeWeight {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int times=Integer.parseInt(sc.nextLine());
        for(int time=0; time<times; ++time){
            String[] strings=sc.nextLine().split(" ");
            TreeNode root=new TreeNode(strings[0]);
            Queue<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            int i=1;
            while (i<strings.length){
                TreeNode cur=queue.remove();
                cur.left=new TreeNode(strings[i++]);
                queue.add(cur.left);
                if(i<strings.length){
                    cur.right=new TreeNode(strings[i++]);
                    queue.add(cur.right);
                }
            }
            if(sumVal(root)==-1){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }

    static int sumVal(TreeNode root){
        if(root.left==null&&root.right==null) return root.val;
        int left,right;
        if(root.left==null){
            right=sumVal(root.right);
            if(right==-1) return -1;
            return right+root.val;
        }
        if(root.right==null){
            left=sumVal(root.left);
            if(left==-1) return -1;
            return left+root.val;
        }
        left=sumVal(root.left);
        right=sumVal(root.right);
        if(left==-1||right==-1) return -1;
        if(left==right) return -1;
        return left+right+root.val;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(String n){
            val=Integer.parseInt(n);
        }
    }
}
