package day6

object Puzzle1 {
  def sumOfDistinctCounts(lines: Seq[String]): Int = {
    val answers: Seq[Seq[String]] = groupLines(lines)
    val answerSets: Seq[Set[Char]] = {
      answers.map(strings => strings.foldLeft(Set.empty[Char]) {
        case (distinctChars, s) => distinctChars ++ s.toCharArray
      })
    }
    answerSets.map(_.size).sum
  }

  def sumOfIntersectionsCounts(lines: Seq[String]): Int = {
    val answers: Seq[Seq[String]] = groupLines(lines)
    val answerSets: Seq[Set[Char]] = {
      answers.map(strings => strings.foldLeft(('a' to 'z').toSet) {
        case (commonChars, s) => commonChars.intersect(s.toCharArray.toSet)
      })
    }
    answerSets.map(_.size).sum
  }

  def groupLines(lines: Seq[String]): Seq[Seq[String]] = {
    var groups: Seq[Seq[String]] = Seq.empty
    var linesToPartition: Seq[String] = lines
    while (linesToPartition.nonEmpty) {
      val (g: Seq[String], tail: Seq[String]) = linesToPartition.span(_ != "")
      groups = groups :+ g
      linesToPartition = if (tail.isEmpty) tail else tail.tail
    }
    groups
  }

}
