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
    builder = CollectionMeta.Builder.class
)
public final class CollectionMeta {
  private final Optional<String> name;

  private final Optional<Integer> size;

  private final Optional<String> status;

  private final Optional<Integer> dimension;

  private final Optional<Integer> vectorCount;

  private int _cachedHashCode;

  CollectionMeta(Optional<String> name, Optional<Integer> size, Optional<String> status,
      Optional<Integer> dimension, Optional<Integer> vectorCount) {
    this.name = name;
    this.size = size;
    this.status = status;
    this.dimension = dimension;
    this.vectorCount = vectorCount;
  }

  @JsonProperty("name")
  public Optional<String> getName() {
    return name;
  }

  /**
   * @return The size of the collection in bytes.
   */
  @JsonProperty("size")
  public Optional<Integer> getSize() {
    return size;
  }

  /**
   * @return The status of the collection.
   */
  @JsonProperty("status")
  public Optional<String> getStatus() {
    return status;
  }

  /**
   * @return The dimension of the vectors in the collection.
   */
  @JsonProperty("dimension")
  public Optional<Integer> getDimension() {
    return dimension;
  }

  /**
   * @return The number of vectors in the collection.
   */
  @JsonProperty("vector_count")
  public Optional<Integer> getVectorCount() {
    return vectorCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CollectionMeta && equalTo((CollectionMeta) other);
  }

  private boolean equalTo(CollectionMeta other) {
    return name.equals(other.name) && size.equals(other.size) && status.equals(other.status) && dimension.equals(other.dimension) && vectorCount.equals(other.vectorCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.size, this.status, this.dimension, this.vectorCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CollectionMeta{" + "name: " + name + ", size: " + size + ", status: " + status + ", dimension: " + dimension + ", vectorCount: " + vectorCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> name = Optional.empty();

    private Optional<Integer> size = Optional.empty();

    private Optional<String> status = Optional.empty();

    private Optional<Integer> dimension = Optional.empty();

    private Optional<Integer> vectorCount = Optional.empty();

    private Builder() {
    }

    public Builder from(CollectionMeta other) {
      name(other.getName());
      size(other.getSize());
      status(other.getStatus());
      dimension(other.getDimension());
      vectorCount(other.getVectorCount());
      return this;
    }

    @JsonSetter(
        value = "name",
        nulls = Nulls.SKIP
    )
    public Builder name(Optional<String> name) {
      this.name = name;
      return this;
    }

    public Builder name(String name) {
      this.name = Optional.of(name);
      return this;
    }

    @JsonSetter(
        value = "size",
        nulls = Nulls.SKIP
    )
    public Builder size(Optional<Integer> size) {
      this.size = size;
      return this;
    }

    public Builder size(Integer size) {
      this.size = Optional.of(size);
      return this;
    }

    @JsonSetter(
        value = "status",
        nulls = Nulls.SKIP
    )
    public Builder status(Optional<String> status) {
      this.status = status;
      return this;
    }

    public Builder status(String status) {
      this.status = Optional.of(status);
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
        value = "vector_count",
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

    public CollectionMeta build() {
      return new CollectionMeta(name, size, status, dimension, vectorCount);
    }
  }
}
