package day2

import org.scalatest.flatspec.AnyFlatSpec

import scala.io.{BufferedSource, Source}

class Puzzle2Test extends AnyFlatSpec {

  behavior of "isLineValid"
  it should "handle simple cases" in {
    assert(Puzzle2.isLineValid("1-3 a: abcde"))
    assert(!Puzzle2.isLineValid("1-3 b: cdefg"))
  }
  it should "solve the puzzle" in {
    val bufferedSource: BufferedSource = Source.fromURL(getClass.getResource("/day2/input.txt"))
    assert(bufferedSource.getLines().count(l => Puzzle2.isLineValid(l)) == 489)
  }

}
