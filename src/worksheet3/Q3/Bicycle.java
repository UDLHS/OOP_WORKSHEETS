package worksheet3.Q3;


public class Bicycle {
    private Owner owner;


    public Bicycle() {
       this.owner = new Owner();
    }

    public Bicycle(String ownerName, String phoneNo) {
        this.owner = new Owner(ownerName,phoneNo);
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner= owner;
    }
    public String getOwnerName() {
        return owner.getOwnerName();
    }

    public void setOwnerName(String ownerName) {
        owner.setOwnerName(ownerName);
    }

    public String getPhoneNo() {
        return owner.getPhoneNO();
    }

    public void setPhoneNo(String phoneNo) {
        owner.setPhoneNO(phoneNo);
    }

}
