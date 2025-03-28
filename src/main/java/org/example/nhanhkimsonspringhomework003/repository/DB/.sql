CREATE TABLE venues(
                       venue_id serial primary key,
                       venue_name varchar(200) NULL NULL,
                       location varchar(200) NOT NULL
);

CREATE TABLE attendees(
    attendee_id SERIAL PRIMARY KEY,
    attendee_name VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL
);
CREATE TABLE events(
    event_id serial PRIMARY KEY,
    event_name VARCHAR(200) NOT NULL,
    event_
)











INSERT INTO venues VALUES (default, 'nhanh kimson', 'phnom penh');

SELECT * FROM venues;