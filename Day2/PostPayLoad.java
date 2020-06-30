package API.HomeWork.Day2;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static API.HomeWork.Day2.Payload.getPetPayload;

public class PostPayLoad {

    @Test
    public void postRequest() throws URISyntaxException, IOException {

        // https://petstore.swagger.io/v2/pet

        for(int i =0; i<25; i++){
            HttpClient client = HttpClientBuilder.create().build();
            URIBuilder uriBuilder = new URIBuilder();
            uriBuilder.setScheme("https");
            uriBuilder.setHost("petstore.swagger.io");
            uriBuilder.setPath("v2/pet");

            HttpPost httpPost = new HttpPost(uriBuilder.build());
            httpPost.setHeader("Content-Type","Application/json");
            httpPost.setHeader("Accept","Application/json");

            HttpEntity entity = new StringEntity(getPetPayload());

            httpPost.setEntity(entity);
            client.execute(httpPost);

            HttpResponse httpResponse = client.execute(httpPost);

            Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());

            Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

        }




    }

}
