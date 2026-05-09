package hospital_appointments_management_system;

import java.util.ArrayList;

public class Doctor extends User {

    private String Specialization;
    private String Department;
    private ArrayList<Patient> List_of_assigned_patients;
    private ArrayList<Appointment> List_of_appointments;

    public Doctor(String Specialization, String Department, String ID, String Name, String UserName, String Password, String Phonenum) {
        super(ID, Name, UserName, Password, Phonenum);
        this.Specialization = Specialization;
        this.Department = Department;
        this.List_of_assigned_patients = new ArrayList<>();
        this.List_of_appointments = new ArrayList<>();

    }

    @Override
    public String getInfo() {
        return ("Name:" + super.getName()
                + ", ID:" + super.getID()
                + ", Username:" + super.getUserName()
                + ", Specialization:" + this.Specialization
                + ", Department:" + this.Department
                + ", Phone number:" + super.getPhonenum());
    }

    public void Addpatients(Patient p) {
        this.List_of_assigned_patients.add(p);
    }

    public void setList_of_appointments(Appointment a) {
        this.List_of_appointments.add(a);
    }

    public String View_assigned_patients() {
        String info = "\n";
        for (int i = 0; i < this.List_of_assigned_patients.size(); i++) {
            info += this.List_of_assigned_patients.get(i).getInfo();
        }
        return info;

    }

    public String View_appointments() {
        String info = "\n";
        for (int i = 0; i < this.List_of_appointments.size(); i++) {
            info += this.List_of_appointments.get(i).getInfo();
        }
        return info;
    }

    public void UpdateAppointmentStatus(String Status, String AID) {
        for (int i = 0; i < this.List_of_appointments.size(); i++) {
            if (this.List_of_appointments.get(i).getAID().equals(AID)) {
                this.List_of_appointments.get(i).setStatus(Status);
            }
        }
    }

    public ArrayList<Patient> getList_of_assigned_patients() {
        return List_of_assigned_patients;
    }

    public ArrayList<Appointment> getList_of_appointments() {
        return List_of_appointments;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public String getDepartment() {
        return Department;
    }
}
