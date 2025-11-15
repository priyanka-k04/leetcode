/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        Map<Integer, Integer> map=new HashMap<>();
        ListNode curr=head;
        while(curr!=null){
            map.put(curr.val, map.getOrDefault(curr.val,0)+1);
            curr=curr.next;
        }
        ListNode dummy= new ListNode(0);
        ListNode tail=dummy;
            curr=head;
        while(curr!=null){
            if(map.get(curr.val)==1){
                tail.next=new ListNode(curr.val);
                tail=tail.next;
            }
            curr=curr.next;
        }
        return dummy.next;
        
    }
}