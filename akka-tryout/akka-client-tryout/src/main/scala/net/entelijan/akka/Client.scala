package net.entelijan.akka

import akka.actor._
import akka.remote._
import scala.concurrent.duration._
import akka.pattern.ask
import scala.concurrent._
import scala.util._

import ExecutionContext.Implicits.global

object Client extends App {
  import scala.language.postfixOps

  val system = ActorSystem("sys")
  println("--- A")
  
  val url = "akka://sys@127.0.0.1:8988/user/server"
  
  val a = system.actorFor(url)
  
  val f  = a.ask(Status)(2 second) 
  println(s"--- C1 ${f}")

  f onComplete {
    case Success(x) => {
      println(s"Completed with Success received '${x}'")
      val msg = Info("Hello from client")
      a ! msg
      println(s"--- C2 ${msg}")
     }
    case Failure(x) => println(s"--- C3 Completed with failure ${x}")
  }
    
  system.shutdown
  println("--- D shutdown")

}