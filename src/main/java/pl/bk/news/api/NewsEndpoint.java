package pl.bk.news.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.bk.news.api.dto.NewsDto;
import pl.bk.news.application.NewsService;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
@Api(value = "News endpoint", description = "API related with online news")
public class NewsEndpoint
{
    private final NewsService newsService;
    
    @GetMapping("/news/{country}/{category}")
    @ApiOperation(value = "Find online news filtering by country and category")
    public ResponseEntity<NewsDto> getNews(@PathVariable("country") String country, @PathVariable("category") String category)
    {
        return ok().body(newsService.getNews(country, category));
    }
}
