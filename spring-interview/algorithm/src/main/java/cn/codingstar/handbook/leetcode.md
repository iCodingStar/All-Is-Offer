## leetcode & lintcode刷题笔记

### String

#### [Implement strStr()](https://leetcode.com/problems/implement-strstr/description/)

##### Question
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

* Example1

Input: haystack = "hello", needle = "ll"

Output: 2

* Example 2:

Input: haystack = "aaaaa", needle = "bba"

Output: -1
##### 思路

对于字符串查找问题，可使用双重 for 循环解决，效率更高的则为 KMP 算法。双重 for 循环的使用较有讲
究，因为这里需要考虑目标字符串比源字符串短的可能。对目标字符串的循环肯定是必要的，所以可以优
化的地方就在于如何访问源字符串了。简单直观的解法是利用源字符串的长度作为 for 循环的截止索引，这
种方法需要处理源字符串中剩余长度不足以匹配目标字符串的情况，而更为高效的方案则为仅遍历源字符
串中有可能和目标字符串匹配的部分索引。

##### code
```java
public class ImplementStrStr {

    /**
     * 粗暴的字符串匹配算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    private static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        // 外层循环一定要注意前一个字符串剩余的长度至少为子串的长度
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // 从前一个字符串位置i开始比较
            int j = 0;
            for (; j < needle.length(); j++) {
                // 如果检测到不一致，退出此轮比较，开始下一轮
                if ((haystack.charAt(i + j) != needle.charAt(j))) {
                    break;
                }
            }
            // 比较结束之后，检查子串是否到了最后，循环结束的时候，j已经到了needle.length()
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "aaaa";
        System.out.println(strStr(str1, str2));
    }
}

```
##### 代码分析
1. 边界检查： haystack(source) 和 needle(target) 有可能是空串。
2. 边界检查之下标溢出：注意变量 i 的循环判断条件，如果用的是 i < source.length() 则在后面
的 source.charAt(i + j) 时有可能溢出。
3. 代码风格：
运算符 == 两边应加空格
变量名不要起 s1``s2 这类，要有意义，如 target``source
Java 代码的大括号一般在同一行右边，C++ 代码的大括号一般另起一行
int i, j;`声明前有一行空格，是好的代码风格
4. 是否在for的条件中声明 i , j ，这个视情况而定，如果需要在循环外再使用时，则须在外部初始化，
否则没有这个必要。
需要注意的是有些题目要求并
##### 复杂度分析

双重 for 循环，时间复杂度最坏情况下为 O((n − m) ∗ m).

