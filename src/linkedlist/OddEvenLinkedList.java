package linkedlist;

public class OddEvenLinkedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;  // Edge case: if the list has fewer than 2 nodes

        ListNode odd = head,
                even = head.next,
                evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;   // Link the next odd node
            even.next = even.next.next; // Link the next even node

            odd = odd.next;             // Move to the next odd node
            even = even.next;           // Move to the next even node
        }

        odd.next = evenHead;            // Connect the last odd node to the head of the even list

        return head;                    // Return the original head
    }

    // Helper method to print the list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the oddEvenList function
    public static void main(String[] args) {
        OddEvenLinkedList solution = new OddEvenLinkedList();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original list
        System.out.println("Original list:");
        solution.printList(head);

        // Rearrange the list with odd-even separation
        ListNode newHead = solution.oddEvenList(head);

        // Print the rearranged list
        System.out.println("Rearranged list:");
        solution.printList(newHead);
    }
}
