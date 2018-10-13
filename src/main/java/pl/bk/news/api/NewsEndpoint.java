package pl.bk.news.api;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.bk.news.api.dto.NewsDto;
import pl.bk.news.application.NewsService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
public class NewsEndpoint
{
    private final NewsService newsService;
    
    @SneakyThrows
    @GetMapping("/news/{country}/{category}")
    public ResponseEntity<NewsDto> getNews(@PathVariable("country") String country, @PathVariable("category") String category)
    {
        return ok().body(newsService.getNews(country, category));
    }
}
