package pl.bk.news.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import okhttp3.Call;
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
        Request request = new Request.Builder()
            .get()
            .url("https://newsapi.org/v2/top-headlines?country=" + country + "&category=" + category + "&apiKey=" + news_key)
            .build();
        
        Call call = client.newCall(request);
        final Response response = call.execute();
        final News news = mapper.readValue(response.body().string(), News.class);
        return newsParser.parse(news, country, category);
    }
    
}
