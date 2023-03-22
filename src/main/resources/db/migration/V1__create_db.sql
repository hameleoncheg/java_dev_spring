CREATE TABLE note(
                     ID INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                     title VARCHAR (255),
                     content VARCHAR (2048)
);