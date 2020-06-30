import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * For your reference:
 */
class SinglyLinkedListNode {
	 int data;
	 SinglyLinkedListNode next;
	 
	 public SinglyLinkedListNode(int mData) {
		 data = mData;
		 next = null;
	 }
}
 

public class InsertNodeAtPosition {

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        if (position < 0) {
            return head;
        }

        SinglyLinkedListNode tempNode = new SinglyLinkedListNode(data);
        if (head == null) {
            return tempNode;
        }

        SinglyLinkedListNode curNode = head;
        int curPos = 0;

        // special case: add to front
        if (position == 0) {
            tempNode.next = curNode;
            head = tempNode;
            return head;
        }

        while (curNode.next != null) {
            if (curPos == position - 1) {
                break;
            }
            curPos++;
            curNode = curNode.next;
        }

        tempNode.next = curNode.next;
        curNode.next = tempNode;

        return head;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

        printSinglyLinkedList(llist_head, " ", bufferedWriter);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
