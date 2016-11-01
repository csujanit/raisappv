package rais.rams.rais.rams.raisdbservices

import slick.dbio.DBIO

import scala.concurrent.Await
import slick.driver.MySQLDriver.api._
import scala.concurrent.duration._

/**
 * Created by 866317 on 10/6/2016.
 */
trait raisdbAccess {
  val db = Database.forConfig("mysqlDB")
  def exec[T](program:DBIO[T]):T = Await.result(db.run(program),200 seconds)
  //def exec[T](program:DBIO[T]):T = db.run(program).asInstanceOf[T]
}
