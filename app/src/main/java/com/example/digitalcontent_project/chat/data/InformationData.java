package com.example.digitalcontent_project.chat.data;

public class InformationData {

    private String name;
    private String age;
    private String gender;
    private String disease;
    private String nowcondition;
    private String precaution;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getNowcondition() {
        return nowcondition;
    }

    public void setNowcondition(String nowcondition) {
        this.nowcondition = nowcondition;
    }

    public String getPrecaution() {
        return precaution;
    }

    public void setPrecaution(String precaution) {
        this.precaution = precaution;
    }

    public InformationData(String name, String age, String gender, String disease, String nowcondition, String precaution) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.nowcondition = nowcondition;
        this.precaution = precaution;
    }
}
