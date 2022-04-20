package day3

object Puzzle1 {
  def numberOfTrees(lines: Seq[String], tree: Char, rightPerStep: Int, downPerStep: Int = 1): Int = {
    (lines.indices by downPerStep).map { i => lines(i).charAt((i * rightPerStep / downPerStep) % lines(i).length) }.count(_ == tree)
  }
}
