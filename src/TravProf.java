public class TravProf {
    String travAgentID,firstName,lastName,address,phone,travelType,paymentType;
    Float tripCost;

    TravProf(String id,String first,String last,String street,String number,Float cost,String travel,String paytype){
        this.travAgentID = id;
        this.firstName = first;
        this.lastName = last;
        this.address = street;
        this.phone = number;
        this.tripCost = cost;
        this.travelType = travel;
        this.paymentType = paytype;
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
    public void updateTravelType(String type){
        this.travelType = type;
    }
    public void updatePaymentType(String type){
        this.paymentType = type;
    }


}
