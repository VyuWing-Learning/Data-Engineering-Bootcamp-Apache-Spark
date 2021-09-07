package com.example
import org.apache.spark.sql.SparkSession
object App {
  def main(args: Array[String]): Unit = {
    //use the spark variable as spark session in local to build and run your code
    val spark = SparkSession.builder().appName("test").master("local[4]").getOrCreate()
    println("hello")
  }
}
