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
    builder = UpsertResponse.Builder.class
)
public final class UpsertResponse {
  private final Optional<Integer> upsertedCount;

  private int _cachedHashCode;

  UpsertResponse(Optional<Integer> upsertedCount) {
    this.upsertedCount = upsertedCount;
  }

  /**
   * @return The number of vectors upserted.
   */
  @JsonProperty("upsertedCount")
  public Optional<Integer> getUpsertedCount() {
    return upsertedCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UpsertResponse && equalTo((UpsertResponse) other);
  }

  private boolean equalTo(UpsertResponse other) {
    return upsertedCount.equals(other.upsertedCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.upsertedCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UpsertResponse{" + "upsertedCount: " + upsertedCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Integer> upsertedCount = Optional.empty();

    private Builder() {
    }

    public Builder from(UpsertResponse other) {
      upsertedCount(other.getUpsertedCount());
      return this;
    }

    @JsonSetter(
        value = "upsertedCount",
        nulls = Nulls.SKIP
    )
    public Builder upsertedCount(Optional<Integer> upsertedCount) {
      this.upsertedCount = upsertedCount;
      return this;
    }

    public Builder upsertedCount(Integer upsertedCount) {
      this.upsertedCount = Optional.of(upsertedCount);
      return this;
    }

    public UpsertResponse build() {
      return new UpsertResponse(upsertedCount);
    }
  }
}
