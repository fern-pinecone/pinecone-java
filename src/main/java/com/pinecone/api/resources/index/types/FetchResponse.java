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
    builder = FetchResponse.Builder.class
)
public final class FetchResponse {
  private final Optional<Map<String, Vector>> vectors;

  private final Optional<String> namespace;

  private int _cachedHashCode;

  FetchResponse(Optional<Map<String, Vector>> vectors, Optional<String> namespace) {
    this.vectors = vectors;
    this.namespace = namespace;
  }

  @JsonProperty("vectors")
  public Optional<Map<String, Vector>> getVectors() {
    return vectors;
  }

  /**
   * @return The namespace of the vectors.
   */
  @JsonProperty("namespace")
  public Optional<String> getNamespace() {
    return namespace;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FetchResponse && equalTo((FetchResponse) other);
  }

  private boolean equalTo(FetchResponse other) {
    return vectors.equals(other.vectors) && namespace.equals(other.namespace);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.vectors, this.namespace);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FetchResponse{" + "vectors: " + vectors + ", namespace: " + namespace + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Map<String, Vector>> vectors = Optional.empty();

    private Optional<String> namespace = Optional.empty();

    private Builder() {
    }

    public Builder from(FetchResponse other) {
      vectors(other.getVectors());
      namespace(other.getNamespace());
      return this;
    }

    @JsonSetter(
        value = "vectors",
        nulls = Nulls.SKIP
    )
    public Builder vectors(Optional<Map<String, Vector>> vectors) {
      this.vectors = vectors;
      return this;
    }

    public Builder vectors(Map<String, Vector> vectors) {
      this.vectors = Optional.of(vectors);
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

    public FetchResponse build() {
      return new FetchResponse(vectors, namespace);
    }
  }
}
