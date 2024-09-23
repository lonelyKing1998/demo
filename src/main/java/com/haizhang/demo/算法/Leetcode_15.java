package com.haizhang.demo.算法;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
 */
public class Leetcode_15 {
    /*
     * 暴力破解
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if(nums.length<=2){
            return rs;
        }
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int k=0;k<nums.length;k++){
                if(k==i){continue;}
                
                for(int j=0;j<nums.length;j++){
                    if(k==j || i== j){
                        continue;
                    }
                    if(nums[i]+nums[k]+nums[j] == 0){
                        int[] tmp = {nums[i],nums[k],nums[j]};
                        Arrays.sort(tmp);
                        String str= tmp[0]+"-"+tmp[1]+"-"+tmp[2];
                        if(set.contains(str)){
                            continue;
                        }
                        set.add(str);
                        List<Integer> r = new ArrayList<>();
                        r.add(nums[i]);
                        r.add(nums[k]);
                        r.add(nums[j]);
                        rs.add(r);
                    }

                }
            }

        }
        return rs;

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1] ) {
                continue;
            }
            if( nums[first]>0){
                return ans;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            //target为什加负号，主要是因为nums排序了，把负数提到了数组前。
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }




    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> rs =  threeSum(nums);
        for(List<Integer> r : rs){
            System.out.println(r.get(0)+","+r.get(1)+","+r.get(2));
        }
    }


}
