package org.hc.lj.entity;

import javax.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@MappedSuperclass
public class Appointment {

    @Id
    @Column(name = "appt_seq", nullable = false)
    private Integer apptSeq;

    @Column(name = "ops_patient_no", nullable = false)
    private Integer opsPatientNo;

    @Column(name = "case_no", length = 24)
    private String caseNo;

    @Column(name = "specialty", nullable = false, length = 8)
    private String specialty;

    @Column(name = "sub_specialty", nullable = false, length = 8)
    private String subSpecialty;

    @Column(name = "slot_datetime", nullable = false)
    private Timestamp slotDatetime;

    @Column(name = "status", nullable = false, length = 2)
    private String status;

    @Column(name = "case_type", nullable = false, length = 2)
    private String caseType;

    @Column(name = "book_type", nullable = false, length = 2)
    private String bookType;

    @Column(name = "priority", nullable = false, length = 8)
    private String priority;

    @Column(name = "priority_type", nullable = false, length = 2)
    private String priorityType;

    @Column(name = "source_code", nullable = false, length = 2)
    private String sourceCode;

    @Column(name = "source_hospital", nullable = false, length = 6)
    private String sourceHospital;

    @Column(name = "source_specialty", nullable = false, length = 8)
    private String sourceSpecialty;

    @Column(name = "remark", length = 8)
    private String remark;

    @Column(name = "memo", nullable = false, length = 40)
    private String memo;

    @Column(name = "treatment_type", nullable = false, length = 2)
    private String treatmentType;

    @Column(name = "treatment_unit", nullable = false)
    private Integer treatmentUnit;

    @Column(name = "attn_status", nullable = false, length = 2)
    private String attnStatus;

    @Column(name = "attn_time")
    private Timestamp attnTime;

    @Column(name = "patient_generic_status", nullable = false, length = 6)
    private String patientGenericStatus;

    @Column(name = "consult_status", nullable = false, length = 2)
    private String consultStatus;

    @Column(name = "booked_by", length = 16)
    private String bookedBy;

    @Column(name = "booking_datetime")
    private Timestamp bookingDatetime;

    @Column(name = "dummy_datetime")
    private Timestamp dummyDatetime;

    @Column(name = "sp_security")
    private Integer spSecurity;

    @Column(name = "create_hosp", nullable = false, length = 6)
    private String createHosp;

    @Column(name = "create_by", nullable = false, length = 16)
    private String createBy;

    @Column(name = "create_datetime", nullable = false)
    private Timestamp createDatetime;

    @Column(name = "update_by", nullable = false, length = 16)
    private String updateBy;

    @Column(name = "update_datetime", nullable = false)
    private Timestamp updateDatetime;

    @Column(name = "uploaded", length = 2)
    private String uploaded;

    @Column(name = "memo2", length = 510)
    private String memo2;

    @Column(name = "general_care", length = 2)
    private String generalCare;

    @Column(name = "patient_no")
    private Integer patientNo;

    @Column(name = "private", length = 2)
    private String privateField;

    @Column(name = "attn_by_ws", length = 60)
    private String attnByWs;

    @Column(name = "hospital", nullable = false, length = 6)
    private String hospital;

    @Column(name = "cancel_datetime")
    private Timestamp cancelDatetime;
}
