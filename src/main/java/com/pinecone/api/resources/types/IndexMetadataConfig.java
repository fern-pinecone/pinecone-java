package com.pinecone.api.resources.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = IndexMetadataConfig.Builder.class
)
public final class IndexMetadataConfig {
  private final Optional<List<String>> indexed;

  private int _cachedHashCode;

  IndexMetadataConfig(Optional<List<String>> indexed) {
    this.indexed = indexed;
  }

  /**
   * @return A list of metadata fields to index.
   */
  @JsonProperty("indexed")
  public Optional<List<String>> getIndexed() {
    return indexed;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof IndexMetadataConfig && equalTo((IndexMetadataConfig) other);
  }

  private boolean equalTo(IndexMetadataConfig other) {
    return indexed.equals(other.indexed);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.indexed);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "IndexMetadataConfig{" + "indexed: " + indexed + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<List<String>> indexed = Optional.empty();

    private Builder() {
    }

    public Builder from(IndexMetadataConfig other) {
      indexed(other.getIndexed());
      return this;
    }

    @JsonSetter(
        value = "indexed",
        nulls = Nulls.SKIP
    )
    public Builder indexed(Optional<List<String>> indexed) {
      this.indexed = indexed;
      return this;
    }

    public Builder indexed(List<String> indexed) {
      this.indexed = Optional.of(indexed);
      return this;
    }

    public IndexMetadataConfig build() {
      return new IndexMetadataConfig(indexed);
    }
  }
}
