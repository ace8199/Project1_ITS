import java.io.Serializable;
public class TravProf implements Serializable{
    String travAgentID,firstName,lastName,address,phone,travelType,paymentType;
    Float tripCost;
    MedCond[] medCondInfo;

    TravProf(String id,String first,String last,String street,String number,Float cost,String travel,String paytype, MedCond[] medCond){
        this.travAgentID = id;
        this.firstName = first;
        this.lastName = last;
        this.address = street;
        this.phone = number;
        this.tripCost = cost;
        this.travelType = travel;
        this.paymentType = paytype;
        this.medCondInfo = medCond;
        // not sure how to setup medcond
    }

    public String gettravAgentID(){
        return this.travAgentID;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPhone(){
        return this.phone;
    }
    public Float getTripCost(){
        return this.tripCost;
    }
    public String getTravelType(){
        return this.travelType;
    }
    public String getPaymentType(){
        return this.paymentType;
    }
    public MedCond[] getMedCondInfo(){
        return this.medCondInfo;
    }


    public void updateFirstName(String first){
        this.firstName = first;
    }
    public void updateLastName(String last){
        this.lastName = last;
    }
    public void updateAddress(String street){
        this.address = street;
    }
    public void updatePhone(String number){
        this.phone = number;
    }
    public void updateTripCost(float cost){
        this.tripCost = cost;
    }
    public void updateTravelType(String travel){
        this.travelType = travel;
    }
    public void updatePaymentType(String paytype){
        this.paymentType = paytype;
    }
    public void updateMedCondInfo(MedCond[] medCond){
        this.medCondInfo = medCond;
    }

}
