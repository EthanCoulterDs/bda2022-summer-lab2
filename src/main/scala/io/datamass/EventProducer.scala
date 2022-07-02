package io.datamass

import akka.Done
import akka.actor.ActorSystem
import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.ThrottleMode
import akka.stream.scaladsl.Source
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

import java.util.concurrent.TimeUnit.SECONDS
import scala.concurrent.Future
import scala.concurrent.duration.FiniteDuration

object EventProducer extends App {
  implicit val system = ActorSystem("SimpleStream")
  val config = system.settings.config.getConfig("akka.kafka.producer")
  val producerSettings =
    ProducerSettings(config, new StringSerializer, new StringSerializer)

  val done: Future[Done] =
    Source(1 to 100)
      .throttle(1, FiniteDuration(1, SECONDS), 1, ThrottleMode.Shaping)
      .map(_.toString)
      .map(value => {
        println(s"Message sent to topic $value")
        new ProducerRecord[String, String]("jwszol-test", value)
      })
      .runWith(Producer.plainSink(producerSettings))
}
