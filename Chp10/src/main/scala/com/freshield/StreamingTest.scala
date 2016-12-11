package com.freshield

/**
  * Created by freshield on 11/12/16.
  */
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._

object StreamingTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    val ssc = new StreamingContext(conf, Seconds(1))
    val lines = ssc.socketTextStream("localhost",7777)
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map(word => (word,1))
    val wordCount = pairs.reduceByKey(_+_)
    wordCount.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
