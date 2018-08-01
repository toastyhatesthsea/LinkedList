package LinkedListers;

import java.util.LinkedList;

class MyLinkedList {

    class Node
    {
        private Node link;
        private Object data;

        public Node(Object data, Node aLink)
        {
            this.data = data;
            link = aLink;
        }
    }

    private int val;
    private Node tail;
    private Node head;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        Node current = head;
        for(int i=0; i < index && current != null; i++)
        {
            current = current.link;
        }

        if (current == null)
        {
            return -1;
        }
        else
        {
            return (int)current.data;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        if (head == null)
        {
            head = new Node(val, null);
            tail = head;
            this.val = val;
        }
        else
        {
            Node oldHead = this.head;
            head = new Node(val, oldHead);
            this.val = val;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        //No objects have been assigned yet
        if (tail == null)
        {
            tail = new Node(val, null);
            head = tail;
        }
        else
        {
            tail.link = new Node(val, null);
            tail = tail.link;
        }

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if (index == size)
        {
            if (head == tail)
            {
                Node newNode = new Node(val, null);
                head.link = newNode;
                tail = newNode;
            }
            else
            {
                Node newNode = new Node(val, null);
                tail.link = newNode;
                tail = newNode;
            }
        } else if (index < size && index >= 0)
        {
            if (index == 0)
            {

            }
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        Node current = head;
        Node beforeCurrent = current;

        for(int i=0; i < index && current != null; i++)
        {
            beforeCurrent = current;
            current = current.link;
        }

        if (index == 0 && current != null)
        {
            head = head.link;
            //Reset tail if node only has one value left
            if (head.link == null)
            {
                tail = head;
            }
            size--;
        } else if (current != null)
        {
            beforeCurrent.link = current.link;
            size--;
        }

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

class LinkedTesters
{
    public static void main(String[] arsgsg)
    {
        MyLinkedList aList = new MyLinkedList();

        aList.addAtHead(1);
        aList.addAtHead(2);
        //int value = aList.get(0);
        aList.deleteAtIndex(1);

    }
}

class LinkedListIterator
{
    public static void printList(MyLinkedList aNode)
    {

    }


}
