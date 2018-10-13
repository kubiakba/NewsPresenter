export class ArticleDto {

  author: String;
  title: String;
  description: String;
  date: String;
  sourceName: String;
  articleUrl: String;
  imageUrl: String;

  constructor(data:any) {
    this.author = data.author || "-";
    this.title = data.title || "-";
    this.description = data.description || "-";
    this.date = data.date || "-";
    this.sourceName = data.sourceName || "-";
    this.articleUrl = data.articleUrl || "-";
    this.imageUrl = data.imageUrl || "-";
  }
}
