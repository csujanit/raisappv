package rais.rams.raiservices

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import rais.rams.rais.rams.raisdbservices.{CorsSupport}

/**
 * Created by 866317 on 10/21/2016.
 */
object raisLauncher2  extends  App with raisAppService  with CorsSupport{
    implicit  val system = ActorSystem()
    implicit  val materializer = ActorMaterializer()
    implicit  val executionContext = system.dispatcher
    Http().bindAndHandle(corsHandler(route),"0.0.0.0",8780)
}

