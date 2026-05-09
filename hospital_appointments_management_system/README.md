# Hospital Appointments Management System

A Java-based console application designed to manage hospital workflows, including doctor and patient registration, appointment scheduling, and reporting. The system uses a multi-role architecture (Admin, Doctor, Patient) with persistent data storage.

## 🚀 Features

### 🛠 Admin Module
- **User Management:** Add new doctors and register patients to the system.
- **Assignment:** Assign specific patients to designated doctors.
- **Appointment Control:** Create and schedule new appointments between patients and doctors.
- **Monitoring:** View comprehensive lists of all doctors, patients, and appointments.
- **Reporting:** Generate a `System_Report.txt` file containing user statistics, appointment status breakdowns, and the top 3 most active doctors.

### 🩺 Doctor Module
- **Profile View:** Access personal professional details.
- **Patient Tracking:** View a list of all patients assigned to them.
- **Schedule Management:** View all scheduled appointments and update appointment statuses (e.g., Completed, Cancelled).

### 👤 Patient Module
- **Profile Management:** View personal information and assigned doctor details.
- **Self-Service:** Book specific dates/times for created appointments and cancel existing appointments.

### 💾 Data Persistence
- **File Management:** Uses a custom `FileManager` to read/write data to `.txt` files (`doctors.txt`, `patients.txt`, `appointments.txt`, and `users.txt`).

## 📁 Project Structure

- `Main.java`: The entry point containing the console-based user interface and login logic.
- `HospitalSystem.java`: The controller class that bridges the UI and the backend logic.
- `Admin.java`, `Doctor.java`, `Patient.java`, `User.java`: Core entities representing system users and their unique functionalities.
- `Appointment.java`: Manages appointment details including IDs, status, and scheduling.
- `FileManager.java`: Handles low-level I/O operations for data persistence.

## 🛠 Setup and Installation

1.  **Prerequisites:** Ensure you have the Java Development Kit (JDK) installed.
2.  **Configuration:** The project uses absolute file paths for data storage. Before running, update the file paths in `HospitalSystem.java` and `Admin.java` to match your local directory structure:
    - Example: `C:\Users\[YourUser]\Documents\...`
3.  **Compilation:**
    ```bash
    javac hospital_appointments_management_system/*.java
    ```
4.  **Running the App:**
    ```bash
    java hospital_appointments_management_system.Main
    ```

## 🔐 Default Credentials

| Role | Username | Password |
| :--- | :--- | :--- |
| **Admin** | `admin` | `admin51` |
| **Doctor/Patient** | *As registered by Admin* | *As registered by Admin* |

## 📊 Reporting
The "Generate Reports" feature creates a detailed summary including:
- Total count of Doctors and Patients.
- Appointment counts filtered by status (Confirmed, Completed, Cancelled).
- Ranking of the Top 3 Doctors based on their appointment volume.
