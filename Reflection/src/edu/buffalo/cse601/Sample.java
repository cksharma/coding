package edu.buffalo.cse601;

import java.util.List;

/**
 * Created by cksharma on 11/29/15.
 */
public class Sample {
    private String groundTruthClass;
    private List<Feature> featureList;
    private String predictedClass;

    public Sample(String groundTruthClass, List<Feature> featureList) {
        this.groundTruthClass = groundTruthClass;
        this.featureList = featureList;
    }

    public String getGroundTruthClass() {
        return groundTruthClass;
    }

    public void setGroundTruthClass(String groundTruthClass) {
        this.groundTruthClass = groundTruthClass;
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public String getPredictedClass() {
        return predictedClass;
    }

    public void setPredictedClass(String predictedClass) {
        this.predictedClass = predictedClass;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "groundTruthClass='" + groundTruthClass + '\'' +
                ", featureList=" + featureList +
                ", predictedClass='" + predictedClass + '\'' +
                '}';
    }
}
