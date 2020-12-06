package haoweilai;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class NotReCuPreOrder {
    /**
     * 二叉树的非递归前序遍历
     * @param root TreeNode类 根节点
     * @return string字符串
     */
    public String notReCuPreOrder (TreeNode root) {
        // write code here
        if(root==null) return "";
        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.addLast(root);
        List<Integer> ans=new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode cur=stack.removeLast();
            ans.add(cur.val);
            if(cur.right!=null) stack.addLast(cur.right);
            if(cur.left!=null) stack.addLast(cur.left);
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0; i<ans.size()-1; ++i){
            sb.append(ans.get(i));
            sb.append(',');
        }
        sb.append(ans.get(ans.size()-1));
        return sb.toString();
    }

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
}
