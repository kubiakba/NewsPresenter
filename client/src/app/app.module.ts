import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {NewsComponent} from './news/news.component';
import {HttpClientModule} from "@angular/common/http";
import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {NewsViewComponent} from './news-view/news-view.component';
import {NgxPaginationModule} from "ngx-pagination";

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent,
    NewsViewComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
