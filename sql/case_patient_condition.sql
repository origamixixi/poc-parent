-- public.case_patient_condition_test definition

-- Drop table

-- DROP TABLE public.case_patient_condition_test;

CREATE TABLE public.case_patient_condition_test (
    hospital varchar(6) NOT NULL,
    case_no varchar(24) NOT NULL,
    patient_no int4 NOT NULL,
    pc1_l1 varchar(8) NOT NULL,
    pc2_l1 varchar(8) NOT NULL,
    pc3_l1 varchar(8) NOT NULL,
    pc4_l1 varchar(8) NOT NULL,
    pc5_l1 varchar(8) NOT NULL,
    pc6_l1 varchar(8) NOT NULL,
    pc1_l2 varchar(8) NOT NULL,
    pc2_l2 varchar(8) NOT NULL,
    pc3_l2 varchar(8) NOT NULL,
    pc4_l2 varchar(8) NOT NULL,
    pc5_l2 varchar(8) NOT NULL,
    pc6_l2 varchar(8) NOT NULL,
    update_by varchar(16) NOT NULL,
    update_datetime timestamp NOT NULL,
    case_specialty varchar(8) NOT NULL,
    CONSTRAINT "PK_CASE_PATIENT_CONDITION" PRIMARY KEY (hospital, case_no)
);
CREATE INDEX idx_case_no ON public.case_patient_condition_test USING btree (case_no);
CREATE INDEX idx_case_pat_cond_major ON public.case_patient_condition_test USING btree (pc1_l1, pc1_l2);


-- public.case_patient_condition_2000000 definition

-- Drop table

-- DROP TABLE public.case_patient_condition_2000000;

CREATE TABLE public.case_patient_condition_2000000 (
   hospital varchar(6) NOT NULL,
   case_no varchar(24) NOT NULL,
   patient_no int4 NOT NULL,
   pc1_l1 varchar(8) NOT NULL,
   pc2_l1 varchar(8) NOT NULL,
   pc3_l1 varchar(8) NOT NULL,
   pc4_l1 varchar(8) NOT NULL,
   pc5_l1 varchar(8) NOT NULL,
   pc6_l1 varchar(8) NOT NULL,
   pc1_l2 varchar(8) NOT NULL,
   pc2_l2 varchar(8) NOT NULL,
   pc3_l2 varchar(8) NOT NULL,
   pc4_l2 varchar(8) NOT NULL,
   pc5_l2 varchar(8) NOT NULL,
   pc6_l2 varchar(8) NOT NULL,
   update_by varchar(16) NOT NULL,
   update_datetime timestamp NOT NULL,
   case_specialty varchar(8) NOT NULL,
   CONSTRAINT "PK_CASE_PATIENT_CONDITION_2000000" PRIMARY KEY (hospital, case_no)
);
CREATE INDEX idx_case_no_2000000 ON public.case_patient_condition_2000000 USING btree (case_no);
CREATE INDEX idx_case_pat_cond_major_2000000 ON public.case_patient_condition_2000000 USING btree (pc1_l1, pc1_l2);