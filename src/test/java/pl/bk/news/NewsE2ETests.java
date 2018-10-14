package pl.bk.news;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.bk.news.application.exception.ErrorMessage;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;
import static pl.bk.news.application.exception.ErrorCode.INVALID_COUNTRY_NAME;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class NewsE2ETests
{
    @Autowired
    OkHttpClient client;
    
    @Autowired
    ObjectMapper mapper;
    
    @Test
    public void shouldReturn200WhenCallingApi() throws IOException
    {
        //given
        Request request = new Request.Builder()
            .get()
            .url("http://localhost:8080/news/pl/sports")
            .build();
        //when
        final Response response = client.newCall(request).execute();
        //then
        assertThat(response.code()).isEqualTo(OK.value());
    }
    
    @Test
    public void shouldReturnErrorWhenCallingApiWithInvalidCountryName() throws IOException
    {
        //given
        Request request = new Request.Builder()
            .get()
            .url("http://localhost:8080/news/eee/sports")
            .build();
        //when
        final Response response = client.newCall(request).execute();
        //then
        final ErrorMessage errorMessage = mapper.readValue(response.body().string(), ErrorMessage.class);
        assertThat(errorMessage.getErrorCode()).isEqualTo(INVALID_COUNTRY_NAME);
    }
}
