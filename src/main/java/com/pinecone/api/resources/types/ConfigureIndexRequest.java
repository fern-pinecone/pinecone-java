package com.pinecone.api.resources.types;

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
    builder = ConfigureIndexRequest.Builder.class
)
public final class ConfigureIndexRequest {
  private final Optional<Integer> replicas;

  private final Optional<String> podType;

  private int _cachedHashCode;

  ConfigureIndexRequest(Optional<Integer> replicas, Optional<String> podType) {
    this.replicas = replicas;
    this.podType = podType;
  }

  /**
   * @return The desired number of replicas for the index.
   */
  @JsonProperty("replicas")
  public Optional<Integer> getReplicas() {
    return replicas;
  }

  /**
   * @return The new pod type for the index. One of <code>s1</code>, <code>p1</code>, or <code>p2</code> appended with <code>.</code> and one of <code>x1</code>, <code>x2</code>, <code>x4</code>, or <code>x8</code>.
   */
  @JsonProperty("pod_type")
  public Optional<String> getPodType() {
    return podType;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ConfigureIndexRequest && equalTo((ConfigureIndexRequest) other);
  }

  private boolean equalTo(ConfigureIndexRequest other) {
    return replicas.equals(other.replicas) && podType.equals(other.podType);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.replicas, this.podType);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ConfigureIndexRequest{" + "replicas: " + replicas + ", podType: " + podType + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Integer> replicas = Optional.empty();

    private Optional<String> podType = Optional.empty();

    private Builder() {
    }

    public Builder from(ConfigureIndexRequest other) {
      replicas(other.getReplicas());
      podType(other.getPodType());
      return this;
    }

    @JsonSetter(
        value = "replicas",
        nulls = Nulls.SKIP
    )
    public Builder replicas(Optional<Integer> replicas) {
      this.replicas = replicas;
      return this;
    }

    public Builder replicas(Integer replicas) {
      this.replicas = Optional.of(replicas);
      return this;
    }

    @JsonSetter(
        value = "pod_type",
        nulls = Nulls.SKIP
    )
    public Builder podType(Optional<String> podType) {
      this.podType = podType;
      return this;
    }

    public Builder podType(String podType) {
      this.podType = Optional.of(podType);
      return this;
    }

    public ConfigureIndexRequest build() {
      return new ConfigureIndexRequest(replicas, podType);
    }
  }
}
