# Pinecone Java Library

[![Maven Central](https://img.shields.io/maven-central/v/io.github.fern-api/pinecone)](https://central.sonatype.com/artifact/io.github.fern-api/pinecone/0.0.4/versions) 
![Sonatype Nexus (Releases)](https://img.shields.io/nexus/r/io.github.fern-api/pinecone?server=https%3A%2F%2Fs01.oss.sonatype.org)
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

## Documentation

API documentation is available at https://docs.pinecone.io/reference/.

## Installation

### Gradle users

Add this dependency to your project's build file:

```groovy
implementation "io.github.fern-api:pinecone:0.0.10"
```

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.github.fern-api</groupId>
  <artifactId>pinecone</artifactId>
  <version>0.0.10</version>
</dependency>
```

## Usage

Check out the [sample app](.sample-app/app.java) which consumes this SDK!

```java
PineconeApiClient pinecone = PineconeApiClient.builder()
    .apiKey(System.getenv("PINECONE_API_KEY"))
    .environment("us-west1-gcp")
    .build();
    
pinecone.createIndex(CreateRequest.builder()
    .name("example-index")
    .dimension(1024)
    .build());
    
List<String> activeIndexes = pinecone.listIndexes();
System.out.println("Received active indexes from pinecone: " + activeIndexes);
```

## Beta status

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning the package version to a specific version in your build.gradle file. This way, you can install the same version each time without breaking changes unless you are intentionally looking for the latest version.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
