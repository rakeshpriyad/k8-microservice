package com.test.prog.ll;// Java program for reversing the linked list

import java.util.HashSet;

public class LinkedList<T> {
    Node head;

    static class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    /* This function is in LinkedList class. Inserts a
   new Node at front of the list. This method is
   defined inside LinkedList class shown above */
    public void push(int new_data) {
    /* 1 & 2: Allocate the Node &
              Put in the data*/
        Node newNode = new Node(new_data);
        /* 3. Make next of new Node as head */
        newNode.next = head;
        /* 4. Move the head to point to new Node */
        head = newNode;
    }

    /* This function is in LinkedList class.
   Inserts a new node after the given prev_node. This method is
   defined inside LinkedList class shown above */
    public void insertAfter(Node prevNode, int new_data) {
        /* 1. Check if the given Node is null */
        if (prevNode == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
    /* 2. Allocate the Node &
       3. Put in the data*/
        Node newNode = new Node(new_data);
        /* 4. Make next of new Node as next of prev_node */
        newNode.next = prevNode.next;

        /* 5. make next of prev_node as new_node */
        prevNode.next = newNode;
    }

    /* Appends a new node at the end. This method is
defined inside LinkedList class shown above */
    public void append(T data) {
	/* 1. Allocate the Node &
	2. Put in the data
	3. Set next as null */
        Node<T> newNode = new Node(data);

	/* 4. If the Linked List is empty, then make the
		new node as head */
        if (head == null) {
            head = new Node(data);
            return;
        }

	/* 4. This new node is going to be the last node, so
		make next of it as null */
        newNode.next = null;

        /* 5. Else traverse till the last node */
        Node<T> last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        return;
    }

    /* Function to reverse the linked list */
    Node<T> reverse(Node<T> node) {
        Node<T> prev = null;
        Node<T> current = node;
        Node<T> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    Node<T> recReverse(Node<T> head) {
        if (head == null || head.next == null)
            return head;

        /* reverse the rest list and put
        the first element at the end */
        Node rest = recReverse(head.next);
        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        /* fix the head pointer */
        return rest;
    }

    // Returns true if there is a loop in linked
    // list else returns false.
    boolean detectLoop(Node<T> h) {
        HashSet<Node<T>> s = new HashSet<Node<T>>();
        while (h != null) {
            // If we have already has this node
            // in hashmap it means their is a cycle
            // (Because you we encountering the
            // node second time).
            if (s.contains(h))
                return true;

            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(h);

            h = h.next;
        }

        return false;
    }

    int detectLoop() {
        Node slowPointer = head, fastPointer = head;
        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                System.out.println("Found loop");
                return 1;
            }
        }
        return 0;
    }

    // Function that detects loop in the list
    /*
    https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
     */
    int detectAndRemoveLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // Function to remove loop
    /*
    This method is also dependent on Floyd’s Cycle detection algorithm.
Detect Loop using Floyd’s Cycle detection algorithm and get the pointer to a loop node.
Count the number of nodes in loop. Let the count be k.
Fix one pointer to the head and another to a kth node from the head.
Move both pointers at the same pace, they will meet at loop starting node.
Get a pointer to the last node of the loop and make next of it as NULL.
Thanks to WgpShashank for suggesting this method.
     */
    void removeLoop(Node loop, Node head) {
        Node ptr1 = loop;
        Node ptr2 = loop;

        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }

        // Fix one pointer to head
        ptr1 = head;

        // And the other pointer to k nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }

        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Get pointer to the last node
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }

        /* Set the next node of the loop ending node
         to fix the loop */
        ptr2.next = null;
    }


    // prints content of double linked list
    void printList(Node<T> node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
