package rais.rams.raiservices

import akka.http.javadsl.unmarshalling.Unmarshaller
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import spray.json.DefaultJsonProtocol
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._


/**
 * Created by 866317 on 10/21/2016.
 */
case class Customer(appt_id:String,mobile_number:BigInt,password:String,login_ind:String)

trait raisAppServiceProtocol extends SprayJsonSupport with DefaultJsonProtocol{
  implicit val CustomerFormat = jsonFormat4(Customer)
}
trait raisAppService  extends raisAppServiceProtocol {

  lazy val route = {
   path("login"){
     post{
       entity(as[Customer]) { ls =>
         println(ls)
         complete(s"Verified Customer")
       }
     }
   }
 }
}
