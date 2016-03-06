package jp.itohiro.kata.scala

import org.scalatest.FunSuite

class FpInScalaKata extends FunSuite {

  test("formatResult function should format.") {
    assert("The absolute value of -42 is 42" == FpInScala.formatResult("absolute value", -42, FpInScala.abs))
    assert("The factorial of 4 is 24" == FpInScala.formatResult("factorial", 4, FpInScala.factorial))
    assert("The fibonacci of 6 is 8" == FpInScala.formatResult("fibonacci", 6, FpInScala.fib))
  }

  test("partial1, curry, uncurry, composite should work.") {
    assert(3 == FpInScala.partial1(1, FpInScala.add)(2))
    assert(3 == FpInScala.curry(FpInScala.add)(1)(2))
    assert(3 == FpInScala.uncurry(FpInScala.addCurry)(1, 2))

    assert("HELLO WORLD" == FpInScala.composite(FpInScala.toUpper, FpInScala.hello)("World"))
  }
}
