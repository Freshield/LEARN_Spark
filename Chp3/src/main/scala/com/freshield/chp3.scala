package com.freshield

/**
  * Created by freshield on 16-11-8.
  */

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object chp3 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("chp3")
    val sc = new SparkContext(conf)

  }

}
