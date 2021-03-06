--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

-- Started on 2022-02-07 20:28:14

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA public;


--
-- TOC entry 3322 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 24587)
-- Name: tb_user; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_user (
    uuid uuid NOT NULL,
    email character varying(255),
    last_name character varying(255),
    name character varying(255),
    password character varying(255),
    status_id bigint
);


--
-- TOC entry 211 (class 1259 OID 24595)
-- Name: tb_user_status; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_user_status (
    id bigint NOT NULL,
    create_at timestamp without time zone,
    expiry_time timestamp without time zone,
    status integer,
    token character varying(255)
);


--
-- TOC entry 210 (class 1259 OID 24594)
-- Name: tb_user_status_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.tb_user_status ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tb_user_status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3314 (class 0 OID 24587)
-- Dependencies: 209
-- Data for Name: tb_user; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.tb_user VALUES ('43856ab2-6428-4fec-809c-03e9765fa84e', 'vicisa8729@kruay.com', 'Test profile', 'Rodrigo', '$2a$10$uYq3pwjY/X6Ey8OYiEVl.eNHVVtCcH7TJlvC6.wHyVHBoHIR86B.e', 1);


--
-- TOC entry 3316 (class 0 OID 24595)
-- Dependencies: 211
-- Data for Name: tb_user_status; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.tb_user_status VALUES (1, '2022-02-07 20:26:29.847102', '2022-02-07 20:43:09.847102', 0, '6af1a2a7-c5c7-4dd9-83b1-6d62d7667d2a');


--
-- TOC entry 3323 (class 0 OID 0)
-- Dependencies: 210
-- Name: tb_user_status_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.tb_user_status_id_seq', 1, true);


--
-- TOC entry 3169 (class 2606 OID 24593)
-- Name: tb_user tb_user_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (uuid);


--
-- TOC entry 3173 (class 2606 OID 24599)
-- Name: tb_user_status tb_user_status_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_user_status
    ADD CONSTRAINT tb_user_status_pkey PRIMARY KEY (id);


--
-- TOC entry 3171 (class 2606 OID 24601)
-- Name: tb_user uk_4vih17mube9j7cqyjlfbcrk4m; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT uk_4vih17mube9j7cqyjlfbcrk4m UNIQUE (email);


--
-- TOC entry 3174 (class 2606 OID 24602)
-- Name: tb_user fk892ogvj4mdm0reg5xap2983tb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT fk892ogvj4mdm0reg5xap2983tb FOREIGN KEY (status_id) REFERENCES public.tb_user_status(id);


-- Completed on 2022-02-07 20:28:14

--
-- PostgreSQL database dump complete
--

