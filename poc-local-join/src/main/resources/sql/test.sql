-- 创建patient表
CREATE TABLE public.patient_test
(
    patient_key          character varying(16) NOT NULL,
    religion             character varying(6),
    hkid                 character varying(24) NOT NULL,
    patient_name         character varying(96) NOT NULL,
    sex                  character varying(2)  NOT NULL,
    cccode1              character varying(10),
    cccode2              character varying(10),
    cccode3              character varying(10),
    cccode4              character varying(10),
    cccode5              character varying(10),
    cccode6              character varying(10),
    chi_name             character varying(24),
    dob                  timestamp,
    exact_dob_flag       character varying(2)  NOT NULL,
    marital_status       character varying(2)  NOT NULL,
    race                 character varying(4)  NOT NULL,
    other_doc_no         character varying(24),
    building             character varying(94),
    room                 character varying(10),
    floor                character varying(4),
    block                character varying(4),
    district             character varying(10),
    phone1               character varying(20),
    phone2               character varying(20),
    address_indicator    character varying(8),
    mobile_phone         character varying(20),
    sms_language         character varying(8),
    death_indicator      character varying(8),
    death_date           timestamp,
    death_diagnosis      character varying(8),
    death_external_cause character varying(8),
    patient_type         character varying(6),
    pcs_count            integer,
    access_code          integer,
    update_hospital      character varying(6)  NOT NULL,
    source_system        character varying(10) NOT NULL,
    update_by            character varying(16) NOT NULL,
    source_system_dtm    timestamp             NOT NULL,
    system_dtm           timestamp             NOT NULL,
    row_update_datetime  timestamp(6) DEFAULT CURRENT_TIMESTAMP,
    filler               character varying(30),
    -- 约束部分
    CONSTRAINT patient_exact_dob_fl_ct CHECK (exact_dob_flag IN ('Y', 'N')),
    CONSTRAINT patient_hkid_ct CHECK (hkid ~* '^[A-Z][A-Z]?[0-9]{6}[0-9A9]{1}$'),
    CONSTRAINT patient_marital_st_ct CHECK (marital_status IN ('M', 'D', 'S', 'W', 'U')),
    CONSTRAINT patient_name_ct CHECK (patient_name ~* '^[A-Z].*'),
    CONSTRAINT patient_patient_key_ct CHECK (patient_key ~* '^[0-9]{8}$'),
    CONSTRAINT patient_sex_ct CHECK (sex IN ('F', 'M', 'U'))
);

-- 创建唯一索引
CREATE UNIQUE INDEX "XAK1patient" ON public.patient_test USING btree (hkid);
-- 创建普通索引
CREATE INDEX "XIE1patient" ON public.patient_test USING btree (patient_name, sex, dob);
CREATE INDEX "XIE2patient" ON public.patient_test USING btree (chi_name, sex, dob);
CREATE INDEX "XIE3patient" ON public.patient_test USING btree (other_doc_no);
CREATE INDEX "XIE4patient" ON public.patient_test USING btree (patient_key);


-- 创建appointment表
CREATE TABLE public.appointment_test
(
    appt_seq               integer               NOT NULL,
    ops_patient_no         integer DEFAULT 0     NOT NULL,
    case_no                character varying(24),
    specialty              character varying(8)  NOT NULL,
    sub_specialty          character varying(8)  NOT NULL,
    slot_datetime          timestamp             NOT NULL,
    status                 character varying(2)  NOT NULL,
    case_type              character varying(2)  NOT NULL,
    book_type              character varying(2)  NOT NULL,
    priority               character varying(8)  NOT NULL,
    priority_type          character varying(2)  NOT NULL,
    source_code            character varying(2)  NOT NULL,
    source_hospital        character varying(6)  NOT NULL,
    source_specialty       character varying(8)  NOT NULL,
    remark                 character varying(8),
    memo                   character varying(40) NOT NULL,
    treatment_type         character varying(2)  NOT NULL,
    treatment_unit         integer               NOT NULL,
    attn_status            character varying(2)  NOT NULL,
    attn_time              timestamp,
    patient_generic_status character varying(6)  NOT NULL,
    consult_status         character varying(2)  NOT NULL,
    booked_by              character varying(16),
    booking_datetime       timestamp,
    dummy_datetime         timestamp,
    sp_security            integer,
    create_hosp            character varying(6)  NOT NULL,
    create_by              character varying(16) NOT NULL,
    create_datetime        timestamp             NOT NULL,
    update_by              character varying(16) NOT NULL,
    update_datetime        timestamp             NOT NULL,
    uploaded               character varying(2),
    memo2                  character varying(510),
    general_care           character varying(2),
    patient_no             integer,
    private                character varying(2),
    attn_by_ws             character varying(60),
    hospital               character varying(6)  NOT NULL,
    cancel_datetime        timestamp
);

-- 约束部分（这里原代码未明确给出约束条件，暂未添加具体逻辑约束，若有业务规则可补充添加）

-- 创建索引
CREATE INDEX "XAK1appointment" ON public.appointment_test USING btree (sub_specialty, specialty, slot_datetime);
CREATE UNIQUE INDEX "XAK2appointment" ON public.appointment_test USING btree (appt_seq, hospital);
CREATE INDEX "XIE1appointment" ON public.appointment_test USING btree (case_no, slot_datetime);
CREATE INDEX "XIE2appointment" ON public.appointment_test USING btree (patient_no, slot_datetime);
CREATE INDEX "XIE4appointment" ON public.appointment_test USING btree (update_datetime);
CREATE UNIQUE INDEX xpk_appointment ON public.appointment_test USING btree (slot_datetime, specialty, sub_specialty, appt_seq);

-- 创建cases表
CREATE TABLE public.cases_test
(
    case_no               VARCHAR(24) NOT NULL,
    hospital              VARCHAR(6)  NOT NULL,
    opcode                VARCHAR(8)  NOT NULL,
    ops_patient_no        INTEGER     NOT NULL DEFAULT 0,
    "type"                VARCHAR(2)  NOT NULL,
    reg_datetime          TIMESTAMP,
    specialty             VARCHAR(8),
    sub_specialty         VARCHAR(8),
    status                VARCHAR(2),
    status_datetime       TIMESTAMP,
    "security"            SMALLINT    NOT NULL,
    sp_security           SMALLINT    NOT NULL,
    hosp_security         SMALLINT    NOT NULL,
    movement_count        SMALLINT,
    discharge_status      VARCHAR(6),
    discharge_datetime    TIMESTAMP,
    discharge_destination VARCHAR(10),
    pay_code              VARCHAR(6),
    reference             VARCHAR(40) NOT NULL,
    create_by             VARCHAR(16) NOT NULL,
    create_datetime       TIMESTAMP   NOT NULL,
    update_by             VARCHAR(16) NOT NULL,
    update_datetime       TIMESTAMP   NOT NULL,
    uploaded              VARCHAR(2),
    patient_no            INTEGER,
    pp_code               VARCHAR(16),
    CONSTRAINT "PK_CASES" PRIMARY KEY (case_no)
);

-- 创建唯一索引XAK1caseC
CREATE UNIQUE INDEX "XAK1caseC" ON public.cases_test USING btree (patient_no, case_no);
-- 创建索引XEK1case
CREATE INDEX "XEK1case" ON public.cases_test USING btree (opcode);
-- 创建索引XEK4case
CREATE INDEX "XEK4case" ON public.cases_test USING btree (specialty, sub_specialty);
-- 创建索引XEK15case
CREATE INDEX "XEK15case" ON public.cases_test USING btree (create_datetime);

-- 创建opas.case_patient_condition表
CREATE TABLE public.case_patient_condition_test
(
    hospital        VARCHAR(6)  NOT NULL,
    case_no         VARCHAR(24) NOT NULL,
    patient_no      INTEGER     NOT NULL,
    pc1_l1          VARCHAR(8)  NOT NULL,
    pc2_l1          VARCHAR(8)  NOT NULL,
    pc3_l1          VARCHAR(8)  NOT NULL,
    pc4_l1          VARCHAR(8)  NOT NULL,
    pc5_l1          VARCHAR(8)  NOT NULL,
    pc6_l1          VARCHAR(8)  NOT NULL,
    pc1_l2          VARCHAR(8)  NOT NULL,
    pc2_l2          VARCHAR(8)  NOT NULL,
    pc3_l2          VARCHAR(8)  NOT NULL,
    pc4_l2          VARCHAR(8)  NOT NULL,
    pc5_l2          VARCHAR(8)  NOT NULL,
    pc6_l2          VARCHAR(8)  NOT NULL,
    update_by       VARCHAR(16) NOT NULL,
    update_datetime TIMESTAMP   NOT NULL,
    case_specialty  VARCHAR(8)  NOT NULL,
    CONSTRAINT "PK_CASE_PATIENT_CONDITION" PRIMARY KEY (hospital, case_no)
);

-- 创建索引idx_case_no
CREATE INDEX idx_case_no ON public.case_patient_condition_test USING btree (case_no);
-- 创建索引idx_case_pat_cond_major
CREATE INDEX idx_case_pat_cond_major ON public.case_patient_condition_test USING btree (pc1_l1, pc1_l2);



