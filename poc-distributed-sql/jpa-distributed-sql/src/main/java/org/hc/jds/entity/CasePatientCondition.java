package org.hc.jds.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Data
@IdClass(CasePatientConditionId.class)
@MappedSuperclass
public class CasePatientCondition {

    @Id
    @Column(name = "hospital", nullable = false, length = 6)
    private String hospital;

    @Id
    @Column(name = "case_no", nullable = false, length = 24)
    private String caseNo;

    @Column(name = "patient_no", nullable = false)
    private Integer patientNo;

    @Column(name = "pc1_l1", nullable = false, length = 8)
    private String pc1L1;

    @Column(name = "pc2_l1", nullable = false, length = 8)
    private String pc2L1;

    @Column(name = "pc3_l1", nullable = false, length = 8)
    private String pc3L1;

    @Column(name = "pc4_l1", nullable = false, length = 8)
    private String pc4L1;

    @Column(name = "pc5_l1", nullable = false, length = 8)
    private String pc5L1;

    @Column(name = "pc6_l1", nullable = false, length = 8)
    private String pc6L1;

    @Column(name = "pc1_l2", nullable = false, length = 8)
    private String pc1L2;

    @Column(name = "pc2_l2", nullable = false, length = 8)
    private String pc2L2;

    @Column(name = "pc3_l2", nullable = false, length = 8)
    private String pc3L2;

    @Column(name = "pc4_l2", nullable = false, length = 8)
    private String pc4L2;

    @Column(name = "pc5_l2", nullable = false, length = 8)
    private String pc5L2;

    @Column(name = "pc6_l2", nullable = false, length = 8)
    private String pc6L2;

    @Column(name = "update_by", nullable = false, length = 16)
    private String updateBy;

    @Column(name = "update_datetime", nullable = false)
    private Timestamp updateDatetime;

    @Column(name = "case_specialty", nullable = false, length = 8)
    private String caseSpecialty;
}
