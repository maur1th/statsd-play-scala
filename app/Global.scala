import com.codahale.metrics.JmxReporter
import com.kenshoo.play.metrics.{MetricsRegistry, MetricsFilter}
import play.api.{Application, GlobalSettings}
import play.api.mvc.WithFilters

object Global extends WithFilters(MetricsFilter) with GlobalSettings {
  override def onStart(app: Application) {
    val jmxReporter = JmxReporter.forRegistry(MetricsRegistry.defaultRegistry).build
    jmxReporter.start
  }
}
