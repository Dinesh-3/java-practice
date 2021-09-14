package DesignPatterns.structural.adapter;


import DesignPatterns.structural.adapter.Gmail.GmailClient;

public class GmailAdapter implements EmailProvider {
  private GmailClient client = new GmailClient();

  @Override
  public void downloadEmails() {
    client.connect();
    client.getEmails();
    client.disconnect();
  }
}
