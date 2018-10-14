package pl.bk.news.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.bk.news.api.dto.NewsDto;
import pl.bk.news.external.news.dto.News;

@Component
public class NewsService
{
    @Value("${news_key}")
    private String news_key;
    private final OkHttpClient client;
    private final ObjectMapper mapper;
    private final NewsParser newsParser;
    
    public NewsService(OkHttpClient client, ObjectMapper mapper, NewsParser newsParser)
    {
        this.client = client;
        this.mapper = mapper;
        this.newsParser = newsParser;
    }
    
    @SneakyThrows
    public NewsDto getNews(String country, String category)
    {
        final HttpUrl url = getHttpUrl(country, category);
        final Request request = new Request.Builder().url(url).build();
        final Response response = client.newCall(request).execute();
        
        return newsParser.parse(mapper.readValue(response.body().string(), News.class), country, category);
    }
    
    private HttpUrl getHttpUrl(String country, String category)
    {
        return HttpUrl.parse("https://newsapi.org/v2/top-headlines")
                      .newBuilder()
                      .setQueryParameter("country", country)
                      .setQueryParameter("category", category)
                      .setQueryParameter("apiKey", news_key)
                      .build();
    }
    
}
