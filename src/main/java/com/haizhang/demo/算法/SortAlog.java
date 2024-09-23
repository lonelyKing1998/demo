package com.haizhang.demo.算法;

/**
 * 排序算法测试（冒泡，选择，插入）
 */
public class SortAlog {


    public static void 冒泡排序(int[] arr){
        //前面和后面依次比较，交换两个元素的位置，大的移到最后
        int size = arr.length;
        boolean hasSwap = false;
        for(int i=0;i<size-1;i++){
            for(int k=1;k<size-i;k++){
                if(arr[k-1]>arr[k]){
                    SortUtil.swap(arr, k-1, k);
                    hasSwap = true;
                }
            }
            if(!hasSwap){
                break;
            }
        }
        System.out.println("冒泡排序后的数组顺序为");
        SortUtil.printArr(arr);
    }

    //每次比较选择一个最小的放在数组前面
    public static void 选择排序(int[] arr){
        int minValue = Integer.MAX_VALUE;
        int minValueIndex = -1;
        for(int i=0;i<arr.length-1;i++){
            minValue = Integer.MAX_VALUE;
            minValueIndex = -1;
            for(int k=i;k<arr.length;k++){
                if(minValue>arr[k]){
                    minValue = arr[k];
                    minValueIndex = k;
                }
            }
            SortUtil.swap(arr, i, minValueIndex);
        }
        System.out.println("选择排序后的数组顺序为");
        SortUtil.printArr(arr);
    }


    /**
     * 先让0-1有序
     * 再让0-2有序
     * ....
     * 最后让0-N有序，整个数组就有序
     * @param arr
     */
    public static void 插入排序(int[] arr){
        //外侧循环是进行了多少轮
        for (int i = 0; i < arr.length-1; i++) {
            //内测循环则是比较
            for(int k=i+1; k>0&&arr[k]<arr[k-1];k--){
                SortUtil.swap(arr, k-1, k);
            }
        }
        System.out.println("插入排序后的数组顺序为");
        SortUtil.printArr(arr);
    }

    public static void main(String[] args) {
        插入排序(SortUtil.genRandomArr(100, 100));
    }

}
