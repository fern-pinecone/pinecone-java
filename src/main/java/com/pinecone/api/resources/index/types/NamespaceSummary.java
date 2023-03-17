package com.pinecone.api.resources.index.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = NamespaceSummary.Builder.class
)
public final class NamespaceSummary {
  private final Optional<Integer> vectorCount;

  private int _cachedHashCode;

  NamespaceSummary(Optional<Integer> vectorCount) {
    this.vectorCount = vectorCount;
  }

  /**
   * @return The number of vectors stored in this namespace. Note that updates to this field may lag behind updates to the
   * underlying index and corresponding query results, etc.
   */
  @JsonProperty("vectorCount")
  public Optional<Integer> getVectorCount() {
    return vectorCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof NamespaceSummary && equalTo((NamespaceSummary) other);
  }

  private boolean equalTo(NamespaceSummary other) {
    return vectorCount.equals(other.vectorCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.vectorCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "NamespaceSummary{" + "vectorCount: " + vectorCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Integer> vectorCount = Optional.empty();

    private Builder() {
    }

    public Builder from(NamespaceSummary other) {
      vectorCount(other.getVectorCount());
      return this;
    }

    @JsonSetter(
        value = "vectorCount",
        nulls = Nulls.SKIP
    )
    public Builder vectorCount(Optional<Integer> vectorCount) {
      this.vectorCount = vectorCount;
      return this;
    }

    public Builder vectorCount(Integer vectorCount) {
      this.vectorCount = Optional.of(vectorCount);
      return this;
    }

    public NamespaceSummary build() {
      return new NamespaceSummary(vectorCount);
    }
  }
}
