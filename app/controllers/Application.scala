package controllers

import kamon.Kamon
import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Kamon.start()
    Ok(views.html.index(s"NOTHING"))
  }
}