package PreProcess;

import Model.TweeterModel;
import Model.TweeterModelSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaConfig {

    private KafkaProducer<String, TweeterModel> producer;
    public void config(){

        // property
        String bootStrapServers = "127.0.0.1:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, TweeterModelSerializer.class.getName());


        //create producer
        producer = new KafkaProducer<String,TweeterModel>(properties);


    }

    public KafkaProducer<String,TweeterModel> getProducer() {
        return producer;
    }
}
