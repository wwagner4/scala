package net.entelijan.akka

import java.net._

object AddressTryout extends App {
    val name = "randy"

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
        println(s"hostname='$hn'")
        val addrs = InetAddress.getAllByName(hn);
        println(addrs.toList.map(a => s"${a.getClass.getName} ${a.getHostName()} ${a.getHostAddress()} ${a.getCanonicalHostName()}").mkString("\n"))
        println
    }

}