package com.example.digitalcontent_project.chat.data;

public class VaccinationData {
    private String date1;
    private String place1;
    private String date2;
    private String place2;

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getPlace1() {
        return place1;
    }

    public void setPlace1(String place1) {
        this.place1 = place1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getPlace2() {
        return place2;
    }

    public void setPlace2(String place2) {
        this.place2 = place2;
    }

    public VaccinationData(String date1, String place1, String date2, String place2) {
        this.date1 = date1;
        this.place1 = place1;
        this.date2 = date2;
        this.place2 = place2;
    }
}
