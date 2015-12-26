package edu.buffalo.cse601;

import java.util.List;

/**
 * Created by cksharma on 12/4/15.
 */
public class TreeNode {

    int featureId;

    double value;

    TreeNode parent;

    List<TreeNode> childrenList;

    List<Sample> sampleList;

    double entropy;

    TreeNode (int featureId, double value, TreeNode parent, List<Sample> sampleList, double entropy) {
        this.featureId = featureId;
        this.value = value;
        this.parent = parent;
        this.sampleList = sampleList;
        this.entropy = entropy;
    }

    private String objString() {
        return "TreeNode{" +
                "featureId=" + featureId +
                ", value='" + value + '\'' +
                ", sampleList=" + sampleList +
                ", entropy=" + entropy +
                '}';
    }

    @Override
    public String toString() {

        StringBuilder childrenListStr = new StringBuilder();
        if (childrenList != null) {
            for (TreeNode treeNode : childrenList) {
                childrenListStr.append(treeNode.objString() + "\n");
            }
        }
        String parentStr = parent == null ? "ROOT" : parent.objString();

        return "TreeNode{" +
                "featureId=" + featureId +
                ", value='" + value + '\'' +
                ", parent= [ " + parentStr + "]" +
                ", childrenList=[ " + childrenListStr.toString() + " ]" +
                ", sampleList=" + sampleList +
                ", entropy=" + entropy +
                '}';
    }
}
