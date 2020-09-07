import java.io.FileWriter

object Choco_recipes extends App {
  val workingDir = System.getProperty("user.dir")
  val srcName = s"$workingDir\\resources\\13177-8.txt"
  val dstName = s"$workingDir\\resources\\13177-8-results.txt"

  def openSource(fName: String) = {
    println(s"Reading a file from source: $fName")
    val filePointer = scala.io.Source.fromFile(fName, "UTF-8")
    val myLines = filePointer.getLines.toSeq
    filePointer.close()
    myLines
  }

  def processSeq(mySeq:Seq[String]): Seq[String]= {

//    val RecipeNames = mySeq.slice(3296,3498)
//    println(RecipeNames mkString "\n")

//      val parts: Seq[String] = mySeq.filter(n => n == n.toUpperCase || n.startsWith("    "))
//      val noEmptyS = recipe.filter(row => row!= null && row.length>0)
//      noEmptyS.slice(45,607)
//    }

//    val upperWords: _.isUpperCase
//    val recipe_titles = mySeq.slice(60, 2957).filter(_.(upperWords))
//    println(s"here are $recipe_titles")

 //val datMap = mySeq.slice(60, 2957).filter(_.isallUpper)
    //println(s"$datMap")

    //  val titleSeq = mySeq.zipWithIndex.filter(t => t._2 % 1 == 0 && t._2 < 100).map(t => t._1)
    //    println(s"ss$titleSeq")
    //    titleSeq

    //val UpperCaseFilter = mySeq.filter(rec => rec().isLetter).filter(rec => rec == rec.toUpperCase())
    //println(s"ssss$UpperCaseFilter")
    //    UpperCaseFilter


    //    def testAllUpperCase(str: String): Boolean = {
    //  for (i <- 0 until str.length) {
    //    val c = str.charAt(i)
    //    if (c >= 97 && c <= 122) return false
    //  }
    //  //str.charAt(index)
    //  return true
    //}

    //initial approach - failed to make:  val startingLines = (_.startswith("    ")) 2957
    val blanks: String = "    "
    val productsUsed = mySeq.slice(60, 2957).filter(_.contains(blanks))

productsUsed
  }

  def saveSeq(dstName: String, mySeq:Seq[String]) = {
    println(s"Saving my Sequence to file $dstName")
    mySeq.foreach(println)
    val fw = new FileWriter(dstName)
    mySeq.map(_ + "\n").foreach(fw.write)
    fw.close()
  }

  val mySeq = openSource(srcName)
  val filteredSeq = processSeq(mySeq)
  saveSeq(dstName,filteredSeq)
}