package jp.itohiro.kata.java;

import org.junit.Assert;
import org.junit.Test;

public class FpInJavaKata {
    @Test
    public void testFunctions() {
        Functions<Integer, Integer, Integer> functions = new Functions<>();
        Functions<String, String, String> functionsString = new Functions<>();
        Assert.assertEquals(3, (int) functions.partial(1, add).apply(2));
        Assert.assertEquals(3, (int) functions.curry(add).apply(1).apply(2));
        Assert.assertEquals(3, (int) functions.uncurry(addCurry).apply(1, 2));
        Assert.assertEquals("HELLO WORLD", functionsString.compose(String::toUpperCase, s -> "Hello " + s).apply("World"));
    }
}
