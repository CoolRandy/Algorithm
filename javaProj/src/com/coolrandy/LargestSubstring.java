package com.coolrandy;

import java.util.HashMap;
import java.util.Map;

/**
 * �����������֪���ռ临�Ӷ�ΪO(N),ʱ�临�Ӷ�Ҳ��O(N)
 * 1������ö��
 * 2��˫ָ�롢��������  ��̬ά������[]
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
        //����hashmap���ݽṹ���洢�ַ����е��ַ��Լ���Ӧ���±�
        Map<Character, Integer> map = new HashMap<>(str.length());
        for (int i = 0; i < str.length(); i++){

            char ch = str.charAt(i);
            //�ж��������ַ����ڣ������±��start
            if(map.containsKey(ch) && map.get(ch) >= start){
                //���map�а������ַ��Ҹ��ַ���Ӧ���±����start
                start = map.get(ch) + 1;
            }else {
                //���򣬱���µ�ǰ���ظ��Ӵ�����󳤶�
                result = Math.max(result, i - start + 1);
            }

            //�����ַ����뵽map��
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
