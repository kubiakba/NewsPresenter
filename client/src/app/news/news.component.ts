import {Component} from '@angular/core';
import {NewsDto} from "../dto/news-dto";
import {NewsService} from "../news-service/news-service";

@Component({
  selector: 'app-news',
  template: `
    <form>
      <div class="form-group col-md-2">
        <div>
          <label for="category">Kategoria</label>
          <input [(ngModel)]="category" name="category" type="text" list="categories" class="form-control"/>
          <datalist id="categories">
            <option>sports</option>
            <option>finance</option>
          </datalist>
        </div>
        <div>
          <label for="country">Kraj</label>
          <select [(ngModel)]="country" name="country" id="country" class="form-control">
            <option *ngFor="let country of countries">
              {{country}}
            </option>
          </select>
        </div>
        <button class="btn light" (click)="getNews()">Wyszukaj</button>
      </div>
    </form>`
})

export class NewsComponent {

  news: NewsDto[] = [];
  countries: String[] = ["ae", "ar", "at", "au", "be", "bg", "br", "ca", "ch", "cn", "co", "cu", "cz", "de", "eg", "fr", "gb", "gr", "hk", "hu", "id", "ie", "il", "in", "it", "jp", "kr", "lt", "lv", "ma", "mx", "my", "ng", "nl", "no", "nz", "ph", "pl", "pt", "ro", "rs", "ru", "sa", "se", "sg", "si", "sk", "th", "tr", "tw", "ua", "us", "ve", "za"];
  country: String = "pl";
  category: String = "";

  constructor(private newsService: NewsService) {
  }

  getNews() {
    this.newsService.getNews(this.country, this.category).subscribe(newsArray => {
      Array.from(newsArray).forEach(news => this.news.push(new NewsDto(news)));
    });
  }
}
