package day4

object Puzzle1 {
  val keyValidations: Map[String, String => Boolean] = Map(
    "byr" -> { (s: String) => s.length == 4 && s.forall(_.isDigit) && s.toInt >= 1920 && s.toInt <= 2002 },
    "iyr" -> { (s: String) => s.length == 4 && s.forall(_.isDigit) && s.toInt >= 2010 && s.toInt <= 2020 },
    "eyr" -> { (s: String) => s.length == 4 && s.forall(_.isDigit) && s.toInt >= 2020 && s.toInt <= 2030 },
    "hgt" -> { (s: String) => {
      s.length >= 3 && s.dropRight(2).forall(_.isDigit) && (s.takeRight(2) match {
        case "cm" => s.dropRight(2).toInt >= 150 && s.dropRight(2).toInt <= 193
        case "in" => s.dropRight(2).toInt >= 59 && s.dropRight(2).toInt <= 76
        case _ => false
      })
    }
    },
    "hcl" -> { (s: String) => "#[0-9a-f]{6}".r.matches(s) },
    "ecl" -> { (s: String) => Set("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(s) },
    "pid" -> { (s: String) => s.length == 9 && s.forall(_.isDigit) }
  )

  def countValidPassportsByRequiredKeys(lines: Seq[String]): Int = {
    val passportLines: Seq[String] = groupPassportLines(lines).map(p => p.mkString(" "))
    val keyValueStringsPerPassport: Seq[Seq[String]] = passportLines.map(s => s.replace('\n', ' ').split(' '))
    val passportMaps: Seq[Map[String, String]] = {
      keyValueStringsPerPassport.map(kvs => kvs.map(kv => kv.split(':')(0) -> kv.split(':')(1)).toMap)
    }
    passportMaps.count(m => keyValidations.keys.toSet.diff(m.keys.toSet).isEmpty)
  }

  def countValidPassportsByValueValidation(lines: Seq[String]): Int = {
    val passportLines: Seq[String] = groupPassportLines(lines).map(p => p.mkString(" "))
    val keyValueStringsPerPassport: Seq[Seq[String]] = passportLines.map(s => s.replace('\n', ' ').split(' '))
    val passportMaps: Seq[Map[String, String]] = {
      keyValueStringsPerPassport.map(kvs => kvs.map(kv => kv.split(':')(0) -> kv.split(':')(1)).toMap)
    }
    passportMaps.count(m => keyValidations.keys.toSet.diff(m.keys.toSet).isEmpty && keyValidations.forall { case (key, validation) => validation(m(key)) })
  }

  def groupPassportLines(lines: Seq[String]): Seq[Seq[String]] = {
    var passports: Seq[Seq[String]] = Seq.empty
    var linesToPartition: Seq[String] = lines
    while (linesToPartition.nonEmpty) {
      val (p: Seq[String], tail: Seq[String]) = linesToPartition.span(_ != "")
      passports = passports :+ p
      linesToPartition = if (tail.isEmpty) tail else tail.tail
    }
    passports
  }
}
