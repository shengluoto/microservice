package com.tck.leetcode;


class ListAddTwoNumbers {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int l1Value = 0;
		int l2Value = 0;
		int sum = 0;
		int remainderValue = 0;
		int carryValue = 0;
		while(null != p || null != q) {
			// 值相加，并带上进位
			l1Value = null==p ? 0 : p.val;
			l2Value = null==q ? 0 : q.val;
			sum = l1Value + l2Value + carryValue;
			// 当前计算值的个位
			remainderValue = sum%10;
			// 进位
			carryValue = sum >= 10 ? 1 : 0;

			curr.next = new ListNode(remainderValue);
			curr = curr.next;
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}
		if (carryValue > 0) {
			curr.next = new ListNode(carryValue);
		}
		return dummyHead.next;
	}

	public void test() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		this.addTwoNumbers(l1, l2);
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
}
