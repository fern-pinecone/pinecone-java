package com.pinecone.api.resources.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = CreateCollectionRequest.Builder.class
)
public final class CreateCollectionRequest {
  private final String name;

  private final String source;

  private int _cachedHashCode;

  CreateCollectionRequest(String name, String source) {
    this.name = name;
    this.source = source;
  }

  /**
   * @return The name of the collection to be created.
   */
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  /**
   * @return The name of the source index to be used as the source for the collection.
   */
  @JsonProperty("source")
  public String getSource() {
    return source;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateCollectionRequest && equalTo((CreateCollectionRequest) other);
  }

  private boolean equalTo(CreateCollectionRequest other) {
    return name.equals(other.name) && source.equals(other.source);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.source);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateCollectionRequest{" + "name: " + name + ", source: " + source + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    SourceStage name(String name);

    Builder from(CreateCollectionRequest other);
  }

  public interface SourceStage {
    _FinalStage source(String source);
  }

  public interface _FinalStage {
    CreateCollectionRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, SourceStage, _FinalStage {
    private String name;

    private String source;

    private Builder() {
    }

    @Override
    public Builder from(CreateCollectionRequest other) {
      name(other.getName());
      source(other.getSource());
      return this;
    }

    /**
     * <p>The name of the collection to be created.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("name")
    public SourceStage name(String name) {
      this.name = name;
      return this;
    }

    /**
     * <p>The name of the source index to be used as the source for the collection.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("source")
    public _FinalStage source(String source) {
      this.source = source;
      return this;
    }

    @Override
    public CreateCollectionRequest build() {
      return new CreateCollectionRequest(name, source);
    }
  }
}
