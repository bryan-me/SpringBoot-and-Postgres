CREATE TABLE if not exists employee (
    id UUID,
    first_name VARCHAR(250),
    last_name VARCHAR(250),
    age integer,
    designation VARCHAR(250),
    phone_number VARCHAR(250),
    joined_on date,
    address VARCHAR(250),
    date_of_birth date,
    created_at timestamp,
    updated_at timestamp,
    PRIMARY KEY (id)
);