package org.excavator.boot.nio

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel
import java.nio.charset.StandardCharsets
import java.util.Scanner

import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory

class NioClient(port: Int) {
  val logger = LoggerFactory.getLogger(classOf[NioClient])
  def connect(): Unit = {
    val socketChannel = SocketChannel.open(new InetSocketAddress(port))

    val byteBuffer = ByteBuffer.allocate(1024)

    socketChannel.read(byteBuffer)

    while(byteBuffer.hasRemaining){
      byteBuffer.flip()
      logger.info(s"read connection info ${StandardCharsets.UTF_8.decode(byteBuffer)}")
    }

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
