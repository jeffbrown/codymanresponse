package codymanresponse;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class ResultAttemptControllerTest {

    @Inject
    EmbeddedServer embeddedServer;

    @Test
    public void testResults() throws Exception {
        try (RxHttpClient client = embeddedServer.getApplicationContext().createBean(RxHttpClient.class, embeddedServer.getURL())) {
            Response response = new Response();
            response.setQuestion("Some Question");
            response.setAnswer("Some Answer");

            HttpResponse<ResultAttemptDTO> httpResponse = client.toBlocking().exchange(HttpRequest.POST("/results", response), ResultAttemptDTO.class);
            assertEquals(HttpStatus.OK, httpResponse.status());
            ResultAttemptDTO resultAttemptDTO = httpResponse.getBody().get();
            assertNotNull(resultAttemptDTO);

            assertEquals("Some Question", resultAttemptDTO.getQuestion());
            assertEquals("Some Answer", resultAttemptDTO.getAnswer());
        }
    }
}
