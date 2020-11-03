import java.io.Serializable;

public class MedCond implements Serializable {
    String mdContact, mdPhone, algType, illType;

    public MedCond(String mdContact, String mdPhone, String algType, String illType) {
        this.mdContact = mdContact;
        this.mdPhone = mdPhone;
        this.algType = algType;
        this.illType = illType;
    }

    public String getMdContact() {
        return this.mdContact;
    }
    public String getMdPhone() {
        return this.mdPhone;
    }
    public String getAlgType() {
        return this.algType;
    }
    public String getIllType() {
        return  this.illType;
    }

    public void updateMdContact(String mdContact) {
        this.mdContact = mdContact;
    }
    public void updateMdPhone(String mdPhone) {
        this.mdPhone = mdPhone;
    }
    public void updateAlgType(String algType) {
        this.algType = algType;
    }
    public void updateIllType(String illType) {
        this.illType = illType;
    }

}
