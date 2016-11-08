package com.freshield

/**
  * Created by freshield on 16-11-8.
  */

import org.apache.spark.rdd
import org.apache.spark.rdd._

class SearchFunctions(val query: String) {
  def isMatch(s: String): Boolean = {
    s.contains(query)
  }

}
