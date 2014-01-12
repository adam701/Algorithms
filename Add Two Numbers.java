/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
         ListNode iter1=l1,iter2=l2,newHead=new ListNode(0),newTail;
        newTail=newHead;
        int res=0;
        int addition=0;
        while(l1!=null || l2!=null){
            int temp;
            if(l1==null){
                temp=l2.val+addition;
                l2=l2.next;
            }
            else if(l2==null){
                temp=l1.val+addition;
                l1=l1.next;
            }
            else{
                temp=l1.val+l2.val+addition;
                l1=l1.next;
                l2=l2.next;
            }
            addition=temp/10;
            temp=temp%10;
            newTail.next=new ListNode(temp);
            newTail=newTail.next;
        }
        if(addition!=0){
            newTail.next=new ListNode(addition);
        }
        return newHead.next;
        
    }
}