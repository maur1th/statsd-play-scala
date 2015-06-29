package controllers

import org.jmxtrans.embedded.config.ConfigurationParser
import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    val jmxTrans = new ConfigurationParser().newEmbeddedJmxTrans("classpath:jmxtrans.json")
    jmxTrans.start()
    Ok(views.html.index(s"Query Count: ${jmxTrans.getQueries().get(0).toString()}"))
  }

}