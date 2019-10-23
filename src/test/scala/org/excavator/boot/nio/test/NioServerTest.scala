package org.excavator.boot.nio.test

import org.excavator.boot.nio.NioServer
import org.junit.jupiter.api.Test

class NioServerTest {

  @Test
  def testNioServer() : Unit = {
    NioServer.apply(8000)
  }
}
