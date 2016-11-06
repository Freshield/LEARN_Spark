package com.liu

/**
 * Hello world!
 *
 */

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object App extends{
  def main(args: Array[String]) {
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val text = sc.textFile("file:///mnt/usb/spark-1.2.0-bin-hadoop2.4/README.md")
    val result = text.flatMap(_.split(' ')).map((_,1)).reduceByKey(_+_).collect()
    result.foreach(println)
  }
}
