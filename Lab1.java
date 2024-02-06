// Assignment based on simple coding on numbers, graphs and matrices

// Write a program to find the largest of 10 numbers using an array.
// Write a program to find the second largest element from a given array of size 10.
// Write a program to read 2 m x  n matrix and print multiplication of this 2 matrix.
// Write a program to print the sum of left diagonal elements. If i=j…add to sum of left diagonal
// Write a program to print lower triangle of n x n matrix

public class Lab1{

    public static int largest(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i:arr){
            if(max < i)    max=i;
        }
        return max;
    }


    public static int sl(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sl = Integer.MIN_VALUE;
        for(int i:arr){
            // System.out.print(i);
            if(max < i){
                sl=max;
                max=i;
            }    
            if(i>sl && i<max){
                sl = i;
            }
        }
        return sl;
    }

    public static void multiply(int [][] mat1, int [][] mat2){
        int m1 = mat1.length;
        int n1 = mat1[0].length;
        int m2 = mat2.length;
        int n2 = mat2[0].length;
        if(n1!=m2){
            System.out.println("cannot multiply");
            return;
        }
        for(int i=0; i<m1; i++){
            for (int j=0; j<n2; j++) {
                System.out.print(mat1[i][j] * mat2[i][j] + "\t");
            }
            System.out.println("");
        }
        return;
    }

    public static int leftSum(int [][] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(i==j)    sum+=arr[i][j];
            }
        }
        return sum;
    }

    public static void lower(int[][]arr){
        int m = arr.length;
        int n = arr[0].length;
        if (m!=n) {
            System.out.println("Not a square trinagle");
            return;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if(j<i){
                    System.out.print(arr[i][j]+ "\t");
                }
            }
            System.out.println("");
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 25, 36, 1, 4, 16, 8, 11};
        int max = largest(arr);
        System.out.println("Largest number in the array is: " + max);

        int sl = sl(arr);
        System.out.println("Second Largest number in the array is: " + sl);

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

        System.out.print("Matrix Multiplication Result:  ");
        multiply(mat1, mat3);

        System.out.println("Sum of left diagonal in the array is: " + leftSum(mat2));
        lower(mat3);
    }
}
