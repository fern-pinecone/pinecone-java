package com.pinecone.api;

import com.pinecone.api.resources.types.CollectionMeta;
import com.pinecone.api.resources.types.ConfigureIndexRequest;
import com.pinecone.api.resources.types.CreateCollectionRequest;
import com.pinecone.api.resources.types.CreateRequest;
import com.pinecone.api.resources.types.IndexMeta;
import java.lang.String;

public interface PineconeApiClient {
  void listCollections();

  void createCollection(CreateCollectionRequest request);

  CollectionMeta describeCollection(String collectionName);

  void deleteCollection(String collectionName);

  void listIndexes();

  void createIndex(CreateRequest request);

  IndexMeta describeIndex(String indexName);

  void deleteIndex(String indexName);

  void configureIndex(String indexName, ConfigureIndexRequest request);

  static Builder builder() {
    return new PineconeApiClientImpl.Builder();
  }

  interface Builder {
    Builder apiKey(String apiKey);

    Builder url(String url);

    PineconeApiClient build();
  }
}
