package org.excavator.boot.nio

import java.net.InetSocketAddress
import java.nio.channels.{SelectionKey, Selector, ServerSocketChannel}

import org.slf4j.LoggerFactory


class NioServer(port: Int){
  val logger = LoggerFactory.getLogger(classOf[NioServer])

  def start(): Unit = {
    val selector = Selector.open()

    val serverSocketChannel = ServerSocketChannel.open()

    serverSocketChannel.bind(new InetSocketAddress(port))
    serverSocketChannel.configureBlocking(false)
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT)

    while(true){
      val readyChannels = selector.select()
      logger.info(s"readyChannels = $readyChannels")

      if(readyChannels != 0 ) {

        val selectionKeys = selector.selectedKeys()

        val iterator = selectionKeys.iterator()

        while (iterator.hasNext()) {
          val selectionKey = iterator.next()

          iterator.remove()

          if (selectionKey.isAcceptable()) {

          }

          if (selectionKey.isReadable) {

          }
        }
      }
    }
  }
}

object NioServer{
  def apply(port: Int):Unit = {
    val nioServer = new NioServer(port)
    nioServer.start()
  }
}
