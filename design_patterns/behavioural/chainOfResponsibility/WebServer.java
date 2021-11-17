package design_patterns.behavioural.chainOfResponsibility;

public class WebServer {
  private Handler handler;

  public WebServer(Handler handler) {
    this.handler = handler;
  }

  public void handle(HttpRequest request) {
    handler.handle(request);
  }
}
