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
    builder = IndexData.Builder.class
)
public final class IndexData {
  private final Optional<String> name;

  private final Optional<Integer> dimension;

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

  IndexData(Optional<String> name, Optional<Integer> dimension, Optional<String> indexType,
      Optional<String> metric, Optional<Integer> pods, Optional<Integer> replicas,
      Optional<Integer> shards, Optional<String> podType, Optional<Object> indexConfig,
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

  @JsonProperty("name")
  public Optional<String> getName() {
    return name;
  }

  @JsonProperty("dimension")
  public Optional<Integer> getDimension() {
    return dimension;
  }

  @JsonProperty("index_type")
  public Optional<String> getIndexType() {
    return indexType;
  }

  @JsonProperty("metric")
  public Optional<String> getMetric() {
    return metric;
  }

  @JsonProperty("pods")
  public Optional<Integer> getPods() {
    return pods;
  }

  @JsonProperty("replicas")
  public Optional<Integer> getReplicas() {
    return replicas;
  }

  @JsonProperty("shards")
  public Optional<Integer> getShards() {
    return shards;
  }

  @JsonProperty("pod_type")
  public Optional<String> getPodType() {
    return podType;
  }

  @JsonProperty("index_config")
  public Optional<Object> getIndexConfig() {
    return indexConfig;
  }

  @JsonProperty("metadata_config")
  public Optional<IndexMetadataConfig> getMetadataConfig() {
    return metadataConfig;
  }

  @JsonProperty("source_collection")
  public Optional<String> getSourceCollection() {
    return sourceCollection;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof IndexData && equalTo((IndexData) other);
  }

  private boolean equalTo(IndexData other) {
    return name.equals(other.name) && dimension.equals(other.dimension) && indexType.equals(other.indexType) && metric.equals(other.metric) && pods.equals(other.pods) && replicas.equals(other.replicas) && shards.equals(other.shards) && podType.equals(other.podType) && indexConfig.equals(other.indexConfig) && metadataConfig.equals(other.metadataConfig) && sourceCollection.equals(other.sourceCollection);
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
    return "IndexData{" + "name: " + name + ", dimension: " + dimension + ", indexType: " + indexType + ", metric: " + metric + ", pods: " + pods + ", replicas: " + replicas + ", shards: " + shards + ", podType: " + podType + ", indexConfig: " + indexConfig + ", metadataConfig: " + metadataConfig + ", sourceCollection: " + sourceCollection + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> name = Optional.empty();

    private Optional<Integer> dimension = Optional.empty();

    private Optional<String> indexType = Optional.empty();

    private Optional<String> metric = Optional.empty();

    private Optional<Integer> pods = Optional.empty();

    private Optional<Integer> replicas = Optional.empty();

    private Optional<Integer> shards = Optional.empty();

    private Optional<String> podType = Optional.empty();

    private Optional<Object> indexConfig = Optional.empty();

    private Optional<IndexMetadataConfig> metadataConfig = Optional.empty();

    private Optional<String> sourceCollection = Optional.empty();

    private Builder() {
    }

    public Builder from(IndexData other) {
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
        value = "index_type",
        nulls = Nulls.SKIP
    )
    public Builder indexType(Optional<String> indexType) {
      this.indexType = indexType;
      return this;
    }

    public Builder indexType(String indexType) {
      this.indexType = Optional.of(indexType);
      return this;
    }

    @JsonSetter(
        value = "metric",
        nulls = Nulls.SKIP
    )
    public Builder metric(Optional<String> metric) {
      this.metric = metric;
      return this;
    }

    public Builder metric(String metric) {
      this.metric = Optional.of(metric);
      return this;
    }

    @JsonSetter(
        value = "pods",
        nulls = Nulls.SKIP
    )
    public Builder pods(Optional<Integer> pods) {
      this.pods = pods;
      return this;
    }

    public Builder pods(Integer pods) {
      this.pods = Optional.of(pods);
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
        value = "shards",
        nulls = Nulls.SKIP
    )
    public Builder shards(Optional<Integer> shards) {
      this.shards = shards;
      return this;
    }

    public Builder shards(Integer shards) {
      this.shards = Optional.of(shards);
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

    @JsonSetter(
        value = "index_config",
        nulls = Nulls.SKIP
    )
    public Builder indexConfig(Optional<Object> indexConfig) {
      this.indexConfig = indexConfig;
      return this;
    }

    public Builder indexConfig(Object indexConfig) {
      this.indexConfig = Optional.of(indexConfig);
      return this;
    }

    @JsonSetter(
        value = "metadata_config",
        nulls = Nulls.SKIP
    )
    public Builder metadataConfig(Optional<IndexMetadataConfig> metadataConfig) {
      this.metadataConfig = metadataConfig;
      return this;
    }

    public Builder metadataConfig(IndexMetadataConfig metadataConfig) {
      this.metadataConfig = Optional.of(metadataConfig);
      return this;
    }

    @JsonSetter(
        value = "source_collection",
        nulls = Nulls.SKIP
    )
    public Builder sourceCollection(Optional<String> sourceCollection) {
      this.sourceCollection = sourceCollection;
      return this;
    }

    public Builder sourceCollection(String sourceCollection) {
      this.sourceCollection = Optional.of(sourceCollection);
      return this;
    }

    public IndexData build() {
      return new IndexData(name, dimension, indexType, metric, pods, replicas, shards, podType, indexConfig, metadataConfig, sourceCollection);
    }
  }
}
