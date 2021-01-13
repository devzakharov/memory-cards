-- user table
CREATE SEQUENCE IF NOT EXISTS public.user_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.user_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public."user"
(
    id integer NOT NULL DEFAULT nextval('user_id_seq'::regclass),
    avatar character varying COLLATE pg_catalog."default" NOT NULL,
    nickname character varying COLLATE pg_catalog."default" NOT NULL,
    login character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    settings json NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public."user"
    OWNER to postgres;

-- group_to_user table
CREATE SEQUENCE IF NOT EXISTS public.group_to_user_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.group_to_user_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.group_to_user
(
    id integer NOT NULL DEFAULT nextval('group_to_user_id_seq'::regclass),
    user_id integer NOT NULL,
    group_id integer NOT NULL,
    CONSTRAINT group_to_user_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.group_to_user
    OWNER to postgres;

-- group table
CREATE SEQUENCE IF NOT EXISTS public.group_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.group_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public."group"
(
    id integer NOT NULL DEFAULT nextval('group_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    color character varying COLLATE pg_catalog."default" NOT NULL,
    type character varying COLLATE pg_catalog."default" NOT NULL,
    likes integer[] NOT NULL,
    CONSTRAINT group_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public."group"
    OWNER to postgres;

-- card_to_group table
CREATE SEQUENCE IF NOT EXISTS public.card_to_group_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.card_to_group_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.card_to_group
(
    id integer NOT NULL DEFAULT nextval('card_to_group_id_seq'::regclass),
    card_id integer NOT NULL,
    group_id integer NOT NULL,
    CONSTRAINT card_to_group_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.card_to_group
    OWNER to postgres;

-- card table
CREATE SEQUENCE IF NOT EXISTS public.card_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.card_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.card
(
    id integer NOT NULL DEFAULT nextval('card_id_seq'::regclass),
    question text COLLATE pg_catalog."default" NOT NULL,
    answer text COLLATE pg_catalog."default" NOT NULL,
    date_created timestamp with time zone NOT NULL,
    CONSTRAINT card_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.card
    OWNER to postgres;

-- card_last_answered table
CREATE SEQUENCE IF NOT EXISTS public.card_last_answered_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.card_last_answered_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.card_last_answered
(
    id integer NOT NULL DEFAULT nextval('card_last_answered_id_seq'::regclass),
    card_id integer NOT NULL,
    user_id integer NOT NULL,
    last_answered timestamp with time zone NOT NULL,
    check_counter integer NOT NULL DEFAULT 0,
    CONSTRAINT card_last_answered_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE public.card_last_answered
    OWNER to postgres;