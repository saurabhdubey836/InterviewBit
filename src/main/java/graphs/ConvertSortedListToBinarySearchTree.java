package graphs;

/**
 * @author RakhmedovRS
 * @created 10-Mar-20
 */
public class ConvertSortedListToBinarySearchTree
{
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	class ListNode
	{
		public int val;
		public ListNode next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}

	private TreeNode convertListToBST(int left, int right, ListNode[] currentHead)
	{
		if (left > right)
		{
			return null;
		}

		int mid = (left + right) / 2;

		TreeNode leftNode = convertListToBST(left, mid - 1, currentHead);

		TreeNode node = new TreeNode(currentHead[0].val);
		node.left = leftNode;

		currentHead[0] = currentHead[0].next;

		node.right = convertListToBST(mid + 1, right, currentHead);
		return node;
	}

	public TreeNode sortedListToBST(ListNode head)
	{
		if (head == null)
		{
			return null;
		}

		ListNode temp = head;
		int size = 0;
		while (temp != null)
		{
			temp = temp.next;
			size++;
		}

		ListNode[] currentHead = new ListNode[]{head};
		return convertListToBST(0, size - 1, currentHead);
	}
}
