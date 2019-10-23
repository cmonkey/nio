package org.excavator.boot.nio.test

import org.excavator.boot.nio.NioClient

object NioClientApp extends App{
  NioClient.apply(8000)
}
