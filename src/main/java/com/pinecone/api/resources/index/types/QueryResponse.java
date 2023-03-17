package com.pinecone.api.resources.index.types;

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
    builder = QueryResponse.Builder.class
)
public final class QueryResponse {
  private final Optional<List<ScoredVector>> matches;

  private final Optional<String> namespace;

  private int _cachedHashCode;

  QueryResponse(Optional<List<ScoredVector>> matches, Optional<String> namespace) {
    this.matches = matches;
    this.namespace = namespace;
  }

  /**
   * @return The matches for the vectors.
   */
  @JsonProperty("matches")
  public Optional<List<ScoredVector>> getMatches() {
    return matches;
  }

  /**
   * @return The namespace for the vectors.
   */
  @JsonProperty("namespace")
  public Optional<String> getNamespace() {
    return namespace;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof QueryResponse && equalTo((QueryResponse) other);
  }

  private boolean equalTo(QueryResponse other) {
    return matches.equals(other.matches) && namespace.equals(other.namespace);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.matches, this.namespace);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "QueryResponse{" + "matches: " + matches + ", namespace: " + namespace + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<List<ScoredVector>> matches = Optional.empty();

    private Optional<String> namespace = Optional.empty();

    private Builder() {
    }

    public Builder from(QueryResponse other) {
      matches(other.getMatches());
      namespace(other.getNamespace());
      return this;
    }

    @JsonSetter(
        value = "matches",
        nulls = Nulls.SKIP
    )
    public Builder matches(Optional<List<ScoredVector>> matches) {
      this.matches = matches;
      return this;
    }

    public Builder matches(List<ScoredVector> matches) {
      this.matches = Optional.of(matches);
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

    public QueryResponse build() {
      return new QueryResponse(matches, namespace);
    }
  }
}
