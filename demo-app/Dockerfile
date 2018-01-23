FROM openjdk:8-jdk

# Install sbt
RUN set -ex && \
        apt-get update && \
        apt-get install apt-transport-https wget -y && \
        echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list && \
        apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823 && \
        apt-get update && \
        apt-get install sbt -y

# Cache dependencies
COPY ["build.sbt", "/tmp/build/"]
COPY ["project/plugins.sbt", "project/build.properties", "/tmp/build/project/"]
RUN set -ex && \
        cd /tmp/build && \
        sbt compile && \
        sbt test:compile && \
        rm -rf /tmp/build

COPY . /app
WORKDIR /app

RUN set -ex && \
        sbt compile && \
        sbt test:compile

RUN mkdir /usr/lib/java/ \
&&  curl -so /usr/lib/java/jmxtrans-agent-1.2.7.jar "https://search.maven.org/remotecontent?filepath=org/jmxtrans/agent/jmxtrans-agent/1.2.7/jmxtrans-agent-1.2.7.jar" \
&&  ln -s /usr/lib/java/jmxtrans-agent-1.2.7.jar /usr/lib/java/jmxtrans-agent.jar

COPY conf/jmxtrans-agent.xml /

EXPOSE 9000
CMD JAVA_OPTS="$JAVA_OPTS -javaagent:/usr/lib/java/jmxtrans-agent.jar=/jmxtrans-agent.xml" sbt run
