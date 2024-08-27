import java.util.Scanner;

public class QuickSort {
    // Function to partition the array and return the pivot index
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Function to perform QuickSort recursively
    static void quicksort(int arr[], int low, int high) {
        if (low < high) {
            // Find pivot such that elements on the left are smaller and on the right are larger
            int pivot = partition(arr, low, high);

            // Recursively sort the sub-arrays
            quicksort(arr, low, pivot - 1);
            quicksort(arr, pivot + 1, high);
        }
    }

    // Function to print an array
    static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Example usage with user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Original array: ");
        printArray(arr);

        quicksort(arr, 0, n - 1);

        System.out.print("Sorted array: ");
        printArray(arr);

        scanner.close();
    }
}
