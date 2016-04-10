package com.suse.example

import com.github.dockerjava.api.model.Info
import com.github.dockerjava.api.model.Image
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.slf4j.LoggerFactory

class RegistrySpec extends FlatSpec with Matchers {

  val log = LoggerFactory.getLogger(classOf[RegistrySpec])

  "registry example" should "have equals images size" in {
    val client = DefaultClient.create
    val info = client.getInfo
    log.info("info object has "+info.getImages+" images.")
    val images = client.getImages
    log.info("images list: "+images.size)
    assert(info.getImages == images.size)
  } 
}

