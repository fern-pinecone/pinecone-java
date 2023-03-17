package com.pinecone.api.resources.index.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = SparseValues.Builder.class
)
public final class SparseValues {
  private final List<Integer> indices;

  private final List<Double> values;

  private int _cachedHashCode;

  SparseValues(List<Integer> indices, List<Double> values) {
    this.indices = indices;
    this.values = values;
  }

  /**
   * @return The indices of the sparse data.
   */
  @JsonProperty("indices")
  public List<Integer> getIndices() {
    return indices;
  }

  /**
   * @return The corresponding values of the sparse data, which must be the same length as the indices.
   */
  @JsonProperty("values")
  public List<Double> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SparseValues && equalTo((SparseValues) other);
  }

  private boolean equalTo(SparseValues other) {
    return indices.equals(other.indices) && values.equals(other.values);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.indices, this.values);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SparseValues{" + "indices: " + indices + ", values: " + values + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Integer> indices = new ArrayList<>();

    private List<Double> values = new ArrayList<>();

    private Builder() {
    }

    public Builder from(SparseValues other) {
      indices(other.getIndices());
      values(other.getValues());
      return this;
    }

    @JsonSetter(
        value = "indices",
        nulls = Nulls.SKIP
    )
    public Builder indices(List<Integer> indices) {
      this.indices.clear();
      this.indices.addAll(indices);
      return this;
    }

    public Builder indices(Integer indices) {
      this.indices.add(indices);
      return this;
    }

    public Builder addAllIndices(List<Integer> indices) {
      this.indices.addAll(indices);
      return this;
    }

    @JsonSetter(
        value = "values",
        nulls = Nulls.SKIP
    )
    public Builder values(List<Double> values) {
      this.values.clear();
      this.values.addAll(values);
      return this;
    }

    public Builder values(Double values) {
      this.values.add(values);
      return this;
    }

    public Builder addAllValues(List<Double> values) {
      this.values.addAll(values);
      return this;
    }

    public SparseValues build() {
      return new SparseValues(indices, values);
    }
  }
}
