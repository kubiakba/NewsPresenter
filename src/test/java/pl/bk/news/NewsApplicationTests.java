package pl.bk.news;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.bk.news.external.news.dto.News;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.stream.Collectors.joining;

public class NewsApplicationTests
{
    BufferedReader reader;
    ObjectMapper mapper = new ObjectMapper();
    
    @Before
    public void setup()
    {
        reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/news.json")));
    }
    @After
    public void close() throws IOException
    {
        reader.close();
    }
    
    @Test
    public void shouldParseJsonFromNewsApi() throws IOException
    {
        //given
        final String json = reader.lines().collect(joining());
        //when
        final News newses = mapper.readValue(json, News.class);
        //then
        Assertions.assertThat(newses.getArticles().size()).isNotZero();
    }
    
}
