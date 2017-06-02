package com.example.rohma.secureit;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rohma on 6/2/2017.
 */

public class ReportCrimeClass {

    String crimeID;
    String nature;
    String area;
    String otherInfo;

    public ReportCrimeClass(){}

    public ReportCrimeClass(String crimeID, String nature, String area, String otherInfo) {
        this.crimeID = crimeID;
        this.nature = nature;
        this.area = area;
        this.otherInfo = otherInfo;
    }

    public String getCrimeID() {
        return crimeID;
    }

    public String getNature() {
        return nature;
    }

    public String getArea() {
        return area;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setCrimeID(String crimeID) {
        this.crimeID = crimeID;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

//    @Exclude
//    public Map<String,Object> toMap(){
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("cID", crimeID);
//        result.put("nature", nature);
//        result.put("area", area);
//        result.put("otherInfo", otherInfo);
//        return result;
//    }
}
