import Model.TweeterModel;
import PreProcess.FindWord;
import PreProcess.GetInformation;
import PreProcess.KafkaConfig;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    private static FindWord findWord = new FindWord();
    private static GetInformation getInformation = new GetInformation();
    private static List<String> hashtags = new ArrayList<>();
    private static KafkaConfig kafkaConfig = new KafkaConfig();
    private static KafkaProducer<String,TweeterModel> kafkaProducer;
    public static void main(String[] args) throws IOException {

        getInformation.getFromExel();

        List<TweeterModel> values = getInformation.getTweeterModels();


        for (TweeterModel item:values) {
            if (item.getText()==null){
                continue;
            }
            for (String item2:findWord.findHashtag(item.getText())) {
                hashtags.add(item2);
            }
        }
        kafkaConfig.config();
        kafkaProducer = kafkaConfig.getProducer();
        ProducerRecord<String,TweeterModel> record = new ProducerRecord<String,TweeterModel>(UUID.randomUUID().toString(),new TweeterModel());
        kafkaProducer.send(record);
    }


}
