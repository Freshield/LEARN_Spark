import scala.io.Source

/**
  * Created by freshield on 24/12/16.
  */
object File2JSON {

  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("TJTest.txt")
    var title = ""
    for (line <- file.getLines()){
      if (line.contains("T")){

      }
    }
  }

}
