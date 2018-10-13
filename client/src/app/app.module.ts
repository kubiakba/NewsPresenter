import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NewsComponent} from './news/news.component';
import {HttpClientModule} from "@angular/common/http";
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent,
    NewsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
