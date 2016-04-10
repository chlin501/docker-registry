package com.suse.example

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.slf4j.LoggerFactory

class SettingSpec extends FlatSpec with Matchers {

  val log = LoggerFactory.getLogger(classOf[SettingSpec])

  val home = System.getProperty("user.home")

  "setting" should "have default values" in {
    val conf = new Setting.Builder().build
    assert("unix:///var/run/docker.sock".equals(conf.getDockerHost))
    assert(true == conf.getDockerTlsVerify)
    assert((home+"/.docker/certs").equals(conf.getDockerCertPath))
    assert((home+"/.docker").equals(conf.getDockerConfig))
    assert("1.21".equals(conf.getApiVersion))
    assert("https://index.docker.io/v1/".equals(conf.getRegistryUrl))
    assert("dockeruser".equals(conf.getRegistryUsername))
    assert("ilovedocker".equals(conf.getRegistryPassword))
    assert("dockeruser@github.com".equals(conf.getRegistryEmail))
  } 

  "setting" should "set tls verify to false" in {
    val conf = new Setting.Builder().withoutDockerTlsVerify.build
    assert(false == conf.getDockerTlsVerify)
  }

  "setting" should "throws illegal argument exceptions" in {
    val builder = new Setting.Builder()
    val ex1 = intercept[IllegalArgumentException] {
      builder.withDockerHost(null).build
    }
    assert(ex1.isInstanceOf[IllegalArgumentException])

    val ex2 = intercept[IllegalArgumentException] {
      builder.withDockerCertPath("").build
    }
    assert(ex2.isInstanceOf[IllegalArgumentException])

    val ex3 = intercept[IllegalArgumentException] {
      builder.withDockerConfig("").build
    }
    assert(ex3.isInstanceOf[IllegalArgumentException])

    val ex4 = intercept[IllegalArgumentException] {
      builder.withApiVersion("").build
    }
    assert(ex4.isInstanceOf[IllegalArgumentException])

    val ex5 = intercept[IllegalArgumentException] {
      builder.withRegistryUrl(null).build
    }
    assert(ex5.isInstanceOf[IllegalArgumentException])

    val ex6 = intercept[IllegalArgumentException] {
      builder.withRegistryUsername(null).build
    }
    assert(ex6.isInstanceOf[IllegalArgumentException])

    val ex7 = intercept[IllegalArgumentException] {
      builder.withRegistryPassword("").build
    }
    assert(ex7.isInstanceOf[IllegalArgumentException])

    val ex8 = intercept[IllegalArgumentException] {
      builder.withRegistryEmail("").build
    }
    assert(ex8.isInstanceOf[IllegalArgumentException])

  }
}

