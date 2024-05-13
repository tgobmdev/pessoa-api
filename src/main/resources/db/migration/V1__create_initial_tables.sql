CREATE SEQUENCE sq_address
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE sq_person
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS address (
    id bigint DEFAULT nextval('sq_address') PRIMARY KEY,
    city varchar(255),
    state varchar(255),
    state_shortname varchar(255),
    street varchar(255),
    street_number varchar(255),
    zipcode varchar(255)
);

CREATE TABLE IF NOT EXISTS person (
    id bigint DEFAULT nextval('sq_person') PRIMARY KEY,
    address_id bigint,
    date_of_birth date,
    name_person varchar(255),
    FOREIGN KEY (address_id) REFERENCES address (id)
);