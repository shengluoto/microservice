package com.example.demo;


import org.junit.Test;

class ListAddTest {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		int times = 0;
		int l1Value = 0;
		int l2Value = 0;
		int tempValue = 0;
		int remainderValue = 0;
		int carryValue = 0;
		while(null != l1 || null != l2 || carryValue !=0) {
			// 值相加，并带上进位
			l1Value = null==l1 ? 0 : l1.val;
			l2Value = null==l2 ? 0 : l2.val;
			tempValue = l1Value + l2Value + carryValue;
			// 当前计算值的个位
			remainderValue = tempValue%10;
			// 进位
			carryValue = tempValue >= 10 ? 1 : 0;

			if (times==0) {
				result = new ListNode(remainderValue);
                last = result;
            } else {
                this.add(remainderValue);
			}
			if (null == l1 && null == l2) {
				break;
			}
            times++;
			l1 = l1.next;
			l2 = l2.next;
		}
		return result;
	}

	private ListNode last;

	private void add(int value) {
	    ListNode current = last;
	    ListNode newNode = new ListNode(value);
        current.next = newNode;
    }

	@Test
	public void test() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		this.addTwoNumbers(l1, l2);
	}
}
