package net.entelijan.akka

import java.net._

object AddressTryout extends App {
    val name = "NB-WWAGNER1.itsv.at"

    val addrs = InetAddress.getAllByName(name);
    println(addrs.toList.map (a => s"${a.getClass.getName} ${a.getHostName()} ${a.getHostAddress()} ${a.getCanonicalHostName()}").mkString("\n"))
    println
    
    val a = InetAddress.getByName(name);
    println(s"${a.getClass.getName} ${a.getHostName()} ${a.getHostAddress()} ${a.getCanonicalHostName()}")
}