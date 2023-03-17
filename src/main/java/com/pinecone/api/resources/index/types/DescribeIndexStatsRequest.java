package com.pinecone.api.resources.index.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = DescribeIndexStatsRequest.Builder.class
)
public final class DescribeIndexStatsRequest {
  private final Optional<Map<String, Object>> filter;

  private int _cachedHashCode;

  DescribeIndexStatsRequest(Optional<Map<String, Object>> filter) {
    this.filter = filter;
  }

  /**
   * @return If this parameter is present, the operation only returns statistics
   * for vectors that satisfy the filter.
   * See https://www.pinecone.io/docs/metadata-filtering/.
   */
  @JsonProperty("filter")
  public Optional<Map<String, Object>> getFilter() {
    return filter;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof DescribeIndexStatsRequest && equalTo((DescribeIndexStatsRequest) other);
  }

  private boolean equalTo(DescribeIndexStatsRequest other) {
    return filter.equals(other.filter);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.filter);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "DescribeIndexStatsRequest{" + "filter: " + filter + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Map<String, Object>> filter = Optional.empty();

    private Builder() {
    }

    public Builder from(DescribeIndexStatsRequest other) {
      filter(other.getFilter());
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

    public DescribeIndexStatsRequest build() {
      return new DescribeIndexStatsRequest(filter);
    }
  }
}
