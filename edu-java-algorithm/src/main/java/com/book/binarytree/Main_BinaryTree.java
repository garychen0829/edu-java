package com.book.binarytree;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 二叉树练习
 */
public class Main_BinaryTree {

    private static Gson gson = new Gson();

    /**
     * 构建二叉树
     *
     * @param inputList 输入序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (CollectionUtils.isEmpty(inputList)) {
            return null;
        }
        Integer data = inputList.removeFirst();
        // 如果元素为空,则不再进一步便利
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树 前序遍历
     *
     * @param node
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树 中序遍历
     *
     * @param node
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树 后续遍历
     * @param node
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 定义: 二叉树 节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }


    /**
     * TreeNode JSON DATA - (BinaryTreeData.json)
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> inputList =
                new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println(gson.toJson(treeNode));
        System.out.println("前序遍历: ");
        preOrderTraveral(treeNode);
        System.out.println("======== ");

        System.out.println("中序遍历: ");
        inOrderTraveral(treeNode);
        System.out.println("======== ");

        System.out.println("后序遍历: ");
        postOrderTraveral(treeNode);
        System.out.println("======== ");
    }
}


