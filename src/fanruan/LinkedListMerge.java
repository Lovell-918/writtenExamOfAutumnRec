package fanruan;

import java.util.Scanner;

public class LinkedListMerge {
    public static void main(String[] args){
        LinkedListMerge linkedListMerge =new LinkedListMerge();
        linkedListMerge.solution();
    }

    void solution(){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int num=sc.nextInt();
            ListNode[] listNodes=new ListNode[num];
            int[] lens=new int[num];
            for (int i=0; i<num; ++i){
                lens[i]=sc.nextInt();
            }
            for(int i=0; i<num; ++i){
                ListNode dummy=new ListNode(-1,-1);
                ListNode temp=dummy;
                for(int j=0; j<lens[i]; ++j){
                    String[] input=sc.next().split(":");
                    temp.next=new ListNode(Long.parseLong(input[0]),Long.parseLong(input[1]));
                    temp=temp.next;
                }
                listNodes[i]=dummy.next;
            }
            ListNode node=merge(listNodes,0,num-1);
            StringBuilder sb=new StringBuilder();
            while (node!=null){
                sb.append(node.key).append(":").append(node.value).append(" ");
                node=node.next;
            }
            System.out.println(sb.toString().trim());
        }
        sc.close();
    }

    ListNode merge(ListNode[] listNodes, int start, int end){
        if(start>end) return null;
        if(start==end) return listNodes[start];
        int mid=start+(end-start)/2;
        ListNode left=merge(listNodes,start,mid);
        ListNode right=merge(listNodes,mid+1,end);
        ListNode dummy=new ListNode(-1,-1);
        ListNode pre=dummy;
        while (left!=null&&right!=null){
            if(left.key==right.key){
                dummy.next=new ListNode(left.key,left.value+right.value);
                left=left.next;
                right=right.next;
            }else if(left.key<right.key){
                dummy.next=left;
                left=left.next;
            }else {
                dummy.next=right;
                right=right.next;
            }
            dummy=dummy.next;
        }
        if(left!=null) dummy.next=left;
        if(right!=null) dummy.next=right;
        return pre.next;
    }

    static class ListNode{
        long key, value;
        ListNode next;
        ListNode(long k, long v){
            key=k;
            value=v;
        }
    }
}
