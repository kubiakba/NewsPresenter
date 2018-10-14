import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {NewsDto} from "../dto/news-dto";
import {ArticleDto} from "../dto/article-dto";

@Component({
  selector: 'app-news-view',
  template: `
    <table width="100%" style='font-family:"Courier New", Courier, monospace; font-size:80%' class="table table-striped">
      <thead>
      <tr>
        <th>kraj</th>
        <th>kategoria</th>
        <th>autor</th>
        <th style="min-width: 300px">tytuł</th>
        <th style="min-width: 300px">opis</th>
        <th>data</th>
        <th>źródło</th>
        <th>url</th>
        <th>imageUrl</th>
      </tr>
      </thead>
      <tbody>
      <tr *ngFor="let article of articles">
        <td>{{news.country}}</td>
        <td>{{news.category}}</td>
        <td>{{article.author}}</td>
        <td style="min-width: 300px">{{article.title}}</td>
        <td style="min-width: 300px">{{article.description}}</td>
        <td>{{article.date}}</td>
        <td>{{article.sourceName}}</td>
        <td><a href="{{article.articleUrl}}">{{article.articleUrl}}</a></td>
        <td><a href="{{article.imageUrl}}">{{article.imageUrl}}</a></td>
      </tr>
      </tbody>
    </table>
  `,
  styleUrls: ['./news-component.css']
})
export class NewsViewComponent implements OnChanges {

  @Input() news: NewsDto;
  articles: ArticleDto[] = [];

  ngOnChanges(changes: SimpleChanges): void {
    this.articles = this.news.articles;
    console.log(this.articles);
  }
}
