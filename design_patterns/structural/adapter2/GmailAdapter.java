package design_patterns.structural.adapter2;


import design_patterns.structural.adapter2.Gmail.GmailClient;

public class GmailAdapter implements EmailProvider {
  private GmailClient client = new GmailClient();

  @Override
  public void downloadEmails() {
    client.connect();
    client.getEmails();
    client.disconnect();
  }
}
