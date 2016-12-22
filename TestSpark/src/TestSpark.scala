/**
  * Created by freshield on 26/12/16.
  */

import java.io.{File, PrintWriter}

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.json4s.JsonDSL._
import org.json4s._
import org.json4s.jackson.JsonMethods._

object TestSpark {
  case class Values(lat: String, lon: String, Time: String)
  case class Trajecotrys(name: String, values: List[Values])

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("TestSpark")
    val sc = new SparkContext(conf)

    val file = sc.textFile("Trajectory_*.txt",1)

    var temp = ""
    val pairs = file.filter(line =>{
      line.contains("T") || (
        !line.contains("T") &&
        line.contains(",") &&
        line.split(",").length == 3 &&
        {
          val temp = line.split(",")
          temp(0) != "" && temp(1) != "" && temp(2) != ""
        }
        )
    }).map(line => {
      if (line.contains("T")){
        temp = line
        ("Title",line)
      }else{
        val value = line.split(",")
        val json =
              ("Lat" -> value(0)) ~
              ("Lon" -> value(1)) ~
              ("Time" -> value(2))

        (temp,pretty(render(json)))
      }
    })


    val reduce = pairs.filter{case (key, value) => key != "Title"}.reduceByKey((x,y) => x + "," + y)


    val result = reduce.foreach(x => {
      val writer = new PrintWriter(new File("/home/freshield/test/"+x._1+".json"))
      writer.println("{\""+x._1+"\":["+x._2+"]}")
      writer.close()
    })

    sc.stop()
  }

}
