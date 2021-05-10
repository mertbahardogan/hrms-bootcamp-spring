--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-10 15:07:11

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16574)
-- Name: employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employers (
    user_id integer NOT NULL,
    company_name character varying(50) NOT NULL,
    website character varying(30) NOT NULL,
    phone_number character varying(20) NOT NULL,
    is_admin_approved boolean NOT NULL
);


ALTER TABLE public.employers OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16617)
-- Name: employers_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.employers ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.employers_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1
);


--
-- TOC entry 204 (class 1259 OID 16584)
-- Name: job_positions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_positions (
    id integer NOT NULL,
    employer_id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.job_positions OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16621)
-- Name: job_positions_employer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.job_positions ALTER COLUMN employer_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.job_positions_employer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1
);


--
-- TOC entry 206 (class 1259 OID 16619)
-- Name: job_positions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.job_positions ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.job_positions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1
);


--
-- TOC entry 203 (class 1259 OID 16579)
-- Name: job_seekers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_seekers (
    user_id integer NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(30) NOT NULL,
    national_id character(11) NOT NULL,
    birth_of_date date NOT NULL,
    is_mernis_approved boolean NOT NULL
);


ALTER TABLE public.job_seekers OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16623)
-- Name: job_seekers_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.job_seekers ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.job_seekers_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1
);


--
-- TOC entry 201 (class 1259 OID 16569)
-- Name: personnels; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personnels (
    user_id integer NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(30) NOT NULL
);


ALTER TABLE public.personnels OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16625)
-- Name: personnels_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.personnels ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.personnels_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1
);


--
-- TOC entry 200 (class 1259 OID 16564)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(20) NOT NULL,
    is_email_approved boolean NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16627)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1
);


--
-- TOC entry 2883 (class 2606 OID 16578)
-- Name: employers employers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2889 (class 2606 OID 16588)
-- Name: job_positions job_positions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT job_positions_pkey PRIMARY KEY (id);


--
-- TOC entry 2885 (class 2606 OID 16583)
-- Name: job_seekers jop_seekers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT jop_seekers_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2881 (class 2606 OID 16573)
-- Name: personnels personnels_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personnels
    ADD CONSTRAINT personnels_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2877 (class 2606 OID 16610)
-- Name: users uk_email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_email UNIQUE (email);


--
-- TOC entry 2891 (class 2606 OID 16612)
-- Name: job_positions uk_name; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT uk_name UNIQUE (name);


--
-- TOC entry 2887 (class 2606 OID 16614)
-- Name: job_seekers uk_national_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT uk_national_id UNIQUE (national_id);


--
-- TOC entry 2879 (class 2606 OID 16568)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2893 (class 2606 OID 16594)
-- Name: employers employers_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT employers_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2895 (class 2606 OID 16604)
-- Name: job_positions job_positions_employer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_positions
    ADD CONSTRAINT job_positions_employer_id_fkey FOREIGN KEY (employer_id) REFERENCES public.employers(user_id) NOT VALID;


--
-- TOC entry 2894 (class 2606 OID 16599)
-- Name: job_seekers jop_seekers_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_seekers
    ADD CONSTRAINT jop_seekers_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


--
-- TOC entry 2892 (class 2606 OID 16589)
-- Name: personnels personnels_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personnels
    ADD CONSTRAINT personnels_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


-- Completed on 2021-05-10 15:07:11

--
-- PostgreSQL database dump complete
--

