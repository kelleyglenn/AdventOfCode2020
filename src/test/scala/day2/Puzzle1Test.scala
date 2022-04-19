package day2

import org.scalatest.flatspec.AnyFlatSpec

import scala.io.{BufferedSource, Source}

class Puzzle1Test extends AnyFlatSpec {
  behavior of "regex"
  it should "match correctly" in {
    assert(Puzzle1.regex.matches("1-2 a: steak"))
    assert(Puzzle1.regex.matches("01-02 a: steak"))
  }
  behavior of "isPasswordValid"
  it should "handle simple input" in {
    assert(Puzzle1.isPasswordValid(1, 2, 'a', "steak"))
    assert(!Puzzle1.isPasswordValid(2, 3, 'a', "steak"))
  }
  behavior of "isLineValid"
  it should "handle simple input" in {
    assert(Puzzle1.isLineValid("01-02 a: steak"))
    assert(!Puzzle1.isLineValid("2-10 a: steak"))
  }
  it should "solve the puzzle" in {
    val bufferedSource: BufferedSource = Source.fromURL(getClass.getResource("/day2/input.txt"))
    assert(bufferedSource.getLines().count(l => Puzzle1.isLineValid(l)) == 538)
  }
}
