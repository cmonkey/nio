package org.excavator.boot.nio

import java.net.InetSocketAddress
import java.nio.channels.SocketChannel
import java.nio.charset.StandardCharsets
import java.util.Scanner

import org.apache.commons.lang3.StringUtils

class NioClient(port: Int) {
  def connect(): Unit = {
    val socketChannel = SocketChannel.open(new InetSocketAddress(port))

    val scanner = new Scanner(System.in)

    while(scanner.hasNextLine){

      val request = scanner.nextLine()

      if(StringUtils.isNotBlank(request)){
        socketChannel.write(StandardCharsets.UTF_8.encode(request))
      }
    }
  }
}

object NioClient{
  def apply(port: Int) = {
    val nioClient = new NioClient(port)
    nioClient.connect()
  }
}
