import java.util.ArrayList;
import java.util.Scanner;

public class MCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan banyak p : ");
        int n = sc.nextInt();
        int p[] = new int[n];
        System.out.println("Masukkan nilai p :");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        sc.close();
        System.out.println();
        ArrayList<int[][]> al = MatrixChainOrder(p);
        int m[][] = al.get(0);
        int s[][] = al.get(1);

        System.out.println("Tabel M");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i == 0 & j == 0)
                    System.out.print("   ");
                else if (j == 0)
                    System.out.printf(" %d ", i);
                else if (i == 0)
                    System.out.printf(" %6d  ", j);
                else
                    System.out.printf("[%6d] ", m[i][j]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Tabel S");
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                if (i == 0 & j == 0)
                    System.out.print("   ");
                else if (j == 0)
                    System.out.printf(" %d ", i);
                else if (i == 0)
                    System.out.printf(" %d  ", j);
                else
                    System.out.printf("[%d] ", s[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("Pekurungan optimal : ");
        printOptimalParentheses(1, p.length - 1, p.length, s);
        System.out.println();
        System.out.println("Nilai termurah     : " + m[1][p.length - 1]);
    }

    static char x = 'A';

    public static ArrayList<int[][]> MatrixChainOrder(int[] p) {
        ArrayList<int[][]> al = new ArrayList<>();
        int n = p.length - 1;
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        al.add(m);
        al.add(s);
        return al;
    }

    public static void printOptimalParentheses(int i, int j, int n, int[][] p) {

        if (i == j) {
            System.out.print(x++);
        } else {
            System.out.print("(");
            printOptimalParentheses(i, p[i][j], n, p);
            printOptimalParentheses(p[i][j] + 1, j, n, p);
            System.out.print(")");
        }
    }
}