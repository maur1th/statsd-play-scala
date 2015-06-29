# jmxtrans-play-scala

A demonstration app using Scala + Play that exports metrics via jmxtrans-embedded

The following settings can be specified as environment variables:

* statsd.host - Defaults to IP 127.0.0.1
* statsd.port - Defaults to port 8125
* statsd.enabled - Defaults to false
* jmxtrans.queryIntervalInSeconds - Defaults to 15 seconds
* jmxtrans.numQueryThreads - Defaults to 1 thread
* jmxtrans.numExportThreads - Defaults to 1 thread
* jmxtrans.exportIntervalInSeconds - Defaults to 30 seconds
* jmxtrans.exportBatchSize - Defaults to 50
