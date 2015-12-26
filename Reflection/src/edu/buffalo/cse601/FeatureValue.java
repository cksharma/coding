package edu.buffalo.cse601;

/**
 * Created by cksharma on 12/4/15.
 */
public class FeatureValue {
    Feature feature;
    double value;

    FeatureValue(Feature feature, double value) {
        this.feature = feature;
        this.value = value;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeatureValue that = (FeatureValue) o;

        if (Double.compare(that.value, value) != 0) return false;
        return !(feature != null ? !feature.equals(that.feature) : that.feature != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = feature != null ? feature.hashCode() : 0;
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
