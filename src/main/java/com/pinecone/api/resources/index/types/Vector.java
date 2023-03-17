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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Vector.Builder.class
)
public final class Vector {
  private final String id;

  private final List<Double> values;

  private final Optional<SparseValues> sparseValues;

  private final Optional<Map<String, Object>> metadata;

  private int _cachedHashCode;

  Vector(String id, List<Double> values, Optional<SparseValues> sparseValues,
      Optional<Map<String, Object>> metadata) {
    this.id = id;
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
   * @return This is the vector data included in the request.
   */
  @JsonProperty("values")
  public List<Double> getValues() {
    return values;
  }

  @JsonProperty("sparseValues")
  public Optional<SparseValues> getSparseValues() {
    return sparseValues;
  }

  /**
   * @return This is the metadata included in the request.
   */
  @JsonProperty("metadata")
  public Optional<Map<String, Object>> getMetadata() {
    return metadata;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Vector && equalTo((Vector) other);
  }

  private boolean equalTo(Vector other) {
    return id.equals(other.id) && values.equals(other.values) && sparseValues.equals(other.sparseValues) && metadata.equals(other.metadata);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.values, this.sparseValues, this.metadata);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Vector{" + "id: " + id + ", values: " + values + ", sparseValues: " + sparseValues + ", metadata: " + metadata + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    _FinalStage id(String id);

    Builder from(Vector other);
  }

  public interface _FinalStage {
    Vector build();

    _FinalStage values(List<Double> values);

    _FinalStage values(Double values);

    _FinalStage addAllValues(List<Double> values);

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

    private List<Double> values = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(Vector other) {
      id(other.getId());
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
     * <p>This is the metadata included in the request.</p>
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
     * <p>This is the vector data included in the request.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllValues(List<Double> values) {
      this.values.addAll(values);
      return this;
    }

    /**
     * <p>This is the vector data included in the request.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage values(Double values) {
      this.values.add(values);
      return this;
    }

    @Override
    @JsonSetter(
        value = "values",
        nulls = Nulls.SKIP
    )
    public _FinalStage values(List<Double> values) {
      this.values.clear();
      this.values.addAll(values);
      return this;
    }

    @Override
    public Vector build() {
      return new Vector(id, values, sparseValues, metadata);
    }
  }
}
