-- public.cases_test definition

-- Drop table

-- DROP TABLE public.cases_test;

CREATE TABLE public.cases_test
(
    case_no               varchar(24) NOT NULL,
    hospital              varchar(6)  NOT NULL,
    opcode                varchar(8)  NOT NULL,
    ops_patient_no        int4        NOT NULL DEFAULT 0,
    "type"                varchar(2)  NOT NULL,
    reg_datetime          timestamp   NULL,
    specialty             varchar(8)  NULL,
    sub_specialty         varchar(8)  NULL,
    status                varchar(2)  NULL,
    status_datetime       timestamp   NULL,
    "security"            int2        NOT NULL,
    sp_security           int2        NOT NULL,
    hosp_security         int2        NOT NULL,
    movement_count        int2        NULL,
    discharge_status      varchar(6)  NULL,
    discharge_datetime    timestamp   NULL,
    discharge_destination varchar(10) NULL,
    pay_code              varchar(6)  NULL,
    reference             varchar(40) NOT NULL,
    create_by             varchar(16) NOT NULL,
    create_datetime       timestamp   NOT NULL,
    update_by             varchar(16) NOT NULL,
    update_datetime       timestamp   NOT NULL,
    uploaded              varchar(2)  NULL,
    patient_no            int4        NULL,
    pp_code               varchar(16) NULL,
    CONSTRAINT "PK_CASES" PRIMARY KEY (case_no)
);
CREATE UNIQUE INDEX "XAK1caseC" ON public.cases_test USING btree (patient_no, case_no);
CREATE INDEX "XEK15case" ON public.cases_test USING btree (create_datetime);
CREATE INDEX "XEK1case" ON public.cases_test USING btree (opcode);
CREATE INDEX "XEK4case" ON public.cases_test USING btree (specialty, sub_specialty);


-- public.cases_200000 definition

-- Drop table

-- DROP TABLE public.cases_200000;

CREATE TABLE public.cases_200000
(
    case_no               varchar(24) NOT NULL,
    hospital              varchar(6)  NOT NULL,
    opcode                varchar(8)  NOT NULL,
    ops_patient_no        int4        NOT NULL DEFAULT 0,
    "type"                varchar(2)  NOT NULL,
    reg_datetime          timestamp   NULL,
    specialty             varchar(8)  NULL,
    sub_specialty         varchar(8)  NULL,
    status                varchar(2)  NULL,
    status_datetime       timestamp   NULL,
    "security"            int2        NOT NULL,
    sp_security           int2        NOT NULL,
    hosp_security         int2        NOT NULL,
    movement_count        int2        NULL,
    discharge_status      varchar(6)  NULL,
    discharge_datetime    timestamp   NULL,
    discharge_destination varchar(10) NULL,
    pay_code              varchar(6)  NULL,
    reference             varchar(40) NOT NULL,
    create_by             varchar(16) NOT NULL,
    create_datetime       timestamp   NOT NULL,
    update_by             varchar(16) NOT NULL,
    update_datetime       timestamp   NOT NULL,
    uploaded              varchar(2)  NULL,
    patient_no            int4        NULL,
    pp_code               varchar(16) NULL,
    CONSTRAINT "PK_CASES_200000" PRIMARY KEY (case_no)
);
CREATE UNIQUE INDEX "XAK1caseC_200000" ON public.cases_200000 USING btree (patient_no, case_no);
CREATE INDEX "XEK15case_200000" ON public.cases_200000 USING btree (create_datetime);
CREATE INDEX "XEK1case_200000" ON public.cases_200000 USING btree (opcode);
CREATE INDEX "XEK4case_200000" ON public.cases_200000 USING btree (specialty, sub_specialty);


-- public.cases_2000000 definition

-- Drop table

-- DROP TABLE public.cases_2000000;

CREATE TABLE public.cases_2000000
(
    case_no               varchar(24) NOT NULL,
    hospital              varchar(6)  NOT NULL,
    opcode                varchar(8)  NOT NULL,
    ops_patient_no        int4        NOT NULL DEFAULT 0,
    "type"                varchar(2)  NOT NULL,
    reg_datetime          timestamp   NULL,
    specialty             varchar(8)  NULL,
    sub_specialty         varchar(8)  NULL,
    status                varchar(2)  NULL,
    status_datetime       timestamp   NULL,
    "security"            int2        NOT NULL,
    sp_security           int2        NOT NULL,
    hosp_security         int2        NOT NULL,
    movement_count        int2        NULL,
    discharge_status      varchar(6)  NULL,
    discharge_datetime    timestamp   NULL,
    discharge_destination varchar(10) NULL,
    pay_code              varchar(6)  NULL,
    reference             varchar(40) NOT NULL,
    create_by             varchar(16) NOT NULL,
    create_datetime       timestamp   NOT NULL,
    update_by             varchar(16) NOT NULL,
    update_datetime       timestamp   NOT NULL,
    uploaded              varchar(2)  NULL,
    patient_no            int4        NULL,
    pp_code               varchar(16) NULL,
    CONSTRAINT "PK_CASES_2000000" PRIMARY KEY (case_no)
);
CREATE UNIQUE INDEX "XAK1caseC_2000000" ON public.cases_2000000 USING btree (patient_no, case_no);
CREATE INDEX "XEK15case_2000000" ON public.cases_2000000 USING btree (create_datetime);
CREATE INDEX "XEK1case_2000000" ON public.cases_2000000 USING btree (opcode);
CREATE INDEX "XEK4case_2000000" ON public.cases_2000000 USING btree (specialty, sub_specialty);