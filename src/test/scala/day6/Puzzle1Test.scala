package day6

import org.scalatest.flatspec.AnyFlatSpec

import scala.io.{BufferedSource, Source}

class Puzzle1Test extends AnyFlatSpec {

  behavior of "Puzzle1Test"

  it should "groupLines" in {
    assert(Puzzle1.groupLines(Seq("abc", "", "a", "b", "c")) === Seq(Seq("abc"), Seq("a", "b", "c")))
  }

  it should "sumOfDistinctCounts" in {
    assert(Puzzle1.sumOfDistinctCounts(Seq("abc", "", "a", "b", "c", "", "ab", "bc", "", "a", "a", "a", "a", "", "b")) == 11)
  }

  it should "sumOfIntersectionCounts" in {
    assert(Puzzle1.sumOfIntersectionsCounts(Seq("abc", "", "a", "b", "c", "", "ab", "bc", "", "a", "a", "a", "a", "", "b")) == 6)
  }

  it should "solve the first puzzle" in {
    val lines: BufferedSource = Source.fromURL(getClass.getResource("/" + getClass.getPackageName + "/input.txt"))
    assert(Puzzle1.sumOfDistinctCounts(lines.getLines().toSeq) == 6387)
  }

  it should "solve the second puzzle" in {
    val lines: BufferedSource = Source.fromURL(getClass.getResource("/" + getClass.getPackageName + "/input.txt"))
    assert(Puzzle1.sumOfIntersectionsCounts(lines.getLines().toSeq) == 3039)
  }
}
