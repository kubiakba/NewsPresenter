import {Component} from '@angular/core';
import {NewsDto} from "../dto/news-dto";
import {NewsService} from "../news-service/news-service";

@Component({
  selector: 'app-news',
  template: `
    <div style="background-color: #B9D3EE">
      <br/>
      <form class="form-inline">
        <div class="form-group">
          <input [(ngModel)]="category" name="category" type="text" list="categories" class="form-control" placeholder="category"/>
          <datalist id="categories">
            <option>sports</option>
            <option>finance</option>
          </datalist>
        </div>
        <div class="form-group">
          <select [(ngModel)]="country" name="country" id="country" class="form-control">
            <option *ngFor="let country of countries">
              {{country}}
            </option>
          </select>
          <button class="form-group mx-2 btn btn-md light" (click)="getNews()">find</button>
        </div>
      </form>
      <div *ngIf="news != null">
        <app-news-view [news]="news"></app-news-view>
      </div>
    </div>
  `
})

export class NewsComponent {

  news: NewsDto;
  countries: String[] = ["ae", "ar", "at", "au", "be", "bg", "br", "ca", "ch", "cn", "co", "cu", "cz", "de", "eg", "fr", "gb", "gr", "hk", "hu", "id", "ie", "il", "in", "it", "jp", "kr", "lt", "lv", "ma", "mx", "my", "ng", "nl", "no", "nz", "ph", "pl", "pt", "ro", "rs", "ru", "sa", "se", "sg", "si", "sk", "th", "tr", "tw", "ua", "us", "ve", "za"];
  country: String = "pl";
  category: String = "";

  constructor(private newsService: NewsService) {
  }

  getNews() {
    this.newsService.getNews(this.country, this.category).subscribe(news => {
      this.news = new NewsDto(news);
    });
  }
}
