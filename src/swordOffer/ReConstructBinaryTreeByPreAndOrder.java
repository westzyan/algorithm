package swordOffer;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ReConstructBinaryTreeByPreAndOrder {


//    // 缓存中序遍历数组每个值对应的索引
//    private Map<Integer, Integer> indexForInOrders = new HashMap<>();
//
//    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        for (int i = 0; i < in.length; i++)
//            indexForInOrders.put(in[i], i);
//        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
//    }
//
//    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
//        if (preL > preR)
//            return null;
//        TreeNode root = new TreeNode(pre[preL]);
//        int inIndex = indexForInOrders.get(root.val);
//        int leftTreeSize = inIndex - inL;
//        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
//        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
//        return root;
//    }


/*    // 主函数，用于测试结果
    public static void main(String[] args) {
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
        TreeNode tree = reConstructBinaryTree(pre, in);
        System.out.print("先序遍历结果: ");
        preTraverseBinTree(tree);
        System.out.println();
        System.out.print("中序遍历结果: ");
        inTraverseBinTree(tree);
        System.out.println();
        System.out.print("后序遍历结果: ");
        postTraverseBinTree(tree);
        System.out.println();
    }*/

/*    // 主功能函数
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        TreeNode tn = reConstructBinaryTreeCore(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return tn;
    }

    // 核心递归
    public static TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart,
                                                     int inEnd) {
        TreeNode tree = new TreeNode(pre[preStart]);
        tree.left = null;
        tree.right = null;
        if (preStart == preEnd && inStart == inEnd) {
            return tree;
        }
        int root = 0;
        for (root = inStart; root < inEnd; root++) {
            if (pre[preStart] == in[root]) {
                break;
            }
        }
        int leifLength = root - inStart;
        int rightLength = inEnd - root;
        if (leifLength > 0) {
            tree.left = reConstructBinaryTreeCore(pre, in, preStart + 1, preStart + leifLength, inStart, root - 1);
        }
        if (rightLength > 0) {
            tree.right = reConstructBinaryTreeCore(pre, in, preStart + 1 + leifLength, preEnd, root + 1, inEnd);
        }
        return tree;
    }*/

    // 将二叉树先序遍历，用于测试结果
    public static void preTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        if (node.left != null) {
            preTraverseBinTree(node.left);
        }
        if (node.right != null) {
            preTraverseBinTree(node.right);
        }
    }

    // 将二叉树中序遍历，用于测试结果
    public static void inTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inTraverseBinTree(node.left);
        }
        System.out.print(node.val + " ");
        if (node.right != null) {
            inTraverseBinTree(node.right);
        }
    }

    // 将二叉树后序遍历，用于测试结果
    public static void postTraverseBinTree(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postTraverseBinTree(node.left);
        }
        if (node.right != null) {
            postTraverseBinTree(node.right);
        }
        System.out.print(node.val + " ");
    }


//    //前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
//    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//
//        int len = pre.length;
//
//        TreeNode root = new TreeNode(pre[0]);
//        //说明只剩下一个了，表示叶子节点,递归可以退出了
//        if (pre.length == 1) {
//            root.left = null;
//            root.right = null;
//            return root;
//        }
//
//        //中间值 在{4,7,2,1,5,3,8,6} 这个中间值第一次应该是3
//        int flag = 0;
//        for (int i = 0; i < len; i++) {
//            //在中序中找到
//            if (pre[0] == in[i]) {
//                flag = i;
//                break;
//            }
//        }
//        if (flag > 0) {
//            //左子树的先序
//            int[] leftPre = new int[flag];
//            //左子树的中序
//            int[] leftIn = new int[flag];
//            for (int j = 0; j < flag; j++) {
//                leftPre[j] = pre[j + 1];
//            }
//            for (int j = 0; j < flag; j++) {
//                leftIn[j] = in[j];
//            }
//            //左子树递归
//            root.left = reConstructBinaryTree(leftPre, leftIn);
//        } else {
//            root.left = null;
//        }
//        if (pre.length - flag - 1 > 0) {
//            //右子树的先序,长度为 总-根-左子树
//            int[] rightPre = new int[pre.length - 1 - flag];
//            //右子树的中序
//            int[] rightIn = new int[pre.length - 1 - flag];
//
//            for (int j = flag + 1; j < len; j++) {
//                //右子树中序，为什么要j-flag-1呢 因为我的rightIn要从0开始 而j是k+1开始的 ，所以很尴尬，只能用j-flag-1
//                rightIn[j - flag - 1] = in[j];
//
//                rightPre[j - flag - 1] = pre[j];
//            }
//
//            root.right = reConstructBinaryTree(rightPre, rightIn);
//        } else {
//            root.right = null;
//        }
//
//        return root;
//
//    }

    /**
     * 根据中序遍历和前序遍历可以确定二叉树，具体过程为：
     *
     * 根据前序序列第一个结点确定根结点
     * 根据根结点在中序序列中的位置分割出左右两个子序列
     * 对左子树和右子树分别递归使用同样的方法继续分解
     * 例如：
     * 前序序列{1,2,4,7,3,5,6,8} = pre
     * 中序序列{4,7,2,1,5,3,8,6} = in
     *
     * 根据当前前序序列的第一个结点确定根结点，为 1
     * 找到 1 在中序遍历序列中的位置，为 in[3]
     * 切割左右子树，则 in[3] 前面的为左子树， in[3] 后面的为右子树
     * 则切割后的左子树前序序列为：{2,4,7}，切割后的左子树中序序列为：{4,7,2}；切割后的右子树前序序列为：{3,5,6,8}，切割后的右子树中序序列为：{5,3,8,6}
     * 对子树分别使用同样的方法分解
      * @param pre
     * @param in
     * @return
     */


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

}
