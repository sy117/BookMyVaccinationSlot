package com.sklearns.vaccinationslotnotifier.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Session {
    @JsonProperty("center_id")
    Long centerId;
    String name;
    String address;
    @JsonProperty("state_name")
    String stateName;
    @JsonProperty("district_name")
    String districtName;
    @JsonProperty("block_name")
    String blockName;
    @JsonProperty("pincode")
    Integer pinCode;
    String from;
    String to;
    @JsonProperty("lat")
    Integer latitude;
    @JsonProperty("long")
    Integer longitude;
    @JsonProperty("fee_type")
    String feeType;
    @JsonProperty("session_id")
    String sessionId;
    String date;
    @JsonProperty("available_capacity")
    Integer availableCapacity;
    @JsonProperty("available_capacity_dose1")
    Integer availableCapacityDose1;
    @JsonProperty("available_capacity_dose2")
    Integer availableCapacityDose2;
    String fee;
    @JsonProperty("min_age_limit")
    Integer minAgeLimit;
    @JsonProperty("allow_all_age")
    Boolean allowAllAge;
    String vaccine;
    List<String> slots;

    @Override
    public String toString() {
//        return "Session{" +
//                "name='" + name + '\'' +
//                ", address='" + address + '\'' +
//                ", stateName='" + stateName + '\'' +
//                ", districtName='" + districtName + '\'' +
//                ", blockName='" + blockName + '\'' +
//                ", pinCode=" + pinCode +
//                ", date='" + date + '\'' +
//                ", availableCapacity=" + availableCapacity +
//                ", availableCapacityDose1=" + availableCapacityDose1 +
//                ", availableCapacityDose2=" + availableCapacityDose2 +
//                ", vaccine='" + vaccine + '\'' +
//                ", slots=" + slots +
//                '}';
        return formattedCenterDetails();
    }


    public String formattedCenterDetails(){
        StringBuilder str = new StringBuilder();
        str.append("\n");
        str.append("Center Name: " + name + "\n");
        str.append("Address: " + address + "\n");
        str.append("State Name " + stateName + "\n");
        str.append("District Name: " + districtName + "\n");
        str.append("Block Name: " + blockName + "\n");
        str.append("Pin Code: " + pinCode + "\n");
        str.append("Date: " + date + "\n");
        str.append("Available Capacity: " + availableCapacity + "\n");
        str.append("Available Capacity Dose1: " + availableCapacityDose1 + "\n");
        str.append("Available Capacity Dose2: " + availableCapacityDose2 + "\n");
        str.append("Available Slots: " + slots + "\n");
        return str.toString();
    }
}
