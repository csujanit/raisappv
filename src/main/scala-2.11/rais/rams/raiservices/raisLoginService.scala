package rais.rams.raiservices

import akka.actor.Actor
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{write,writePretty}
import rais.rams.rais.rams.raisdbservices.{CORSSupport, rais_appt_details_query_dao, raisTables}
import spray.http.HttpHeaders._
import spray.http._
import spray.httpx.Json4sSupport
import spray.routing.{Route, Directives, HttpService}
import spray.http.MediaType._
import spray.http.HttpHeaders.{`Access-Control-Allow-Methods`, `Access-Control-Max-Age`, `Access-Control-Allow-Headers`,`Access-Control-Allow-Origin`}
import spray.http.AllOrigins
import spray.http.HttpMethods.{PUT,GET,POST,OPTIONS}

/**
 * Created by 866317 on 9/29/2016.
 * **/

 object Json4sProtocol extends Json4sSupport{
  implicit def json4sFormats:Formats = DefaultFormats
}

case class raisLogin(appt_id:String,mobile_number:Number,password:String,login_ind:String)



trait raisLoginService extends HttpService with rais_appt_details_query_dao with CORSSupport  {
  import Json4sProtocol._
  val myformats = Serialization.formats(
    ShortTypeHints(List(classOf[ApptMemberDetailsRow]))
  )
  implicit val formats =  myformats
  val allowOriginHeader = `Access-Control-Allow-Origin`(AllOrigins)
  //val optionsCorsHeaders = List(
    //`Access-Control-Allow-Headers`("Origin,X-Requested-With,Content-Type,Host,Accept"))
  //val somemethods = spray.routing.RejectionHandler(OPTIONS)
  val optionsCorsHeaders = List(
    `Access-Control-Allow-Headers`("X-Requested-With,Origin,Content-Type, Accept, Accept-Encoding, Accept-Language, Host, Referer, User-Agent"))
  lazy val raisLoginRoute:Route = cors {
     path("login"){
          post {
           entity(as[raisLogin]){
                 raisLogin => {
                   println(raisLogin)
                   val wr = getalluser
                   val jsonw = write(wr)
                   println(jsonw)

                   respondWithMediaType(MediaTypes.`application/json`)
                    {
                      complete{wr}
                     }

                  }
                 }
           }
         }
     }
  }



