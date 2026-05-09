package hospital_appointments_management_system;

public class Appointment {

    private String AID;
    private String PID;
    private String DID;
    private String Date;
    private String time;
    private String Status;

    public Appointment(String AID, String PID, String DID) {
        this.AID = AID;
        this.PID = PID;
        this.DID = DID;
        this.Status = "Confirmed";
    }

    public String getInfo() {
        return "Appointment ID:" + this.AID
                + ", Patient ID:" + this.PID
                + ", Doctor ID:" + this.DID
                + ", Data:" + this.Date
                + ", Time:" + this.time
                + ", Status:" + this.Status;
    }

    public String getPID() {
        return PID;
    }

    public String getDID() {
        return DID;
    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getAID() {
        return AID;
    }
}
