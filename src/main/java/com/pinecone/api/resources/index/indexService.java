package com.pinecone.api.resources.index;

import com.fern.java.jersey.contracts.OptionalAwareContract;
import com.pinecone.api.core.ApiKey;
import com.pinecone.api.core.ObjectMappers;
import com.pinecone.api.resources.index.exceptions.DeleteException;
import com.pinecone.api.resources.index.exceptions.DescribeIndexStatsException;
import com.pinecone.api.resources.index.exceptions.FetchException;
import com.pinecone.api.resources.index.exceptions.QueryException;
import com.pinecone.api.resources.index.exceptions.UpdateException;
import com.pinecone.api.resources.index.exceptions.UpsertException;
import com.pinecone.api.resources.index.types.DeleteRequest;
import com.pinecone.api.resources.index.types.DescribeIndexStatsRequest;
import com.pinecone.api.resources.index.types.DescribeIndexStatsResponse;
import com.pinecone.api.resources.index.types.FetchResponse;
import com.pinecone.api.resources.index.types.QueryRequest;
import com.pinecone.api.resources.index.types.QueryResponse;
import com.pinecone.api.resources.index.types.UpdateRequest;
import com.pinecone.api.resources.index.types.UpsertRequest;
import com.pinecone.api.resources.index.types.UpsertResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;
import java.lang.Object;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("")
interface indexService {
  @POST
  @Path("/describe_index_stats")
  DescribeIndexStatsResponse describeIndexStats(@HeaderParam("Api-Key") ApiKey auth,
      DescribeIndexStatsRequest body) throws DescribeIndexStatsException;

  @POST
  @Path("/query")
  QueryResponse query(@HeaderParam("Api-Key") ApiKey auth, QueryRequest body) throws QueryException;

  @POST
  @Path("/vectors/delete")
  Map<String, Object> delete(@HeaderParam("Api-Key") ApiKey auth, DeleteRequest body) throws
      DeleteException;

  @GET
  @Path("/vectors/fetch")
  FetchResponse fetch(@HeaderParam("Api-Key") ApiKey auth, @QueryParam("ids") String ids,
      @QueryParam("namespace") Optional<String> namespace) throws FetchException;

  @POST
  @Path("/vectors/update")
  Map<String, Object> update(@HeaderParam("Api-Key") ApiKey auth, UpdateRequest body) throws
      UpdateException;

  @POST
  @Path("/vectors/upsert")
  UpsertResponse upsert(@HeaderParam("Api-Key") ApiKey auth, UpsertRequest body) throws
      UpsertException;

  static indexService getClient(String url) {
    return Feign.builder()
        .contract(new OptionalAwareContract(new JAXRSContract()))
        .decoder(new JacksonDecoder(ObjectMappers.JSON_MAPPER))
        .encoder(new JacksonEncoder(ObjectMappers.JSON_MAPPER))
        .errorDecoder(new indexServiceErrorDecoder()).target(indexService.class, url);
  }
}
