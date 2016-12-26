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

    val file = sc.textFile("TJTest.txt",1)

    var temp = ""
    val pairs = file.map(line => {
      if (line.contains("T")){
        temp = line
        ("Title",line)
      }else{
        val value = line.split(",")
        val valuePair = ("value",(("Lat",value(0)),("Lon",value(1),("Time",value(2)))))
        (temp,valuePair)
      }
    })

    val reduce = pairs.filter{case(key,value) => (key != "Title")}.groupByKey()

    reduce.foreach(println)

    sc.stop()
  }

}
