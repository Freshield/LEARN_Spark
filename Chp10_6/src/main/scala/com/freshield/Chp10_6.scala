package com.freshield

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.Duration
import org.apache.spark.streaming.Seconds
import org.apache.spark.SparkConf

/**
  * Created by freshield on 22/12/16.
  */
object Chp10_6 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Streaming Test")
    val ssc = new StreamingContext(conf,Seconds(1))
    val lines = ssc.socketTextStream("localhost",7777)
    val errorLInes = lines.filter(_.contains("error"))
    errorLInes.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
