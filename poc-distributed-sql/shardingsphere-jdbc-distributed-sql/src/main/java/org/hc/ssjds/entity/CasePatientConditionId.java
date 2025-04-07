package org.hc.ssjds.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CasePatientConditionId implements Serializable {

    @Column(name = "hospital", nullable = false, length = 6)
    private String hospital;

    @Column(name = "case_no", nullable = false, length = 24)
    private String caseNo;

}
