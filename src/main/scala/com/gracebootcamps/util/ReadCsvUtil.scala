package com.gracebootcamps.util
import java.util.NoSuchElementException
import scala.io.Source
import com.github.tototoshi.csv._
import java.io._

object ReadCsvUtil {
  def read(): Unit = {
    println("Reading CSV")

    val reader = CSVReader.open(new File("C:/var/data/file_in_g.csv"))
    //var reader = CSVReader.open(new File("sample.csv"))
    reader.readNext()

    //reader.all()
    reader.foreach(fields => println(fields))

    reader.close()
    println("Completed reading CSV")
  }

    def writer(): Unit = {
      println("Writing CSV")
      val resultSet2: java.sql.ResultSet = statement.executeQuery(query)
      val csvWriter = new CSVWriter(new FileWriter("Output.csv"), ',')
      csvWriter.writeAll(resultSet2, true)
      csvWriter.close()

      val writer = CSVWriter.open(new FileWriter("C:/var/data/test.csv"))
      //val writer = CSVWriter.open(new FileWriter(("test.csv"))
      writer.writeAll(List(List("a", "b", "c"),List("d", "e", "f")))
      /* CSVWriter.open(new FilterWriter("test.csv") ) {writer =>
          writer.writeAll(List(List("a", "b", "c"), List("d", "e","f")))}

      */
    }




}
