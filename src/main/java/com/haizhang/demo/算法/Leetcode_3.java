package com.haizhang.demo.算法;
import java.util.HashSet;
import java.util.Set;
/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串的长度。
 * 
 * 示例 1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Leetcode_3 {

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s ==""){
            return 0;
        }
        if(s.length() == 1){
            return 1 ;
        }
        char[] sarr = s.toCharArray();
        Set<Character> checkDup = new HashSet<>();
        int maxLen = 0 ;
        for(int i=0;i<sarr.length;){
            boolean flag = false;
            checkDup.clear();
            checkDup.add(sarr[i]);
            for(int k=i+1;k<sarr.length;k++){
                char cur = sarr[k];
                if(checkDup.contains(cur)){
                    if(k==sarr.length-1){
                        System.out.println(checkDup.size()>maxLen?checkDup.size():maxLen);
                        return  checkDup.size()>maxLen?checkDup.size():maxLen;
                    }
                    if(cur == sarr[k-1]){
                        i = k ;
                        flag = true ;
                    }
                    break;
                }
                checkDup.add(cur);
                if(k==sarr.length-1){
                    return checkDup.size()>maxLen?checkDup.size():maxLen;
                }
            }
            if(!flag){
                i++;
            }
            System.out.println(checkDup.size()>maxLen?checkDup.size():maxLen);
            maxLen = checkDup.size()>maxLen?checkDup.size():maxLen;
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        //滑动窗口
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();//去重
        int res = 0;//结果
        for(int left = 0, right = 0; right < s.length(); right++) {//每一轮右端点都扩一个。
            char ch = ss[right];//right指向的元素，也是当前要考虑的元素
            while(set.contains(ch)) {//set中有ch，则缩短左边界，同时从set集合出元素
                set.remove(ss[left]);
                left++;
            }
            set.add(ss[right]);//别忘。将当前元素加入。
            res = Math.max(res, right - left + 1);//计算当前不重复子串的长度。
        }
        return res;
    }
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("a");
        s.add("b");
        
    }

}
