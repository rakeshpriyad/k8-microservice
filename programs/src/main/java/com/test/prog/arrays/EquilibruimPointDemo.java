package com.test.prog.arrays;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.IntStream;

public class EquilibruimPointDemo {
    static MyEquuibiliriumFun<AtomicInteger,AtomicInteger,AtomicInteger,AtomicInteger,Integer, Integer> f=(sLeft,sRight,end, index, arr, data)-> {
        sLeft.getAndAdd(data);
        sRight.getAndAdd(arr[end.getAndDecrement()]);
        index.incrementAndGet();
        if((sLeft.get()== sRight.get())) {
            System.out.println("Equilibrium point J8 ="+index + " with value: "+ arr[index.get()]);
            return true;
        }
        return false;
    };
    public static void main(String[] args) {
        int[] ar = new int[]{1, 3, 5, 2, 2};
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        findEquilibruimPointJ6(arr);
        findEquilibruimPointJ8(arr);
        findEquilibruimPointJ6(ar);
        findEquilibruimPointJ8(ar);
    }

    public static void findEquilibruimPointJ6(int ar[]) {
        int start = 0;
        int end = ar.length - 1;
        int sumEnd = 0;
        int sumStart = 0;
        int index = 0;
        do {
            index++;
            sumStart += ar[start++];
            sumEnd += ar[end--];
        } while (!(sumStart == sumEnd));

        System.out.println("Equilibrium point is =" + index + " with value: " + ar[index]);
    }

    public static void findEquilibruimPointJ8(int arr[]) {
        AtomicInteger sumStart = new AtomicInteger(0);
        AtomicInteger sumEnd = new AtomicInteger(0);
        AtomicInteger end = new AtomicInteger(arr.length - 1);
        AtomicInteger index = new AtomicInteger(0);
        IntStream is = Arrays.stream(arr);
        is.anyMatch(data -> f.isEquibilirium(sumStart, sumEnd, end, index,arr, data));
    }
}
