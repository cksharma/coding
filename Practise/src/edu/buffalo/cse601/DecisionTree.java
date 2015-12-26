package edu.buffalo.cse601;

import java.util.*;

public class DecisionTree {

    /**
     * takes class count map and returns the entropy at root level. H(S)
     * @param classCountMap
     * @return entropy H(S)
     */
    private double calculateEntropy(Map<String, Integer> classCountMap) {
        int totalNum = 0;
        double entropy = 0.;
        for (int value : classCountMap.values()) totalNum += value;
        for (String eachClass : classCountMap.keySet()) {
            int classCount = classCountMap.get(eachClass);
            double probability = 1. * classCount / totalNum;
            entropy -= probability * Utils.log2(probability);
        }
        return entropy;
    }

    public TreeNode getBestFeatureRoot(List<Sample> sampleList, TreeNode parent) {

        Set<Integer> visitedFeatureIdSet = new HashSet<>();

        TreeNode _parent = parent;
        while (_parent != null) {
            visitedFeatureIdSet.add(_parent.featureId);
            _parent = _parent.parent;
        }

        //calculate the count of each class from sampleList
        Map<String, Integer> classCountMap = new HashMap<>();
        for (Sample sample : sampleList) {
            classCountMap.put(sample.getGroundTruthClass(), classCountMap.get(sample.getGroundTruthClass()) == null ? 1 : classCountMap.get(sample.getGroundTruthClass()) + 1);
        }

        //total Entropy H(S) for the entire sample
        double totalEntropy = calculateEntropy(classCountMap);
        int totalSample = sampleList.size();

        //Now calculating sum of Pv * H(Sv)
        Map<Integer, Map<FeatureValue, Integer>> featureIdValueCountMap = new HashMap<>();

        for (Sample sample : sampleList) {
            for (Feature feature : sample.getFeatureList()) {

                int featureId = feature.getFeatureId();

                if (visitedFeatureIdSet.contains(featureId)) continue;

                FeatureValue featureValue = new FeatureValue(feature, feature.getValue());

                //get featureValueMap for the featureId
                Map<FeatureValue, Integer> featureValueMap = featureIdValueCountMap.get(featureId);
                if (featureValueMap == null) featureValueMap = new HashMap<>();

                if (featureValueMap.containsKey(featureValue)) {
                    featureValueMap.put(featureValue, featureValueMap.get(featureValue) + 1);
                } else {
                    featureValueMap.put(featureValue, 1);
                }
                //put the constructed featureValueMap for key featureId
                featureIdValueCountMap.put(featureId, featureValueMap);
            }
        }

        //maxEntropy initially is 0
        double maxEntropy = 0.;
        int id = -1;

        for (int featureId : featureIdValueCountMap.keySet()) {
            Map<String, Map<String, Integer>> featureValueClassMap = getClassCountForEachFeature(featureIdValueCountMap.get(featureId));

            double entropyValue = 0.;
            for (String eachAttr : featureValueClassMap.keySet()) {

                int Sv = Utils.sumOfTotalAttribute(featureValueClassMap.get(eachAttr));
                int S = totalSample;

                double attrEntropy = calculateEntropyForEachFeature(featureValueClassMap.get(eachAttr), Sv);
                entropyValue += Sv * 1. / S * attrEntropy;
            }
            double IG = totalEntropy - entropyValue;
            System.out.println(" IG " + IG);
            if (IG > maxEntropy) {
                maxEntropy = IG;
                id = featureId;
            }
        }

        if (id == -1) return null;

        int featureId = id;

        String value;
        if (parent == null) value = "ROOT";
        else value = parent.value;

        double entropy = maxEntropy;
        TreeNode rootNode = new TreeNode(featureId, value, parent, sampleList, entropy);

        Map<FeatureValue, Integer> featureValueCntMap = featureIdValueCountMap.get(featureId);
        List<TreeNode> childrenList = getChildrenForFeatureId(featureId, sampleList, featureValueCntMap, rootNode);
        rootNode.childrenList = childrenList;

        return rootNode;
    }

    private List<TreeNode> getChildrenForFeatureId(int featureId, List<Sample> sampleList, Map<FeatureValue, Integer> featureValueCntMap, TreeNode parent) {
        List<TreeNode> childrenList = new ArrayList<>();

        Set<String> attrValueSet = new HashSet<>();

        for (FeatureValue featureValue : featureValueCntMap.keySet()) {
            attrValueSet.add(featureValue.getValue());
        }

        for(String attrValue: attrValueSet) {
            List<Sample> sampleListWithAttrValue = getSampleListWithAttrValue(featureId, attrValue, sampleList);
            TreeNode childTreeNode = new TreeNode(featureId, attrValue, parent, sampleListWithAttrValue, Double.MIN_VALUE);
            childrenList.add(childTreeNode);
        }

        return childrenList;
    }

    private List<Sample> getSampleListWithAttrValue(int featureId, String attrValue, List<Sample> sampleList) {
        List<Sample> attrSpecificSampleList = new ArrayList<>();
        for (Sample sample : sampleList) {
            Feature feature = sample.getFeatureList().get(featureId);
            if (feature.getValue().equals(attrValue)) {
                attrSpecificSampleList.add(sample);
            }
        }
        return attrSpecificSampleList;
    }

    private Map<String, Map<String, Integer>> getClassCountForEachFeature(Map<FeatureValue, Integer> map) {
        Map<String, Map<String, Integer>> eachFeatureClassCntMap = new HashMap<>();
        for (FeatureValue featureValue : map.keySet()) {
            String attrValue = featureValue.getValue();
            String featureClass = featureValue.getFeature().getFeatureClass();
            Map<String, Integer> classCountMap = eachFeatureClassCntMap.get(attrValue);
            if (classCountMap == null) classCountMap = new HashMap<>();
            int cnt = map.get(featureValue);
            classCountMap.put(featureClass, classCountMap.get(featureClass) == null ? cnt : classCountMap.get(featureClass) + cnt);
            eachFeatureClassCntMap.put(attrValue, classCountMap);
        }
        return eachFeatureClassCntMap;
    }

    private double calculateEntropyForEachFeature(Map<String, Integer> map, int Sv) {
        double ans = 0.;

        //will hold count of each attribute in each featureId.. map above is particular to a featureId
        for (String eachClass : map.keySet()) {
            double prob = map.get(eachClass) * 1. / Sv;
            ans -= prob * Utils.log2(prob);
        }

        return ans;
    }
}
