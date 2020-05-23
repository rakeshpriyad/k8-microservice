package com.test.prog.ll;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(85);
        list.push(15);
        list.push(4);
        list.push(20);
       /* list.head = new Node<Integer>(85);
        list.head.next = new Node<Integer>(15);
        list.head.next.next = new Node<Integer>(4);
        list.head.next.next.next = new Node<Integer>(20);*/

        System.out.println("Given Linked list");
        list.printList(list.head);
        LinkedList.Node<Integer> head = list.reverse(list.head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);

        list.append(30);
        System.out.println("Given Linked list after append");
        list.printList(head);
        head = list.recReverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);

        /*Create loop for testing */
        list.head.next.next.next.next = list.head;

        list.detectLoop();
        System.out.println(list.detectLoop(head));

        list.detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}
