import {Component, OnInit} from '@angular/core';
import {NewsService} from "../news-service/news-service";
import {NewsDto} from "../dto/news-dto";

@Component({
  selector: 'app-news',
  template: ''
})
export class NewsComponent implements OnInit {

  news: NewsDto[] = [];

  constructor(private newsService: NewsService) {
  }

  ngOnInit() {
    this.newsService.getNews("pl", "sports").subscribe(newsArray => {
      Array.from(newsArray).forEach(news => this.news.push(new NewsDto(news)));
    });
  }

}
