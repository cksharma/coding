package practise; /**
 * Created by cksharma on 11/30/15.
 */

import java.io.*;
import java.util.*;

public class Temp {

    int numAttributes;
    String[] attributeNames;
    Vector v = new Vector();
    Queue q = new LinkedList();
    int k;

    Vector[] domains;

    class DataPoint {

        public int[] attributes;

        public DataPoint(int numattributes) {
            attributes = new int[numattributes];
        }
    }

    class TreeNode {
        public double entropy;
        public Vector data;
        public int decompositionAttribute;
        public int decompositionValue;
        public TreeNode[] children;
        public TreeNode parent;

        public TreeNode() {
            data = new Vector();
        }

    }

    TreeNode root = new TreeNode();

    public int getSymbolValue(int attribute, String symbol) {
        int index = domains[attribute].indexOf(symbol);
        if (index < 0) {
            domains[attribute].addElement(symbol);
            return domains[attribute].size() - 1;
        }
        return index;
    }

    public int[] getAllValues(Vector data, int attribute) {
        Vector values = new Vector();
        int num = data.size();
        for (int i = 0; i < num; i++) {
            DataPoint point = (DataPoint) data.elementAt(i);
            String symbol = (String) domains[attribute].elementAt(point.attributes[attribute]);
            int index = values.indexOf(symbol);
            if (index < 0) {
                values.addElement(symbol);
            }
        }

        int[] array = new int[values.size()];
        for (int i = 0; i < array.length; i++) {
            String symbol = (String) values.elementAt(i);
            array[i] = domains[attribute].indexOf(symbol);
        }
        values = null;
        return array;
    }

    public Vector getSubset(Vector data, int attribute, int value) {
        Vector subset = new Vector();

        int num = data.size();
        for (int i = 0; i < num; i++) {
            DataPoint point = (DataPoint) data.elementAt(i);
            if (point.attributes[attribute] == value) subset.addElement(point);
        }
        return subset;

    }

    public double calculateEntropy(Vector data) {

        int numdata = data.size();
        if (numdata == 0) return 0;

        int attribute = numAttributes - 1;
        int numvalues = domains[attribute].size();
        double sum = 0;
        for (int i = 0; i < numvalues; i++) {
            int count = 0;
            for (int j = 0; j < numdata; j++) {
                DataPoint point = (DataPoint) data.elementAt(j);
                if (point.attributes[attribute] == i) count++;
            }
            double probability = 1. * count / numdata;
            if (count > 0) sum += -probability * Math.log(probability);
        }
        return sum;

    }

    public boolean alreadyUsedToDecompose(TreeNode node, int attribute) {
        if (node.children != null) {
            if (node.decompositionAttribute == attribute)
                return true;
        }
        if (node.parent == null) return false;
        return alreadyUsedToDecompose(node.parent, attribute);
    }

    public void decomposeNode(TreeNode node) {

        double bestEntropy = 0;
        boolean selected = false;
        int selectedAttribute = 0;

        int numdata = node.data.size();
        int numinputattributes = numAttributes - 1;
        node.entropy = calculateEntropy(node.data);
        if (node.entropy == 0) return;

        for (int i = 0; i < numinputattributes; i++) {
            int numvalues = domains[i].size();
            if (alreadyUsedToDecompose(node, i)) continue;
            double averageentropy = 0;
            for (int j = 0; j < numvalues; j++) {
                Vector subset = getSubset(node.data, i, j);
                if (subset.size() == 0) continue;
                double subentropy = calculateEntropy(subset);
                averageentropy += subentropy * subset.size();
            }

            averageentropy = averageentropy / numdata;
            if (selected == false) {
                selected = true;
                bestEntropy = averageentropy;
                selectedAttribute = i;
            } else {
                if (averageentropy < bestEntropy) {
                    selected = true;
                    bestEntropy = averageentropy;
                    selectedAttribute = i;
                }
            }
        }

        if (selected == false) return;

        int numvalues = domains[selectedAttribute].size();
        node.decompositionAttribute = selectedAttribute;
        node.children = new TreeNode[numvalues];
        for (int j = 0; j < numvalues; j++) {
            node.children[j] = new TreeNode();
            node.children[j].parent = node;
            node.children[j].data = getSubset(node.data, selectedAttribute, j);
            node.children[j].decompositionValue = j;
        }

        for (int j = 0; j < numvalues; j++) {
            decomposeNode(node.children[j]);
        }
        node.data = null;
    }

    public int readData(String filename) throws Exception {

        FileInputStream in = null;

        try {
            File inputFile = new File(filename);
            in = new FileInputStream(inputFile);
        } catch (Exception e) {
            System.err.println("Unable to open data file: " + filename + "\n" + e);
            return 0;
        }

        BufferedReader bin = new BufferedReader(new InputStreamReader(in));

        String input;
        while (true) {
            input = bin.readLine();
            if (input == null) {
                System.err.println("No data found in the data file: " + filename + "\n");
                return 0;
            }
            if (input.startsWith("//")) continue;
            if (input.equals("")) continue;
            break;
        }

        StringTokenizer tokenizer = new StringTokenizer(input);
        numAttributes = tokenizer.countTokens();
        if (numAttributes <= 1) {
            System.err.println("Read line: " + input);
            System.err.println("Could not obtain the names of attributes in the line");
            System.err.println("Expecting at least one input attribute and one output attribute");
            return 0;
        }

        domains = new Vector[numAttributes];
        for (int i = 0; i < numAttributes; i++) domains[i] = new Vector();
        attributeNames = new String[numAttributes];

        for (int i = 0; i < numAttributes; i++) {
            attributeNames[i] = tokenizer.nextToken();
        }

        while (true) {
            input = bin.readLine();
            if (input == null) break;
            if (input.startsWith("//")) continue;
            if (input.equals("")) continue;

            tokenizer = new StringTokenizer(input);
            int numtokens = tokenizer.countTokens();
            if (numtokens != numAttributes) {
                System.err.println("Read " + root.data.size() + " data");
                System.err.println("Last line read: " + input);
                System.err.println("Expecting " + numAttributes + " attributes");
                return 0;
            }

            DataPoint point = new DataPoint(numAttributes);
            for (int i = 0; i < numAttributes; i++) {
                point.attributes[i] = getSymbolValue(i, tokenizer.nextToken());
            }
            root.data.addElement(point);
        }
        bin.close();
        return 1;
    }

    public void printTree(TreeNode node, String tab) {
        Queue<Integer> a = new LinkedList<Integer>();
        int outputattr = numAttributes - 1;
        Queue q = new LinkedList();
        q.add(node);
        System.out.println("digraph decision_tree { ");
        int kk;
        kk = (int) (Math.random() * 500000) % 1000;
        a.add(kk);
        while (!q.isEmpty()) {
            kk = (int) a.remove();
            //System.out.println(kk);
            TreeNode n = (TreeNode) q.remove();
            if (n.children == null) {
                continue;
            }
            int numvalues = n.children.length;
            String ss = attributeNames[n.decompositionAttribute];
            System.out.println("\"" + ss + "@" + kk + "\" [label = \"" + ss + "\"] ; ");
            String st1, st2, st3;
            for (int i = 0; i < numvalues; i++) {
                int ll = (int) (Math.random() * 500000) % 1000;
                a.add(ll);
                TreeNode ab = n.children[i];
                q.add(ab);
                if (ab.children != null) {
                    System.out.println("\"" + ss + "@" + kk + "\" -> \"" + attributeNames[ab.decompositionAttribute] + "@" + ll + "\" [label = \"" + domains[n.decompositionAttribute].elementAt(i) + "\"] ; ");
                } else {
                    int[] values = getAllValues(ab.data, outputattr);
                    for (int j = 0; j < values.length; j++) {
                        System.out.println("\"" + ss + "@" + kk + "\" -> \"" + domains[outputattr].elementAt(values[j]) + "@" + ll + "\" [label = \"" + domains[n.decompositionAttribute].elementAt(i) + "\"] ; ");
                    }
                }
            }
        }
        System.out.println("}");
    }

    public void createDecisionTree() {
        decomposeNode(root);
        printTree(root, "");
    }

    public static void main(String[] args) throws Exception {

        String filePath = "/home/cksharma/data/git/dm/project3/data/temp_data.txt";

        Temp me = new Temp();

        int status = me.readData(filePath);
        if (status <= 0) return;

        me.createDecisionTree();
    }
}


