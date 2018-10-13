import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/index";

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  news_url = "/news";

  constructor(private http: HttpClient) {
  }

  public getNews(country: String, category: String): Observable<any[]> {
    return this.http.get<any[]>(this.news_url + `/${country}/${category}`);
  }
}
