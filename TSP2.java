import java.util.*;

public class TSP2{
    static final int MAX_VILLAGES = 10;
    static final int INF = 999;

    static int[][] ary = new int[MAX_VILLAGES][MAX_VILLAGES];
    static int[] completed = new int[MAX_VILLAGES];
    static int n, cost = 0;

    public static void takeInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of villages: ");
        n = scanner.nextInt();

        System.out.println("\nEnter the Cost Matrix");
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter elements of Row %d:\n", i + 1);
            for (int j = 0; j < n; j++)
                ary[i][j] = scanner.nextInt();

            completed[i] = 0;
        }

        System.out.println("\n\nThe cost matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(ary[i][j] + "\t");
            System.out.println();
        }

        scanner.close();
    }

    public static int least(int c) {
        int min = INF;
        int kmin = -1;

        for (int i = 0; i < n; i++) {
            if (ary[c][i] != 0 && completed[i] == 0 && ary[c][i] < min) {
                min = ary[c][i];
                kmin = i;
            }
        }

        if (min != INF)
            cost += min;

        return kmin;
    }

    public static void mincost(int city) {
        int ncity;

        completed[city] = 1;
        System.out.print((city + 1) + "--->");

        ncity = least(city);

        if (ncity == -1) {
            ncity = 0;
            System.out.print((ncity + 1));
            cost += ary[city][ncity];
            return;
        }

        mincost(ncity);
    }

    public static void main(String[] args) {
        takeInput();

        System.out.println("\n\nThe Path is:");
        mincost(0); // Start from city 0

        System.out.println("\n\nMinimum cost is " + cost);
    }
}
