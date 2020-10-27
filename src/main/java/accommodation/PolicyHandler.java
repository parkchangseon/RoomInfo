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

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSave_CheckOuted(@Payload CheckedOut checkedOut){
        if(checkedOut.isMe()){
            System.out.println("##### listener 체크아웃 정보저장 : " + checkedOut.toJson());
            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setReserveNo(checkedOut.getReserveNo());
            roomInfo.setCustomerName(checkedOut.getCustomerName());
            roomInfo.setRoomNo(checkedOut.getRoomNo());
            roomInfo.setCustomerId(checkedOut.getCustomerId());
            roomInfo.setCustomerName(checkedOut.getCustomerName());
            roomInfo.setReservationStatus(checkedOut.getReserveStatus());
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSave_PaymentCompleted(@Payload PaymentCompleted paymentCompleted){
        if(paymentCompleted.isMe()){
            // external message send
            System.out.println("##### listener 결제 정보저장 : " + paymentCompleted.toJson());
            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setReservationNumber(paymentCompleted.getReservationNumber());
            roomInfo.setPaymentId(paymentCompleted.getPaymentId());
            roomInfo.setPaymentPrice(paymentCompleted.getPaymentPrice());
            roomInfo.setReservationStatus(paymentCompleted.getReservationStatus());

            roomInfoRepository.save(roomInfo);
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSave_Reserved(@Payload Reserved reserved) {
        if (reserved.isMe()) {
            // external message send
            System.out.println("##### listener 예약정보 저장 : " + reserved.toJson());
            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setReserveNo(reserved.getReserveNo());
            roomInfo.setCustomerName(reserved.getCustomerName());
            roomInfo.setCustomerId(reserved.getCustomerId());
            roomInfo.setReservationStatus(reserved.getReserveStatus());
            roomInfo.setRoomNo(reserved.getRoomNo());
            roomInfo.setReservePrice(reserved.getReservePrice());
        }
    }
}
