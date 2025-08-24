package com.example.votingapplication3;

public class VoterSession {
    private static VoterSession instance;

    private String name;
    private String cnic;
    private String passportNo;
    private String email;

    private String firstName;

    private String lastName;

    private String dob;

    private String gender;

    private String fatherName;

    private String countryOfResidence;

    private String visaType;

    private boolean naVoteCasted;
    private boolean paVoteCasted;

    private String userName;

    private String password;

    private boolean isRegistered;

    private VoterSession() {}

    public static synchronized VoterSession getInstance() {
        if (instance == null) {
            instance = new VoterSession();
        }
        return instance;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNaVoteCasted() {
        return naVoteCasted;
    }

    public void setNaVoteCasted(boolean naVoteCasted) {
        this.naVoteCasted = naVoteCasted;
    }

    public boolean isPaVoteCasted() {
        return paVoteCasted;
    }

    public void setPaVoteCasted(boolean paVoteCasted) {
        this.paVoteCasted = paVoteCasted;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }
}

//public class VoterData {
//    private static VoterData instance;
//    private String name;
//    private String cnic;
//    private String passport;
//    private String email;
//
//    private VoterData() {}
//
//    public static VoterData getInstance() {
//        if (instance == null) {
//            instance = new VoterData();
//        }
//        return instance;
//    }
//
//    public void setData(String name, String cnic, String passport, String email) {
//        this.name = name;
//        this.cnic = cnic;
//        this.passport = passport;
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getCnic() {
//        return cnic;
//    }
//
//    public String getPassport() {
//        return passport;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//}
