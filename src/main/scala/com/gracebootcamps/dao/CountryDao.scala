package com.gracebootcamps.dao

import java.sql.{ResultSet, SQLException}


class CountryDao extends Dao {


  def findCountryByQuery(continent: String): ResultSet = {

   val sql = "'select * from country where continent = '" + continent + "'"
    var resultSet: ResultSet = null

    try {

      val statement = getConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
      val resultSet = statement.executeQuery(sql)

      /*
                  while (resultSet.next) {
                    val countryName = resultSet.getString("name")
                    val location = resultSet.getString("region")
                    // logger.debug("country-name = %30s, region = %s".format(countryName, location))
                  }

                  resultSet.last()
                  println("rows=" + resultSet.getRow)
                  resultSet.beforeFirst()*/



      closeConnection
      } catch {
      case e: SQLException =>logger.error("SQLException: %s", e.getMessage)
      case _: Throwable => logger.error("Exception: Unknown exception.")
       null
    }
    resultSet
  }
}