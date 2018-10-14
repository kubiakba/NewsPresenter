package pl.bk.news.external.news.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article
{
    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String publishedAt;
    private String urlToImage;
}
