package hospital_appointments_management_system;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HospitalSystem {

    private ArrayList<User> userslist;
    private FileManager userfileManager;

    private Admin admin;
    private int Dcount, Pcount;

    public HospitalSystem() throws IOException {
        this.userslist = new ArrayList<>();
        this.userfileManager = new FileManager("users.txt");
        this.admin = new Admin();
    }

    public void AddDoctor(String Specialization, String Department, String ID, String Name, String UserName, String Password, String Phonenum) throws IOException {
        this.userslist.add(new User(ID, Name, UserName, Password, Phonenum));
        for (int i = 0; i < this.userslist.size(); i++) {
            this.userfileManager.fileWriter(this.userslist.get(i).getInfo());
        }
        this.admin.AddDoctor(Specialization, Department, ID, Name, UserName, Password, Phonenum);
    }

    public void RegisterPatient(String Age, String Gender, String ID, String Name, String UserName, String Password, String Phonenum) throws IOException {
        this.userslist.add(new User(ID, Name, UserName, Password, Phonenum));
        for (int i = 0; i < this.userslist.size(); i++) {
            this.userfileManager.fileWriter(this.userslist.get(i).getInfo());
            this.userfileManager.saveData();
        }
        this.admin.RegisterPatient(Age, Gender, ID, Name, UserName, Password, Phonenum);
    }

    public void SaveData() throws IOException {
        this.admin.SaveData();
        this.userfileManager.saveData();
    }

    public void GenerateReports() {
        try {
            File file = new File("System_Report.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write("=== HOSPITAL SYSTEM REPORT ===\n\n");

            writer.write("1. System Users Statistics:\n");
            writer.write("- Total Doctors: " + this.admin.getDoctorList().size() + "\n");
            writer.write("- Total Patients: " + this.admin.getPatientList().size() + "\n\n");

            int confirmed = 0, completed = 0, cancelled = 0;
            for (Appointment app : this.admin.getAppointmentList()) {
                if (app.getStatus().equalsIgnoreCase("Confirmed")) {
                    confirmed++;
                } else if (app.getStatus().equalsIgnoreCase("Completed")) {
                    completed++;
                } else if (app.getStatus().equalsIgnoreCase("Cancelled") || app.getStatus().equalsIgnoreCase("Cancel")) {
                    cancelled++;
                }
            }

            writer.write("2. Appointments Statistics:\n");
            writer.write("- Total Appointments: " + this.admin.getAppointmentList().size() + "\n");
            writer.write("- Confirmed: " + confirmed + "\n");
            writer.write("- Completed: " + completed + "\n");
            writer.write("- Cancelled: " + cancelled + "\n\n");

            writer.write("3. Top 3 Doctors (By Number of Appointments):\n");

            ArrayList<Doctor> sortedDoctors = new ArrayList<>(this.admin.getDoctorList());

            sortedDoctors.sort((d1, d2) -> d2.getList_of_appointments().size() - d1.getList_of_appointments().size());

            int limit = Math.min(3, sortedDoctors.size());
            for (int i = 0; i < limit; i++) {
                Doctor doc = sortedDoctors.get(i);
                writer.write("  " + (i + 1) + ". Dr. " + doc.getName()
                        + " (Appointments: " + doc.getList_of_appointments().size() + ")\n");
            }

            writer.write("\n==============================\n");
            writer.close();

            System.out.println("Report Generated Successfully!");
            System.out.println("Path: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }

    public String SearchDoctorByID(String ID) {
        return this.admin.SearchForDoctorByID(ID);
    }

    public String SearchPatientByID(String id) {
        return this.admin.SearchForPatientByID(id);
    }

    public void AssignPatientToDoctor(String Doc, String patientName) {
        this.admin.assignPatientToDoctor(Doc, patientName);
    }

    public String ViewAllAppointments() {
        return this.admin.ViewAllAppointments();
    }

    public String ViewAllPatients() {
        return this.admin.ViewAllPatients();
    }

    public String ViewAllDoctors() {
        return this.admin.ViewAllDoctors();
    }

    public void CreateAppointment(String AID, String PID, String DID) {
        this.admin.CreateAnAppointment(AID, PID, DID);
    }

    public boolean DUserCheck(String UserName, String password) {
        for (int i = 0; i < this.admin.getDoctorList().size(); i++) {
            if (this.admin.getDoctorList().get(i).UserName.equals(UserName) && this.admin.getDoctorList().get(i).Password.equals(password)) {
                this.Dcount = i;
                return true;
            }
        }
        return false;
    }

    public boolean PUserCheck(String UserName, String password) {
        for (int i = 0; i < this.admin.getPatientList().size(); i++) {
            if (this.admin.getPatientList().get(i).UserName.equals(UserName) && this.admin.getPatientList().get(i).Password.equals(password)) {
                this.Pcount = i;
                return true;
            }
        }
        return false;
    }

    public String DProfile() {
        return this.admin.getDoctorList().get(this.Dcount).getInfo();
    }

    public String DAssignedPatients() {
        return this.admin.getDoctorList().get(this.Dcount).View_assigned_patients();
    }

    public String DAppointments() {
        return this.admin.getDoctorList().get(this.Dcount).View_appointments();
    }

    public void DUpDateAppointments(String Status, String AID) {
        this.admin.getDoctorList().get(this.Dcount).UpdateAppointmentStatus(Status, AID);
    }

    public String PProfile() {
        return this.admin.getPatientList().get(this.Pcount).getInfo();
    }

    public String PAssignedDoctor() {
        return this.admin.getPatientList().get(this.Pcount).getAssigned();
    }

    public String PAppointments() {
        return this.admin.getDoctorList().get(this.Pcount).View_appointments();
    }

    public void PCancelAppointment(String AID) {
        for (int i = 0; i < this.admin.getDoctorList().size(); i++) {
            if (this.admin.getDoctorList().get(i).UserName.equals(this.admin.getPatientList().get(this.Pcount).getAssigned())) {
                this.admin.getDoctorList().get(i).UpdateAppointmentStatus("Cancel", AID);
                this.admin.getPatientList().get(this.Pcount).CancelAppointments(AID);
                System.out.println("Appointment" + AID + ": Canceled");
            }
        }
    }

    public void BookAppointment(String AID, String Time, String Date) {
        this.admin.getPatientList().get(this.Pcount).BookAppointment(AID, Time, Date);
    }
}
