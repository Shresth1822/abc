import java.util.Scanner;

public class MCM{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of matrices: ");
        int n = scanner.nextInt();
        int[] matrixDimensions = new int[n + 1];

        System.out.println("Enter the dimensions of each matrix:");
        for (int i = 0; i <= n; i++) {
            System.out.print("Dimension " + i + ": ");
            matrixDimensions[i] = scanner.nextInt();
        }

        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        matrixChainOrder(matrixDimensions, m, s);

        System.out.println("Minimum number of multiplications: " + m[1][n]);
        System.out.print("Optimal Parenthesization: ");
        printOptimalParenthesization(s, 1, n);

        scanner.close();
    }

    public static void matrixChainOrder(int[] p, int[][] m, int[][] s) {
        int n = p.length - 1;

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static void printOptimalParenthesization(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParenthesization(s, i, s[i][j]);
            printOptimalParenthesization(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
