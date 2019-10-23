package org.excavator.boot.nio.test

import org.excavator.boot.nio.NioServer

object NioServerApp extends App{
  NioServer.apply(8000)
}
