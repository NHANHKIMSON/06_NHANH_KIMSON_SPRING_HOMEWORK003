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
    event_date VARCHAR(200) NOT NULL,
    venue_id INT NOT NULL,
    CONSTRAINT fk_venue FOREIGN KEY (venue_id) REFERENCES venues(venue_id)
                   ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE event_attendee(
    id serial PRIMARY KEY,
    event_id INT NOT NULL,
    attendee_id INT NOT NULL,
    CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES events(event_id)
                           ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT  fk_attendee FOREIGN KEY (attendee_id) REFERENCES attendees(attendee_id)
                           ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT * FROM event_attendee;

INSERT INTO event_attendee VALUES (default, 2, 3);






SELECT * FROM events;
SELECT * FROM attendees;

INSERT INTO events VALUES (default, 'FINAL PROJECT',
                           '10-10-2020', 2
                           );

SELECT * FROM venues WHERE venue_id = 2;
INSERT INTO venues VALUES (default, 'nhanh kimson', 'phnom penh');

SELECT * FROM venues;