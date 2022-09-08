package consumer;

//compile with:
//  javac -d modules/ --module-source-path "./*/src/main/java" --module my.provider,my.client
//run with
//  java --module-path modules --module my.client/consumer.Main

//import nonpublic.MessageHacker;
import provider.MyProvider;
import provider.MyServiceIf;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

public class Main {
  public static void main(String[] args) throws Throwable {
//    System.setSecurityManager(new SecurityManager());
    System.out.println(provider.MyProvider.message);

    //    System.out.println(nonpublic.LocalMessage.myLocalMessage);
//    System.out.println(MessageHacker.getMessage());

//        System.out.println(provider.MyProvider.secretMessage);
    Class<?> clazz = provider.MyProvider.class;
    Field secretField = clazz.getDeclaredField("secretMessage");
    secretField.setAccessible(true); // disable access checks
    Object sfValue = secretField.get(null);
    System.out.println("secret message is " + sfValue);
    secretField.set(null, "Bwahahahahaha, I hacked you");
    System.out.println(MyProvider.getSecretMessage());

    // Look for services of type provider.MyServiceIf
    ServiceLoader<MyServiceIf> loader = ServiceLoader.load(MyServiceIf.class);
    for (MyServiceIf srv : loader) {
      System.out.println("Found a service impl: " + srv.getClass().getName());
      System.out.println("Message is " + srv.getMessage());
    }

  }
}
