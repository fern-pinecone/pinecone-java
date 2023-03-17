package com.pinecone.api.resources.index.endpoints;

import com.pinecone.api.core.ApiKey;
import com.pinecone.api.resources.index.types.UpdateRequest;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Update {
  private Update() {
  }

  public static final class Request {
    private final UpdateRequest body;

    private final Optional<ApiKey> authOverride;

    private int _cachedHashCode;

    Request(UpdateRequest body, Optional<ApiKey> authOverride) {
      this.body = body;
      this.authOverride = authOverride;
    }

    public UpdateRequest getBody() {
      return body;
    }

    public Optional<ApiKey> getAuthOverride() {
      return authOverride;
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
      return body.equals(other.body) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.body, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Update.Request{" + "body: " + body + ", authOverride: " + authOverride + "}";
    }

    public static BodyStage builder() {
      return new Builder();
    }

    public interface BodyStage {
      _FinalStage body(UpdateRequest body);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage authOverride(Optional<ApiKey> authOverride);

      _FinalStage authOverride(ApiKey authOverride);
    }

    public static final class Builder implements BodyStage, _FinalStage {
      private UpdateRequest body;

      private Optional<ApiKey> authOverride = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        body(other.getBody());
        authOverride(other.getAuthOverride());
        return this;
      }

      @Override
      public _FinalStage body(UpdateRequest body) {
        this.body = body;
        return this;
      }

      @Override
      public _FinalStage authOverride(ApiKey authOverride) {
        this.authOverride = Optional.of(authOverride);
        return this;
      }

      @Override
      public _FinalStage authOverride(Optional<ApiKey> authOverride) {
        this.authOverride = authOverride;
        return this;
      }

      @Override
      public Request build() {
        return new Request(body, authOverride);
      }
    }
  }
}