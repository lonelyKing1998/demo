package com.haizhang.demo.算法;

public class SortUtil {

    public static int[] genRandomArr(int maxSize,int maxValue){
        int size = (int)((maxSize+1)*Math.random());
        int[] arr = new int[size];
        for(int i =0 ;i<size ; i++){
            arr[i] = (int)((maxValue+1)*Math.random());
        }
        System.out.println("生成新数组，长度为："+size);
        printArr(arr);
        return arr;
    }

    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    
    /**
     * 交换两个数组位置的数值
     * @param arr
     * @param apos
     * @param bpos
     */
    public static void swap(int[] arr, int apos, int bpos ){
        int tmp = arr[apos]^arr[bpos];
        arr[apos]^= tmp;
        arr[bpos]^= tmp;
    }

    public static void main(String[] args) {
        printArr(genRandomArr(100, 100));
    }
}
