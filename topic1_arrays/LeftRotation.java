import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] leftRotation(int[] a, int d) {
        if (a == null || a.length == 0 || d == 0 || d < 0) {
            return a;
        }

        int rotation = d % a.length;
        reverse(a, 0, a.length-1);
        reverse(a, 0, a.length-1-rotation);
        reverse(a, a.length-rotation, a.length-1);

        return a;
    }

    static void reverse(int[] a, int start, int end) {
        if (start > a.length - 1 || end > a.length - 1 || start > end || start == end) {
            return;
        }
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
     }
    
    static int[] leftRotationExactly(int[] a, int d) {
        // They say in requirements that these inputs should not be considered.
        // However, noting that we should prevent against those.
        if (d == 0 || a.length == 0) {
            return a;
        }

        int rotation = d % a.length;
        if (rotation == 0) return a;

        // Please note that there is an implementation, circular arrays that could be considered here,
        // but that one has an edge case (Test#1)
        // As, we don't need to optimize for memory, let's keep it simple.
        int [] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {
//            b[i] = a[indexHelper(i + rotation, a.length)];
        	// rotate without the helper method 
            b[i] = a[(i+rotation) % a.length ];
        }
        return b;
    }

    /**
    * Takes care of the case where the rotation index. You have to take into account
    * how it is rotated towards the left. To compute index of B, we rotate towards the right.
    * If we were to do a[i] in the loop, then these method would need to be slightly chnaged
    * to compute index of b.
    */
    private static int indexHelper(int index, int length) {
        if (index >= length) {
            return index - length;
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
