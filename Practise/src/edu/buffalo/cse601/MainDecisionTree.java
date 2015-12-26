package edu.buffalo.cse601;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cksharma on 12/4/15.
 */
public class MainDecisionTree {
    public static void main(String[] args) {

        String filePath = "/home/cksharma/data/git/dm/project3/data/temp_data.txt";
        List<Sample> sampleList = Utils.getFeatureList(filePath);

        DecisionTree decisionTree = new DecisionTree();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        TreeNode rootNode = null;

        while (queue.isEmpty() == false) {

            TreeNode parent = queue.poll();

            if (parent != null) sampleList = parent.sampleList;

            TreeNode root = decisionTree.getBestFeatureRoot(sampleList, parent);

            if (root == null) continue;

            if (root != null && rootNode == null) {
                rootNode = root;
            }

            root.parent = parent;
            if (parent != null)
                parent.childrenList = root.childrenList;

            if (root.childrenList == null) continue;

            for (TreeNode child : root.childrenList) {
                queue.add(child);
                child.parent = root;
            }
        }

        printTree(rootNode);
    }

    private static void printTree(TreeNode rootNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);

        while (queue.isEmpty() == false) {
            TreeNode parent = queue.poll();

            if (parent == null) continue;;

            System.out.println();
            System.out.println("parent = " + parent.value);

            if (parent.childrenList == null) continue;

            StringBuilder sb = new StringBuilder();
            sb.append("children = [");
            for (TreeNode child : parent.childrenList) {
                sb.append(child.value).append(" ");
                queue.add(child);
            }
            sb.append("]");
            System.out.println(sb);
            System.out.println();
        }
    }
}
