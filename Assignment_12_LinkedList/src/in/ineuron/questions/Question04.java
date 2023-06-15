package in.ineuron.questions;

public class Question04 {
	public String isPalindrome(ListNode head) {
		ListNode slow = head, fast = head, prev, temp;

		// Step I:: find middle
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// Middle = slow

		// Step II : Reverse second half
		prev = slow;
		slow = slow.next;
		prev.next = null;
		while (slow != null) {
			temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}

		// Step III: chech palindrome or not by keeping two pointers at start node and
		// at start of second half
		fast = head;
		slow = prev;
		while (slow != null) {
			if (fast.val != slow.val)
				return "No";
			fast = fast.next;
			slow = slow.next;
		}
		return "Yes";

	}
}
