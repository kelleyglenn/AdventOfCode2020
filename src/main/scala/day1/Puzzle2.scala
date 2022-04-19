package day1

object Puzzle2 {
  def productOfXEntriesWithSum(entries: Seq[Int], sum: Int, x: Int): Option[Int] = {
    if (sum < 0 || entries.length < x) None
    else if (x == 1) Option.when(entries.contains(sum))(sum)
    else {
      val foundProduct = productOfXEntriesWithSum(entries.tail, sum - entries.head, x - 1)
      if (foundProduct.nonEmpty) Some(foundProduct.get * entries.head)
      else productOfXEntriesWithSum(entries.tail, sum, x)
    }
  }
}
