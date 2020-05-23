package com.test.prog.arrays;

import java.util.ArrayList;

/**
 * https://www.geeksforgeeks.org/number-subarrays-product-less-k/
 */
// Java program to count subarrays
// having product less than k. 
public class CountSubArray {
    /**
     * We can optimized approach is based on sliding window technique (Not that we need to find contiguous parts)
     *
     * Firstly, according to the description, all elements in the array are strictly positive. Also let’s assume that the product of all array elements always fits in 64-bit integer type. Taking these two points into consideration, we are able to multiply and divide array’s elements safety (no division by zero, no overflows).
     *
     * Let’s see how to count the desired amount. Assume, we have a window between start and end, and the product of all elements of it is p < k. Now, let's try to add a new element x. There are two possible cases.
     *
     * Case 1. p*x < k
     * This means we can move the window’s right bound one step further. How many contiguous arrays does this step produce? It is: 1 + (end-start).
     *
     * Indeed, the element itself comprises an array, and also we can add x to all contiguous arrays which have right border at end. There are as many such arrays as the length of the window.
     *
     * Case 2. p*x >= k
     *
     * This means we must first adjust the window’s left border so that the product is again less than k. After that, we can apply the formula from Case 1.
     *
     * Example :
     *
     *
     *
     *
     *   a = [5, 3, 2]
     *   k = 16
     *
     *   counter = 0
     *   Window: [5]
     *   Product: 5
     *
     *   5  counter += 1+ (0-0)
     *   counter = 1
     *   Window: [5,3]
     *   Product: 15
     *
     *   15  counter += 1 + (1-0)
     *   counter = 3
     *   Window: [5,3,2]
     *   Product: 30
     *
     *   30 > 16 --> Adjust the left border
     *   New Window: [3,2]
     *   New Product: 6
     *
     *   6  counter += 1 + (2-1)
     *   counter = 5
     *   Answer: 5
     * @param a
     * @param k
     * @return
     */
    static int countSubArrayProductLessThanK(int [] a,  long k) {
        int n = a.length;
        long p = 1;
        int res = 0;
        for (int start = 0, end = 0; end < n; end++) {

            // Move right bound by 1 step.
            // Update the product.
            p *= a[end];

            // Move left bound so guarantee that
            // p is again less than k.
            while (start < end && p >= k) {
                p /= a[start++];
            }

            // If p is less than k, update the counter.
            // Note that this is working even for
            // (start == end): it means that the
            // previous window cannot grow anymore
            // and a single array element is the only
            // addendum.
            if (p < k) {
                int counter = 1+ end - start;
                res += counter;
            }
        }

        return res;
    }

    /**
     * Simple approach
     * @param array
     * @param n
     * @param k
     * @return
     */
    static int countsubarray(int array[],
                             int n, int k) {
        int count = 0;
        int i, j, mul;

        for (i = 0; i < n; i++) {

            // Counter for single element
            if (array[i] <= k)
                count++;

            mul = array[i];

            for (j = i + 1; j < n; j++) {

                // Multiple subarray
                mul = mul * array[j];

                // If this multiple is less
                // than k, then increment
                if (mul <= k)
                    count++;
                else
                    break;
            }
        }

        return count;
    }

    // Driver Code
    public static void main(String args[]) {
        int array[] = {1, 2, 3, 4};
        int k = 10;
        int size = array.length;
        /**
         * Simple approach
         */
        int count = countsubarray(array, size, k);
        System.out.println(count);

        /**
         * Approach
         */
        count = countSubArrayProductLessThanK(array, k);
        System.out.println(count);
    }
}

// This code is contributed by Sam007 
