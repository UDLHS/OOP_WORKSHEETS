package worksheet3.Q3;

public class Owner {
    private String ownerName;
    private  String phoneNO;

    public Owner() {
        ownerName = "Unknown";
        phoneNO = "N/A";
    }

    public Owner(String ownerName,String phoneNO) {
        this.phoneNO = phoneNO;
        this.ownerName = ownerName;
    }


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }
}
