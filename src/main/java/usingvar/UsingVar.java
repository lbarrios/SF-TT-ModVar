package usingvar;

import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.function.BiFunction;

public class UsingVar {

  // var is ONLY for method local variables (include *lambda* formal params)
//  public var name = "Fred"; // NOPE

  public static void main(String[] args) {
//    final long x = 99;
//    byte b = x;

    var x = 99;
//    x = "Hello"; // NOT dynamic typing!!!

//    x ++;
    var s = "Hello";
//    var t; // NOPE, must initialize in the declaration statement
//    t = 99.9;

//    var ia = new int[10];
//    var ia = new int[]{1, 2, 3};
//    int[] ia = {1, 2, 3}; // type inferencing for the array base type
//    var ia = {1, 2, 3}; // NOT PERMITTED, dual inferencing!?

    BiFunction<String, Integer, Boolean> bfsib =
//        (@Deprecated String str, Integer i) -> true;

        // must have NO specfied types to use the following
//        (str, i) -> true; // ONLY if the formal param types are inferrable

        // ASSUMING inferrable formal param types:
        // This allows type inference WITH annotation for formal param
        (@Deprecated var str, var i) -> true; // ONLY if the formal param types are inferrable

    // var is a "context sensitive 'pseudo-type'"
    // if you put "var" in a place expecting a type name,
    // it tries to be magical, elsewhere, it's just an identifier
    var var = 99;

    var obj =
        true ? "Hello" : 99;
//    obj.compareTo(null);
//    obj.describeConstable();

  }
}

//class var {} // NOPE!!!