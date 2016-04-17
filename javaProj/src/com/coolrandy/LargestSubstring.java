package com.coolrandy;

import java.util.HashMap;
import java.util.Map;

/**
 * 分析代码可以知道空间复杂度为O(N),时间复杂度也是O(N)
 * 1、暴力枚举
 * 2、双指针、滑动窗口  动态维护窗口[]
 */

public class LargestSubstring {

    /**
     * LeetCode 3. Longest Substring Without Repeating Characters
     * Given a string, find the length of the longest substring without repeating characters.
     * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
     * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
     * @param str
     * @return
     */
    public static int lengthOfLongestSubString(String str){

        if(null == str || str.equals("")){
            return 0;
        }
        int start = 0;
        int result = 0;
        //采用hashmap数据结构来存储字符串中的字符以及相应的下标
        Map<Character, Integer> map = new HashMap<>(str.length());
        for (int i = 0; i < str.length(); i++){

            char ch = str.charAt(i);
            //判断如果这个字符存在，就重新标记start
            if(map.containsKey(ch) && map.get(ch) >= start){
                //如果map中包含该字符且该字符对应的下标大于start
                start = map.get(ch) + 1;
            }else {
                //否则，标记下当前非重复子串的最大长度
                result = Math.max(result, i - start + 1);
            }

            //将该字符存入到map中
            map.put(ch, i);
        }

        return result;
    }

    public static void main(String[] args) {

//        System.out.print("Hello World");
        String str = "abcabcbb";
        int res = lengthOfLongestSubString(str);
        System.out.println("Longest Substring Without Repeating Characters: ");
        System.out.println(res);
    }
}
