/*
（1）sc.nextLine() 可以获得一行的输入，其形式为 字符串，然后可以 split(" ") 对其进行分割
（2）既然是链表，就先定义链表的结点，然后生成链表
*/


import java.util.*;
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
public class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ListNode list1 = createList(sc.nextLine().split(" "));   // 解析输入的每一行
        ListNode list2 = createList(sc.nextLine().split(" "));
        ListNode list = combineList(list1,list2);
        while(list != null){    // 输出结果
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
    public static ListNode createList(String[] str){    // 生成链表结点
        if(str == null || str.length == 0)
            return null;
        ListNode pre = new ListNode(0);
        ListNode list = pre;
        for(int i = 0; i < str.length; i ++) {
            list.next = new ListNode(Integer.parseInt(str[i]));
            list = list.next;
        }
        return pre.next;
    }
    public static ListNode combineList(ListNode list1, ListNode list2){  // 合并链表结点
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode pre = new ListNode(0);
        ListNode list = pre;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                list.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            else {
                list.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            list = list.next;
            if(list1 == null) list.next = list2;
            if(list2 == null) list.next = list1;
        }
        return pre.next;
    }
}
