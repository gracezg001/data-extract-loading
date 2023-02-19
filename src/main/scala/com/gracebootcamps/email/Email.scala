package com.gracebootcamps.email

class Email (val username: String, val domainName: String)

object Email {

  def fromString(emailSting: String): Option[Email] ={
    emailSting.split('@') match {
      case Array(a,b) => Some(new Email(a,b))
      case _ => None
    }
  }
}
