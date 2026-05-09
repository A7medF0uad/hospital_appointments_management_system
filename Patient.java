package hospital_appointments_management_system;

import java.util.ArrayList;

public class Patient extends User {

    private String Age;
    private String Gender;
    private String Assigned;
    private ArrayList<Appointment> List_of_appointments;

    public Patient(String Age, String Gender, String ID, String Name, String UserName, String Password, String Phonenum) {
        super(ID, Name, UserName, Password, Phonenum);
        this.Age = Age;
        this.Gender = Gender;
        this.List_of_appointments = new ArrayList<>();
    }

    @Override
    public String getInfo() {
        return ("Name:" + super.getName()
                + ", ID:" + super.getID()
                + ", Username:" + super.getUserName()
                + ", Age:" + this.Age
                + ", Gender:" + this.Gender
                + ", phone number:" + super.getPhonenum()
                + ", Assigned Doctor" + this.Assigned);
    }

    @Override
    public String getID() {
        return super.getID();
    }

    public String getAssigned() {
        return Assigned;
    }

    public void setAssigned(String Assigned) {
        this.Assigned = Assigned;
    }

    public String View_appointments() {
        String info = "\n";
        for (int i = 0; i < this.List_of_appointments.size(); i++) {
            info += this.List_of_appointments.get(i).getInfo();
        }
        return info;
    }

    public void CancelAppointments(String AID) {
        for (int i = 0; i < this.List_of_appointments.size(); i++) {
            if (this.List_of_appointments.get(i).getAID().equals(AID)) {
                this.List_of_appointments.get(i).setStatus("Cancel");
            }
        }
    }

    public void BookAppointment(String AID, String Time, String Date) {
        for (int i = 0; i < this.List_of_appointments.size(); i++) {
            if (this.List_of_appointments.get(i).getAID().equals(AID)) {
                this.List_of_appointments.get(i).setDate(Date);
                this.List_of_appointments.get(i).setTime(Time);
            }
        }
    }
}
