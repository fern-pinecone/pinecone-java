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
    builder = UpdateRequest.Builder.class
)
public final class UpdateRequest {
  private final String id;

  private final Optional<List<Double>> values;

  private final Optional<SparseValues> sparseValues;

  private final Optional<Map<String, Object>> setMetadata;

  private final Optional<String> namespace;

  private int _cachedHashCode;

  UpdateRequest(String id, Optional<List<Double>> values, Optional<SparseValues> sparseValues,
      Optional<Map<String, Object>> setMetadata, Optional<String> namespace) {
    this.id = id;
    this.values = values;
    this.sparseValues = sparseValues;
    this.setMetadata = setMetadata;
    this.namespace = namespace;
  }

  /**
   * @return Vector's unique id.
   */
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  /**
   * @return Vector data.
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
   * @return Metadata to <em>set</em> for the vector.
   */
  @JsonProperty("setMetadata")
  public Optional<Map<String, Object>> getSetMetadata() {
    return setMetadata;
  }

  /**
   * @return The namespace containing the vector to update.
   */
  @JsonProperty("namespace")
  public Optional<String> getNamespace() {
    return namespace;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UpdateRequest && equalTo((UpdateRequest) other);
  }

  private boolean equalTo(UpdateRequest other) {
    return id.equals(other.id) && values.equals(other.values) && sparseValues.equals(other.sparseValues) && setMetadata.equals(other.setMetadata) && namespace.equals(other.namespace);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.id, this.values, this.sparseValues, this.setMetadata, this.namespace);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UpdateRequest{" + "id: " + id + ", values: " + values + ", sparseValues: " + sparseValues + ", setMetadata: " + setMetadata + ", namespace: " + namespace + "}";
  }

  public static IdStage builder() {
    return new Builder();
  }

  public interface IdStage {
    _FinalStage id(String id);

    Builder from(UpdateRequest other);
  }

  public interface _FinalStage {
    UpdateRequest build();

    _FinalStage values(Optional<List<Double>> values);

    _FinalStage values(List<Double> values);

    _FinalStage sparseValues(Optional<SparseValues> sparseValues);

    _FinalStage sparseValues(SparseValues sparseValues);

    _FinalStage setMetadata(Optional<Map<String, Object>> setMetadata);

    _FinalStage setMetadata(Map<String, Object> setMetadata);

    _FinalStage namespace(Optional<String> namespace);

    _FinalStage namespace(String namespace);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdStage, _FinalStage {
    private String id;

    private Optional<String> namespace = Optional.empty();

    private Optional<Map<String, Object>> setMetadata = Optional.empty();

    private Optional<SparseValues> sparseValues = Optional.empty();

    private Optional<List<Double>> values = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(UpdateRequest other) {
      id(other.getId());
      values(other.getValues());
      sparseValues(other.getSparseValues());
      setMetadata(other.getSetMetadata());
      namespace(other.getNamespace());
      return this;
    }

    /**
     * <p>Vector's unique id.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("id")
    public _FinalStage id(String id) {
      this.id = id;
      return this;
    }

    /**
     * <p>The namespace containing the vector to update.</p>
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

    /**
     * <p>Metadata to <em>set</em> for the vector.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage setMetadata(Map<String, Object> setMetadata) {
      this.setMetadata = Optional.of(setMetadata);
      return this;
    }

    @Override
    @JsonSetter(
        value = "setMetadata",
        nulls = Nulls.SKIP
    )
    public _FinalStage setMetadata(Optional<Map<String, Object>> setMetadata) {
      this.setMetadata = setMetadata;
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
     * <p>Vector data.</p>
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

    @Override
    public UpdateRequest build() {
      return new UpdateRequest(id, values, sparseValues, setMetadata, namespace);
    }
  }
}
