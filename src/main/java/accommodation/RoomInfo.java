package accommodation;

import javax.persistence.*;

@Entity
@Table(name="RoomInfo_table")
public class RoomInfo {

    @Id @GeneratedValue
    private Integer roomNumber;
    private String roomName;
    private String roomStatus;
    private String roomType;
    private Integer roomQty;
    private String roomPrice;

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomQty() {
        return roomQty;
    }

    public void setRoomQty(Integer roomQty) {
        this.roomQty = roomQty;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }
}