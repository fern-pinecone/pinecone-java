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
    builder = CreateRequest.Builder.class
)
public final class CreateRequest {
  private final String name;

  private final int dimension;

  private final Optional<String> indexType;

  private final Optional<String> metric;

  private final Optional<Integer> pods;

  private final Optional<Integer> replicas;

  private final Optional<Integer> shards;

  private final Optional<String> podType;

  private final Optional<Object> indexConfig;

  private final Optional<IndexMetadataConfig> metadataConfig;

  private final Optional<String> sourceCollection;

  private int _cachedHashCode;

  CreateRequest(String name, int dimension, Optional<String> indexType, Optional<String> metric,
      Optional<Integer> pods, Optional<Integer> replicas, Optional<Integer> shards,
      Optional<String> podType, Optional<Object> indexConfig,
      Optional<IndexMetadataConfig> metadataConfig, Optional<String> sourceCollection) {
    this.name = name;
    this.dimension = dimension;
    this.indexType = indexType;
    this.metric = metric;
    this.pods = pods;
    this.replicas = replicas;
    this.shards = shards;
    this.podType = podType;
    this.indexConfig = indexConfig;
    this.metadataConfig = metadataConfig;
    this.sourceCollection = sourceCollection;
  }

  /**
   * @return The name of the index to be created. The maximum length is 45 characters.
   */
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  /**
   * @return The dimensions of the vectors to be inserted in the index
   */
  @JsonProperty("dimension")
  public int getDimension() {
    return dimension;
  }

  /**
   * @return The type of vector index. Pinecone supports 'approximated'.
   */
  @JsonProperty("index_type")
  public Optional<String> getIndexType() {
    return indexType;
  }

  /**
   * @return The distance metric to be used for similarity search. You can use 'euclidean', 'cosine', or 'dotproduct'.
   */
  @JsonProperty("metric")
  public Optional<String> getMetric() {
    return metric;
  }

  /**
   * @return The number of pods for the index to use,including replicas.
   */
  @JsonProperty("pods")
  public Optional<Integer> getPods() {
    return pods;
  }

  /**
   * @return The number of replicas. Replicas duplicate your index. They provide higher availability and throughput.
   */
  @JsonProperty("replicas")
  public Optional<Integer> getReplicas() {
    return replicas;
  }

  /**
   * @return The number of shards to be used in the index.
   */
  @JsonProperty("shards")
  public Optional<Integer> getShards() {
    return shards;
  }

  /**
   * @return The type of pod to use. One of <code>s1</code>, <code>p1</code>, or <code>p2</code> appended with <code>.</code> and one of <code>x1</code>, <code>x2</code>, <code>x4</code>, or <code>x8</code>.
   */
  @JsonProperty("pod_type")
  public Optional<String> getPodType() {
    return podType;
  }

  @JsonProperty("index_config")
  public Optional<Object> getIndexConfig() {
    return indexConfig;
  }

  /**
   * @return Configuration for the behavior of Pinecone's internal metadata index. By default, all metadata is indexed; when <code>metadata_config</code> is present, only specified metadata fields are indexed. To specify metadata fields to index, provide a JSON object of the following form:
   * <pre><code>{&quot;indexed&quot;: [&quot;example_metadata_field&quot;]} 
   * </code></pre>
   */
  @JsonProperty("metadata_config")
  public Optional<IndexMetadataConfig> getMetadataConfig() {
    return metadataConfig;
  }

  /**
   * @return The name of the collection to create an index from
   */
  @JsonProperty("source_collection")
  public Optional<String> getSourceCollection() {
    return sourceCollection;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateRequest && equalTo((CreateRequest) other);
  }

  private boolean equalTo(CreateRequest other) {
    return name.equals(other.name) && dimension == other.dimension && indexType.equals(other.indexType) && metric.equals(other.metric) && pods.equals(other.pods) && replicas.equals(other.replicas) && shards.equals(other.shards) && podType.equals(other.podType) && indexConfig.equals(other.indexConfig) && metadataConfig.equals(other.metadataConfig) && sourceCollection.equals(other.sourceCollection);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.dimension, this.indexType, this.metric, this.pods, this.replicas, this.shards, this.podType, this.indexConfig, this.metadataConfig, this.sourceCollection);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateRequest{" + "name: " + name + ", dimension: " + dimension + ", indexType: " + indexType + ", metric: " + metric + ", pods: " + pods + ", replicas: " + replicas + ", shards: " + shards + ", podType: " + podType + ", indexConfig: " + indexConfig + ", metadataConfig: " + metadataConfig + ", sourceCollection: " + sourceCollection + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    DimensionStage name(String name);

    Builder from(CreateRequest other);
  }

  public interface DimensionStage {
    _FinalStage dimension(int dimension);
  }

  public interface _FinalStage {
    CreateRequest build();

    _FinalStage indexType(Optional<String> indexType);

    _FinalStage indexType(String indexType);

    _FinalStage metric(Optional<String> metric);

    _FinalStage metric(String metric);

    _FinalStage pods(Optional<Integer> pods);

    _FinalStage pods(Integer pods);

    _FinalStage replicas(Optional<Integer> replicas);

    _FinalStage replicas(Integer replicas);

    _FinalStage shards(Optional<Integer> shards);

    _FinalStage shards(Integer shards);

    _FinalStage podType(Optional<String> podType);

    _FinalStage podType(String podType);

    _FinalStage indexConfig(Optional<Object> indexConfig);

    _FinalStage indexConfig(Object indexConfig);

    _FinalStage metadataConfig(Optional<IndexMetadataConfig> metadataConfig);

    _FinalStage metadataConfig(IndexMetadataConfig metadataConfig);

    _FinalStage sourceCollection(Optional<String> sourceCollection);

    _FinalStage sourceCollection(String sourceCollection);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, DimensionStage, _FinalStage {
    private String name;

    private int dimension;

    private Optional<String> sourceCollection = Optional.empty();

    private Optional<IndexMetadataConfig> metadataConfig = Optional.empty();

    private Optional<Object> indexConfig = Optional.empty();

    private Optional<String> podType = Optional.empty();

    private Optional<Integer> shards = Optional.empty();

    private Optional<Integer> replicas = Optional.empty();

    private Optional<Integer> pods = Optional.empty();

    private Optional<String> metric = Optional.empty();

    private Optional<String> indexType = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(CreateRequest other) {
      name(other.getName());
      dimension(other.getDimension());
      indexType(other.getIndexType());
      metric(other.getMetric());
      pods(other.getPods());
      replicas(other.getReplicas());
      shards(other.getShards());
      podType(other.getPodType());
      indexConfig(other.getIndexConfig());
      metadataConfig(other.getMetadataConfig());
      sourceCollection(other.getSourceCollection());
      return this;
    }

    /**
     * <p>The name of the index to be created. The maximum length is 45 characters.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("name")
    public DimensionStage name(String name) {
      this.name = name;
      return this;
    }

    /**
     * <p>The dimensions of the vectors to be inserted in the index</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("dimension")
    public _FinalStage dimension(int dimension) {
      this.dimension = dimension;
      return this;
    }

    /**
     * <p>The name of the collection to create an index from</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage sourceCollection(String sourceCollection) {
      this.sourceCollection = Optional.of(sourceCollection);
      return this;
    }

    @Override
    @JsonSetter(
        value = "source_collection",
        nulls = Nulls.SKIP
    )
    public _FinalStage sourceCollection(Optional<String> sourceCollection) {
      this.sourceCollection = sourceCollection;
      return this;
    }

    /**
     * <p>Configuration for the behavior of Pinecone's internal metadata index. By default, all metadata is indexed; when <code>metadata_config</code> is present, only specified metadata fields are indexed. To specify metadata fields to index, provide a JSON object of the following form:</p>
     * <pre><code>{&quot;indexed&quot;: [&quot;example_metadata_field&quot;]} 
     * </code></pre>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage metadataConfig(IndexMetadataConfig metadataConfig) {
      this.metadataConfig = Optional.of(metadataConfig);
      return this;
    }

    @Override
    @JsonSetter(
        value = "metadata_config",
        nulls = Nulls.SKIP
    )
    public _FinalStage metadataConfig(Optional<IndexMetadataConfig> metadataConfig) {
      this.metadataConfig = metadataConfig;
      return this;
    }

    @Override
    public _FinalStage indexConfig(Object indexConfig) {
      this.indexConfig = Optional.of(indexConfig);
      return this;
    }

    @Override
    @JsonSetter(
        value = "index_config",
        nulls = Nulls.SKIP
    )
    public _FinalStage indexConfig(Optional<Object> indexConfig) {
      this.indexConfig = indexConfig;
      return this;
    }

    /**
     * <p>The type of pod to use. One of <code>s1</code>, <code>p1</code>, or <code>p2</code> appended with <code>.</code> and one of <code>x1</code>, <code>x2</code>, <code>x4</code>, or <code>x8</code>.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage podType(String podType) {
      this.podType = Optional.of(podType);
      return this;
    }

    @Override
    @JsonSetter(
        value = "pod_type",
        nulls = Nulls.SKIP
    )
    public _FinalStage podType(Optional<String> podType) {
      this.podType = podType;
      return this;
    }

    /**
     * <p>The number of shards to be used in the index.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage shards(Integer shards) {
      this.shards = Optional.of(shards);
      return this;
    }

    @Override
    @JsonSetter(
        value = "shards",
        nulls = Nulls.SKIP
    )
    public _FinalStage shards(Optional<Integer> shards) {
      this.shards = shards;
      return this;
    }

    /**
     * <p>The number of replicas. Replicas duplicate your index. They provide higher availability and throughput.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage replicas(Integer replicas) {
      this.replicas = Optional.of(replicas);
      return this;
    }

    @Override
    @JsonSetter(
        value = "replicas",
        nulls = Nulls.SKIP
    )
    public _FinalStage replicas(Optional<Integer> replicas) {
      this.replicas = replicas;
      return this;
    }

    /**
     * <p>The number of pods for the index to use,including replicas.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage pods(Integer pods) {
      this.pods = Optional.of(pods);
      return this;
    }

    @Override
    @JsonSetter(
        value = "pods",
        nulls = Nulls.SKIP
    )
    public _FinalStage pods(Optional<Integer> pods) {
      this.pods = pods;
      return this;
    }

    /**
     * <p>The distance metric to be used for similarity search. You can use 'euclidean', 'cosine', or 'dotproduct'.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage metric(String metric) {
      this.metric = Optional.of(metric);
      return this;
    }

    @Override
    @JsonSetter(
        value = "metric",
        nulls = Nulls.SKIP
    )
    public _FinalStage metric(Optional<String> metric) {
      this.metric = metric;
      return this;
    }

    /**
     * <p>The type of vector index. Pinecone supports 'approximated'.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage indexType(String indexType) {
      this.indexType = Optional.of(indexType);
      return this;
    }

    @Override
    @JsonSetter(
        value = "index_type",
        nulls = Nulls.SKIP
    )
    public _FinalStage indexType(Optional<String> indexType) {
      this.indexType = indexType;
      return this;
    }

    @Override
    public CreateRequest build() {
      return new CreateRequest(name, dimension, indexType, metric, pods, replicas, shards, podType, indexConfig, metadataConfig, sourceCollection);
    }
  }
}
