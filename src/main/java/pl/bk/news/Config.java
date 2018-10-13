package pl.bk.news;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config
{
    @Bean
    public OkHttpClient httpClient()
    {
        return new OkHttpClient();
    }
    
    @Bean
    public ObjectMapper mapper()
    {
        return new ObjectMapper();
    }
    
}
