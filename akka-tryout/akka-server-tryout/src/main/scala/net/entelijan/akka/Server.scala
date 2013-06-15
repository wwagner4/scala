package net.entelijan.akka

import akka.actor._
import akka.remote._

case class Info(s: String)
case object Status
case object Ok

class ServerActor extends Actor {
  def receive = {
    case Info(s) => println(s"Received Info containing '${s}'")
    case Status => sender ! Ok
  }
}

object Server extends App {

  try {
    val system = ActorSystem("sys")
    println("--- A")

    val props: Props = Props[ServerActor]
    println(s"--- D $props")

    val ref = system.actorOf(props, "server")
    println(s"--- E $ref")
  } catch {
    case e: Exception => {
      println(s"--- F Could not start server. $e")
      System.exit(-1);
    }
  }

}