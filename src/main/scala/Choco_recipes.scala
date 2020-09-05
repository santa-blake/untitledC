import java.io.FileWriter

object Choco_recipes extends App {
  //  val f = scala.io.Source.fromFile(arg)
  //  for ((line,i) <- f.getLines().zipWithIndex) {
  //    println(s"${line.length.toString}::: $line")
  val workingDir = System.getProperty("user.dir")
  val srcName = s"$workingDir\\resources\\13177-8.txt"
  val dstName = s"$workingDir\\resources\\13177-8-results.txt"

  def openSource(fName: String): Seq[String] = {
    println(s"Reading a file from source: $fName")
    val filePointer = scala.io.Source.fromFile(fName)
    val myLines = filePointer.getLines.toList
    filePointer.close()

    myLines
  }

  def processSeq(mySeq:Seq[String]): Seq[String]= {
    var newSeq: Seq[String] = Seq()
    for (i <- 0 to 8 by 2) {
      newSeq = newSeq :+ mySeq(i)
    }
    val funSeq = mySeq.zipWithIndex.filter(t => t._2 % 2 == 0 && t._2 < 12).map(t => t._1)
    funSeq
  }

  def saveSeq(dstName: String, mySeq:Seq[String]): Any = {
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