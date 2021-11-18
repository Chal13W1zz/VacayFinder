CREATE DATABASE vacayfinder;

\c vacayfinder;

CREATE TABLE places(
id serial PRIMARY KEY,
placeName VARCHAR,
placeLocation VARCHAR,
placeDescription VARCHAR,
imageUrl VARCHAR
);

CREATE TABLE reviews(
id serial PRIMARY KEY,
reviewer VARCHAR,
reviewerLocation VARCHAR,
rating int,
reviewMessage VARCHAR,
placeId int,
createdAt timestamp);

CREATE DATABASE vacayfinder_test WITH TEMPLATE vacayfinder;