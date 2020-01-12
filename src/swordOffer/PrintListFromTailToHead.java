package swordOffer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
  @author zyan
  @version 1.0
  @date 20-1-6 下午4:32
 */


 class ListNode {

    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList list = new ArrayList();
        if (listNode == null){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode !=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

    public ArrayList printListFromTailToHead1(ListNode listNode) {
        ArrayList list = new ArrayList();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(0, i);
        }
        System.out.println(list);
    }
}
