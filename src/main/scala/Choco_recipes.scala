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

      val recipe: Seq[String] = mySeq.filter(n => n == n.toUpperCase || n.startsWith("    "))
      val noEmptyrows = recipe.filter(row => row!= null && row.length>0)
      noEmptyrows.slice(45,607)

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