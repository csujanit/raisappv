package rais.rams.raiservices

/**
 * Created by 866317 on 9/29/2016.
**/
import akka.actor.{Actor, ActorLogging, Props, ActorSystem}
import akka.io.IO
import rais.rams.rais.rams.raisdbservices.CORSSupport
import spray.can.Http
import spray.routing._

object raisLauncher extends  App{

  implicit val system = ActorSystem("rais-app-system")

  val raiservice = system.actorOf(Props[RaisServiceActor],"rais-app-services")

  IO(Http) ! Http.Bind(raiservice,"0.0.0.0",8780)

  readLine(s"Hit ENTER to exit ...${System.getProperty("line.separator")}")
  system.shutdown()
}

class RaisServiceActor extends Actor with ActorLogging with raisLoginService{
  def actorRefFactory = context
  def receive = runRoute(raisLoginRoute)
}

