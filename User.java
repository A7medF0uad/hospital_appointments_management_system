package hospital_appointments_management_system;

import java.util.ArrayList;

public class User {

    protected String ID;
    protected String Name;
    protected String UserName;
    protected String Password;
    protected String Phonenum;

    public User(String ID, String Name, String UserName, String Password, String Phonenum) {
        this.ID = ID;
        this.Name = Name;
        this.UserName = UserName;
        this.Password = Password;
        this.Phonenum = Phonenum;
    }

    public String getInfo() {
        return "Name:" + this.Name + " ,Id:" + this.ID + " ,UserName:" + this.UserName + " ,Password:" + this.Password + " ,Phonenum:" + this.Phonenum;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhonenum() {
        return Phonenum;
    }

}
