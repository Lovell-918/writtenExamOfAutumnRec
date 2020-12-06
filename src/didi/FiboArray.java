package didi;

import java.util.Scanner;

public class FiboArray {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            if(n==1){
                System.out.println(1);
            }else {
                int n2 = n * n;
                long[] fb = new long[n2];
                fb[0] = 1;
                fb[1] = 1;
                for (int i = 2; i < n2; ++i) {
                    fb[i] = fb[i - 1] + fb[i - 2];
                }
                long[][] ans = new long[n][n];
                int t = 1;
                int up = 0, down = n - 1, left = 0, right = n - 1;
                while (t <= n2) {
                    for (int i = left; i <= right && t <= n2; ++i) {
                        ans[up][i] = fb[n2 - t];
                        t++;
                    }
                    up++;
                    for (int i = up; i <= down && t <= n2; ++i) {
                        ans[i][right] = fb[n2 - t];
                        t++;
                    }
                    right--;
                    for (int i = right; i >= left && t <= n2; --i) {
                        ans[down][i] = fb[n2 - t];
                        t++;
                    }
                    down--;
                    for (int i = down; i >= up && t <= n2; --i) {
                        ans[i][left] = fb[n2 - t];
                        t++;
                    }
                    left++;
                }
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n - 1; ++j) {
                        System.out.print(ans[i][j] + " ");
                    }
                    System.out.println(ans[i][n - 1]);
                }
            }
        }
        sc.close();
    }
}
