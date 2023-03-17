package com.pinecone.api.resources.index.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = QueryRequest.Builder.class
)
public final class QueryRequest {
  private final Optional<String> namespace;

  private final int topK;

  private final Optional<Map<String, Object>> filter;

  private final Optional<Boolean> includeValues;

  private final Optional<Boolean> includeMetadata;

  private final Optional<List<QueryVector>> queries;

  private final Optional<List<Double>> vector;

  private final Optional<SparseValues> sparseVector;

  private final Optional<String> id;

  private int _cachedHashCode;

  QueryRequest(Optional<String> namespace, int topK, Optional<Map<String, Object>> filter,
      Optional<Boolean> includeValues, Optional<Boolean> includeMetadata,
      Optional<List<QueryVector>> queries, Optional<List<Double>> vector,
      Optional<SparseValues> sparseVector, Optional<String> id) {
    this.namespace = namespace;
    this.topK = topK;
    this.filter = filter;
    this.includeValues = includeValues;
    this.includeMetadata = includeMetadata;
    this.queries = queries;
    this.vector = vector;
    this.sparseVector = sparseVector;
    this.id = id;
  }

  /**
   * @return The namespace to query.
   */
  @JsonProperty("namespace")
  public Optional<String> getNamespace() {
    return namespace;
  }

  /**
   * @return The number of results to return for each query.
   */
  @JsonProperty("topK")
  public int getTopK() {
    return topK;
  }

  /**
   * @return The filter to apply. You can use vector metadata to limit your search. See https://www.pinecone.io/docs/metadata-filtering/.
   */
  @JsonProperty("filter")
  public Optional<Map<String, Object>> getFilter() {
    return filter;
  }

  /**
   * @return Indicates whether vector values are included in the response.
   */
  @JsonProperty("includeValues")
  public Optional<Boolean> getIncludeValues() {
    return includeValues;
  }

  /**
   * @return Indicates whether metadata is included in the response as well as the ids.
   */
  @JsonProperty("includeMetadata")
  public Optional<Boolean> getIncludeMetadata() {
    return includeMetadata;
  }

  /**
   * @return DEPRECATED. The query vectors. Each <code>query()</code> request can contain only one of the parameters <code>queries</code>, <code>vector</code>, or  <code>id</code>.
   */
  @JsonProperty("queries")
  public Optional<List<QueryVector>> getQueries() {
    return queries;
  }

  /**
   * @return The query vector. This should be the same length as the dimension of the index being queried. Each <code>query()</code> request can contain only one of the parameters <code>id</code> or <code>vector</code>.
   */
  @JsonProperty("vector")
  public Optional<List<Double>> getVector() {
    return vector;
  }

  @JsonProperty("sparseVector")
  public Optional<SparseValues> getSparseVector() {
    return sparseVector;
  }

  /**
   * @return The unique ID of the vector to be used as a query vector. Each <code>query()</code> request can contain only one of the parameters <code>queries</code>, <code>vector</code>, or  <code>id</code>.
   */
  @JsonProperty("id")
  public Optional<String> getId() {
    return id;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof QueryRequest && equalTo((QueryRequest) other);
  }

  private boolean equalTo(QueryRequest other) {
    return namespace.equals(other.namespace) && topK == other.topK && filter.equals(other.filter) && includeValues.equals(other.includeValues) && includeMetadata.equals(other.includeMetadata) && queries.equals(other.queries) && vector.equals(other.vector) && sparseVector.equals(other.sparseVector) && id.equals(other.id);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.namespace, this.topK, this.filter, this.includeValues, this.includeMetadata, this.queries, this.vector, this.sparseVector, this.id);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "QueryRequest{" + "namespace: " + namespace + ", topK: " + topK + ", filter: " + filter + ", includeValues: " + includeValues + ", includeMetadata: " + includeMetadata + ", queries: " + queries + ", vector: " + vector + ", sparseVector: " + sparseVector + ", id: " + id + "}";
  }

  public static TopKStage builder() {
    return new Builder();
  }

  public interface TopKStage {
    _FinalStage topK(int topK);

    Builder from(QueryRequest other);
  }

  public interface _FinalStage {
    QueryRequest build();

    _FinalStage namespace(Optional<String> namespace);

    _FinalStage namespace(String namespace);

    _FinalStage filter(Optional<Map<String, Object>> filter);

    _FinalStage filter(Map<String, Object> filter);

    _FinalStage includeValues(Optional<Boolean> includeValues);

    _FinalStage includeValues(Boolean includeValues);

    _FinalStage includeMetadata(Optional<Boolean> includeMetadata);

    _FinalStage includeMetadata(Boolean includeMetadata);

    _FinalStage queries(Optional<List<QueryVector>> queries);

    _FinalStage queries(List<QueryVector> queries);

    _FinalStage vector(Optional<List<Double>> vector);

    _FinalStage vector(List<Double> vector);

    _FinalStage sparseVector(Optional<SparseValues> sparseVector);

    _FinalStage sparseVector(SparseValues sparseVector);

    _FinalStage id(Optional<String> id);

    _FinalStage id(String id);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TopKStage, _FinalStage {
    private int topK;

    private Optional<String> id = Optional.empty();

    private Optional<SparseValues> sparseVector = Optional.empty();

    private Optional<List<Double>> vector = Optional.empty();

    private Optional<List<QueryVector>> queries = Optional.empty();

    private Optional<Boolean> includeMetadata = Optional.empty();

    private Optional<Boolean> includeValues = Optional.empty();

    private Optional<Map<String, Object>> filter = Optional.empty();

    private Optional<String> namespace = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(QueryRequest other) {
      namespace(other.getNamespace());
      topK(other.getTopK());
      filter(other.getFilter());
      includeValues(other.getIncludeValues());
      includeMetadata(other.getIncludeMetadata());
      queries(other.getQueries());
      vector(other.getVector());
      sparseVector(other.getSparseVector());
      id(other.getId());
      return this;
    }

    /**
     * <p>The number of results to return for each query.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("topK")
    public _FinalStage topK(int topK) {
      this.topK = topK;
      return this;
    }

    /**
     * <p>The unique ID of the vector to be used as a query vector. Each <code>query()</code> request can contain only one of the parameters <code>queries</code>, <code>vector</code>, or  <code>id</code>.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage id(String id) {
      this.id = Optional.of(id);
      return this;
    }

    @Override
    @JsonSetter(
        value = "id",
        nulls = Nulls.SKIP
    )
    public _FinalStage id(Optional<String> id) {
      this.id = id;
      return this;
    }

    @Override
    public _FinalStage sparseVector(SparseValues sparseVector) {
      this.sparseVector = Optional.of(sparseVector);
      return this;
    }

    @Override
    @JsonSetter(
        value = "sparseVector",
        nulls = Nulls.SKIP
    )
    public _FinalStage sparseVector(Optional<SparseValues> sparseVector) {
      this.sparseVector = sparseVector;
      return this;
    }

    /**
     * <p>The query vector. This should be the same length as the dimension of the index being queried. Each <code>query()</code> request can contain only one of the parameters <code>id</code> or <code>vector</code>.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage vector(List<Double> vector) {
      this.vector = Optional.of(vector);
      return this;
    }

    @Override
    @JsonSetter(
        value = "vector",
        nulls = Nulls.SKIP
    )
    public _FinalStage vector(Optional<List<Double>> vector) {
      this.vector = vector;
      return this;
    }

    /**
     * <p>DEPRECATED. The query vectors. Each <code>query()</code> request can contain only one of the parameters <code>queries</code>, <code>vector</code>, or  <code>id</code>.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage queries(List<QueryVector> queries) {
      this.queries = Optional.of(queries);
      return this;
    }

    @Override
    @JsonSetter(
        value = "queries",
        nulls = Nulls.SKIP
    )
    public _FinalStage queries(Optional<List<QueryVector>> queries) {
      this.queries = queries;
      return this;
    }

    /**
     * <p>Indicates whether metadata is included in the response as well as the ids.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage includeMetadata(Boolean includeMetadata) {
      this.includeMetadata = Optional.of(includeMetadata);
      return this;
    }

    @Override
    @JsonSetter(
        value = "includeMetadata",
        nulls = Nulls.SKIP
    )
    public _FinalStage includeMetadata(Optional<Boolean> includeMetadata) {
      this.includeMetadata = includeMetadata;
      return this;
    }

    /**
     * <p>Indicates whether vector values are included in the response.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage includeValues(Boolean includeValues) {
      this.includeValues = Optional.of(includeValues);
      return this;
    }

    @Override
    @JsonSetter(
        value = "includeValues",
        nulls = Nulls.SKIP
    )
    public _FinalStage includeValues(Optional<Boolean> includeValues) {
      this.includeValues = includeValues;
      return this;
    }

    /**
     * <p>The filter to apply. You can use vector metadata to limit your search. See https://www.pinecone.io/docs/metadata-filtering/.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage filter(Map<String, Object> filter) {
      this.filter = Optional.of(filter);
      return this;
    }

    @Override
    @JsonSetter(
        value = "filter",
        nulls = Nulls.SKIP
    )
    public _FinalStage filter(Optional<Map<String, Object>> filter) {
      this.filter = filter;
      return this;
    }

    /**
     * <p>The namespace to query.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage namespace(String namespace) {
      this.namespace = Optional.of(namespace);
      return this;
    }

    @Override
    @JsonSetter(
        value = "namespace",
        nulls = Nulls.SKIP
    )
    public _FinalStage namespace(Optional<String> namespace) {
      this.namespace = namespace;
      return this;
    }

    @Override
    public QueryRequest build() {
      return new QueryRequest(namespace, topK, filter, includeValues, includeMetadata, queries, vector, sparseVector, id);
    }
  }
}
