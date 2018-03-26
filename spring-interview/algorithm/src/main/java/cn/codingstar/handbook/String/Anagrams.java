package cn.codingstar.handbook.String;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Anagrams.java
 * @time: 18-3-26 下午9:03
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: Two Strings Are Anagrams
 * Tags: String, Cracking The Coding Interview, Easy
 * Question
 * lintcode: Two Strings Are Anagrams
 * Problem Statement
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 * Clarification
 * What is Anagram?
 * - Two strings are anagram if they can be the same after change the order of characters.
 * Example
 * Given s = "abcd" , t = "dcab" , return true .
 * Given s = "ab" , t = "ab" , return true .
 * Given s = "ab" , t = "ac" , return false .
 * Challenge **
 * O(n) time, O(1) extra space
 */
public class Anagrams {

    /**
     * 比较两个字符串是否护卫anagrams
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean anagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            map[t.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "adbc";
        String str2 = "abc9";
        System.out.println(anagram(str1,str2));
    }
}
