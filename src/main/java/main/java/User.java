package main.java;

public class User {
private    String mName =null;
 private    String mPassword =null;
  private   int mID;
  private  String mEmail;

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public User(String mName, String mPassword, int mID, String mEmail) { //конструктор
        this.mName = mName;
        this.mPassword = mPassword;
        this.mID = mID;
        this.mEmail = mEmail;

    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }
}
