package org.hc.ssjds.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class Patient {

    @Id
    @Column(name = "patient_key", nullable = false, length = 16)
    private String patientKey;

    @Column(name = "religion", length = 6)
    private String religion;

    @Column(name = "hkid", nullable = false, length = 24)
    private String hkid;

    @Column(name = "patient_name", nullable = false, length = 96)
    private String patientName;

    @Column(name = "sex", nullable = false, length = 2)
    private String sex;

    @Column(name = "cccode1", length = 10)
    private String cccode1;

    @Column(name = "cccode2", length = 10)
    private String cccode2;

    @Column(name = "cccode3", length = 10)
    private String cccode3;

    @Column(name = "cccode4", length = 10)
    private String cccode4;

    @Column(name = "cccode5", length = 10)
    private String cccode5;

    @Column(name = "cccode6", length = 10)
    private String cccode6;

    @Column(name = "chi_name", length = 24)
    private String chiName;

    @Column(name = "dob")
    private Timestamp dob;

    @Column(name = "exact_dob_flag", nullable = false, length = 2)
    private String exactDobFlag;

    @Column(name = "marital_status", nullable = false, length = 2)
    private String maritalStatus;

    @Column(name = "race", nullable = false, length = 4)
    private String race;

    @Column(name = "other_doc_no", length = 24)
    private String otherDocNo;

    @Column(name = "building", length = 94)
    private String building;

    @Column(name = "room", length = 10)
    private String room;

    @Column(name = "floor", length = 4)
    private String floor;

    @Column(name = "block", length = 4)
    private String block;

    @Column(name = "district", length = 10)
    private String district;

    @Column(name = "phone1", length = 20)
    private String phone1;

    @Column(name = "phone2", length = 20)
    private String phone2;

    @Column(name = "address_indicator", length = 8)
    private String addressIndicator;

    @Column(name = "mobile_phone", length = 20)
    private String mobilePhone;

    @Column(name = "sms_language", length = 8)
    private String smsLanguage;

    @Column(name = "death_indicator", length = 8)
    private String deathIndicator;

    @Column(name = "death_date")
    private Timestamp deathDate;

    @Column(name = "death_diagnosis", length = 8)
    private String deathDiagnosis;

    @Column(name = "death_external_cause", length = 8)
    private String deathExternalCause;

    @Column(name = "patient_type", length = 6)
    private String patientType;

    @Column(name = "pcs_count")
    private Integer pcsCount;

    @Column(name = "access_code")
    private Integer accessCode;

    @Column(name = "update_hospital", nullable = false, length = 6)
    private String updateHospital;

    @Column(name = "source_system", nullable = false, length = 10)
    private String sourceSystem;

    @Column(name = "update_by", nullable = false, length = 16)
    private String updateBy;

    @Column(name = "source_system_dtm", nullable = false)
    private Timestamp sourceSystemDtm;

    @Column(name = "system_dtm", nullable = false)
    private Timestamp systemDtm;

    @Column(name = "row_update_datetime", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp rowUpdateDatetime;

    @Column(name = "filler", length = 30)
    private String filler;
}
