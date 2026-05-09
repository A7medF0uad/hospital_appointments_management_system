package hospital_appointments_management_system;

import java.io.IOException;
import java.util.ArrayList;

public class Admin {

    private ArrayList<Doctor> doctorList = new ArrayList<>();
    private ArrayList<Patient> patientList = new ArrayList<>();
    private ArrayList<Appointment> appointmentList = new ArrayList<>();

    private FileManager doctorsFile;
    private FileManager patientsFile;
    private FileManager appointmentsFile;

    public Admin() throws IOException {
        this.patientsFile = new FileManager("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Hospital_Appointments_Management_System\\src\\main\\java\\hospital_appointments_management_system\\patients.txt");
        this.doctorsFile = new FileManager("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Hospital_Appointments_Management_System\\src\\main\\java\\hospital_appointments_management_system\\doctors.txt");
        this.appointmentsFile = new FileManager("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Hospital_Appointments_Management_System\\src\\main\\java\\hospital_appointments_management_system\\appointments.txt");
    }

    public void setLists(ArrayList<Doctor> doctorList, ArrayList<Patient> patientList, ArrayList<Appointment> appointmentList) {
        this.doctorList = doctorList;
        this.patientList = patientList;
        this.appointmentList = appointmentList;
    }

    public void AddDoctor(String Specialization, String Department, String ID, String Name, String UserName, String Password, String Phonenum) {
        this.doctorList.add(new Doctor(Specialization, Department, ID, Name, UserName, Password, Phonenum));
    }

    public void RegisterPatient(String Age, String Gender, String ID, String Name, String UserName, String Password, String Phonenum) {
        this.patientList.add(new Patient(Age, Gender, ID, Name, UserName, Password, Phonenum));
    }

    public void assignPatientToDoctor(String patientId, String doctorId) {
        Patient p = findPatientById(patientId);
        Doctor d = findDoctorById(doctorId);

        if (p != null && d != null) {
            p.setAssigned(doctorId);
            System.out.println("Successfully assigned " + p.getName() + " to Dr. " + d.getName());
        } else {
            System.out.println("Error: Could not find Patient or Doctor ID.");
        }
    }

    public void searchPatient(String id) {
        Patient p = findPatientById(id);
        if (p != null) {
            System.out.println("Patient Found: " + p.getName() + " | Phone: " + p.getPhonenum() + " | Assigned Doctor: " + p.getAssigned());
        } else {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }

    public void searchDoctor(String id) {
        Doctor d = findDoctorById(id);
        if (d != null) {
            System.out.println("Doctor Found: Dr. " + d.getName() + " | Specialization: " + d.getSpecialization());
        } else {
            System.out.println("Doctor with ID " + id + " not found.");
        }
    }

    private Patient findPatientById(String id) {
        return this.patientList.stream().filter(p -> p.getID().equals(id)).findFirst().orElse(null);
    }

    private Doctor findDoctorById(String id) {
        return this.doctorList.stream().filter(d -> d.getID().equals(id)).findFirst().orElse(null);
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void CreateAnAppointment(String AID, String PID, String DID) {
        this.appointmentList.add(new Appointment(AID, PID, DID));
    }

    public String ViewAllAppointments() {
        String info = "\n";
        for (int i = 0; i < this.appointmentList.size(); i++) {
            info += this.appointmentList.get(i).getInfo();
        }
        return info;
    }

    public String ViewAllDoctors() {
        String info = "\n";
        for (int i = 0; i < this.doctorList.size(); i++) {
            info += this.doctorList.get(i).getInfo();
        }
        return info;
    }

    public String ViewAllPatients() {
        String info = "\n";
        for (int i = 0; i < this.patientList.size(); i++) {
            info += this.patientList.get(i).getInfo();
        }
        return info;
    }

    public String SearchForPatientByID(String Id) {
        String Info = null;
        for (int i = 0; i < this.patientList.size(); i++) {
            if (this.patientList.get(i).getID().equals(Id)) {
                Info = this.patientList.get(i).getInfo();
                break;
            }
        }
        return Info;
    }

    public String SearchForDoctorByID(String Id) {
        String Info = null;
        for (int i = 0; i < this.doctorList.size(); i++) {
            if (this.doctorList.get(i).getID().equals(Id)) {
                Info = this.doctorList.get(i).getInfo();
                break;
            }
        }
        return Info;
    }

    public void SaveData() throws IOException {
        for (int i = 0; i < this.doctorList.size(); i++) {
            this.doctorsFile.fileWriter(this.doctorList.get(i).getInfo());
        }
        this.doctorsFile.saveData();

        for (int i = 0; i < this.patientList.size(); i++) {
            this.patientsFile.fileWriter(this.patientList.get(i).getInfo());
        }
        this.patientsFile.saveData();

        for (int i = 0; i < this.appointmentList.size(); i++) {
            this.appointmentsFile.fileWriter(this.appointmentList.get(i).getInfo());
        }
        this.appointmentsFile.saveData();
    }
}
