package API.HomeWork.Day3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.it.Ma;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class Deserialization {

  @Test
    public void response1() throws URISyntaxException, IOException {

      HttpClient client = HttpClientBuilder.create().build();
      URIBuilder uriBuilder = new URIBuilder();
      uriBuilder.setScheme("https");
      uriBuilder.setHost("api.chucknorris.io");
      uriBuilder.setPath("jokes/random");

      HttpGet httpGet = new HttpGet(uriBuilder.build());

      httpGet.setHeader("Accept","application/json");

      HttpResponse response = client.execute(httpGet);

      if(response.getStatusLine().getStatusCode() != 200){
          Assert.fail();
      }

      ObjectMapper objectMapper = new ObjectMapper();

      Map<String, Object> deserializationResponse= objectMapper.readValue(response.getEntity().getContent(),
              new TypeReference<Map<String, Object>>() {
              });
      System.out.println("The value1 from response body: "+deserializationResponse.get("value"));

  }

  @Test
    public void response2() throws URISyntaxException, IOException {

      HttpClient client = HttpClientBuilder.create().build();

      URIBuilder uriBuilder = new URIBuilder();
      uriBuilder.setScheme("https");
      uriBuilder.setHost("tronalddump.io");
      uriBuilder.setPath("random/quote");

      HttpGet httpGet = new HttpGet(uriBuilder.build());

      httpGet.setHeader("Accept", "application/json");

      HttpResponse response = client.execute(httpGet);

      if(response.getStatusLine().getStatusCode() != 200){
          Assert.fail();
      }

      ObjectMapper objectMapper = new ObjectMapper();

      Map<String, Object> deserializationResponse = objectMapper.readValue(response.getEntity().getContent(),
              new TypeReference<Map<String, Object>>() {
              });
      System.out.println("The value2 from response body: "+deserializationResponse.get("value"));



      Map<String, Object> embedded = (Map<String, Object>) deserializationResponse.get("_embedded");

      List<Map<String, Object>> author = (List<Map<String, Object>>) embedded.get("author");

      Map<String, Object> links = (Map<String, Object>) author.get(0).get("_links");

      Map<String, Object> self = (Map<String, Object>) links.get("self");

      System.out.println("The 1 href from response body: "+self.get("href"));

      List<Map<String, Object>> source = (List<Map<String, Object>>) embedded.get("source");

      Map<String, Object> links2 = (Map<String, Object>) source.get(0).get("_links");

      Map<String, Object> self2 = (Map<String, Object>) links2.get("self");

      System.out.println("The 2 href from response body: "+self2.get("href"));


      Map<String, Object> get_links = (Map<String, Object>) deserializationResponse.get("_links");

      Map<String, Object> self3 = (Map<String, Object>) get_links.get("self");
      System.out.println("The last href from body response: "+self3.get("href"));




  }
}
