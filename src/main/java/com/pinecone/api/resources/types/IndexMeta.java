package com.pinecone.api.resources.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = IndexMeta.Builder.class
)
public final class IndexMeta {
  private final Optional<IndexData> database;

  private final Optional<IndexStatus> status;

  private int _cachedHashCode;

  IndexMeta(Optional<IndexData> database, Optional<IndexStatus> status) {
    this.database = database;
    this.status = status;
  }

  @JsonProperty("database")
  public Optional<IndexData> getDatabase() {
    return database;
  }

  @JsonProperty("status")
  public Optional<IndexStatus> getStatus() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof IndexMeta && equalTo((IndexMeta) other);
  }

  private boolean equalTo(IndexMeta other) {
    return database.equals(other.database) && status.equals(other.status);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.database, this.status);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "IndexMeta{" + "database: " + database + ", status: " + status + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<IndexData> database = Optional.empty();

    private Optional<IndexStatus> status = Optional.empty();

    private Builder() {
    }

    public Builder from(IndexMeta other) {
      database(other.getDatabase());
      status(other.getStatus());
      return this;
    }

    @JsonSetter(
        value = "database",
        nulls = Nulls.SKIP
    )
    public Builder database(Optional<IndexData> database) {
      this.database = database;
      return this;
    }

    public Builder database(IndexData database) {
      this.database = Optional.of(database);
      return this;
    }

    @JsonSetter(
        value = "status",
        nulls = Nulls.SKIP
    )
    public Builder status(Optional<IndexStatus> status) {
      this.status = status;
      return this;
    }

    public Builder status(IndexStatus status) {
      this.status = Optional.of(status);
      return this;
    }

    public IndexMeta build() {
      return new IndexMeta(database, status);
    }
  }
}
