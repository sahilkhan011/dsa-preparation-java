package NumberAndArray;

public class AddTwoNumberLinkedList {

    public static void main(String[] args) {
        // Create first linked list [2,4,3]
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second linked list [5,6,9]
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Print the linked lists
        System.out.print("Linked List 1: ");
        printList(l1);
        System.out.print("Linked List 2: ");
        printList(l2);


        ListNode l3 = addTwoNumbers(l1,l2);
        System.out.print("Linked List 3: ");
        printList(l3);
    }

    // Method to print a linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode currentNode = null;

        int i =0;
        int hasilka = 0;

        while(l1 != null || l2 != null){
            int num1=0,num2=0;
            if(l1 != null){
                num1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                num2 = l2.val;
                l2 = l2.next;
            }

            // create first node
            if(i++==0){
                l3.val = (num1+num2+hasilka)%10;
                currentNode = l3;
            }
            // run if already created first node
            else{
                ListNode nextNode = new ListNode((num1+num2+hasilka)%10);
                currentNode.next = nextNode;
                currentNode = nextNode;
            }
            // manage hasilka
            hasilka = (num1+num2+hasilka)/10;
        }

        // last hasilka
        if(hasilka!=0){
            currentNode.next = new ListNode(hasilka);
        }

        return  l3;

    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;

        }
    }
}








