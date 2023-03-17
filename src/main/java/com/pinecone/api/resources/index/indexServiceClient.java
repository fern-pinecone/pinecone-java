package com.pinecone.api.resources.index;

import com.pinecone.api.core.ApiKey;
import com.pinecone.api.resources.index.endpoints.Delete;
import com.pinecone.api.resources.index.endpoints.DescribeIndexStats;
import com.pinecone.api.resources.index.endpoints.Fetch;
import com.pinecone.api.resources.index.endpoints.Query;
import com.pinecone.api.resources.index.endpoints.Update;
import com.pinecone.api.resources.index.endpoints.Upsert;
import com.pinecone.api.resources.index.exceptions.DeleteException;
import com.pinecone.api.resources.index.exceptions.DescribeIndexStatsException;
import com.pinecone.api.resources.index.exceptions.FetchException;
import com.pinecone.api.resources.index.exceptions.QueryException;
import com.pinecone.api.resources.index.exceptions.UpdateException;
import com.pinecone.api.resources.index.exceptions.UpsertException;
import com.pinecone.api.resources.index.types.DescribeIndexStatsResponse;
import com.pinecone.api.resources.index.types.FetchResponse;
import com.pinecone.api.resources.index.types.QueryResponse;
import com.pinecone.api.resources.index.types.UpsertResponse;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.Map;
import java.util.Optional;

public final class indexServiceClient {
  private final indexService service;

  private final Optional<ApiKey> auth;

  public indexServiceClient(String url) {
    this.service = indexService.getClient(url);
    this.auth = Optional.empty();
  }

  public indexServiceClient(String url, ApiKey auth) {
    this.service = indexService.getClient(url);
    this.auth = Optional.of(auth);
  }

  /**
   * <p>The <code>DescribeIndexStats</code> operation returns statistics about the index's contents.
   * For example: The vector count per namespace and the number of dimensions.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws DescribeIndexStatsException Exception that wraps all possible endpoint errors 
   * @return DescribeIndexStatsResponse
   */
  public DescribeIndexStatsResponse describeIndexStats(DescribeIndexStats.Request request) throws
      DescribeIndexStatsException {
    ApiKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.describeIndexStats(authValue, request.getBody());
  }

  /**
   * <p>The <code>Query</code> operation searches a namespace, using a query vector.
   * It retrieves the ids of the most similar items in a namespace, along with their similarity scores.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws QueryException Exception that wraps all possible endpoint errors 
   * @return QueryResponse
   */
  public QueryResponse query(Query.Request request) throws QueryException {
    ApiKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.query(authValue, request.getBody());
  }

  /**
   * <p>The <code>Delete</code> operation deletes vectors, by id, from a single namespace.
   * You can delete items by their id, from a single namespace.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws DeleteException Exception that wraps all possible endpoint errors 
   * @return Map<String, Object>
   */
  public Map<String, Object> delete(Delete.Request request) throws DeleteException {
    ApiKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.delete(authValue, request.getBody());
  }

  /**
   * <p>The <code>Fetch</code> operation looks up and returns vectors, by ID, from a single namespace.
   * The returned vectors include the vector data and/or metadata.</p>
   * @param request Wrapper object that includes any path parameters, query parameters, and headers
   * @throws FetchException Exception that wraps all possible endpoint errors 
   * @return FetchResponse
   */
  public FetchResponse fetch(Fetch.Request request) throws FetchException {
    ApiKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.fetch(authValue, request.getIds(), request.getNamespace());
  }

  /**
   * <p>The <code>Update</code> operation updates vector in a namespace.
   * If a value is included, it will overwrite the previous value.
   * If a set_metadata is included, the values of the fields specified in it will be added or overwrite the previous value.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws UpdateException Exception that wraps all possible endpoint errors 
   * @return Map<String, Object>
   */
  public Map<String, Object> update(Update.Request request) throws UpdateException {
    ApiKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.update(authValue, request.getBody());
  }

  /**
   * <p>The <code>Upsert</code> operation writes vectors into a namespace.
   * If a new value is upserted for an existing vector id, it will overwrite the previous value.</p>
   * @param request Wrapper object for the request body that includes any path parameters, query parameters, and headers
   * @throws UpsertException Exception that wraps all possible endpoint errors 
   * @return UpsertResponse
   */
  public UpsertResponse upsert(Upsert.Request request) throws UpsertException {
    ApiKey authValue = request.getAuthOverride().orElseGet(() -> this.auth.orElseThrow(() -> new RuntimeException("Auth is required")));
    return this.service.upsert(authValue, request.getBody());
  }
}
