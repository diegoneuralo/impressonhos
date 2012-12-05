--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.5
-- Dumped by pg_dump version 9.1.5
-- Started on 2012-12-02 18:10:38 BRST

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = impressonhos, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 211 (class 1259 OID 26601)
-- Dependencies: 8
-- Name: uf; Type: TABLE; Schema: impressonhos; Owner: postgres; Tablespace: 
--

CREATE TABLE uf (
    uf_id bigint NOT NULL,
    estado character varying(30) NOT NULL,
    sigla character varying(2) NOT NULL
);


ALTER TABLE impressonhos.uf OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 26599)
-- Dependencies: 211 8
-- Name: uf_uf_id_seq; Type: SEQUENCE; Schema: impressonhos; Owner: postgres
--

CREATE SEQUENCE uf_uf_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE impressonhos.uf_uf_id_seq OWNER TO postgres;

--
-- TOC entry 2035 (class 0 OID 0)
-- Dependencies: 210
-- Name: uf_uf_id_seq; Type: SEQUENCE OWNED BY; Schema: impressonhos; Owner: postgres
--

ALTER SEQUENCE uf_uf_id_seq OWNED BY uf.uf_id;


--
-- TOC entry 2036 (class 0 OID 0)
-- Dependencies: 210
-- Name: uf_uf_id_seq; Type: SEQUENCE SET; Schema: impressonhos; Owner: postgres
--

SELECT pg_catalog.setval('uf_uf_id_seq', 4, true);


--
-- TOC entry 2027 (class 2604 OID 26604)
-- Dependencies: 211 210 211
-- Name: uf_id; Type: DEFAULT; Schema: impressonhos; Owner: postgres
--

ALTER TABLE ONLY uf ALTER COLUMN uf_id SET DEFAULT nextval('uf_uf_id_seq'::regclass);


--
-- TOC entry 2030 (class 0 OID 26601)
-- Dependencies: 211 2031
-- Data for Name: uf; Type: TABLE DATA; Schema: impressonhos; Owner: postgres
--

COPY uf (uf_id, estado, sigla) FROM stdin;
1	Acre	AC
2	Alagoas	AL
3	Amapá	AP
4	Amazonas	AM
5	Bahia	BA
6	Ceará	CE
27	Tocantins	TO
26	Sergipe	SE
25	São Paulo	SP
24	Santa Catarina	SC
21	Rio Grande do Sul	RS
20	Rio Grande do Norte	RN
19	Rio de Janeiro	RJ
18	Piauí	PI
15	Paraíba	PB
14	Pará	PA
13	Minas Gerais	MG
12	Mato Grosso do Sul	MS
11	Mato Grosso	MT
10	Maranhão	MA
9	Goiás	GO
8	Espírito Santo	ES
7	Distrito Federal	DF
16	Paraná	PR
17	Pernambuco	PE
22	Rondônia	RO
23	Roraima	RR
\.


--
-- TOC entry 2029 (class 2606 OID 26606)
-- Dependencies: 211 211 2032
-- Name: uf_pkey; Type: CONSTRAINT; Schema: impressonhos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY uf
    ADD CONSTRAINT uf_pkey PRIMARY KEY (uf_id);


-- Completed on 2012-12-02 18:10:39 BRST

--
-- PostgreSQL database dump complete
--

