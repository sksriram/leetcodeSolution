package org.leetcode.solutions


 // Definition for singly-linked list.
   class ListNode(_x: Int = 0, _next: ListNode = null) {
     var next: ListNode = _next
     var x: Int = _x
  }



object AddTwoNumbers extends App {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

    def addHelper(node1: ListNode, node2: ListNode, carry: Int): ListNode = {
      if (node1 == null && node2 == null && carry == 0) {
        null
      } else {
        val value1 = if (node1 != null) node1.x else 0
        val value2 = if (node2 != null) node2.x else 0
        val sum = value1 + value2 + carry
        val newNode = new ListNode(sum % 10)

        newNode.next = addHelper(if (node1 != null) node1.next else null, if (node2 != null) node2.next else null, sum / 10)
        newNode
      }
    }

    addHelper(l1, l2, 0)
  }
  val list1 = new ListNode(2, new ListNode(4, new ListNode(3)))
  val list2 = new ListNode(5, new ListNode(6, new ListNode(4)))



  val addList = addTwoNumbers(list1, list2)

  var ptr = addList

  while (ptr != null)
  {
    println(ptr.x)
    ptr = ptr.next
  }

}
