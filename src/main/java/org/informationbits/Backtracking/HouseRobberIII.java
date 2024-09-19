package org.informationbits.Backtracking;

/**
 * https://leetcode.com/problems/house-robber-iii/description/
 */
public class HouseRobberIII {

    //Here cleverly redundant/repeat computation are saved without using extra memory.
    public static int getMaxPossibleRobbedAmount(TreeNode<Integer> root) {
        int[] amtPairRoot = dfs(root);
        return Math.max(amtPairRoot[0], amtPairRoot[1]);
    }

    /**
     * Result -
     * index 0 - is amount excluding the node
     * index 1 - is amount including the node value.
     */
    private static int[] dfs(TreeNode<Integer> node) {
        if (node == null) return new int[]{0, 0};

        int[] amtPairLeft = dfs(node.left);
        int[] amtPairRight = dfs(node.right);
        //Math.max importance.
        return new int[]{Math.max(amtPairLeft[0], amtPairLeft[1]) + Math.max(amtPairRight[0], amtPairRight[1]),
                node.data + amtPairLeft[0] + amtPairRight[0]};
    }

    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
