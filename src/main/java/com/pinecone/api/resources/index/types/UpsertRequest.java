package com.pinecone.api.resources.index.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = UpsertRequest.Builder.class
)
public final class UpsertRequest {
  private final List<Vector> vectors;

  private final Optional<String> namespace;

  private int _cachedHashCode;

  UpsertRequest(List<Vector> vectors, Optional<String> namespace) {
    this.vectors = vectors;
    this.namespace = namespace;
  }

  /**
   * @return An array containing the vectors to upsert. Recommended batch limit is 100 vectors.
   */
  @JsonProperty("vectors")
  public List<Vector> getVectors() {
    return vectors;
  }

  /**
   * @return This is the namespace name where you upsert vectors.
   */
  @JsonProperty("namespace")
  public Optional<String> getNamespace() {
    return namespace;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UpsertRequest && equalTo((UpsertRequest) other);
  }

  private boolean equalTo(UpsertRequest other) {
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
    return "UpsertRequest{" + "vectors: " + vectors + ", namespace: " + namespace + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Vector> vectors = new ArrayList<>();

    private Optional<String> namespace = Optional.empty();

    private Builder() {
    }

    public Builder from(UpsertRequest other) {
      vectors(other.getVectors());
      namespace(other.getNamespace());
      return this;
    }

    @JsonSetter(
        value = "vectors",
        nulls = Nulls.SKIP
    )
    public Builder vectors(List<Vector> vectors) {
      this.vectors.clear();
      this.vectors.addAll(vectors);
      return this;
    }

    public Builder vectors(Vector vectors) {
      this.vectors.add(vectors);
      return this;
    }

    public Builder addAllVectors(List<Vector> vectors) {
      this.vectors.addAll(vectors);
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

    public UpsertRequest build() {
      return new UpsertRequest(vectors, namespace);
    }
  }
}
