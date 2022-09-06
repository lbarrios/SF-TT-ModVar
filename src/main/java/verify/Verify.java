package verify;

sealed interface X permits Verify {}
final public class Verify implements X {
  public static void main(String[] args) {
    System.out.println("Hello Java 18 World!");
  }
}
