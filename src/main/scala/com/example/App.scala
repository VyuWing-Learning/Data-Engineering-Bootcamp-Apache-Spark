package com.example
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.sql.functions._
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

import java.sql.Timestamp
object App {

  case class Log(ip:String,datetime:String,requesttype:String,path:String,status:Integer, PageSize:String,referer:String,agent:String)

  def processdata(spark:SparkSession,fileLoc:String) = {
    val rdd = spark.sparkContext.textFile(fileLoc,30)
    val rdd1 = rdd.map(line=> {
        val pattern = "([0-9.]+) - - \\[([^\\]]+)\\]\\s?+\\\"([A-Z]+)\\s?+([^\\\"]+)\\\"\\s?+([0-9]+)\\s?+([0-9]+)\\s?+\\\"([^\\\"]+)\\\"\\s?+\\\"([^\\\"]+)\\\"".r
        val groups = pattern.findAllIn(line)
        if(groups.hasNext){
          Log(groups.group(1),groups.group(2),groups.group(3),groups.group(4),Integer.parseInt(groups.group(5))
            ,groups.group(6),groups.group(7),groups.group(8))
        } else
          null
    }).filter(x=> x != null)

    val df = spark.createDataFrame(rdd1)
    df.coalesce(3).write.option("compression","none").mode("overwrite").parquet("data/logdata/")
  }

  def botsAndMobileFeatures(df:Dataset[Row],spark:SparkSession):DataFrame = {
    df.withColumn("isBot",when(lower(col("agent")).contains("bot"),true).otherwise(false))
      .withColumn("isAndroid",when(col("isBot") === false && col("agent").contains("Android"),true).otherwise(false))
      .withColumn("isIphone",when(col("isBot") === false && col("agent").contains("Iphone"),true).otherwise(false))
  }

  def parsedatetime(datetime:String):Timestamp = {
    val dtFmt = DateTimeFormat.forPattern("dd/MMM/yyyy:HH:mm:ss Z")
    val dt = DateTime.parse(datetime,dtFmt)
    new Timestamp(dt.getMillis)
  }

  def processDatetimeFeatures(df:Dataset[Row],spark:SparkSession):Dataset[Row] = {
    val parsedate = udf((dt:String) => parsedatetime(dt))
    df.withColumn("datetime",parsedate(col("datetime")))
      .withColumn("hour",hour(col("datetime")))
      .withColumn("date",to_date(col("datetime")))
      .withColumn("dayofWeek",dayofweek(col("datetime")))
  }

  def main(args: Array[String]): Unit = {
    //use the spark variable as spark session in local to build and run your code
    val spark = SparkSession.builder().appName("test").master("local[4]").getOrCreate()


    //for windows users
    /**
     * System.setProperty("hadoop.home.dir","<path to the hadoop binaries>")
       val spark = SparkSession.builder().appName("test").config("spark.driver.memory","6g")
                .config("spark.testing.memory","1g").master("local[*]").getOrCreate()
     */
    processdata(spark,"data/access.log")


    val df = spark.read.parquet("data/logdata")
    df.select("agent").show(50,false)
    var df1 = botsAndMobileFeatures(df,spark)
    df1.show()
    df1 = processDatetimeFeatures(df1,spark)
    df1.show()

    /**
     * SQL API of spark
     */

    df1.createOrReplaceTempView("logdata")

    var df2 = spark.sql("select date,hour, count(1) from logdata group by date, hour order by date,hour")
    df2.show()




    println("hello")
  }
}
