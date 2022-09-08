package nonpublic;

import provider.MyServiceIf;

public class MyServiceImpl implements MyServiceIf {
  @Override
  public String getMessage() {
    return "This message came from a service";
  }
}
