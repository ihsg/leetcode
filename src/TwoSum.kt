/*
1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

from: https://leetcode.com/problems/two-sum/
*/

fun twoSumMine(nums: IntArray, target: Int): IntArray {
    var length = nums.size - 1
    for (i in 0 until length) {
        val delta = target - nums[i]
        for (j in (i + 1)..length) {
            if (delta == nums[j]) {
                return arrayOf(i, j).toIntArray()
            }
        }
    }
    return IntArray(0)
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val hashMap = HashMap<Int, Int>()
    val size = nums.size
    for (i in 0 until size) {
        val key = target - nums[i]
        if (hashMap.containsKey(key)) {
            return arrayOf(hashMap[key]!!, i).toIntArray()
        } else {
            hashMap[nums[i]] = i
        }
    }
    return IntArray(0)
}
