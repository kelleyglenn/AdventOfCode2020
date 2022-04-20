package day5

import org.scalatest.flatspec.AnyFlatSpec

import scala.io.{BufferedSource, Source}

class Puzzle1Test extends AnyFlatSpec {

  behavior of "Puzzle1Test"

  it should "row" in {
    assert(Puzzle1.row("BFFFBBFRRR".take(7)) == 70)
  }

  it should "seat" in {
    assert(Puzzle1.seat("BFFFBBFRRR".drop(7)) == 7)
  }

  it should "seatID" in {
    assert(Puzzle1.seatID("BFFFBBFRRR") == 567)
    assert(Puzzle1.seatID("FFFBBBFRRR") == 119)
    assert(Puzzle1.seatID("BBFFBBFRLL") == 820)
  }

  it should "solve the first puzzle" in {
    val input: BufferedSource = Source.fromURL(getClass.getResource("/" + getClass.getPackageName + "/input.txt"))
    assert(input.getLines().toSeq.map(l => Puzzle1.seatID(l)).max == 871)
  }

  it should "solve the second puzzle" in {
    val input: BufferedSource = Source.fromURL(getClass.getResource("/" + getClass.getPackageName + "/input.txt"))
    val seatIDs: Iterator[Int] = input.getLines().map(l => Puzzle1.seatID(l))
    assert(Puzzle1.missingSeatID(seatIDs) == 640)
  }

}
