CREATE TABLE address (
    id bigint NOT NULL,
    city varchar(255),
    state varchar(255),
    state_shortname varchar(255),
    street varchar(255),
    street_number varchar(255),
    zipcode varchar(255),
    PRIMARY KEY (id))

CREATE TABLE person (
    id bigint NOT NULL,
    date_of_birth date,
    name_person varchar(255),
    PRIMARY KEY (id))

CREATE TABLE person_address (
    person_id bigint NOT NULL,
    address_id bigint NOT NULL)
--
CREATE SEQUENCE sq_address
    START WITH 1
    INCREMENT BY 1

CREATE SEQUENCE sq_person
    START WITH 1
    INCREMENT BY 1
--
ALTER TABLE IF EXISTS person_address
    ADD CONSTRAINT FKcyc1krsxqelkm4uwh65avij23 FOREIGN KEY (address_id) REFERENCES address

ALTER TABLE IF EXISTS person_address
    ADD CONSTRAINT FKnndfs0btabect8upo03uwgfxt FOREIGN KEY (person_id) REFERENCES person