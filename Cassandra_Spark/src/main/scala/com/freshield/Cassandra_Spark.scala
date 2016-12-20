package com.freshield

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._

/**
  * Created by freshield on 19/12/16.
  */
object Cassandra_Spark {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf(true)
      .set("spark.cassandra.connection.host","127.0.0.1")

    val sc = new SparkContext(conf)

    import com.datastax.spark.connector._

    val data = sc.cassandraTable("tutorialspoint","emp")

    data.map(row => row.getVarInt("emp_phone")).foreach(println)

    println("done")
  }

}
