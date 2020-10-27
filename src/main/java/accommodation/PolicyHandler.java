package accommodation;

import accommodation.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    RoomInfoRepository roomInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSave_RoomInfo(@Payload RoomConditionChanged roomConditionChanged){

        if(roomConditionChanged.isMe()){
            System.out.println("##### listener 객실정보저장 : " + roomConditionChanged.toJson());
            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setRoomNumber(roomConditionChanged.getRoomNumber());
            roomInfo.setRoomName(roomConditionChanged.getRoomName());
            roomInfo.setRoomStatus(roomConditionChanged.getRoomStatus());
            roomInfo.setRoomPrice(roomConditionChanged.getRoomPrice());
            roomInfo.setRoomQty(roomConditionChanged.getRoomQty());
            roomInfo.setRoomStatus(roomConditionChanged.getRoomStatus());
            roomInfo.setRoomType(roomConditionChanged.getRoomType());

            roomInfoRepository.save(roomInfo);
        }
    }
}
