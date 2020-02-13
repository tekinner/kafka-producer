CREATE SCHEMA IF NOT EXISTS REWARDS;

CREATE TABLE rewards.consumer
(
    transactionid bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999999999 CACHE 1 ),
    memberid bigint NOT NULL,
    message character varying(60) COLLATE pg_catalog."default",
    transactiontype character varying(60) COLLATE pg_catalog."default" NOT NULL,
    amount bigint NOT NULL,
    topic character varying(60) COLLATE pg_catalog."default",
    CONSTRAINT "NBACONSUMER_pkey" PRIMARY KEY (transactionid)
);
CREATE TABLE rewards.producer
(
    memberid bigint NOT NULL,
    message character varying(60) COLLATE pg_catalog."default",
    transactiontype character varying(60) COLLATE pg_catalog."default" NOT NULL,
    amount bigint NOT NULL,
    topic character varying(60) COLLATE pg_catalog."default"
);