package sample;

import com.pinecone.api.resources.types.CreateRequest;
import java.lang.String;
import com.pinecone.api.PineconeApiClient;
import java.util.List;

public final class App {
  public static void main(String[] args) {
    PineconeApiClient pinecone = PineconeApiClient.builder()
            .apiKey(System.getenv("PINECONE_API_KEY"))
            .environment(System.getenv("us-west1-gcp"))
            .build();

    pinecone.createIndex(CreateRequest.builder()
            .name("example-index")
            .dimension(1024)
            .build());

    List<String> activeIndexes = pinecone.listIndexes();
    System.out.println("Received active indexes from pinecone: " + activeIndexes);
  }
}
