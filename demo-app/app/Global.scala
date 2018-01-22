import com.codahale.metrics.JmxReporter
import com.kenshoo.play.metrics.{MetricsRegistry, MetricsFilter}
import org.jmxtrans.embedded.config.ConfigurationParser
import play.api.{Application, GlobalSettings}
import play.api.mvc.WithFilters

object Global extends WithFilters(MetricsFilter) with GlobalSettings {
  override def onStart(app: Application) {
    JmxReporter.forRegistry(MetricsRegistry.defaultRegistry).build.start
    new ConfigurationParser().newEmbeddedJmxTrans("classpath:jmxtrans.json").start
  }
}
