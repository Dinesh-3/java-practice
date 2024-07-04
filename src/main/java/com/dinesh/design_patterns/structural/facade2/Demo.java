package com.dinesh.design_patterns.structural.facade2;

public class Demo {
  public static void show() {
    var twitterAPI = new TwitterAPI("appKey", "secret");
    var tweets = twitterAPI.getRecentTweets();
  }
}
