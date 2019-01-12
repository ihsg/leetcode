/*
3. Longest Substring Without Repeating Characters

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

from: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

fun lengthOfLongestSubstringMine(s: String): Int {
    val total = s.length
    val map = HashMap<Char, Int>()
    val longestMap = HashMap<Char, Int>()
    var length = 0
    for (i in 0 until total) {
        map[s[i]] = ++length
        for (j in i + 1 until total) {
            val c = s[j]
            if (map.containsKey(c)) {
                break
            } else {
                map[c] = ++length
            }
        }

        if (longestMap.size < length) {
            longestMap.clear()
            longestMap.putAll(map)
        }

        map.clear()
        length = 0
    }

    return longestMap.size
}

fun lengthOfLongestSubstringOptimized1(s: String): Int {
    val total = s.length
    val set = HashSet<Char>()
    var i = 0
    var j = 0
    var max = 0
    while (j < total) {
        val c = s[j]
        if (set.contains(c)) {
            set.remove(s[i])
            ++i
        } else {
            set.add(c)
            ++j
        }
        max = Math.max(max, (j - i))
    }
    return max
}


fun lengthOfLongestSubstringOptimized2(s: String): Int {
    val total = s.length
    val map = HashMap<Char, Int>()
    var i = 0
    var j = 0
    var max = 0
    while (j < total) {
        val c = s[j]
        if (map.containsKey(c)) {
            i = maxOf(map[c]!!, i) //abcddc
        }
        map[c] = ++j
        max = maxOf(max, j - i)
    }
    return max
}
