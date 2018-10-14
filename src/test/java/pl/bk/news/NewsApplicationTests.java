package pl.bk.news;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.bk.news.external.news.dto.News;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

public class NewsApplicationTests
{
    private BufferedReader reader;
    private final ObjectMapper mapper = new ObjectMapper();
    
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
        assertThat(newses.getArticles().size()).isEqualTo(2);
        assertThat(newses.getArticles().get(0).getSource().getName()).isEqualTo("TechCrunch");
        assertThat(newses.getArticles().get(0).getAuthor()).isEqualTo("Joyce Yang");
        assertThat(newses.getArticles().get(0).getTitle()).isEqualTo("The 21-day bitcoin challenge");
        assertThat(newses.getArticles().get(0).getDescription()).isEqualTo(
            "There is a documentary series currently airing on iQiyi, China’s Netflix equivalent, about a Chinese bitcoin enthusiast who attempts to survive 21 days by merely living on 0.21 bitcoin, or $1,300, without any help or donations. He You Bing is traveling and ca…");
        assertThat(newses.getArticles().get(0).getUrl()).isEqualTo("http://techcrunch.com/2018/09/16/the-21-day-bitcoin-challenge/");
        assertThat(newses.getArticles().get(0).getUrlToImage()).isEqualTo("https://techcrunch.com/wp-content/uploads/2018/09/Screen-Shot-2018-09-16-at-8.57.40-AM.png?w=745");
        assertThat(newses.getArticles().get(0).getPublishedAt()).isEqualTo("2018-09-16T13:11:12Z");
    }
    
}
