package provider;

public class MyProvider {
  public static String message = "Hello, I'm a message";
  private static String secretMessage = "Haha, you can't see me!";
  public static String getSecretMessage() {
    return "The secret message is " + secretMessage;
  }
}
