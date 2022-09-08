import nonpublic.MyServiceImpl;
import provider.MyServiceIf;

/*open*/ module my.provider {
  requires java.base; // implicit!!! kinda like java.lang
  exports provider to nonexistent, my.client;
//  exports nonpublic;
  opens provider to other.stuff, my.client;
  provides MyServiceIf with MyServiceImpl;
}
