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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = DescribeIndexStatsResponse.Builder.class
)
public final class DescribeIndexStatsResponse {
  private final Optional<Map<String, NamespaceSummary>> namespaces;

  private final Optional<Integer> dimension;

  private final Optional<Double> indexFullness;

  private final Optional<Integer> totalVectorCount;

  private int _cachedHashCode;

  DescribeIndexStatsResponse(Optional<Map<String, NamespaceSummary>> namespaces,
      Optional<Integer> dimension, Optional<Double> indexFullness,
      Optional<Integer> totalVectorCount) {
    this.namespaces = namespaces;
    this.dimension = dimension;
    this.indexFullness = indexFullness;
    this.totalVectorCount = totalVectorCount;
  }

  /**
   * @return A mapping for each namespace in the index from the namespace name to a
   * summary of its contents. If a metadata filter expression is present, the
   * summary will reflect only vectors matching that expression.
   */
  @JsonProperty("namespaces")
  public Optional<Map<String, NamespaceSummary>> getNamespaces() {
    return namespaces;
  }

  /**
   * @return The dimension of the indexed vectors.
   */
  @JsonProperty("dimension")
  public Optional<Integer> getDimension() {
    return dimension;
  }

  /**
   * @return The fullness of the index, regardless of whether a metadata filter expression was passed. The granularity of this metric is 10%.
   */
  @JsonProperty("indexFullness")
  public Optional<Double> getIndexFullness() {
    return indexFullness;
  }

  @JsonProperty("totalVectorCount")
  public Optional<Integer> getTotalVectorCount() {
    return totalVectorCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof DescribeIndexStatsResponse && equalTo((DescribeIndexStatsResponse) other);
  }

  private boolean equalTo(DescribeIndexStatsResponse other) {
    return namespaces.equals(other.namespaces) && dimension.equals(other.dimension) && indexFullness.equals(other.indexFullness) && totalVectorCount.equals(other.totalVectorCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.namespaces, this.dimension, this.indexFullness, this.totalVectorCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "DescribeIndexStatsResponse{" + "namespaces: " + namespaces + ", dimension: " + dimension + ", indexFullness: " + indexFullness + ", totalVectorCount: " + totalVectorCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Map<String, NamespaceSummary>> namespaces = Optional.empty();

    private Optional<Integer> dimension = Optional.empty();

    private Optional<Double> indexFullness = Optional.empty();

    private Optional<Integer> totalVectorCount = Optional.empty();

    private Builder() {
    }

    public Builder from(DescribeIndexStatsResponse other) {
      namespaces(other.getNamespaces());
      dimension(other.getDimension());
      indexFullness(other.getIndexFullness());
      totalVectorCount(other.getTotalVectorCount());
      return this;
    }

    @JsonSetter(
        value = "namespaces",
        nulls = Nulls.SKIP
    )
    public Builder namespaces(Optional<Map<String, NamespaceSummary>> namespaces) {
      this.namespaces = namespaces;
      return this;
    }

    public Builder namespaces(Map<String, NamespaceSummary> namespaces) {
      this.namespaces = Optional.of(namespaces);
      return this;
    }

    @JsonSetter(
        value = "dimension",
        nulls = Nulls.SKIP
    )
    public Builder dimension(Optional<Integer> dimension) {
      this.dimension = dimension;
      return this;
    }

    public Builder dimension(Integer dimension) {
      this.dimension = Optional.of(dimension);
      return this;
    }

    @JsonSetter(
        value = "indexFullness",
        nulls = Nulls.SKIP
    )
    public Builder indexFullness(Optional<Double> indexFullness) {
      this.indexFullness = indexFullness;
      return this;
    }

    public Builder indexFullness(Double indexFullness) {
      this.indexFullness = Optional.of(indexFullness);
      return this;
    }

    @JsonSetter(
        value = "totalVectorCount",
        nulls = Nulls.SKIP
    )
    public Builder totalVectorCount(Optional<Integer> totalVectorCount) {
      this.totalVectorCount = totalVectorCount;
      return this;
    }

    public Builder totalVectorCount(Integer totalVectorCount) {
      this.totalVectorCount = Optional.of(totalVectorCount);
      return this;
    }

    public DescribeIndexStatsResponse build() {
      return new DescribeIndexStatsResponse(namespaces, dimension, indexFullness, totalVectorCount);
    }
  }
}
