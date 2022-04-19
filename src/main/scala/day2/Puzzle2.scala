package day2

import scala.util.matching.Regex

object Puzzle2 {
  val regex: Regex = "(\\d+)-(\\d+) (\\w): (.+)".r

  def isLineValid(line: String): Boolean = {
    val regex(pos1, pos2, c, password) = line
    Seq(password(pos1.toInt - 1), password(pos2.toInt - 1)).count(_ == c.head) == 1
  }
}
