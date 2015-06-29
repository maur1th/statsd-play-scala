# statsd-play-scala

A demonstration app using Scala + Play that exports metrics via StatsD

AspectJ needs to be added with the JVM runtime, e.g.:

    -javaagent:$HOME/.ivy2/cache/org.aspectj/aspectjweaver/jars/aspectjweaver-1.8.6.jar