package com.pinecone.api.resources.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = IndexStatus.Builder.class
)
public final class IndexStatus {
  private final Optional<Boolean> ready;

  private final Optional<String> message;

  private final Optional<String> state;

  private int _cachedHashCode;

  IndexStatus(Optional<Boolean> ready, Optional<String> message, Optional<String> state) {
    this.ready = ready;
    this.message = message;
    this.state = state;
  }

  @JsonProperty("ready")
  public Optional<Boolean> getReady() {
    return ready;
  }

  @JsonProperty("message")
  public Optional<String> getMessage() {
    return message;
  }

  @JsonProperty("state")
  public Optional<String> getState() {
    return state;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof IndexStatus && equalTo((IndexStatus) other);
  }

  private boolean equalTo(IndexStatus other) {
    return ready.equals(other.ready) && message.equals(other.message) && state.equals(other.state);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ready, this.message, this.state);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "IndexStatus{" + "ready: " + ready + ", message: " + message + ", state: " + state + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Boolean> ready = Optional.empty();

    private Optional<String> message = Optional.empty();

    private Optional<String> state = Optional.empty();

    private Builder() {
    }

    public Builder from(IndexStatus other) {
      ready(other.getReady());
      message(other.getMessage());
      state(other.getState());
      return this;
    }

    @JsonSetter(
        value = "ready",
        nulls = Nulls.SKIP
    )
    public Builder ready(Optional<Boolean> ready) {
      this.ready = ready;
      return this;
    }

    public Builder ready(Boolean ready) {
      this.ready = Optional.of(ready);
      return this;
    }

    @JsonSetter(
        value = "message",
        nulls = Nulls.SKIP
    )
    public Builder message(Optional<String> message) {
      this.message = message;
      return this;
    }

    public Builder message(String message) {
      this.message = Optional.of(message);
      return this;
    }

    @JsonSetter(
        value = "state",
        nulls = Nulls.SKIP
    )
    public Builder state(Optional<String> state) {
      this.state = state;
      return this;
    }

    public Builder state(String state) {
      this.state = Optional.of(state);
      return this;
    }

    public IndexStatus build() {
      return new IndexStatus(ready, message, state);
    }
  }
}
