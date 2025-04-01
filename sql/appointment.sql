-- public.appointment_test definition

-- Drop table

-- DROP TABLE public.appointment_test;

CREATE TABLE public.appointment_test
(
    appt_seq               int4         NOT NULL,
    ops_patient_no         int4         NOT NULL DEFAULT 0,
    case_no                varchar(24)  NULL,
    specialty              varchar(8)   NOT NULL,
    sub_specialty          varchar(8)   NOT NULL,
    slot_datetime          timestamp    NOT NULL,
    status                 varchar(2)   NOT NULL,
    case_type              varchar(2)   NOT NULL,
    book_type              varchar(2)   NOT NULL,
    priority               varchar(8)   NOT NULL,
    priority_type          varchar(2)   NOT NULL,
    source_code            varchar(2)   NOT NULL,
    source_hospital        varchar(6)   NOT NULL,
    source_specialty       varchar(8)   NOT NULL,
    remark                 varchar(8)   NULL,
    memo                   varchar(40)  NOT NULL,
    treatment_type         varchar(2)   NOT NULL,
    treatment_unit         int4         NOT NULL,
    attn_status            varchar(2)   NOT NULL,
    attn_time              timestamp    NULL,
    patient_generic_status varchar(6)   NOT NULL,
    consult_status         varchar(2)   NOT NULL,
    booked_by              varchar(16)  NULL,
    booking_datetime       timestamp    NULL,
    dummy_datetime         timestamp    NULL,
    sp_security            int4         NULL,
    create_hosp            varchar(6)   NOT NULL,
    create_by              varchar(16)  NOT NULL,
    create_datetime        timestamp    NOT NULL,
    update_by              varchar(16)  NOT NULL,
    update_datetime        timestamp    NOT NULL,
    uploaded               varchar(2)   NULL,
    memo2                  varchar(510) NULL,
    general_care           varchar(2)   NULL,
    patient_no             int4         NULL,
    private                varchar(2)   NULL,
    attn_by_ws             varchar(60)  NULL,
    hospital               varchar(6)   NOT NULL,
    cancel_datetime        timestamp    NULL
);
CREATE INDEX "XAK1appointment" ON public.appointment_test USING btree (sub_specialty, specialty, slot_datetime);
CREATE UNIQUE INDEX "XAK2appointment" ON public.appointment_test USING btree (appt_seq, hospital);
CREATE INDEX "XIE1appointment" ON public.appointment_test USING btree (case_no, slot_datetime);
CREATE INDEX "XIE2appointment" ON public.appointment_test USING btree (patient_no, slot_datetime);
CREATE INDEX "XIE4appointment" ON public.appointment_test USING btree (update_datetime);
CREATE UNIQUE INDEX xpk_appointment ON public.appointment_test USING btree (slot_datetime, specialty, sub_specialty, appt_seq);


-- public.appointment_100000 definition

-- Drop table

-- DROP TABLE public.appointment_100000;

CREATE TABLE public.appointment_100000
(
    appt_seq               int4         NOT NULL,
    ops_patient_no         int4         NOT NULL DEFAULT 0,
    case_no                varchar(24)  NULL,
    specialty              varchar(8)   NOT NULL,
    sub_specialty          varchar(8)   NOT NULL,
    slot_datetime          timestamp    NOT NULL,
    status                 varchar(2)   NOT NULL,
    case_type              varchar(2)   NOT NULL,
    book_type              varchar(2)   NOT NULL,
    priority               varchar(8)   NOT NULL,
    priority_type          varchar(2)   NOT NULL,
    source_code            varchar(2)   NOT NULL,
    source_hospital        varchar(6)   NOT NULL,
    source_specialty       varchar(8)   NOT NULL,
    remark                 varchar(8)   NULL,
    memo                   varchar(40)  NOT NULL,
    treatment_type         varchar(2)   NOT NULL,
    treatment_unit         int4         NOT NULL,
    attn_status            varchar(2)   NOT NULL,
    attn_time              timestamp    NULL,
    patient_generic_status varchar(6)   NOT NULL,
    consult_status         varchar(2)   NOT NULL,
    booked_by              varchar(16)  NULL,
    booking_datetime       timestamp    NULL,
    dummy_datetime         timestamp    NULL,
    sp_security            int4         NULL,
    create_hosp            varchar(6)   NOT NULL,
    create_by              varchar(16)  NOT NULL,
    create_datetime        timestamp    NOT NULL,
    update_by              varchar(16)  NOT NULL,
    update_datetime        timestamp    NOT NULL,
    uploaded               varchar(2)   NULL,
    memo2                  varchar(510) NULL,
    general_care           varchar(2)   NULL,
    patient_no             int4         NULL,
    private                varchar(2)   NULL,
    attn_by_ws             varchar(60)  NULL,
    hospital               varchar(6)   NOT NULL,
    cancel_datetime        timestamp    NULL
);
CREATE INDEX "XAK1appointment_100000" ON public.appointment_100000 USING btree (sub_specialty, specialty, slot_datetime);
CREATE UNIQUE INDEX "XAK2appointment_100000" ON public.appointment_100000 USING btree (appt_seq, hospital);
CREATE INDEX "XIE1appointment_100000" ON public.appointment_100000 USING btree (case_no, slot_datetime);
CREATE INDEX "XIE2appointment_100000" ON public.appointment_100000 USING btree (patient_no, slot_datetime);
CREATE INDEX "XIE4appointment_100000" ON public.appointment_100000 USING btree (update_datetime);
CREATE UNIQUE INDEX xpk_appointment_100000 ON public.appointment_100000 USING btree (slot_datetime, specialty, sub_specialty, appt_seq);

-- public.appointment_5000000_500 definition

-- Drop table

-- DROP TABLE public.appointment_5000000_500;

CREATE TABLE public.appointment_5000000_500
(
    appt_seq               int4         NOT NULL,
    ops_patient_no         int4         NOT NULL DEFAULT 0,
    case_no                varchar(24)  NULL,
    specialty              varchar(8)   NOT NULL,
    sub_specialty          varchar(8)   NOT NULL,
    slot_datetime          timestamp    NOT NULL,
    status                 varchar(2)   NOT NULL,
    case_type              varchar(2)   NOT NULL,
    book_type              varchar(2)   NOT NULL,
    priority               varchar(8)   NOT NULL,
    priority_type          varchar(2)   NOT NULL,
    source_code            varchar(2)   NOT NULL,
    source_hospital        varchar(6)   NOT NULL,
    source_specialty       varchar(8)   NOT NULL,
    remark                 varchar(8)   NULL,
    memo                   varchar(40)  NOT NULL,
    treatment_type         varchar(2)   NOT NULL,
    treatment_unit         int4         NOT NULL,
    attn_status            varchar(2)   NOT NULL,
    attn_time              timestamp    NULL,
    patient_generic_status varchar(6)   NOT NULL,
    consult_status         varchar(2)   NOT NULL,
    booked_by              varchar(16)  NULL,
    booking_datetime       timestamp    NULL,
    dummy_datetime         timestamp    NULL,
    sp_security            int4         NULL,
    create_hosp            varchar(6)   NOT NULL,
    create_by              varchar(16)  NOT NULL,
    create_datetime        timestamp    NOT NULL,
    update_by              varchar(16)  NOT NULL,
    update_datetime        timestamp    NOT NULL,
    uploaded               varchar(2)   NULL,
    memo2                  varchar(510) NULL,
    general_care           varchar(2)   NULL,
    patient_no             int4         NULL,
    private                varchar(2)   NULL,
    attn_by_ws             varchar(60)  NULL,
    hospital               varchar(6)   NOT NULL,
    cancel_datetime        timestamp    NULL
);
CREATE INDEX "XAK1appointment_5000000_500" ON public.appointment_5000000_500 USING btree (sub_specialty, specialty, slot_datetime);
CREATE UNIQUE INDEX "XAK2appointment_5000000_500" ON public.appointment_5000000_500 USING btree (appt_seq, hospital);
CREATE INDEX "XIE1appointment_5000000_500" ON public.appointment_5000000_500 USING btree (case_no, slot_datetime);
CREATE INDEX "XIE2appointment_5000000_500" ON public.appointment_5000000_500 USING btree (patient_no, slot_datetime);
CREATE INDEX "XIE4appointment_5000000_500" ON public.appointment_5000000_500 USING btree (update_datetime);
CREATE UNIQUE INDEX xpk_appointment_5000000_500 ON public.appointment_5000000_500 USING btree (slot_datetime, specialty, sub_specialty, appt_seq);


-- public.appointment_5000000 definition

-- Drop table

-- DROP TABLE public.appointment_5000000;

CREATE TABLE public.appointment_5000000_3000
(
    appt_seq               int4         NOT NULL,
    ops_patient_no         int4         NOT NULL DEFAULT 0,
    case_no                varchar(24)  NULL,
    specialty              varchar(8)   NOT NULL,
    sub_specialty          varchar(8)   NOT NULL,
    slot_datetime          timestamp    NOT NULL,
    status                 varchar(2)   NOT NULL,
    case_type              varchar(2)   NOT NULL,
    book_type              varchar(2)   NOT NULL,
    priority               varchar(8)   NOT NULL,
    priority_type          varchar(2)   NOT NULL,
    source_code            varchar(2)   NOT NULL,
    source_hospital        varchar(6)   NOT NULL,
    source_specialty       varchar(8)   NOT NULL,
    remark                 varchar(8)   NULL,
    memo                   varchar(40)  NOT NULL,
    treatment_type         varchar(2)   NOT NULL,
    treatment_unit         int4         NOT NULL,
    attn_status            varchar(2)   NOT NULL,
    attn_time              timestamp    NULL,
    patient_generic_status varchar(6)   NOT NULL,
    consult_status         varchar(2)   NOT NULL,
    booked_by              varchar(16)  NULL,
    booking_datetime       timestamp    NULL,
    dummy_datetime         timestamp    NULL,
    sp_security            int4         NULL,
    create_hosp            varchar(6)   NOT NULL,
    create_by              varchar(16)  NOT NULL,
    create_datetime        timestamp    NOT NULL,
    update_by              varchar(16)  NOT NULL,
    update_datetime        timestamp    NOT NULL,
    uploaded               varchar(2)   NULL,
    memo2                  varchar(510) NULL,
    general_care           varchar(2)   NULL,
    patient_no             int4         NULL,
    private                varchar(2)   NULL,
    attn_by_ws             varchar(60)  NULL,
    hospital               varchar(6)   NOT NULL,
    cancel_datetime        timestamp    NULL
);
CREATE INDEX "XAK1appointment_5000000" ON public.appointment_5000000 USING btree (sub_specialty, specialty, slot_datetime);
CREATE UNIQUE INDEX "XAK2appointment_5000000" ON public.appointment_5000000 USING btree (appt_seq, hospital);
CREATE INDEX "XIE1appointment_5000000" ON public.appointment_5000000 USING btree (case_no, slot_datetime);
CREATE INDEX "XIE2appointment_5000000" ON public.appointment_5000000 USING btree (patient_no, slot_datetime);
CREATE INDEX "XIE4appointment_5000000" ON public.appointment_5000000 USING btree (update_datetime);
CREATE UNIQUE INDEX xpk_appointment_5000000 ON public.appointment_5000000 USING btree (slot_datetime, specialty, sub_specialty, appt_seq);

-- public.appointment_5000000_10000 definition

-- Drop table

-- DROP TABLE public.appointment_5000000_10000;

CREATE TABLE public.appointment_5000000_10000
(
    appt_seq               int4         NOT NULL,
    ops_patient_no         int4         NOT NULL DEFAULT 0,
    case_no                varchar(24)  NULL,
    specialty              varchar(8)   NOT NULL,
    sub_specialty          varchar(8)   NOT NULL,
    slot_datetime          timestamp    NOT NULL,
    status                 varchar(2)   NOT NULL,
    case_type              varchar(2)   NOT NULL,
    book_type              varchar(2)   NOT NULL,
    priority               varchar(8)   NOT NULL,
    priority_type          varchar(2)   NOT NULL,
    source_code            varchar(2)   NOT NULL,
    source_hospital        varchar(6)   NOT NULL,
    source_specialty       varchar(8)   NOT NULL,
    remark                 varchar(8)   NULL,
    memo                   varchar(40)  NOT NULL,
    treatment_type         varchar(2)   NOT NULL,
    treatment_unit         int4         NOT NULL,
    attn_status            varchar(2)   NOT NULL,
    attn_time              timestamp    NULL,
    patient_generic_status varchar(6)   NOT NULL,
    consult_status         varchar(2)   NOT NULL,
    booked_by              varchar(16)  NULL,
    booking_datetime       timestamp    NULL,
    dummy_datetime         timestamp    NULL,
    sp_security            int4         NULL,
    create_hosp            varchar(6)   NOT NULL,
    create_by              varchar(16)  NOT NULL,
    create_datetime        timestamp    NOT NULL,
    update_by              varchar(16)  NOT NULL,
    update_datetime        timestamp    NOT NULL,
    uploaded               varchar(2)   NULL,
    memo2                  varchar(510) NULL,
    general_care           varchar(2)   NULL,
    patient_no             int4         NULL,
    private                varchar(2)   NULL,
    attn_by_ws             varchar(60)  NULL,
    hospital               varchar(6)   NOT NULL,
    cancel_datetime        timestamp    NULL
);
CREATE INDEX "XAK1appointment_5000000_10000" ON public.appointment_5000000_10000 USING btree (sub_specialty, specialty, slot_datetime);
CREATE UNIQUE INDEX "XAK2appointment_5000000_10000" ON public.appointment_5000000_10000 USING btree (appt_seq, hospital);
CREATE INDEX "XIE1appointment_5000000_10000" ON public.appointment_5000000_10000 USING btree (case_no, slot_datetime);
CREATE INDEX "XIE2appointment_5000000_10000" ON public.appointment_5000000_10000 USING btree (patient_no, slot_datetime);
CREATE INDEX "XIE4appointment_5000000_10000" ON public.appointment_5000000_10000 USING btree (update_datetime);
CREATE UNIQUE INDEX xpk_appointment_5000000_10000 ON public.appointment_5000000_10000 USING btree (slot_datetime, specialty, sub_specialty, appt_seq);


-- public.appointment_50000000 definition

-- Drop table

-- DROP TABLE public.appointment_50000000;

CREATE TABLE public.appointment_50000000
(
    appt_seq               int4         NOT NULL,
    ops_patient_no         int4         NOT NULL DEFAULT 0,
    case_no                varchar(24)  NULL,
    specialty              varchar(8)   NOT NULL,
    sub_specialty          varchar(8)   NOT NULL,
    slot_datetime          timestamp    NOT NULL,
    status                 varchar(2)   NOT NULL,
    case_type              varchar(2)   NOT NULL,
    book_type              varchar(2)   NOT NULL,
    priority               varchar(8)   NOT NULL,
    priority_type          varchar(2)   NOT NULL,
    source_code            varchar(2)   NOT NULL,
    source_hospital        varchar(6)   NOT NULL,
    source_specialty       varchar(8)   NOT NULL,
    remark                 varchar(8)   NULL,
    memo                   varchar(40)  NOT NULL,
    treatment_type         varchar(2)   NOT NULL,
    treatment_unit         int4         NOT NULL,
    attn_status            varchar(2)   NOT NULL,
    attn_time              timestamp    NULL,
    patient_generic_status varchar(6)   NOT NULL,
    consult_status         varchar(2)   NOT NULL,
    booked_by              varchar(16)  NULL,
    booking_datetime       timestamp    NULL,
    dummy_datetime         timestamp    NULL,
    sp_security            int4         NULL,
    create_hosp            varchar(6)   NOT NULL,
    create_by              varchar(16)  NOT NULL,
    create_datetime        timestamp    NOT NULL,
    update_by              varchar(16)  NOT NULL,
    update_datetime        timestamp    NOT NULL,
    uploaded               varchar(2)   NULL,
    memo2                  varchar(510) NULL,
    general_care           varchar(2)   NULL,
    patient_no             int4         NULL,
    private                varchar(2)   NULL,
    attn_by_ws             varchar(60)  NULL,
    hospital               varchar(6)   NOT NULL,
    cancel_datetime        timestamp    NULL
);
CREATE INDEX "XAK1appointment_50000000" ON public.appointment_50000000 USING btree (sub_specialty, specialty, slot_datetime);
CREATE UNIQUE INDEX "XAK2appointment_50000000" ON public.appointment_50000000 USING btree (appt_seq, hospital);
CREATE INDEX "XIE1appointment_50000000" ON public.appointment_50000000 USING btree (case_no, slot_datetime);
CREATE INDEX "XIE2appointment_50000000" ON public.appointment_50000000 USING btree (patient_no, slot_datetime);
CREATE INDEX "XIE4appointment_50000000" ON public.appointment_50000000 USING btree (update_datetime);
CREATE UNIQUE INDEX xpk_appointment_50000000 ON public.appointment_50000000 USING btree (slot_datetime, specialty, sub_specialty, appt_seq);