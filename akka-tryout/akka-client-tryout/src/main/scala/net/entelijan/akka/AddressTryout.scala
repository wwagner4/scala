package net.entelijan.akka

import java.net._

object AddressTryout extends App {
    val name = "randy.lan"

    {
        val addrs = InetAddress.getAllByName(name);
        println(addrs.toList.map(a => s"${a.getClass.getName} ${a.getHostName()} ${a.getHostAddress()} ${a.getCanonicalHostName()}").mkString("\n"))
        println
    }

    {
        val a = InetAddress.getByName(name);
        println(s"${a.getClass.getName} ${a.getHostName()} ${a.getHostAddress()} ${a.getCanonicalHostName()}")
        println
    }

    {
        val lh = InetAddress.getLocalHost();
        println(s"${lh.getClass.getName} ${lh.getHostName()} ${lh.getHostAddress()} ${lh.getCanonicalHostName()}")
        println
    }

    {
        val hn = java.net.InetAddress.getLocalHost().getHostName()
        val addrs = InetAddress.getAllByName(s"$hn.lan");
        println(addrs.toList.map(a => s"${a.getClass.getName} ${a.getHostName()} ${a.getHostAddress()} ${a.getCanonicalHostName()}").mkString("\n"))
        println
    }
    {
        import scala.collection.JavaConversions._
        val nifs = java.net.NetworkInterface.getNetworkInterfaces()
        for (nif <- nifs) {
            println(s"displayName=${nif.getDisplayName}")
            val adrs = nif.getInetAddresses()
            for (adr <- adrs) {
            	println(s"adr canonical host name=${adr.getCanonicalHostName}")
            	println(s"adr host address=${adr.getHostAddress}")
            	println(s"adr is local=${adr.isAnyLocalAddress()}")
            	println(s"adr is linked local=${adr.isLinkLocalAddress()}")
            	println(s"adr is site local=${adr.isSiteLocalAddress()}")
            	println(s"adr is loopback=${adr.isLoopbackAddress()}")
            	println(s"adr is address=${adr.getAddress().toList}")
            	println(s"adr is address.size=${adr.getAddress().size}")
            	println
            }
           	println("----------")
        }
    }

}