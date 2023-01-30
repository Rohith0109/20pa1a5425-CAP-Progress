class reverseLinkedList{
  public ListNode reverse(ListNode head){
    if (head==null)
      return null;
    
    ListNode dummy = null;
    while (head!=null){
      ListNode curr = head.next;
      head.next = dummy;
      dummy = head;
      head = curr;
    }
  }
