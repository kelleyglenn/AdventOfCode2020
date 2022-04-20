package day3

import org.scalatest.flatspec.AnyFlatSpec

import scala.io.Source

class Puzzle1Test extends AnyFlatSpec {

  behavior of "numberOfTrees"

  it should "handle simple case" in {
    val input: Seq[String] = "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#".linesIterator.toSeq
    assert(Puzzle1.numberOfTrees(input, '#', 3) == 7)
  }
  it should "solve the first puzzle" in {
    val source = Source.fromURL(getClass.getResource("/day3/input.txt"))
    assert(Puzzle1.numberOfTrees(source.getLines().toSeq, '#', 3) == 200)
  }
  it should "handle the second example" in {
    val input: Seq[String] = "..##.......\n#...#...#..\n.#....#..#.\n..#.#...#.#\n.#...##..#.\n..#.##.....\n.#.#.#....#\n.#........#\n#.##...#...\n#...##....#\n.#..#...#.#".linesIterator.toSeq
    val slopes: Seq[(Int, Int)] = Seq((1, 1), (3, 1), (5, 1), (7, 1), (1, 2))
    val trees = slopes.map { case (right, down) => Puzzle1.numberOfTrees(input, '#', right, down) }
    assert(trees.product == 336)
  }
  it should "solve the second puzzle" in {
    val source = Source.fromURL(getClass.getResource("/day3/input.txt"))
    val input = source.getLines().toSeq
    val slopes: Seq[(Int, Int)] = Seq((1, 1), (3, 1), (5, 1), (7, 1), (1, 2))
    val trees: Seq[Long] = slopes.map { case (right, down) => Puzzle1.numberOfTrees(input, '#', right, down).toLong }
      assert(trees.product == 3737923200L)
  }

}
