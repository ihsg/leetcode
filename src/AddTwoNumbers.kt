/*
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

from: https://leetcode.com/problems/add-two-numbers/
 */


class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

fun addTwoNumbersMine(l1: ListNode?, l2: ListNode?): ListNode? {
    var over = 0
    var list1 = l1
    var list2 = l2
    var head: ListNode? = null
    var p: ListNode? = null
    val def = ListNode(0)

    while (list1 != null || list2 != null) {
        if (list1 == null) {
            list1 = def
        }

        if (list2 == null) {
            list2 = def
        }

        val result = ListNode(0)

        result.`val` = list1.`val` + list2.`val` + over
        over = result.`val` / 10
        result.`val` = result.`val` % 10

        list1 = list1.next
        list2 = list2.next

        if (p == null) {
            head = result
        } else {
            p.next = result
        }
        p = result
    }

    if (over != 0 && p != null) {
        p.next = ListNode(over)
    }

    return head
}


fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var over = 0
    var p = l1
    var q = l2
    var head: ListNode? = null
    var cur: ListNode? = null
    var x1: Int
    var x2: Int
    var y: Int

    while (p != null || q != null) {
        x1 = p?.`val` ?: 0
        x2 = q?.`val` ?: 0


        y = x1 + x2 + over
        over = y / 10
        y %= 10

        val node = ListNode(y)

        if (cur == null) {
            head = node
        } else {
            cur.next = node
        }
        cur = node

        p = p?.next
        q = q?.next
    }

    if (over > 0) {
        cur?.next = ListNode(over)
    }

    return head
}
