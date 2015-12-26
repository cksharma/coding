package edu.buffalo.cse601;

/**
 * Created by cksharma on 11/29/15.
 */
public class Feature {
    private int featureId;
    private String featureClass;
    private FeatureType type;
    private String value;

    public Feature(int featureId, String featureClass, FeatureType type, String value) {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feature feature = (Feature) o;

        if (featureId != feature.featureId) return false;
        return !(featureClass != null ? !featureClass.equals(feature.featureClass) : feature.featureClass != null);

    }

    @Override
    public int hashCode() {
        int result = featureId;
        result = 31 * result + (featureClass != null ? featureClass.hashCode() : 0);
        return result;
    }
}
