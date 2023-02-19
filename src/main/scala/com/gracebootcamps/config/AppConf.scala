package com.gracebootcamps

package object AppConf {
  import com.typesafe.config.ConfigFactory
  import java.io.File

  object AppConf{
    val default = ConfigFactory.load()
    val fromSource = ConfigFactory.parseResources("kafka.conf")
    val file = new File(default.getString("appinfo.config"))

    val conf = ConfigFactory.parseFile(file).withFallback(fromSource).withFallback(default)
    val url = conf.getString("database.url")
    val username = conf.getString("database.username")
  }

}
