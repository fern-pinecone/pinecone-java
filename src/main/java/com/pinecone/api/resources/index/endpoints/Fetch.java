package com.pinecone.api.resources.index.endpoints;

import com.pinecone.api.core.ApiKey;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class Fetch {
  private Fetch() {
  }

  public static final class Request {
    private final String ids;

    private final Optional<String> namespace;

    private final Optional<ApiKey> authOverride;

    private int _cachedHashCode;

    Request(String ids, Optional<String> namespace, Optional<ApiKey> authOverride) {
      this.ids = ids;
      this.namespace = namespace;
      this.authOverride = authOverride;
    }

    /**
     * @return The vector IDs to fetch. Does not accept values containing spaces.
     */
    public String getIds() {
      return ids;
    }

    public Optional<String> getNamespace() {
      return namespace;
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
      return ids.equals(other.ids) && namespace.equals(other.namespace) && authOverride.equals(other.authOverride);
    }

    @Override
    public int hashCode() {
      if (_cachedHashCode == 0) {
        _cachedHashCode = Objects.hash(this.ids, this.namespace, this.authOverride);
      }
      return _cachedHashCode;
    }

    @Override
    public String toString() {
      return "Fetch.Request{" + "ids: " + ids + ", namespace: " + namespace + ", authOverride: " + authOverride + "}";
    }

    public static IdsStage builder() {
      return new Builder();
    }

    public interface IdsStage {
      _FinalStage ids(String ids);

      Builder from(Request other);
    }

    public interface _FinalStage {
      Request build();

      _FinalStage namespace(Optional<String> namespace);

      _FinalStage namespace(String namespace);

      _FinalStage authOverride(Optional<ApiKey> authOverride);

      _FinalStage authOverride(ApiKey authOverride);
    }

    public static final class Builder implements IdsStage, _FinalStage {
      private String ids;

      private Optional<ApiKey> authOverride = Optional.empty();

      private Optional<String> namespace = Optional.empty();

      private Builder() {
      }

      @Override
      public Builder from(Request other) {
        ids(other.getIds());
        namespace(other.getNamespace());
        authOverride(other.getAuthOverride());
        return this;
      }

      /**
       * <p>The vector IDs to fetch. Does not accept values containing spaces.</p>
       * @return Reference to {@code this} so that method calls can be chained together.
       */
      @Override
      public _FinalStage ids(String ids) {
        this.ids = ids;
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
      public _FinalStage namespace(String namespace) {
        this.namespace = Optional.of(namespace);
        return this;
      }

      @Override
      public _FinalStage namespace(Optional<String> namespace) {
        this.namespace = namespace;
        return this;
      }

      @Override
      public Request build() {
        return new Request(ids, namespace, authOverride);
      }
    }
  }
}
