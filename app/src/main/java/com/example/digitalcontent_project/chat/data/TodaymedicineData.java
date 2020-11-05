package com.example.digitalcontent_project.chat.data;

public class TodaymedicineData {
    private String name;
    private String administrationway;
    private String precaution;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdministrationway() {
        return administrationway;
    }

    public void setAdministrationway(String administrationway) {
        this.administrationway = administrationway;
    }

    public String getPrecaution() {
        return precaution;
    }

    public void setPrecaution(String precaution) {
        this.precaution = precaution;
    }

    public TodaymedicineData(String name, String administrationway, String precaution) {
        this.name = name;
        this.administrationway = administrationway;
        this.precaution = precaution;
    }
}
