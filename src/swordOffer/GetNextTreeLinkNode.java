package swordOffer;


import java.util.ArrayList;

/**
 * 既然给了二叉树的某个结点，且二叉树存储着指向父结点的指针（next），那我们可以先找到根节点，再对树进行中序遍历，最后根据中序遍历结果找到给定结点的下一结点
 */
public class GetNextTreeLinkNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }


    private static ArrayList<TreeLinkNode> list = new ArrayList<>();

    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
        TreeLinkNode node = pNode;
        while (node.next != null){
            node = node.next;
        }
        InOrder(node);
        for (int i = 0; i < list.size(); i++) {
            if (pNode == list.get(i)){
                return i == list.size()-1?null:list.get(i + 1);
            }
        }
        return null;
    }

    private void InOrder(TreeLinkNode node) {
        if (node != null){
            InOrder(node.left);
            list.add(node);
            InOrder(node.right);
        }
    }

}


class TreeLinkNode {

    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}