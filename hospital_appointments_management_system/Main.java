package hospital_appointments_management_system;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        HospitalSystem hospitalSystem = new HospitalSystem();

        int choice = 4;
        boolean loop = true;
        String username, password;

        while (loop) {
            System.out.println("""
                               1. Login as Admin
                               2. Login as Doctor
                               3. Login as Patient
                               4. Exit""");

            try {
                System.out.print("ChoiceNum:");
                choice = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }

            switch (choice) {
                case 1:
                    System.out.print("UserName:");
                    username = input.next();

                    System.out.print("Password:");
                    password = input.next();

                    if ("admin".equals(username) && "admin51".equals(password)) {
                        while (loop) {
                            System.out.println();
                            System.out.println("""
                                               1. Add Doctor
                                               2. Register Patient
                                               3. Assign Patient to Doctor
                                               4. Create Appointment
                                               5. View All Doctors
                                               6. View All Patients
                                               7. View All Appointments
                                               8. Search Patient by ID
                                               9. Search Doctor by ID
                                               10. Generate Reports
                                               11. Save Data
                                               12. Logout""");

                            try {
                                System.out.print("ChoiceNum:");
                                choice = input.nextInt();
                                input.nextLine();
                            } catch (Exception e) {
                                System.out.println("Invalid Input");
                            }

                            if (choice == 12) {
                                break;
                            }

                            switch (choice) {
                                case 1:
                                    System.out.println();
                                    System.out.print("Specialization:");
                                    String Specialization = input.next();

                                    System.out.print("Department:");
                                    String Department = input.next();

                                    System.out.print("ID:");
                                    String ID = input.next();

                                    System.out.print("Name:");
                                    String Name = input.next();

                                    System.out.print("UserName:");
                                    String UserName = input.next();

                                    System.out.print("Password:");
                                    String Password = input.next();

                                    System.out.print("Phone number:");
                                    String Phonenum = input.next();

                                    hospitalSystem.AddDoctor(Specialization, Department, ID, Name, UserName, Password, Phonenum);
                                    break;

                                case 2:
                                    System.out.println();
                                    System.out.print("Age:");
                                    String Age = input.next();

                                    System.out.print("Gender:");
                                    String Gender = input.next();

                                    System.out.print("ID:");
                                    ID = input.next();

                                    System.out.print("Name:");
                                    Name = input.next();

                                    System.out.print("UserName:");
                                    UserName = input.next();

                                    System.out.print("Password:");
                                    Password = input.next();

                                    System.out.print("Phone number:");
                                    Phonenum = input.next();

                                    hospitalSystem.RegisterPatient(Age, Gender, ID, Name, UserName, Password, Phonenum);
                                    break;
                                case 3:
                                    System.out.print("Doctor Name:");
                                    String Doc = input.next();

                                    System.out.print("Patien Name:");
                                    String patientName = input.next();

                                    hospitalSystem.AssignPatientToDoctor(Doc, patientName);
                                    break;
                                case 4:
                                    System.out.print("Appointment ID:");
                                    String AID = input.next();

                                    System.out.print("Patient ID:");
                                    String PID = input.next();

                                    System.out.println("Doctor ID ");
                                    String DID = input.next();

                                    hospitalSystem.CreateAppointment(AID, PID, DID);

                                    break;
                                case 5:
                                    System.out.println(hospitalSystem.ViewAllDoctors());
                                    break;
                                case 6:
                                    System.out.println(hospitalSystem.ViewAllPatients());
                                    break;
                                case 7:
                                    System.out.println(hospitalSystem.ViewAllAppointments());
                                    break;
                                case 8:
                                    System.out.print("Patient ID: ");
                                    ID = input.next();

                                    System.out.println(hospitalSystem.SearchPatientByID(ID));
                                    break;
                                case 9:
                                    System.out.print("Doctor ID: ");
                                    ID = input.next();

                                    System.out.println(hospitalSystem.SearchDoctorByID(ID));
                                    break;
                                case 10:
                                    hospitalSystem.GenerateReports();
                                    break;
                                case 11:
                                    hospitalSystem.SaveData();
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.print("UserName:");
                    username = input.next();

                    System.out.print("Password:");
                    password = input.next();

                    while (hospitalSystem.DUserCheck(username, password)) {
                        System.out.println("""
                                           1. View My Profile
                                           2. View Assigned Patients
                                           3. View My Appointments
                                           4. Update Appointment Status
                                           5. Logout""");

                        try {
                            System.out.print("ChoiceNum:");
                            choice = input.nextInt();
                        } catch (Exception e) {
                            System.out.println("Invalid Input");
                        }

                        if (choice == 5) {
                            break;
                        }

                        switch (choice) {
                            case 1:
                                System.out.println(hospitalSystem.DProfile());
                                break;
                            case 2:
                                System.out.println(hospitalSystem.DAssignedPatients());
                                break;
                            case 3:
                                System.out.println(hospitalSystem.DAppointments());
                                break;
                            case 4:
                                System.out.println("Appointment ID:");
                                String AID = input.next();
                                System.out.println("Status");
                                String status = input.next();

                                hospitalSystem.DUpDateAppointments(status, AID);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("UserName:");
                    username = input.next();

                    System.out.print("Password:");
                    password = input.next();

                    while (hospitalSystem.PUserCheck(username, password)) {
                        System.out.println("""
                                           1. View My Profile 
                                           2. View Assigned Doctor 
                                           3. View My Appointments 
                                           4. Book Appointment 
                                           5. Cancel Appointment
                                           6. Logout """);
                        try {
                            System.out.print("ChoiceNum:");
                            choice = input.nextInt();
                        } catch (Exception e) {
                            System.out.println("Invalid Input");
                        }

                        if (choice == 6) {
                            break;
                        }

                        switch (choice) {
                            case 1:
                                System.out.println(hospitalSystem.PProfile());
                                break;
                            case 2:
                                System.out.println(hospitalSystem.PAssignedDoctor());
                                break;
                            case 3:
                                System.out.println(hospitalSystem.PAppointments());
                                break;
                            case 4:
                                System.out.println("Appiment ID:");
                                String AID = input.next();

                                System.out.println("Date(YY-MM-DD):");
                                String Date = input.next();

                                System.out.println("Time(H:M:S)");
                                String Time = input.next();

                                hospitalSystem.BookAppointment(AID, Time, Date);
                                break;
                            case 5:
                                System.out.print("Appointment ID:");
                                AID = input.next();
                                hospitalSystem.PCancelAppointment(AID);
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 4:
                    loop = false;
                    break;
                default:
                    System.out.println("InvalideNum");
                    break;
            }
        }
    }
}
