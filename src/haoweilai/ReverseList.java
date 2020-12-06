package haoweilai;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class ReverseList {
    /**
     * 逆序
     * @param head ListNode类 头结点
     * @return ListNode类
     */
    public ListNode reverseList (ListNode head) {
        // write code here
        if(head==null||head.next==null) return head;
        ListNode pre=null, next;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }


class ListNode {
    int val;
    ListNode next = null;
  }
}
