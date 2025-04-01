-- public.patient_test definition

-- Drop table

-- DROP TABLE public.patient_test;

CREATE TABLE public.patient_test
(
    patient_key          varchar(16)  NOT NULL,
    religion             varchar(6)   NULL,
    hkid                 varchar(24)  NOT NULL,
    patient_name         varchar(96)  NOT NULL,
    sex                  varchar(2)   NOT NULL,
    cccode1              varchar(10)  NULL,
    cccode2              varchar(10)  NULL,
    cccode3              varchar(10)  NULL,
    cccode4              varchar(10)  NULL,
    cccode5              varchar(10)  NULL,
    cccode6              varchar(10)  NULL,
    chi_name             varchar(24)  NULL,
    dob                  timestamp    NULL,
    exact_dob_flag       varchar(2)   NOT NULL,
    marital_status       varchar(2)   NOT NULL,
    race                 varchar(4)   NOT NULL,
    other_doc_no         varchar(24)  NULL,
    building             varchar(94)  NULL,
    room                 varchar(10)  NULL,
    floor                varchar(4)   NULL,
    block                varchar(4)   NULL,
    district             varchar(10)  NULL,
    phone1               varchar(20)  NULL,
    phone2               varchar(20)  NULL,
    address_indicator    varchar(8)   NULL,
    mobile_phone         varchar(20)  NULL,
    sms_language         varchar(8)   NULL,
    death_indicator      varchar(8)   NULL,
    death_date           timestamp    NULL,
    death_diagnosis      varchar(8)   NULL,
    death_external_cause varchar(8)   NULL,
    patient_type         varchar(6)   NULL,
    pcs_count            int4         NULL,
    access_code          int4         NULL,
    update_hospital      varchar(6)   NOT NULL,
    source_system        varchar(10)  NOT NULL,
    update_by            varchar(16)  NOT NULL,
    source_system_dtm    timestamp    NOT NULL,
    system_dtm           timestamp    NOT NULL,
    row_update_datetime  timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP,
    filler               varchar(30)  NULL,
    CONSTRAINT patient_exact_dob_fl_ct CHECK (((exact_dob_flag)::text = ANY
                                               ((ARRAY ['Y'::character varying, 'N'::character varying])::text[]))),
    CONSTRAINT patient_hkid_ct CHECK (((hkid)::text ~* '^[A-Z][A-Z]?[0-9]{6}[0-9A9]{1}$'::text)),
    CONSTRAINT patient_marital_st_ct CHECK (((marital_status)::text = ANY
                                             ((ARRAY ['M'::character varying, 'D'::character varying, 'S'::character varying, 'W'::character varying, 'U'::character varying])::text[]))),
    CONSTRAINT patient_name_ct CHECK (((patient_name)::text ~* '^[A-Z].*'::text)),
    CONSTRAINT patient_patient_key_ct CHECK (((patient_key)::text ~* '^[0-9]{8}$'::text)),
    CONSTRAINT patient_sex_ct CHECK (((sex)::text = ANY
                                      ((ARRAY ['F'::character varying, 'M'::character varying, 'U'::character varying])::text[])))
);
CREATE UNIQUE INDEX "XAK1patient" ON public.patient_test USING btree (hkid);
CREATE INDEX "XIE1patient" ON public.patient_test USING btree (patient_name, sex, dob);
CREATE INDEX "XIE2patient" ON public.patient_test USING btree (chi_name, sex, dob);
CREATE INDEX "XIE3patient" ON public.patient_test USING btree (other_doc_no);
CREATE INDEX "XIE4patient" ON public.patient_test USING btree (patient_key);

-- public.patient_10000 definition

-- Drop table

-- DROP TABLE public.patient_10000;

CREATE TABLE public.patient_10000
(
    patient_key          varchar(16)  NOT NULL,
    religion             varchar(6)   NULL,
    hkid                 varchar(24)  NOT NULL,
    patient_name         varchar(96)  NOT NULL,
    sex                  varchar(2)   NOT NULL,
    cccode1              varchar(10)  NULL,
    cccode2              varchar(10)  NULL,
    cccode3              varchar(10)  NULL,
    cccode4              varchar(10)  NULL,
    cccode5              varchar(10)  NULL,
    cccode6              varchar(10)  NULL,
    chi_name             varchar(24)  NULL,
    dob                  timestamp    NULL,
    exact_dob_flag       varchar(2)   NOT NULL,
    marital_status       varchar(2)   NOT NULL,
    race                 varchar(4)   NOT NULL,
    other_doc_no         varchar(24)  NULL,
    building             varchar(94)  NULL,
    room                 varchar(10)  NULL,
    floor                varchar(4)   NULL,
    block                varchar(4)   NULL,
    district             varchar(10)  NULL,
    phone1               varchar(20)  NULL,
    phone2               varchar(20)  NULL,
    address_indicator    varchar(8)   NULL,
    mobile_phone         varchar(20)  NULL,
    sms_language         varchar(8)   NULL,
    death_indicator      varchar(8)   NULL,
    death_date           timestamp    NULL,
    death_diagnosis      varchar(8)   NULL,
    death_external_cause varchar(8)   NULL,
    patient_type         varchar(6)   NULL,
    pcs_count            int4         NULL,
    access_code          int4         NULL,
    update_hospital      varchar(6)   NOT NULL,
    source_system        varchar(10)  NOT NULL,
    update_by            varchar(16)  NOT NULL,
    source_system_dtm    timestamp    NOT NULL,
    system_dtm           timestamp    NOT NULL,
    row_update_datetime  timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP,
    filler               varchar(30)  NULL,
    CONSTRAINT patient_exact_dob_fl_ct CHECK (((exact_dob_flag)::text = ANY
                                               ((ARRAY ['Y'::character varying, 'N'::character varying])::text[]))),
    CONSTRAINT patient_hkid_ct CHECK (((hkid)::text ~* '^[A-Z][A-Z]?[0-9]{6}[0-9A9]{1}$'::text)),
    CONSTRAINT patient_marital_st_ct CHECK (((marital_status)::text = ANY
                                             ((ARRAY ['M'::character varying, 'D'::character varying, 'S'::character varying, 'W'::character varying, 'U'::character varying])::text[]))),
    CONSTRAINT patient_name_ct CHECK (((patient_name)::text ~* '^[A-Z].*'::text)),
    CONSTRAINT patient_patient_key_ct CHECK (((patient_key)::text ~* '^[0-9]{8}$'::text)),
    CONSTRAINT patient_sex_ct CHECK (((sex)::text = ANY
                                      ((ARRAY ['F'::character varying, 'M'::character varying, 'U'::character varying])::text[])))
);
CREATE UNIQUE INDEX "XAK1patient_10000" ON public.patient_10000 USING btree (hkid);
CREATE INDEX "XIE1patient_10000" ON public.patient_10000 USING btree (patient_name, sex, dob);
CREATE INDEX "XIE2patient_10000" ON public.patient_10000 USING btree (chi_name, sex, dob);
CREATE INDEX "XIE3patient_10000" ON public.patient_10000 USING btree (other_doc_no);
CREATE INDEX "XIE4patient_10000" ON public.patient_10000 USING btree (patient_key);

-- public.patient_2000000_500 definition

-- Drop table

-- DROP TABLE public.patient_2000000_500;

CREATE TABLE public.patient_2000000_500
(
    patient_key          varchar(16)  NOT NULL,
    religion             varchar(6)   NULL,
    hkid                 varchar(24)  NOT NULL,
    patient_name         varchar(96)  NOT NULL,
    sex                  varchar(2)   NOT NULL,
    cccode1              varchar(10)  NULL,
    cccode2              varchar(10)  NULL,
    cccode3              varchar(10)  NULL,
    cccode4              varchar(10)  NULL,
    cccode5              varchar(10)  NULL,
    cccode6              varchar(10)  NULL,
    chi_name             varchar(24)  NULL,
    dob                  timestamp    NULL,
    exact_dob_flag       varchar(2)   NOT NULL,
    marital_status       varchar(2)   NOT NULL,
    race                 varchar(4)   NOT NULL,
    other_doc_no         varchar(24)  NULL,
    building             varchar(94)  NULL,
    room                 varchar(10)  NULL,
    floor                varchar(4)   NULL,
    block                varchar(4)   NULL,
    district             varchar(10)  NULL,
    phone1               varchar(20)  NULL,
    phone2               varchar(20)  NULL,
    address_indicator    varchar(8)   NULL,
    mobile_phone         varchar(20)  NULL,
    sms_language         varchar(8)   NULL,
    death_indicator      varchar(8)   NULL,
    death_date           timestamp    NULL,
    death_diagnosis      varchar(8)   NULL,
    death_external_cause varchar(8)   NULL,
    patient_type         varchar(6)   NULL,
    pcs_count            int4         NULL,
    access_code          int4         NULL,
    update_hospital      varchar(6)   NOT NULL,
    source_system        varchar(10)  NOT NULL,
    update_by            varchar(16)  NOT NULL,
    source_system_dtm    timestamp    NOT NULL,
    system_dtm           timestamp    NOT NULL,
    row_update_datetime  timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP,
    filler               varchar(30)  NULL,
    CONSTRAINT patient_exact_dob_fl_ct CHECK (((exact_dob_flag)::text = ANY
                                               (ARRAY [('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT patient_hkid_ct CHECK (((hkid)::text ~* '^[A-Z][A-Z]?[0-9]{6}[0-9A9]{1}$'::text)),
    CONSTRAINT patient_marital_st_ct CHECK (((marital_status)::text = ANY
                                             (ARRAY [('M'::character varying)::text, ('D'::character varying)::text, ('S'::character varying)::text, ('W'::character varying)::text, ('U'::character varying)::text]))),
    CONSTRAINT patient_name_ct CHECK (((patient_name)::text ~* '^[A-Z].*'::text)),
    CONSTRAINT patient_patient_key_ct CHECK (((patient_key)::text ~* '^[0-9]{8}$'::text)),
    CONSTRAINT patient_sex_ct CHECK (((sex)::text = ANY
                                      (ARRAY [('F'::character varying)::text, ('M'::character varying)::text, ('U'::character varying)::text])))
);
CREATE UNIQUE INDEX "XAK1patient_2000000_500" ON public.patient_2000000_500 USING btree (hkid);
CREATE INDEX "XIE1patient_2000000_500" ON public.patient_2000000_500 USING btree (patient_name, sex, dob);
CREATE INDEX "XIE2patient_2000000_500" ON public.patient_2000000_500 USING btree (chi_name, sex, dob);
CREATE INDEX "XIE3patient_2000000_500" ON public.patient_2000000_500 USING btree (other_doc_no);
CREATE INDEX "XIE4patient_2000000_500" ON public.patient_2000000_500 USING btree (patient_key);

-- public.patient_2000000 definition

-- Drop table

-- DROP TABLE public.patient_2000000;

CREATE TABLE public.patient_2000000_3000
(
    patient_key          varchar(16)  NOT NULL,
    religion             varchar(6)   NULL,
    hkid                 varchar(24)  NOT NULL,
    patient_name         varchar(96)  NOT NULL,
    sex                  varchar(2)   NOT NULL,
    cccode1              varchar(10)  NULL,
    cccode2              varchar(10)  NULL,
    cccode3              varchar(10)  NULL,
    cccode4              varchar(10)  NULL,
    cccode5              varchar(10)  NULL,
    cccode6              varchar(10)  NULL,
    chi_name             varchar(24)  NULL,
    dob                  timestamp    NULL,
    exact_dob_flag       varchar(2)   NOT NULL,
    marital_status       varchar(2)   NOT NULL,
    race                 varchar(4)   NOT NULL,
    other_doc_no         varchar(24)  NULL,
    building             varchar(94)  NULL,
    room                 varchar(10)  NULL,
    floor                varchar(4)   NULL,
    block                varchar(4)   NULL,
    district             varchar(10)  NULL,
    phone1               varchar(20)  NULL,
    phone2               varchar(20)  NULL,
    address_indicator    varchar(8)   NULL,
    mobile_phone         varchar(20)  NULL,
    sms_language         varchar(8)   NULL,
    death_indicator      varchar(8)   NULL,
    death_date           timestamp    NULL,
    death_diagnosis      varchar(8)   NULL,
    death_external_cause varchar(8)   NULL,
    patient_type         varchar(6)   NULL,
    pcs_count            int4         NULL,
    access_code          int4         NULL,
    update_hospital      varchar(6)   NOT NULL,
    source_system        varchar(10)  NOT NULL,
    update_by            varchar(16)  NOT NULL,
    source_system_dtm    timestamp    NOT NULL,
    system_dtm           timestamp    NOT NULL,
    row_update_datetime  timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP,
    filler               varchar(30)  NULL,
    CONSTRAINT patient_exact_dob_fl_ct CHECK (((exact_dob_flag)::text = ANY
                                               ((ARRAY ['Y'::character varying, 'N'::character varying])::text[]))),
    CONSTRAINT patient_hkid_ct CHECK (((hkid)::text ~* '^[A-Z][A-Z]?[0-9]{6}[0-9A9]{1}$'::text)),
    CONSTRAINT patient_marital_st_ct CHECK (((marital_status)::text = ANY
                                             ((ARRAY ['M'::character varying, 'D'::character varying, 'S'::character varying, 'W'::character varying, 'U'::character varying])::text[]))),
    CONSTRAINT patient_name_ct CHECK (((patient_name)::text ~* '^[A-Z].*'::text)),
    CONSTRAINT patient_patient_key_ct CHECK (((patient_key)::text ~* '^[0-9]{8}$'::text)),
    CONSTRAINT patient_sex_ct CHECK (((sex)::text = ANY
                                      ((ARRAY ['F'::character varying, 'M'::character varying, 'U'::character varying])::text[])))
);
CREATE UNIQUE INDEX "XAK1patient_2000000" ON public.patient_2000000 USING btree (hkid);
CREATE INDEX "XIE1patient_2000000" ON public.patient_2000000 USING btree (patient_name, sex, dob);
CREATE INDEX "XIE2patient_2000000" ON public.patient_2000000 USING btree (chi_name, sex, dob);
CREATE INDEX "XIE3patient_2000000" ON public.patient_2000000 USING btree (other_doc_no);
CREATE INDEX "XIE4patient_2000000" ON public.patient_2000000 USING btree (patient_key);

-- public.patient_2000000_10000 definition

-- Drop table

-- DROP TABLE public.patient_2000000_10000;

CREATE TABLE public.patient_2000000_10000
(
    patient_key          varchar(16)  NOT NULL,
    religion             varchar(6)   NULL,
    hkid                 varchar(24)  NOT NULL,
    patient_name         varchar(96)  NOT NULL,
    sex                  varchar(2)   NOT NULL,
    cccode1              varchar(10)  NULL,
    cccode2              varchar(10)  NULL,
    cccode3              varchar(10)  NULL,
    cccode4              varchar(10)  NULL,
    cccode5              varchar(10)  NULL,
    cccode6              varchar(10)  NULL,
    chi_name             varchar(24)  NULL,
    dob                  timestamp    NULL,
    exact_dob_flag       varchar(2)   NOT NULL,
    marital_status       varchar(2)   NOT NULL,
    race                 varchar(4)   NOT NULL,
    other_doc_no         varchar(24)  NULL,
    building             varchar(94)  NULL,
    room                 varchar(10)  NULL,
    floor                varchar(4)   NULL,
    block                varchar(4)   NULL,
    district             varchar(10)  NULL,
    phone1               varchar(20)  NULL,
    phone2               varchar(20)  NULL,
    address_indicator    varchar(8)   NULL,
    mobile_phone         varchar(20)  NULL,
    sms_language         varchar(8)   NULL,
    death_indicator      varchar(8)   NULL,
    death_date           timestamp    NULL,
    death_diagnosis      varchar(8)   NULL,
    death_external_cause varchar(8)   NULL,
    patient_type         varchar(6)   NULL,
    pcs_count            int4         NULL,
    access_code          int4         NULL,
    update_hospital      varchar(6)   NOT NULL,
    source_system        varchar(10)  NOT NULL,
    update_by            varchar(16)  NOT NULL,
    source_system_dtm    timestamp    NOT NULL,
    system_dtm           timestamp    NOT NULL,
    row_update_datetime  timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP,
    filler               varchar(30)  NULL,
    CONSTRAINT patient_exact_dob_fl_ct CHECK (((exact_dob_flag)::text = ANY
                                               (ARRAY [('Y'::character varying)::text, ('N'::character varying)::text]))),
    CONSTRAINT patient_hkid_ct CHECK (((hkid)::text ~* '^[A-Z][A-Z]?[0-9]{6}[0-9A9]{1}$'::text)),
    CONSTRAINT patient_marital_st_ct CHECK (((marital_status)::text = ANY
                                             (ARRAY [('M'::character varying)::text, ('D'::character varying)::text, ('S'::character varying)::text, ('W'::character varying)::text, ('U'::character varying)::text]))),
    CONSTRAINT patient_name_ct CHECK (((patient_name)::text ~* '^[A-Z].*'::text)),
    CONSTRAINT patient_patient_key_ct CHECK (((patient_key)::text ~* '^[0-9]{8}$'::text)),
    CONSTRAINT patient_sex_ct CHECK (((sex)::text = ANY
                                      (ARRAY [('F'::character varying)::text, ('M'::character varying)::text, ('U'::character varying)::text])))
);
CREATE UNIQUE INDEX "XAK1patient_2000000_10000" ON public.patient_2000000_10000 USING btree (hkid);
CREATE INDEX "XIE1patient_2000000_10000" ON public.patient_2000000_10000 USING btree (patient_name, sex, dob);
CREATE INDEX "XIE2patient_2000000_10000" ON public.patient_2000000_10000 USING btree (chi_name, sex, dob);
CREATE INDEX "XIE3patient_2000000_10000" ON public.patient_2000000_10000 USING btree (other_doc_no);
CREATE INDEX "XIE4patient_2000000_10000" ON public.patient_2000000_10000 USING btree (patient_key);

-- public.patient_10000000 definition

-- Drop table

-- DROP TABLE public.patient_10000000;

CREATE TABLE public.patient_10000000
(
    patient_key          varchar(16)  NOT NULL,
    religion             varchar(6)   NULL,
    hkid                 varchar(24)  NOT NULL,
    patient_name         varchar(96)  NOT NULL,
    sex                  varchar(2)   NOT NULL,
    cccode1              varchar(10)  NULL,
    cccode2              varchar(10)  NULL,
    cccode3              varchar(10)  NULL,
    cccode4              varchar(10)  NULL,
    cccode5              varchar(10)  NULL,
    cccode6              varchar(10)  NULL,
    chi_name             varchar(24)  NULL,
    dob                  timestamp    NULL,
    exact_dob_flag       varchar(2)   NOT NULL,
    marital_status       varchar(2)   NOT NULL,
    race                 varchar(4)   NOT NULL,
    other_doc_no         varchar(24)  NULL,
    building             varchar(94)  NULL,
    room                 varchar(10)  NULL,
    floor                varchar(4)   NULL,
    block                varchar(4)   NULL,
    district             varchar(10)  NULL,
    phone1               varchar(20)  NULL,
    phone2               varchar(20)  NULL,
    address_indicator    varchar(8)   NULL,
    mobile_phone         varchar(20)  NULL,
    sms_language         varchar(8)   NULL,
    death_indicator      varchar(8)   NULL,
    death_date           timestamp    NULL,
    death_diagnosis      varchar(8)   NULL,
    death_external_cause varchar(8)   NULL,
    patient_type         varchar(6)   NULL,
    pcs_count            int4         NULL,
    access_code          int4         NULL,
    update_hospital      varchar(6)   NOT NULL,
    source_system        varchar(10)  NOT NULL,
    update_by            varchar(16)  NOT NULL,
    source_system_dtm    timestamp    NOT NULL,
    system_dtm           timestamp    NOT NULL,
    row_update_datetime  timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP,
    filler               varchar(30)  NULL,
    CONSTRAINT patient_exact_dob_fl_ct CHECK (((exact_dob_flag)::text = ANY
                                               ((ARRAY ['Y'::character varying, 'N'::character varying])::text[]))),
    CONSTRAINT patient_hkid_ct CHECK (((hkid)::text ~* '^[A-Z][A-Z]?[0-9]{6}[0-9A9]{1}$'::text)),
    CONSTRAINT patient_marital_st_ct CHECK (((marital_status)::text = ANY
                                             ((ARRAY ['M'::character varying, 'D'::character varying, 'S'::character varying, 'W'::character varying, 'U'::character varying])::text[]))),
    CONSTRAINT patient_name_ct CHECK (((patient_name)::text ~* '^[A-Z].*'::text)),
    CONSTRAINT patient_patient_key_ct CHECK (((patient_key)::text ~* '^[0-9]{8}$'::text)),
    CONSTRAINT patient_sex_ct CHECK (((sex)::text = ANY
                                      ((ARRAY ['F'::character varying, 'M'::character varying, 'U'::character varying])::text[])))
);
CREATE UNIQUE INDEX "XAK1patient_10000000" ON public.patient_10000000 USING btree (hkid);
CREATE INDEX "XIE1patient_10000000" ON public.patient_10000000 USING btree (patient_name, sex, dob);
CREATE INDEX "XIE2patient_10000000" ON public.patient_10000000 USING btree (chi_name, sex, dob);
CREATE INDEX "XIE3patient_10000000" ON public.patient_10000000 USING btree (other_doc_no);
CREATE INDEX "XIE4patient_10000000" ON public.patient_10000000 USING btree (patient_key);