package edu.buffalo.cse601;

/**
 * Created by cksharma on 11/29/15.
 */
public class Feature {

    private int featureId;
    private String featureClass;
    private FeatureType type; //for now we are ignoring FeatureType.DISCRETE
    private double value; //TODO we will make data type generic later

    public Feature(int featureId, String featureClass, FeatureType type, double value) {
        this.featureId = featureId;
        this.featureClass = featureClass;
        this.type = type;
        this.value = value;
    }

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getFeatureClass() {
        return featureClass;
    }

    public void setFeatureClass(String featureClass) {
        this.featureClass = featureClass;
    }

    public FeatureType getType() {
        return type;
    }

    public void setType(FeatureType type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((featureClass == null) ? 0 : featureClass.hashCode());
        result = prime * result + featureId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Feature other = (Feature) obj;
        if (featureClass == null) {
            if (other.featureClass != null)
                return false;
        } else if (!featureClass.equals(other.featureClass))
            return false;
        if (featureId != other.featureId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "featureId=" + featureId +
                ", featureClass='" + featureClass + '\'' +
                ", type=" + type +
                ", value=" + value +
                '}';
    }
}
