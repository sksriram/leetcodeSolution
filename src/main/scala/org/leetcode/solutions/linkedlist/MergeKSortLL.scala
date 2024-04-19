package org.leetcode.solutions.linkedlist

object MergeKSortLL extends App {

  def mergeKLists(lists: Array[ListNode]): ListNode = {

      def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
      var dummy = new ListNode()
      var curr = dummy
      var p1 = l1
      var p2 = l2

      while (p1 != null && p2 != null) {
        if (p1.x < p2.x) {
          curr.next = p1
          p1 = p1.next
        } else {
          curr.next = p2
          p2 = p2.next
        }
        curr = curr.next
      }

      if (p1 != null) curr.next = p1
      if (p2 != null) curr.next = p2

      dummy.next
    }

    def mergeLists(left: Int, right: Int): ListNode = {
      if (left == right) return lists(left)
      if (left > right) return null

      val mid = left + (right - left) / 2
      val l1 = mergeLists(left, mid)
      val l2 = mergeLists(mid + 1, right)
      mergeTwoLists(l1, l2)
    }

    mergeLists(0, lists.length - 1)

  }

  val arr = Array(new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))))

  val merList = mergeKLists(arr)

  var ptr = merList

  while (ptr != null)
  {
    println(ptr.x)
    ptr = ptr.next
  }

}
