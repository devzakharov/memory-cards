-- user table
CREATE TABLE IF NOT EXISTS public.user_table
(
    id uuid NOT NULL,
    avatar_id uuid NULL,
    nickname text NULL UNIQUE,
    "password" text NOT NULL,
    email text NOT NULL UNIQUE,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

-- group_to_user table
CREATE TABLE IF NOT EXISTS public.group_to_user
(
    id uuid NOT NULL,
    user_id uuid NOT NULL,
    group_id uuid NOT NULL,
    CONSTRAINT group_to_user_pkey PRIMARY KEY (id)
);

-- group table
CREATE TABLE IF NOT EXISTS public."group"
(
    id uuid NOT NULL,
    name text NOT NULL,
    color text NULL,
    type text NOT NULL,
    liked_by_users uuid[] NULL,
    CONSTRAINT group_pkey PRIMARY KEY (id)
);

-- card_to_group table
CREATE TABLE IF NOT EXISTS public.card_to_group
(
    id uuid NOT NULL,
    card_id uuid NOT NULL,
    group_id uuid NOT NULL,
    CONSTRAINT card_to_group_pkey PRIMARY KEY (id)
);

-- card table
CREATE TABLE IF NOT EXISTS public.card
(
    id uuid NOT NULL,
    question text NOT NULL,
    answer text NOT NULL,
    date_created timestamp NOT NULL,
    CONSTRAINT card_pkey PRIMARY KEY (id)
);

-- card_last_answered table
CREATE TABLE IF NOT EXISTS public.card_last_answered
(
    id uuid NOT NULL,
    card_id integer NOT NULL,
    user_id integer NOT NULL,
    last_answered timestamp with time zone NOT NULL,
    check_counter integer NOT NULL DEFAULT 0,
    CONSTRAINT card_last_answered_pkey PRIMARY KEY (id)
);


