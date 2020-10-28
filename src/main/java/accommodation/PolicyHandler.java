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
    public void wheneverSave_PromotionSaved(@Payload PromotionSaved promotionSaved) {
        if (promotionSaved.isMe()) {
            // external message send
            System.out.println("##### listener Promotion 저장 : " + promotionSaved.toJson());
            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setPaymentId(promotionSaved.getPaymentId());
            roomInfo.setPaymentPrice(promotionSaved.getPaymentPrice());
            roomInfo.setPaymentStatus(promotionSaved.getPaymentStatus());
            roomInfo.setService(promotionSaved.getService());
            roomInfo.setCouponId(promotionSaved.getCouponId());
            roomInfo.setPoint(promotionSaved.getPoint());
            roomInfo.setReserveStatus(promotionSaved.getReserveStatus());

            roomInfoRepository.save(roomInfo);
        }
    }
}
