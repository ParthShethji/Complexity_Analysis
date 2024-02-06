import java.util.HashSet;
import java.util.Set;

public class Lab2 {

// 1.WAP that identifies and removes duplicates from an array of size n.

// 2.WAP to print sum of upper right triangular matrix 

// 3.WAP to print all even number from given matrix

// 4.WAP to print largest element from lower triangle of matrix

// 5.WAP to print left lower and right lower triangle of matrix of size n*n


    private static void duplicate(int[]arr){
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (!set.add(i)) {
                System.out.println("Duplicate number is " + i);
            }
        }
    }

    private static void upperSum(int[][] mat){
        int sum=0;
        int m = mat.length;
        int n = mat[0].length;
        if(m!=n){
            System.out.println("Its not a square matrix");
            return;
        }
        else{
            for(int i=0; i<m; i++){
                for (int j = 0; j < m; j++) {
                    if(j>i){
                        sum+=mat[i][j];
                    }
                }
            }
            System.out.println("The sum of Upper Triangle is: " + sum);
            return;
        }
    }

    private static void even(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
            for(int i=0; i<m; i++){
                for (int j = 0; j < n; j++) {
                    if(mat[i][j]%2==0){
                        System.out.print(mat[i][j] + "\t");
                    }
                }
        }
        System.out.println();
    }

    private static void maxLT(int[][]arr){
        int m = arr.length;
        int n = arr[0].length;
        int max = Integer.MIN_VALUE;
        if (m!=n) {
            System.out.println("Not a square trinagle");
            return;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if(j<i){
                    max = Math.max(max, arr[i][j]);
                }
            }
        }
        System.out.println("The largest element in Lower Triangle is: "+ max);
        return;
    }


    private static void LRlower(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] ll = new int[m][m];
        int[][] rl = new int[m][m];

        if (m!=n) {
            System.out.println("Not a square trinagle");
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ll[i][j] = 0;
                rl[i][j] = 0;
            }
        }
    
            // Left Lower Triangle
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (j < i) {
                    ll[i][j] = mat[i][j];
                }
            }
        }

    // Right Lower Triangle
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (j + i >= m) {
                    rl[i][j] = mat[i][j];
                }
            }
        }
        System.out.println("Lower Left Trinagle is \t");
        printMat(ll);
        System.out.println();
        System.out.println("Lower right Trinagle is \t");
        printMat(rl);
    }

    private static void printMat(int[][]mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+ "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 25, 36, 1, 4, 16, 8, 11};

         int[][] mat1 = {
            {2, 3, 4, 5},
            {5, 6, 7, 0}
        };
    
        int[][] mat2 = {
            {8, 9, 0},
            {10, 11, 5},
            {12, 13, 7},
            {8, 1, 5}
        };

        int[][]mat3 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };


        duplicate(arr);
        upperSum(mat3);
        even(mat1);
        maxLT(mat3);
        LRlower(mat3);
    }
}
