package API.HomeWork;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class iTunesMusic {


    @Test
    public void getRequest() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();
//https://itunes.apple.com/search?term=linkinpark
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("itunes.apple.com");
        uriBuilder.setPath("search");
        uriBuilder.setCustomQuery("term=linkinpark");

        HttpGet get = new HttpGet(uriBuilder.build());

        HttpResponse response = client.execute(get);

        Assert.assertEquals(200,response.getStatusLine().getStatusCode());
        Assert.assertTrue(response.containsHeader("Content-type"));

    }

        @Test
        public void getRequest2() throws URISyntaxException, IOException {

        HttpClient client = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("itunes.apple.com");
        uriBuilder.setPath("search");
        uriBuilder.setCustomQuery("term=Mark");

        HttpGet get = new HttpGet(uriBuilder.build());

        HttpResponse response = client.execute(get);

        Assert.assertEquals(200, response.getStatusLine().getStatusCode());

        }
}
