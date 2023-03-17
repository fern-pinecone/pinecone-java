package com.pinecone.api;

import com.pinecone.api.core.ApiKey;
import com.pinecone.api.resources.index.indexServiceClient;
import java.lang.String;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public final class PineconeApiClient {
  private final Supplier<indexServiceClient> indexServiceClient;

  public PineconeApiClient(String url, ApiKey auth) {
    this.indexServiceClient = memoize(() -> new indexServiceClient(url, auth));
  }

  public final indexServiceClient index() {
    return this.indexServiceClient.get();
  }

  private static <T> Supplier<T> memoize(Supplier<T> delegate) {
    AtomicReference<T> value = new AtomicReference<>();
    return () ->  {
      T val = value.get();
      if (val == null) {
        val = value.updateAndGet(cur -> cur == null ? Objects.requireNonNull(delegate.get()) : cur);
      }
      return val;
    } ;
  }
}
