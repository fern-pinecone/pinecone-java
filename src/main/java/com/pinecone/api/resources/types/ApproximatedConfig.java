package com.pinecone.api.resources.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = ApproximatedConfig.Builder.class
)
public final class ApproximatedConfig {
  private final Optional<Integer> kBits;

  private final Optional<Boolean> hybrid;

  private int _cachedHashCode;

  ApproximatedConfig(Optional<Integer> kBits, Optional<Boolean> hybrid) {
    this.kBits = kBits;
    this.hybrid = hybrid;
  }

  @JsonProperty("k_bits")
  public Optional<Integer> getKBits() {
    return kBits;
  }

  @JsonProperty("hybrid")
  public Optional<Boolean> getHybrid() {
    return hybrid;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ApproximatedConfig && equalTo((ApproximatedConfig) other);
  }

  private boolean equalTo(ApproximatedConfig other) {
    return kBits.equals(other.kBits) && hybrid.equals(other.hybrid);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.kBits, this.hybrid);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ApproximatedConfig{" + "kBits: " + kBits + ", hybrid: " + hybrid + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Integer> kBits = Optional.empty();

    private Optional<Boolean> hybrid = Optional.empty();

    private Builder() {
    }

    public Builder from(ApproximatedConfig other) {
      kBits(other.getKBits());
      hybrid(other.getHybrid());
      return this;
    }

    @JsonSetter(
        value = "k_bits",
        nulls = Nulls.SKIP
    )
    public Builder kBits(Optional<Integer> kBits) {
      this.kBits = kBits;
      return this;
    }

    public Builder kBits(Integer kBits) {
      this.kBits = Optional.of(kBits);
      return this;
    }

    @JsonSetter(
        value = "hybrid",
        nulls = Nulls.SKIP
    )
    public Builder hybrid(Optional<Boolean> hybrid) {
      this.hybrid = hybrid;
      return this;
    }

    public Builder hybrid(Boolean hybrid) {
      this.hybrid = Optional.of(hybrid);
      return this;
    }

    public ApproximatedConfig build() {
      return new ApproximatedConfig(kBits, hybrid);
    }
  }
}
