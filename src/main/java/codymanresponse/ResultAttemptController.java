package codymanresponse;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/results")
public class ResultAttemptController {

    @Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<ResultAttemptDTO> save(@Body Response response) {
        ResultAttemptDTO resultAttempt = new ResultAttemptDTO(response.getQuestion(), response.getAnswer());
        return HttpResponse.ok(resultAttempt);
    }
}