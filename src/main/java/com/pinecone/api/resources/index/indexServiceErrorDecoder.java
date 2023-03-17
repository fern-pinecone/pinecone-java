package com.pinecone.api.resources.index;

import com.pinecone.api.core.ObjectMappers;
import com.pinecone.api.resources.index.exceptions.DeleteException;
import com.pinecone.api.resources.index.exceptions.DescribeIndexStatsException;
import com.pinecone.api.resources.index.exceptions.FetchException;
import com.pinecone.api.resources.index.exceptions.QueryException;
import com.pinecone.api.resources.index.exceptions.UpdateException;
import com.pinecone.api.resources.index.exceptions.UpsertException;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;

final class indexServiceErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    try {
      if (methodKey.contains("describeIndexStats")) {
        return decodeException(response, DescribeIndexStatsException.class);
      }
      if (methodKey.contains("query")) {
        return decodeException(response, QueryException.class);
      }
      if (methodKey.contains("delete")) {
        return decodeException(response, DeleteException.class);
      }
      if (methodKey.contains("fetch")) {
        return decodeException(response, FetchException.class);
      }
      if (methodKey.contains("update")) {
        return decodeException(response, UpdateException.class);
      }
      if (methodKey.contains("upsert")) {
        return decodeException(response, UpsertException.class);
      }
    }
    catch (IOException e) {
    }
    return new RuntimeException("Failed to read response body. Received status " + response.status() + " for method " + methodKey);
  }

  private static <T extends Exception> Exception decodeException(Response response, Class<T> clazz)
      throws IOException {
    return ObjectMappers.JSON_MAPPER.reader().withAttribute("statusCode", response.status()).readValue(response.body().asInputStream(), clazz);
  }
}
