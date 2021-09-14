package DesignPatterns.structural.facade;

public class Demo {
  public static void show() {
    var twitterAPI = new TwitterAPI("appKey", "secret");
    var tweets = twitterAPI.getRecentTweets();
  }
}
