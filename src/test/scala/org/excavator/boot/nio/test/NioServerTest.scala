package org.excavator.boot.nio.test

import org.excavator.boot.nio.{NioClient, NioServer}
import org.junit.jupiter.api.Test

class NioServerTest {

  @Test
  def testNioServer() : Unit = {
    val port = 8000
    NioServer.apply(port)
    NioClient.apply(port)
  }
}
