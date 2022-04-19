package day2

import scala.util.matching.Regex

object Puzzle1 {
  val regex: Regex = "(\\d+)-(\\d+) (\\w): (.+)".r

  def isLineValid(line: String): Boolean = {
    val regex(min, max, c, password) = line
    isPasswordValid(min.toInt, max.toInt, c.head, password)
  }

  def isPasswordValid(min: Int, max: Int, c: Char, password: String): Boolean = {
    val count = password.count(_ == c)
    min <= count && count <= max
  }
}
