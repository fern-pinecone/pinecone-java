package com.pinecone.api.resources.index.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = DeleteRequest.Builder.class
)
public final class DeleteRequest {
  private final Optional<List<String>> ids;

  private final Optional<Boolean> deleteAll;

  private final Optional<String> namespace;

  private final Optional<Map<String, Object>> filter;

  private int _cachedHashCode;

  DeleteRequest(Optional<List<String>> ids, Optional<Boolean> deleteAll, Optional<String> namespace,
      Optional<Map<String, Object>> filter) {
    this.ids = ids;
    this.deleteAll = deleteAll;
    this.namespace = namespace;
    this.filter = filter;
  }

  /**
   * @return Vectors to delete.
   */
  @JsonProperty("ids")
  public Optional<List<String>> getIds() {
    return ids;
  }

  /**
   * @return This indicates that all vectors in the index namespace should be deleted.
   */
  @JsonProperty("deleteAll")
  public Optional<Boolean> getDeleteAll() {
    return deleteAll;
  }

  /**
   * @return The namespace to delete vectors from, if applicable.
   */
  @JsonProperty("namespace")
  public Optional<String> getNamespace() {
    return namespace;
  }

  /**
   * @return If specified, the metadata filter here will be used to select the vectors to delete. This is mutually exclusive
   * with specifying ids to delete in the ids param or using delete_all=True.
   * See https://www.pinecone.io/docs/metadata-filtering/.
   */
  @JsonProperty("filter")
  public Optional<Map<String, Object>> getFilter() {
    return filter;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof DeleteRequest && equalTo((DeleteRequest) other);
  }

  private boolean equalTo(DeleteRequest other) {
    return ids.equals(other.ids) && deleteAll.equals(other.deleteAll) && namespace.equals(other.namespace) && filter.equals(other.filter);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ids, this.deleteAll, this.namespace, this.filter);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "DeleteRequest{" + "ids: " + ids + ", deleteAll: " + deleteAll + ", namespace: " + namespace + ", filter: " + filter + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<List<String>> ids = Optional.empty();

    private Optional<Boolean> deleteAll = Optional.empty();

    private Optional<String> namespace = Optional.empty();

    private Optional<Map<String, Object>> filter = Optional.empty();

    private Builder() {
    }

    public Builder from(DeleteRequest other) {
      ids(other.getIds());
      deleteAll(other.getDeleteAll());
      namespace(other.getNamespace());
      filter(other.getFilter());
      return this;
    }

    @JsonSetter(
        value = "ids",
        nulls = Nulls.SKIP
    )
    public Builder ids(Optional<List<String>> ids) {
      this.ids = ids;
      return this;
    }

    public Builder ids(List<String> ids) {
      this.ids = Optional.of(ids);
      return this;
    }

    @JsonSetter(
        value = "deleteAll",
        nulls = Nulls.SKIP
    )
    public Builder deleteAll(Optional<Boolean> deleteAll) {
      this.deleteAll = deleteAll;
      return this;
    }

    public Builder deleteAll(Boolean deleteAll) {
      this.deleteAll = Optional.of(deleteAll);
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

    public DeleteRequest build() {
      return new DeleteRequest(ids, deleteAll, namespace, filter);
    }
  }
}
