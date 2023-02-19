import com.gracebootcamps.util.{CsvFileUtil,CommonUtils}
import com.gracebootcamps.config.ApplicationConfiguration
import com.gracebootcamps.helper.CsvDemoHelper
import com.gracebootcamps.dao.{CityDao, CountryDao}
import com.gracebootcamps.service.EmailService
import org.slf4j.LoggerFactory
object Main {

 val logger = LoggerFactory.getLogger(this.getClass)

 def main(args: Array[String]): Unit = {
   logger.info("Application Started................................")
   println(ApplicationConfiguration.url)

   val esvr = new EmailService
   esvr.register("Elon@hotmail.com")

   generateReport

    CsvDemoHelper.write("/var/output/demo.csv")
   logger.info("Application Completed....................")

 }

  def generateReport(): Unit ={
    //Find country by Continent
    // val sql = "select * from country where continent = 'North American'"
    val dao = new CountryDao
    val resultSet = dao.findCountryByQuery("South America")
    val csvName = composeFileName
    logger.info(csvName)
    logger.info(csvName)
    CsvFileUtil.writeAll(resultSet,csvName)

    // Find city by Country code

    val countrycode = "USA"
    val query = s" select * from city where countrycode = '${countrycode}'"
    val cityDao = new CityDao
    cityDao.read(query)
  }

  def composeFileName: String = {
    val dateString = CommonUtils.currentDateString("yyyy-MM-dd")
   "/var/output/city_" + dateString + ".csv"
  }

  def register(email: String): Unit = {
    val service = new EmailService
    service.register(email)
  }

}