package com.cheryl.petit;

public class Docmodel {
    String docday,whysick,hospital,sicknote,backtodoc,backtodocday,petname;

    public Docmodel(){}
    public Docmodel(String docday, String whysick, String hospital, String sicknote, String backtodoc, String backtodocday, String petname) {

        this.docday = docday;
        this.whysick = whysick;
        this.hospital = hospital;
        this.sicknote = sicknote;
        this.backtodoc = backtodoc;
        this.backtodocday = backtodocday;
        this.petname = petname;
    }


    public String getDocday() {
        return docday;
    }

    public void setDocday(String docday) {
        this.docday = docday;
    }

    public String getWhysick() {
        return whysick;
    }

    public void setWhysick(String whysick) {
        this.whysick = whysick;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSicknote() {
        return sicknote;
    }

    public void setSicknote(String sicknote) {
        this.sicknote = sicknote;
    }

    public String getBacktodoc() {
        return backtodoc;
    }

    public void setBacktodoc(String backtodoc) {
        this.backtodoc = backtodoc;
    }

    public String getBacktodocday() {
        return backtodocday;
    }

    public void setBacktodacday(String backtodocday) {
        this.backtodocday = backtodocday;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }
}
