package com.test.prog.arrays;

/**
 * Rearrange an array so that arr[i] becomes arr[arr[i]] with O(1) extra space
 * Given an array arr[] of size n where every element is in range from 0 to n-1. Rearrange the given array so that arr[i] becomes arr[arr[i]]. This should be done with O(1) extra space.
 *
 * Examples:
 *
 * Input: arr[]  = {3, 2, 0, 1}
 * Output: arr[] = {1, 0, 3, 2}
 * Explanation:
 * In the given array
 * arr[arr[0]] is 1 so arr[0] in output array is 1
 * arr[arr[1]] is 0 so arr[1] in output array is 0
 * arr[arr[2]] is 3 so arr[2] in output array is 3
 * arr[arr[3]] is 2 so arr[3] in output array is 2
 *
 * Input: arr[] = {4, 0, 2, 1, 3}
 * Output: arr[] = {3, 4, 2, 0, 1}
 * Explanation:
 * arr[arr[0]] is 3 so arr[0] in output array is 3
 * arr[arr[1]] is 4 so arr[1] in output array is 4
 * arr[arr[2]] is 2 so arr[2] in output array is 2
 * arr[arr[3]] is 0 so arr[3] in output array is 0
 * arr[arr[4]] is 1 so arr[4] in output array is 1
 *
 * Input: arr[] = {0, 1, 2, 3}
 * Output: arr[] = {0, 1, 2, 3}
 * Explanation:
 * arr[arr[0]] is 0 so arr[0] in output array is 0
 * arr[arr[1]] is 1 so arr[1] in output array is 1
 * arr[arr[2]] is 2 so arr[2] in output array is 2
 * arr[arr[3]] is 3 so arr[3] in output array is 3
 *
 *
 * How this can be achieved?
 * Let’s assume an element is a and another element is b, both the elements are less than n. So if an element a is incremented by b*n. So the element becomes a + b*n so when a + b*n is divided by n then the value is b and a + b*n % n is a.
 *
 * Algorithm:
 *
 * Traverse the array from start to end.
 * For every index increment the element by array[array[index] % n]. To get the ith element find the modulo with n, i.e array[index]%n.
 * Again Travsese the array from start to end
 * Print the ith element after dividing the ith element by n, i.e. array[i]/n.
 */
public class RearrangeArray {
    // The function to rearrange an array in-place so that arr[i]
    // becomes arr[arr[i]].
    void rearrange(int arr[], int n) {
        // First step: Increase all values by (arr[arr[i]]%n)*n
        for (int i = 0; i < n; i++)
            arr[i] += (arr[arr[i]] % n) * n;

        // Second Step: Divide all values by n
        for (int i = 0; i < n; i++)
            arr[i] /= n;
    }

    // A utility function to print an array of size n
    void printArr(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        RearrangeArray rearrange = new RearrangeArray();
        int arr[] = {3, 2, 0, 1};
        int n = arr.length;

        System.out.println("Given Array is :");
        rearrange.printArr(arr, n);

        rearrange.rearrange(arr, n);

        System.out.println("Modified Array is :");
        rearrange.printArr(arr, n);
    }
}

// This code has been contributed by Mayank Jaiswal 
