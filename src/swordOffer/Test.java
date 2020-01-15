package swordOffer;

import java.util.ArrayList;

public class Test {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }else {
            while (pNode.next != null){
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode){
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }

    private static ArrayList<TreeLinkNode> list = new ArrayList<>();

    public TreeLinkNode GetNext1(TreeLinkNode pNode){
        TreeLinkNode node = pNode;
        while (node.next != null){
            node = node.next;
        }
        InOrder(node);
        for (int i = 0; i <list.size(); i++) {
            if (pNode == list.get(i)){
                if (i == list.size() - 1){
                    return null;
                }else {
                    return list.get(i + 1);
                }
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
