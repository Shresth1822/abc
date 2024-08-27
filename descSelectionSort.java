import java.util.*;
public class descSelectionSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int i = 0;
        int j = 0;
        int t = 0;
        int max = 0;

        while (i < n) {
            max = i;
            j = i + 1;
            while (j < n) {
                if (a[j] > a[max])
                    max = j;
                j = j + 1;
            }
            t = a[i];
            a[i] = a[max];
            a[max] = t;
            i = i + 1;
        }
        System.out.println("Sorted Array in Descending Order:");
        i = 0;
        while (i < n) {
            System.out.print(a[i] + " ");
            i = i + 1;
        }
        sc.close();
    }
}
