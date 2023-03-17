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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = QueryVector.Builder.class
)
public final class QueryVector {
  private final List<Double> values;

  private final Optional<SparseValues> sparseValues;

  private final Optional<Integer> topK;

  private final Optional<String> namespace;

  private final Optional<Map<String, Object>> filter;

  private int _cachedHashCode;

  QueryVector(List<Double> values, Optional<SparseValues> sparseValues, Optional<Integer> topK,
      Optional<String> namespace, Optional<Map<String, Object>> filter) {
    this.values = values;
    this.sparseValues = sparseValues;
    this.topK = topK;
    this.namespace = namespace;
    this.filter = filter;
  }

  /**
   * @return The query vector values. This should be the same length as the dimension of the index being queried.
   */
  @JsonProperty("values")
  public List<Double> getValues() {
    return values;
  }

  @JsonProperty("sparseValues")
  public Optional<SparseValues> getSparseValues() {
    return sparseValues;
  }

  /**
   * @return An override for the number of results to return for this query vector.
   */
  @JsonProperty("topK")
  public Optional<Integer> getTopK() {
    return topK;
  }

  /**
   * @return An override the namespace to search.
   */
  @JsonProperty("namespace")
  public Optional<String> getNamespace() {
    return namespace;
  }

  /**
   * @return An override for the metadata filter to apply. This replaces the request-level filter.
   */
  @JsonProperty("filter")
  public Optional<Map<String, Object>> getFilter() {
    return filter;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof QueryVector && equalTo((QueryVector) other);
  }

  private boolean equalTo(QueryVector other) {
    return values.equals(other.values) && sparseValues.equals(other.sparseValues) && topK.equals(other.topK) && namespace.equals(other.namespace) && filter.equals(other.filter);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.values, this.sparseValues, this.topK, this.namespace, this.filter);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "QueryVector{" + "values: " + values + ", sparseValues: " + sparseValues + ", topK: " + topK + ", namespace: " + namespace + ", filter: " + filter + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Double> values = new ArrayList<>();

    private Optional<SparseValues> sparseValues = Optional.empty();

    private Optional<Integer> topK = Optional.empty();

    private Optional<String> namespace = Optional.empty();

    private Optional<Map<String, Object>> filter = Optional.empty();

    private Builder() {
    }

    public Builder from(QueryVector other) {
      values(other.getValues());
      sparseValues(other.getSparseValues());
      topK(other.getTopK());
      namespace(other.getNamespace());
      filter(other.getFilter());
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

    @JsonSetter(
        value = "sparseValues",
        nulls = Nulls.SKIP
    )
    public Builder sparseValues(Optional<SparseValues> sparseValues) {
      this.sparseValues = sparseValues;
      return this;
    }

    public Builder sparseValues(SparseValues sparseValues) {
      this.sparseValues = Optional.of(sparseValues);
      return this;
    }

    @JsonSetter(
        value = "topK",
        nulls = Nulls.SKIP
    )
    public Builder topK(Optional<Integer> topK) {
      this.topK = topK;
      return this;
    }

    public Builder topK(Integer topK) {
      this.topK = Optional.of(topK);
      return this;
    }

    @JsonSetter(
        value = "namespace",
        nulls = Nulls.SKIP
    )
    public Builder namespace(Optional<String> namespace) {
      this.namespace = namespace;
      return this;
    }

    public Builder namespace(String namespace) {
      this.namespace = Optional.of(namespace);
      return this;
    }

    @JsonSetter(
        value = "filter",
        nulls = Nulls.SKIP
    )
    public Builder filter(Optional<Map<String, Object>> filter) {
      this.filter = filter;
      return this;
    }

    public Builder filter(Map<String, Object> filter) {
      this.filter = Optional.of(filter);
      return this;
    }

    public QueryVector build() {
      return new QueryVector(values, sparseValues, topK, namespace, filter);
    }
  }
}
