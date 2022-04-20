package day4

import org.scalatest.flatspec.AnyFlatSpec

import scala.io.Source

class Puzzle1Test extends AnyFlatSpec {

  behavior of "Puzzle1Test"

  it should "countValidPassportsByRequiredKeys" in {
    assert(Puzzle1.countValidPassportsByRequiredKeys(Seq("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\nbyr:1937 iyr:2017 cid:147 hgt:183cm"))
      == 1)
    assert(Puzzle1.countValidPassportsByRequiredKeys(Seq("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\nhcl:#cfa07d byr:1929"))
      == 0)
  }

  it should "groupPassportLines" in {
    assert(Puzzle1.groupPassportLines(Seq("line1", "", "line2")) === Seq(Seq("line1"), Seq("line2")))
  }

  it should "solve puzzle 1" in {
    val source = Source.fromURL(getClass.getResource("/" + getClass.getPackageName + "/input.txt"))
    val input = source.getLines().toSeq
    assert(Puzzle1.countValidPassportsByRequiredKeys(input) == 210)
  }

  it should "handle individual validations" in {
    assert(Puzzle1.keyValidations("byr")("2002"))
    assert(!Puzzle1.keyValidations("byr")("2003"))
    assert(Puzzle1.keyValidations("hgt")("60in"))
    assert(Puzzle1.keyValidations("hgt")("190cm"))
    assert(!Puzzle1.keyValidations("hgt")("190in"))
    assert(!Puzzle1.keyValidations("hgt")("190"))
    assert(Puzzle1.keyValidations("hcl")("#123abc"))
    assert(!Puzzle1.keyValidations("hcl")("#123abz"))
    assert(!Puzzle1.keyValidations("hcl")("123abc"))
    assert(Puzzle1.keyValidations("ecl")("brn"))
    assert(!Puzzle1.keyValidations("ecl")("wat"))
    assert(Puzzle1.keyValidations("pid")("000000001"))
    assert(!Puzzle1.keyValidations("pid")("0123456789"))
  }

  it should "countValidPassportsByValueValidation" in {
    assert(Puzzle1.countValidPassportsByValueValidation(Seq("eyr:1972 cid:100\nhcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926"))
      == 0)
    assert(Puzzle1.countValidPassportsByValueValidation(Seq("pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\nhcl:#623a2f"))
      == 1)
  }

  it should "solve puzzle 2" in {
    val source = Source.fromURL(getClass.getResource("/" + getClass.getPackageName + "/input.txt"))
    val input = source.getLines().toSeq
    assert(Puzzle1.countValidPassportsByValueValidation(input) == 131)
  }
}
