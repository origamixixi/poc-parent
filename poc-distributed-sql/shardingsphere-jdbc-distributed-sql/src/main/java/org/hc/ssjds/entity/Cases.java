package org.hc.ssjds.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class Cases {

    @Id
    @Column(name = "case_no", nullable = false, length = 24)
    private String caseNo;

    @Column(name = "hospital", nullable = false, length = 6)
    private String hospital;

    @Column(name = "opcode", nullable = false, length = 8)
    private String opcode;

    @Column(name = "ops_patient_no", nullable = false)
    private Integer opsPatientNo;

    @Column(name = "type", nullable = false, length = 2)
    private String type;

    @Column(name = "reg_datetime")
    private Timestamp regDatetime;

    @Column(name = "specialty", length = 8)
    private String specialty;

    @Column(name = "sub_specialty", length = 8)
    private String subSpecialty;

    @Column(name = "status", length = 2)
    private String status;

    @Column(name = "status_datetime")
    private Timestamp statusDatetime;

    @Column(name = "security", nullable = false)
    private Short security;

    @Column(name = "sp_security", nullable = false)
    private Short spSecurity;

    @Column(name = "hosp_security", nullable = false)
    private Short hospSecurity;

    @Column(name = "movement_count")
    private Short movementCount;

    @Column(name = "discharge_status", length = 6)
    private String dischargeStatus;

    @Column(name = "discharge_datetime")
    private Timestamp dischargeDatetime;

    @Column(name = "discharge_destination", length = 10)
    private String dischargeDestination;

    @Column(name = "pay_code", length = 6)
    private String payCode;

    @Column(name = "reference", nullable = false, length = 40)
    private String reference;

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

    @Column(name = "patient_no")
    private Integer patientNo;

    @Column(name = "pp_code", length = 16)
    private String ppCode;
}