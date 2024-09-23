package com.haizhang.demo.算法;

public class FindNumber {

    /**
     * 给定两个数出现奇数次的数组，找到他们两个数
     */
    public static void findNumbers(int[] arr){
        int eor = 0 ;
        //eor最后装的是a^b 也就是两个奇数次的抑或值
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //找到eor最右位非零二进制位，以此做分组
        int pos = eor & (~eor+1);
        int eor2 = 0;
        for(int cur : arr){
            //这一步等于0或者1都可以
            if((cur^pos)==0){
                eor2^=cur;
            }
        }
        //eor2装的就是a or b 
        int a = eor^eor2;
        int b = a^eor;
        System.out.printf("%d,%d",a,b);
        
    }

    public static void main(String[] args) {
        int[] arr = {1,1,4,5,6,5,6,4,3,4,3,8};
        findNumbers(arr);
    }
}
