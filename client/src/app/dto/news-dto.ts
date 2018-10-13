import {ArticleDto} from "./article-dto";

export class NewsDto {

  country: String;
  category: String;
  articles: ArticleDto[] = [];

  constructor(data: any) {
    this.country = data.country;
    this.category = data.category;
    Array.from(data.articles).forEach(entry => {
      this.articles.push(new ArticleDto(entry))
    });
  }
}
