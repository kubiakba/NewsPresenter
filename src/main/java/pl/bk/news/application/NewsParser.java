package pl.bk.news.application;

import org.springframework.stereotype.Component;
import pl.bk.news.api.dto.ArticleDto;
import pl.bk.news.api.dto.NewsDto;
import pl.bk.news.external.news.dto.Article;
import pl.bk.news.external.news.dto.News;

import static java.util.stream.Collectors.toList;

@Component
public class NewsParser
{
    public NewsDto parse(News news, String country, String category)
    {
        return NewsDto.builder()
                      .country(country)
                      .category(category)
                      .articles(news.getArticles()
                                    .stream()
                                    .map(this::parseArticle)
                                    .collect(toList()))
                      .build();
    }
    
    private ArticleDto parseArticle(Article article)
    {
        return ArticleDto.builder()
                         .author(article.getAuthor())
                         .title(article.getTitle())
                         .description(article.getDescription())
                         .date(article.getPublishedAt())
                         .sourceName(article.getSource().getName())
                         .articleUrl(article.getUrl())
                         .imageUrl(article.getUrlToImage())
                         .build();
    }
}
