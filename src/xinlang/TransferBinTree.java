package xinlang;

import java.util.*;

public class TransferBinTree {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        String[] strArrays=input.split(",");
        int[] nums=new int[strArrays.length];
        for(int i=0; i<strArrays.length; ++i){
            nums[i]=Integer.parseInt(strArrays[i]);
        }
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode root=new TreeNode(nums[0]);
        int ptr=1;
        queue.add(root);
        while (ptr<nums.length){
            TreeNode cur=queue.remove();
            cur.left=new TreeNode(nums[ptr++]);
            queue.add(cur.left);
            if(ptr<nums.length){
                cur.right=new TreeNode(nums[ptr++]);
                queue.add(cur.right);
            }
        }
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode node=solution(root);
        List<Integer> ans=new ArrayList<>();
        stack.addLast(node);
        while (!stack.isEmpty()){
            TreeNode temp=stack.removeLast();
            ans.add(temp.val);
            if(temp.right!=null) stack.addLast(temp.right);
            if(temp.left!=null) stack.addLast(temp.left);
        }
        for(int i=0; i<ans.size()-1; ++i){
            System.out.print(ans.get(i)+",");
        }
        System.out.println(ans.get(ans.size()-1));
    }

    static TreeNode solution(TreeNode root){
        if(root.left==null) return root;
        TreeNode father=solution(root.left);
        root.left=null;
        TreeNode cur=father;
        while (cur.right!=null){
            cur=cur.right;
        }
        cur.right=root;
        cur.left=root.right;
        root.right=null;
        return father;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
}
