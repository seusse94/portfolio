import {Tweet} from "./tweet";

export class Portfolio {

  public name: string;
  public title: string;
  public description: string;
  public imageUrl: string;
  public tweets: Tweet[];


  constructor(name: string, title: string, description: string, imageUrl: string, tweets: any[]) {
    this.name = name;
    this.title = title;
    this.description = description;
    this.imageUrl = imageUrl;
    this.tweets = this.buildTweets(tweets);
  }

  private buildTweets(tweets: any): Tweet[] {
    return tweets != null ? tweets.map(t => new Tweet(t.user.name, t.text)) : [];
  }

}
