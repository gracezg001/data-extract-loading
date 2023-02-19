package com.gracebootcamps.config

import com.typesafe.config.ConfigFactory
import com.gracebootcamps.encryption._

import java.io.File
import scala.util.control.ControlThrowable

object ApplicationConfiguration{
  var url: String =""
  var username: String =""
  var password: String =""

  var key: String =""
  var initVector =""

  private val loaded = initialize


def initialize():Boolean = {
    try {
      val default = ConfigFactory.load()
      val fromSource = ConfigFactory.parseResources("kafka.conf").withFallback(default)
      val file = new File(default.getString("appinfo.config"))
      val conf = ConfigFactory.parseFile(file).withFallback(fromSource).withFallback(default)

      key = conf.getString("secure.key")
      initVector = conf.getString("secure.initVector")
      println(s"key=$key, initVector= $initVector")

      url = conf.getString("database.url")
      username = conf.getString("database.username")
      val pwd = conf.getString("database.password") // encrypted password
      password = EncryptionUtil.decrypt(pwd) // decrypt the password to actual password

      println(s"Initialize: url=$url, username=$username, pwd =$password")

      val appName = conf.getString("appInfo.name")
      println(s"appName =$appName")

      /* println (conf.getString("Modules.Logging.logDb"))
      println(conf.getString("Modules.Tenants.tenantsDb"))

      println(conf.getString("KafkaClient.principal")) */

    } catch safely {
      case ex: Throwable =>println("ERROR: Failed to initialize application config")
      // case _: Throwable => logger.error("Exception: Failed to initialize application config!!")
        false
    }
      true
    }

  def safely[T](handler: PartialFunction[Throwable, T]): PartialFunction[Throwable, T] = {
    case ex: ControlThrowable => throw ex
    case ex: Throwable if handler.isDefinedAt(ex) => handler(ex)
    // If they didn't handle it, rethrow. This line isn't necessary, just for clarity
    case ex: Throwable => throw ex
  }


}

