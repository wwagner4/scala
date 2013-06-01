package net.entelijan.akka

import akka.actor._
import akka.remote._
import scala.concurrent.duration._
import akka.pattern.ask
import scala.concurrent._
import scala.util._
import ExecutionContext.Implicits.global
import akka.pattern.AskTimeoutException

object Client extends App {
  try {
    import scala.language.postfixOps

    val system = ActorSystem("sys")
    println("--- A")
    val url = "akka://sys@127.0.0.1:8988/user/server"

    val a = system.actorFor(url)

    val f = a.ask(Status)(5 second)
    println(s"--- C1 ${f}")

    f onComplete {
      case Success(x) => {
        println(s"Completed with Success received '${x}'")
        val msg = Info("Hello from client")
        a ! msg
        println(s"--- C2 sent message to server: '${msg}'")
      }
      case Failure(x) => println(s"--- C3 Completed with failure ${x}")
    }
    f onFailure {
      case at: AskTimeoutException => println(s"--- C4a Received AkkaTimeoutException '${at.getMessage()}' onFailure")
      case any => println(s"--- C4b Received Any '$any' onFailure")
    }

    system.shutdown
    println("--- D shutdown")
  } catch {
    case e: Exception => {
      println(s"--- E Failure in initializing the client $e")
      println("--- F exit -1")
      System.exit(-1)
    }
  }

}