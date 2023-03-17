package com.pinecone.api.resources.index.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = ScoredVector.Builder.class
)
public final class ScoredVector {
  private final String id;

  private final Optional<Double> score;

  private final Optional<List<Double>> values;

  private final Optional<SparseValues> sparseValues;

  private final Optional<Map<String, Object>> metadata;

  private int _cachedHashCode;

  ScoredVector(String id, Optional<Double> score, Optional<List<Double>> values,
      Optional<SparseValues> sparseValues, Optional<Map<String, Object>> metadata) {
    this.id = id;
    this.score = score;
    this.values = values;
    this.sparseValues = sparseValues;
    this.metadata = metadata;
  }

  /**
   * @return This is the vector's unique id.
   */
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  /**
   * @return This is a measure of similarity between this vector and the query vector.  The higher the score, the more they are similar.
   */
  @JsonProperty("score")
  public Optional<Double> getScore() {
    return score;
  }

  /**
   * @return This is the vector data, if it is requested.
   */
  @JsonProperty("values")
  public Optional<List<Double>> getValues() {
    return values;
  }

  @JsonProperty("sparseValues")
  public Optional<SparseValues> getSparseValues() {
    return sparseValues;
  }

  /**
   * @return This is the metadata, if it is requested.
   */
  @JsonProperty("metadata")
  public Optional<Map<String, Object>> getMetadata() {
    return metadata;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ScoredVector && equalTo((ScoredVector) other);
  }

  private boolean equalTo(ScoredVector other) {
    return id.equals(other.id) && score.equals(other.score) && values.equals(other.values) && sparseValues.equals(other.sparseValues) && metadata.equals(other.metadata);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.score, this.values, this.sparseValues, this.metadata);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ScoredVector{" + "id: " + id + ", score: " + score + ", values: " + values + ", sparseValues: " + sparseValues + ", metadata: " + metadata + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    _FinalStage id(String id);

    Builder from(ScoredVector other);
  }

  public interface _FinalStage {
    ScoredVector build();

    _FinalStage score(Optional<Double> score);

    _FinalStage score(Double score);

    _FinalStage values(Optional<List<Double>> values);

    _FinalStage values(List<Double> values);

    _FinalStage sparseValues(Optional<SparseValues> sparseValues);

    _FinalStage sparseValues(SparseValues sparseValues);

    _FinalStage metadata(Optional<Map<String, Object>> metadata);

    _FinalStage metadata(Map<String, Object> metadata);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdStage, _FinalStage {
    private String id;

    private Optional<Map<String, Object>> metadata = Optional.empty();

    private Optional<SparseValues> sparseValues = Optional.empty();

    private Optional<List<Double>> values = Optional.empty();

    private Optional<Double> score = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(ScoredVector other) {
      id(other.getId());
      score(other.getScore());
      values(other.getValues());
      sparseValues(other.getSparseValues());
      metadata(other.getMetadata());
      return this;
    }

    /**
     * <p>This is the vector's unique id.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("id")
    public _FinalStage id(String id) {
      this.id = id;
      return this;
    }

    /**
     * <p>This is the metadata, if it is requested.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage metadata(Map<String, Object> metadata) {
      this.metadata = Optional.of(metadata);
      return this;
    }

    @Override
    @JsonSetter(
        value = "metadata",
        nulls = Nulls.SKIP
    )
    public _FinalStage metadata(Optional<Map<String, Object>> metadata) {
      this.metadata = metadata;
      return this;
    }

    @Override
    public _FinalStage sparseValues(SparseValues sparseValues) {
      this.sparseValues = Optional.of(sparseValues);
      return this;
    }

    @Override
    @JsonSetter(
        value = "sparseValues",
        nulls = Nulls.SKIP
    )
    public _FinalStage sparseValues(Optional<SparseValues> sparseValues) {
      this.sparseValues = sparseValues;
      return this;
    }

    /**
     * <p>This is the vector data, if it is requested.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage values(List<Double> values) {
      this.values = Optional.of(values);
      return this;
    }

    @Override
    @JsonSetter(
        value = "values",
        nulls = Nulls.SKIP
    )
    public _FinalStage values(Optional<List<Double>> values) {
      this.values = values;
      return this;
    }

    /**
     * <p>This is a measure of similarity between this vector and the query vector.  The higher the score, the more they are similar.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage score(Double score) {
      this.score = Optional.of(score);
      return this;
    }

    @Override
    @JsonSetter(
        value = "score",
        nulls = Nulls.SKIP
    )
    public _FinalStage score(Optional<Double> score) {
      this.score = score;
      return this;
    }

    @Override
    public ScoredVector build() {
      return new ScoredVector(id, score, values, sparseValues, metadata);
    }
  }
}
