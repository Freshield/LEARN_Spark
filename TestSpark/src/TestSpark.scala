/**
  * Created by freshield on 26/12/16.
  */

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object TestSpark {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("TestSpark")
    val sc = new SparkContext(conf)

    val file = sc.textFile("TJTest.txt")

    file.foreach(println)

    sc.stop()
  }

}
