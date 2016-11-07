package com.freshield

/**
  * Created by freshield on 16-11-6.
  */

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object WordCount {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("wordCount")
    val sc = new SparkContext(conf)
    val input = sc.textFile("file:///mnt/usb/spark-1.2.0-bin-hadoop2.4/README.md")
    val words = input.flatMap(line => line.split(" "))
    val counts = words.map(word => (word, 1)).reduceByKey{case (x, y) => x + y}
    counts.foreach(println)
    counts.saveAsTextFile("file:///mnt/usb/WordCount")
  }

}
