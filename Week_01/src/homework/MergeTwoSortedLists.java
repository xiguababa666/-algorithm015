package homework;

/**
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

  

 示例：

 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4

 *
 * */

public class MergeTwoSortedLists {

    // 遍历
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode m = l1, n = l2;

        while (m != null) {
            ListNode s = m, b = n;
            if (m.val > n.val) {
                s = n;
                b = m;
            }
            ListNode insertPoint = findSmall(s, b);
            m = insertPoint.next;
            n = b;
            insertPoint.next = b;
        }

        return l1.val <= l2.val ? l1 : l2;
    }


    private static ListNode findSmall(ListNode s, ListNode b) {

        ListNode tmp = s;
        while ((s = s.next) != null) {
            if (s.val <= b.val) {
                tmp = s;
            } else {
                break;
            }
        }
        return tmp;

    }



    // 递归
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;


        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }

    }




    public static void main(String[] args) {


        ListNode l1 = ListNode.create(new int[] {1,1,3,4});
        System.out.println(l1);
        ListNode l2 = ListNode.create(new int[] {1,2,2,5,6});
        System.out.println(l2);

        ListNode l3 = mergeTwoLists2(l1,l2);
        System.out.println(l3);

    }

}
