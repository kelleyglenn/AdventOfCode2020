package day5

object Puzzle1 {
  def seatID(bsp: String): Int = {
    row(bsp.take(7)) * 8 + seat(bsp.drop(7))
  }

  def row(bsp: String): Int = {
    var range: Range = 0 to 127
    bsp.foreach(c => range = c match {
      case 'F' => range.splitAt(range.length / 2)._1
      case 'B' => range.splitAt(range.length / 2)._2
    })
    range.head
  }

  def seat(bsp: String): Int = {
    var range: Range = 0 to 7
    bsp.foreach(c => range = c match {
      case 'L' => range.splitAt(range.length / 2)._1
      case 'R' => range.splitAt(range.length / 2)._2
    })
    range.head
  }

  def missingSeatID(seatIDs: Iterator[Int]): Int = {
    val found: Array[Boolean] = new Array(128 * 8)
    seatIDs.foreach(i => found(i) = true)
    found.indices.drop(1).dropRight(1).find(i => found(i - 1) && found(i + 1) && !found(i)).get
  }
}
