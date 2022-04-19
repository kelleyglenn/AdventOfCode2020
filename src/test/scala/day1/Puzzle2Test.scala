package day1

import org.scalatest.flatspec.AnyFlatSpec

import scala.io.{BufferedSource, Source}

class Puzzle2Test extends AnyFlatSpec {
  behavior of "Puzzle2"

  it should "solve simple problem" in {
    assert(Puzzle2.productOfXEntriesWithSum(Seq(1, 2, 3), 6, 3).contains(6))
    assert(Puzzle2.productOfXEntriesWithSum(Seq(123, 1, 432, 2, 76, 3, 32), 6, 3).contains(6))
  }

  it should "solve the puzzle" in {
    val bufferedSource: BufferedSource = Source.fromURL(getClass.getResource("/day1/input.txt"))
    val input: Seq[Int] = bufferedSource.getLines.toSeq.map(_.toInt)
    assert(Puzzle2.productOfXEntriesWithSum(input, 2020, 3).contains(276650720))
  }
}
