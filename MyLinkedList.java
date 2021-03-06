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

        //Empty List
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
            Node newTail = new Node(val, null);

            //A List of only 1 node
            if (tail == head)
            {
                head.link = newTail;
            }

            tail.link = newTail;
            tail = newTail;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if (index == size && head == tail) //List is 1 or less
        {
                Node newNode = new Node(val, null);
                if (head == null)//List is empty
                {
                    head = newNode;
                    tail = head;
                } else
                {
                    Node oldHead = head;
                    head.link = newNode;
                    tail = newNode;
                }
            size++;
        } else if (index < size && index >= 0)
        {
            if (index == 0)
            {
                Node newNode = new Node(val, head);
                head = newNode;
            } else
            {
                Node current = head;

                for (int i = 0; i < index - 1 && current != null; i++)
                {
                    current = current.link;
                }

                if (current != null)
                {
                    Node newNode = new Node(val, current.link);
                    current.link = newNode;
                }
            }
            size++;
        } else if (index == size) //list not empty, index at end
        {
            Node newTail = new Node(val, null);
            tail.link = newTail;
            tail = newTail;
            size++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        Node current = head;
        Node beforeCurrent = current;

        if (index < size)
        {
            for (int i = 0; i < (index - 1) && current != null; i++)
            {
                beforeCurrent = current;
                current = current.link;
            }

            //At head
            if (index == 0 && current != null)
            {
                head = head.link;
                //Reset tail if node only has one value left
                if (head.link == null)
                {
                    tail = head;
                }
                size--;
            }
            else if (current != null && current.link != null && current.link.link != null)
            {
                current.link = current.link.link;
                size--;
            } else if (current != null) //Deleting last link
            {
                current.link = null;
                tail = current;
                size--;
            }
        }

    }

    public void printList()
    {
        Node current = head;
        while (current != null)
        {
            System.out.println(current.data);
            current = current.link;
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

        /*aList.addAtHead(1);
        aList.addAtHead(2);
        //int value = aList.get(0);
        aList.addAtIndex(0, 3);
        aList.addAtHead(55);
        aList.addAtTail(100);
        aList.addAtIndex(2, 99);*/

        /*aList.addAtHead(1);
        aList.addAtTail(3);
        aList.addAtIndex(1, 2);
        System.out.println(aList.get(1));
        aList.deleteAtIndex(1);
        System.out.println(aList.get(1));*/

        /*aList.get(0);
        aList.addAtIndex(1, 2);
        aList.get(0);
        aList.get(1);
        aList.addAtIndex(0, 1);
        aList.get(0);
        aList.get(1);
        //aList.printList();*/

        /*aList.addAtHead(8);
        aList.get(1);
        aList.addAtTail(81);
        aList.deleteAtIndex(2);
        aList.addAtHead(26);
        aList.deleteAtIndex(2);
        aList.get(1);
        aList.addAtTail(24);*/
        /*aList.addAtTail(5);
        aList.addAtTail(6);
        aList.addAtTail(10);
        aList.addAtHead(1);
        aList.addAtHead(2);
        aList.addAtHead(3);*/
        /*aList.addAtIndex(0, 100);
        aList.addAtHead(500);
        aList.addAtTail(900);
        aList.deleteAtIndex(0);
        aList.addAtIndex(2, 300);
        aList.printList();*/

        /*aList.addAtHead(38);
        aList.addAtHead(45);
        aList.deleteAtIndex(2);*/

        /*aList.addAtHead(1);
        aList.addAtIndex(1, 2);
        System.out.println(aList.get(1));
        System.out.println(aList.get(0));
        System.out.println(aList.get(2));*/

        aList.addAtHead(8);
        aList.get(1);
        aList.addAtTail(81);
        //aList.deleteAtIndex(2);
        aList.addAtHead(26);
        aList.deleteAtIndex(2);
        //aList.printList();
        aList.get(1);
        aList.addAtTail(24);
        System.out.println();
        //aList.printList();
        aList.addAtHead(15);
        aList.addAtTail(0);
        aList.addAtTail(13);
        aList.addAtTail(1);
        //aList.printList();
        aList.addAtIndex(6, 33);
        //System.out.println(aList.get(6));

        MyLinkedList listers = new MyLinkedList();

        listers.addAtHead(47);
        listers.get(1);
        listers.addAtHead(39);
        listers.get(1);
        listers.addAtIndex(2, 53);
        //listers.printList();
        System.out.println();

        listers.addAtIndex(2, 56);
        //System.out.println(listers.get(2));
        listers.addAtHead(0);

        MyLinkedList myLink = new MyLinkedList();

        myLink.addAtHead(41);
        myLink.addAtHead(5);
        myLink.addAtTail(37);
        myLink.addAtHead(88);
        myLink.addAtIndex(1, 83);
        myLink.addAtTail(9);
        myLink.get(1);
        myLink.deleteAtIndex(1);
        myLink.get(3);
        myLink.addAtTail(12);
        myLink.addAtTail(91);
        myLink.get(3);
        myLink.addAtTail(2);
        myLink.get(4);
        myLink.get(1);
        myLink.addAtIndex(5, 78);
        myLink.addAtTail(15);
        myLink.deleteAtIndex(1);
        myLink.addAtHead(35);
        myLink.deleteAtIndex(6);
        myLink.addAtTail(63);
        myLink.addAtHead(71);
        myLink.addAtHead(30);
        myLink.addAtHead(11);
        myLink.deleteAtIndex(10);
        myLink.addAtHead(49);
        myLink.get(5);
        myLink.addAtTail(16);
        myLink.addAtIndex(10, 36);
        myLink.addAtIndex(7, 91);
        myLink.addAtHead(12);
        myLink.addAtHead(56);
        myLink.addAtHead(22);
        myLink.deleteAtIndex(10);
        myLink.addAtHead(43);
        myLink.addAtTail(46);
        myLink.addAtTail(73);
        myLink.addAtIndex(20, 32);
        myLink.addAtTail(67);
        myLink.addAtTail(62);
        myLink.addAtHead(24);
        myLink.addAtTail(73);
        myLink.deleteAtIndex(3);
        myLink.addAtIndex(4, 66);
        myLink.addAtIndex(10, 5);
        myLink.addAtTail(72);
        myLink.deleteAtIndex(23);
        myLink.get(7);
        myLink.deleteAtIndex(3);
        myLink.addAtTail(11);
        myLink.deleteAtIndex(1);
        myLink.addAtTail(94);
        myLink.get(1);
        myLink.addAtIndex(15, 55);
        myLink.addAtTail(88);
        myLink.addAtTail(47);
        myLink.addAtIndex(20, 27);
        myLink.addAtIndex(14, 9);
        myLink.addAtHead(53);
        myLink.addAtHead(13);
        myLink.get(16);
        myLink.get(6);
        myLink.deleteAtIndex(27);
        myLink.deleteAtIndex(16);
        myLink.addAtHead(94);
        myLink.addAtHead(35);
        myLink.addAtIndex(34, 64);
        myLink.addAtTail(91);
        myLink.addAtTail(14);
        myLink.addAtHead(94);
        myLink.addAtHead(4);
        myLink.addAtHead(89);
        myLink.addAtHead(21);
        myLink.addAtTail(16);
        myLink.addAtTail(56);
        myLink.addAtHead(37);
        myLink.addAtHead(16);
        System.out.println(myLink.get(44));
        //System.out.println(myLink.get(42));
        //System.out.println("\n)");
        //myLink.printList();



        myLink.addAtHead(51);
        myLink.addAtHead(4);
        myLink.addAtHead(31);
        myLink.addAtIndex(18, 21);
        myLink.addAtTail(76);
        myLink.addAtTail(74);
        myLink.deleteAtIndex(2);
        myLink.addAtHead(23);
        myLink.addAtTail(65);
        myLink.addAtTail(73);
        myLink.addAtTail(37);
        myLink.addAtHead(14);

        /*["MyLinkedList","addAtHead","addAtHead","addAtTail","addAtHead","addAtIndex","addAtTail","get","deleteAtIndex","get",
        "addAtTail","addAtTail","get","addAtTail","get","get","addAtIndex","addAtTail","deleteAtIndex","addAtHead",
        "deleteAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","deleteAtIndex","addAtHead","//get","//addAtTail",
        "//addAtIndex","//addAtIndex","//addAtHead","//addAtHead","//addAtHead","//deleteAtIndex","//addAtHead","//addAtTail","//addAtTail",
        "//addAtIndex","//addAtTail","//addAtTail","//addAtHead","//addAtTail","//deleteAtIndex","//addAtIndex","//addAtIndex","//addAtTail",
        "//deleteAtIndex","//get","//deleteAtIndex","//addAtTail","//deleteAtIndex","//addAtTail","//get","//addAtIndex","//addAtTail","//addAtTail",
        "//addAtIndex","//addAtIndex","//addAtHead","//addAtHead","//get","//get","//deleteAtIndex","//deleteAtIndex","//addAtHead","//addAtHead",
        "//addAtIndex",
        "//addAtTail",
        "//addAtTail",
        "//addAtHead",
        "//addAtHead",
        "//addAtHead",
        "//addAtHead",
        "//addAtTail","
        //addAtTail","
        //addAtHead",
        "//addAtHead",
        "//get",
        "//addAtHead",
        "//addAtHead",
        "//addAtHead",
        "//addAtIndex",
        "//addAtTail",
        "//addAtTail",
        "//deleteAtIndex",
        "//addAtHead",
        "//addAtTail",
        "//addAtTail",
        "//addAtTail",
        "//addAtHead","addAtTail","addAtIndex","addAtHead","addAtTail","addAtIndex","addAtTail",
        "addAtHead","deleteAtIndex","addAtTail","addAtHead","get"]
        [[],[41],[5],[37],[88],[1,83],[9],[1],[1],[3],[12],[91],[3],[2],[4],[1],[5,78],[15],[1],[35],[6],[63],[71],[30],[11],[10],[49],
        [5],[//16],[//10,36],[//7,91],[//12],[//56],[//22],[//10],[//43],[//46],[//73],[//20,32],[//67],[//62],[//24],[//73],[//3],[//4,66],[//10,5],
        [//72],[//23],[//7],[//3],[//11],
        [//1],[//94],[//1],[//15,55],[//88],[//47],[//20,27],[//14,9],[//53],[//13],[//16],[//6],[//27],[//16],[//94],[//35],[//34,64],
        [//91],
        [//14],
        [//94],
        [//4],[//89],[//21],[//16],
        [//56],[//37],[//16],
        [//44],[//51],[//4],[//31],
        [//18,21],[//76],
        [//74],[//2],[//23],[//65],[//73],[//37],[//14],[73],[10,59],[7],[73],[28,8],[9],[53],[44],[18],[72],[7]]*/




        /*["MyLinkedList","addAtHead","get","addAtHead","get","addAtIndex","addAtIndex","addAtHead","get","addAtHead","addAtTail","addAtHead","get","deleteAtIndex","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtIndex","addAtHead","addAtTail","deleteAtIndex","deleteAtIndex","addAtTail","get","addAtTail","addAtHead","get","get","get","addAtTail","addAtIndex","addAtTail","addAtHead","addAtTail","addAtIndex","get","addAtTail","addAtHead","addAtIndex","addAtHead","addAtIndex","addAtTail","addAtIndex","addAtIndex","addAtTail","addAtTail","addAtHead","addAtTail","addAtTail","addAtTail","addAtHead","get","get","get","addAtHead","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtIndex","get","addAtHead","addAtTail","addAtHead","addAtHead","addAtTail","addAtTail","get","get","deleteAtIndex","get","addAtTail","addAtTail","addAtTail","deleteAtIndex","deleteAtIndex","addAtHead","addAtHead","deleteAtIndex","get","get","addAtHead","addAtTail","addAtTail","get","addAtTail","deleteAtIndex","addAtTail","deleteAtIndex","deleteAtIndex","addAtTail","get","addAtTail","addAtTail","deleteAtIndex","deleteAtIndex","addAtTail","addAtHead","get"]
[[],[47],[1],[39],[1],[2,53],[2,56],[0],[3],[2],[62],[58],[6],[3],[1],[0],[25],[68],[1,37],[94],[83],[5],[7],[47],[1],[3],[6],[7],[9],[5],[72],[3,32],[61],[95],[74],[5,56],[14],[57],[16],[17,10],[93],[11,87],[18],[17,83],[23,6],[67],[6],[53],[67],[80],[69],[59],[23],[34],[7],[64],[46],[76],[28],[23],[4],[58],[3,15],[5],[3],[86],[39],[2],[9],[89],[9],[44],[38],[33],[70],[16],[91],[43],[41],[52],[95],[14],[30],[8],[80],[7],[60],[5],[14],[9],[31],[4],[2],[34],[10],[36],[37],[40],[11],[97],[32],[33]]*/


        //aList.printList();

        /*["MyLinkedList","addAtHead","get","addAtTail","deleteAtIndex","addAtHead","deleteAtIndex","get","addAtTail","addAtHead","addAtTail","addAtTail","addAtTail","addAtIndex","get","addAtIndex","addAtHead","deleteAtIndex","addAtIndex","addAtHead","addAtIndex","deleteAtIndex","get","addAtTail","deleteAtIndex","deleteAtIndex","addAtTail","addAtTail","addAtIndex","addAtHead","get","get","addAtTail","addAtTail","addAtTail","addAtTail","addAtIndex","addAtIndex","addAtHead","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","addAtHead","deleteAtIndex","addAtHead","get","addAtHead","get","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtTail","deleteAtIndex","get","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtIndex","deleteAtIndex","deleteAtIndex","deleteAtIndex","addAtHead","addAtTail","addAtTail","addAtHead","addAtTail","addAtIndex","deleteAtIndex","deleteAtIndex","addAtIndex","addAtHead","addAtHead","addAtTail","get","addAtIndex","get","addAtHead","addAtHead","addAtHead","addAtIndex","addAtIndex","get","addAtHead","get","get","addAtTail","addAtHead","addAtHead","addAtTail","addAtTail","get","addAtTail"]
[[],[8],[1],[81],[2],[26],[2],[1],[24],[15],[0],[13],[1],[6,33],[6],[2,91],[82],[6],[4,11],[3],[7,14],[1],[6],[99],[11],[7],[5],[92],[7,92],[57],[2],[6],[39],[51],[3],[22],[5,26],[9,52],[69],[5,58],[79],[7],[41],[33],[88],[44],[8],[72],[93],[18],[1],[9],[46],[9],[92],[71],[69],[11,54],[27],[83],[12],[20],[19,97],[77],[36],[3],[35],[16,68],[22],[36],[17],[62],[89],[61],[6],[92],[28,69],[23],[28],[7,4],[0],[24],[52],[1],[23,3],[7],[6],[68],[79],[45,90],[41,52],[28],[25],[9],[32],[11],[90],[24],[98],[36],[34],[26]]*/


        /*["MyLinkedList","addAtHead","addAtHead","deleteAtIndex","addAtIndex","addAtTail","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","addAtTail","addAtTail","addAtHead","addAtTail","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtTail","addAtTail","get","addAtIndex","addAtHead","get","get","addAtHead","get","addAtIndex","addAtTail","addAtIndex","addAtHead","addAtHead","addAtHead","get","addAtHead","addAtIndex","addAtTail","addAtHead","addAtIndex","get","addAtTail","addAtTail","addAtIndex","addAtIndex","addAtHead","addAtHead","get","addAtTail","addAtIndex","addAtIndex","addAtHead","deleteAtIndex","addAtIndex","addAtHead","deleteAtIndex","addAtTail","deleteAtIndex","addAtTail","addAtHead","addAtTail","addAtTail","addAtHead","addAtTail","addAtIndex","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtTail","get","addAtIndex","addAtTail","addAtTail","addAtTail","deleteAtIndex","get","addAtHead","get","get","addAtTail","deleteAtIndex","addAtTail","addAtIndex","addAtHead","addAtIndex","addAtTail","get","addAtIndex","addAtIndex","addAtHead","addAtHead","get","get","get","addAtIndex","addAtHead","addAtIndex","addAtHead","addAtTail","addAtIndex","get"]
[[],[38],[45],[2],[1,24],[36],[3,72],[76],[7],[36],[34],[91],[69],[37],[38],[4],[66],[38],[14],[12],[32],[5],[7,5],[74],[7],[13],[11],[8],[10,9],[19],[3,76],[7],[37],[99],[10],[12],[1,20],[29],[42],[21,52],[11],[44],[47],[6,27],[31,85],[59],[57],[4],[99],[13,83],[10,34],[48],[9],[22,64],[69],[33],[5],[18],[87],[42],[1],[35],[31],[67],[36,46],[23],[64],[81],[29],[50],[23],[36,63],[8],[19],[98],[22],[28],[42],[24],[34],[32],[25],[53],[55,76],[38],[23,98],[27],[18],[44,27],[16,8],[70],[15],[9],[27],[59],[40,50],[15],[11,57],[80],[50],[23,37],[12]]*/

               /* ["MyLinkedList", "addAtHead", "get", "addAtTail", "deleteAtIndex", "addAtHead", "deleteAtIndex", "get", "addAtTail", "addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtIndex", "get", "addAtIndex", "addAtHead", "deleteAtIndex", "addAtIndex", "addAtHead", "addAtIndex", "deleteAtIndex", "get", "addAtTail", "deleteAtIndex", "deleteAtIndex", "addAtTail", "addAtTail", "addAtIndex", "addAtHead", "get", "get", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "addAtIndex", "addAtIndex", "addAtHead", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtHead", "addAtHead", "addAtHead", "addAtHead", "addAtTail", "addAtHead", "deleteAtIndex", "addAtHead", "get", "addAtHead", "get", "addAtHead", "addAtHead", "addAtHead", "addAtIndex", "deleteAtIndex", "addAtTail", "deleteAtIndex", "get", "addAtIndex", "addAtHead", "addAtTail", "deleteAtIndex", "addAtHead", "addAtIndex", "deleteAtIndex", "deleteAtIndex", "deleteAtIndex", "addAtHead", "addAtTail", "addAtTail", "addAtHead", "addAtTail", "addAtIndex", "deleteAtIndex", "deleteAtIndex", "addAtIndex", "addAtHead", "addAtHead", "addAtTail", "get", "addAtIndex", "get", "addAtHead", "addAtHead", "addAtHead", "addAtIndex", "addAtIndex", "get", "addAtHead", "get", "get", "addAtTail", "addAtHead", "addAtHead", "addAtTail", "addAtTail", "get", "addAtTail"]
[[],[8],[1],[81],[2],[26],[2],[1],[24],[15],[0],[13],[1],[6,33],[6],[2,91],[82],[6],[4,11],[3],[7,14],[1],[6],[99],[11],[7],[5],[92],[7,92],[57],[2],[6],[39],[51],[3],[22],[5,26],[9,52],[69],[5,58],[79],[7],[41],[33],[88],[44],[8],[72],[93],[18],[1],[9],[46],[9],[92],[71],[69],[11,54],[27],[83],[12],[20],[19,97],[77],[36],[3],[35],[16,68],[22],[36],[17],[62],[89],[61],[6],[92],[28,69],[23],[28],[7,4],[0],[24],[52],[1],[23,3],[7],[6],[68],[79],[45,90],[41,52],[28],[25],[9],[32],[11],[90],[24],[98],[36],[34],[26]]*/

    }
}

