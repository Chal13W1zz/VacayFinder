# VacayFinder
## Author
By Brian Mutiso, Carlos Kipkoech,Sitati Solomon, Charles Muthii.

## Description
This is an application where travel and vacation agencies can post the locations and services they offer and  users looking for vacations or a place to visit can find the places , read reviews from past visitors and get a chance to review after visiting a place.
## Projects Home page
## Setup/Installation Requirements
* git clone https://github.com/Chal13W1zz/VacayFinder.git
* cd to vacayFinder/
* open with intellij IDEA or your preferred editor
* run create.sql file for database setup
* Run the gradle

## DATABASE SETUP
CREATE DATABASE vacayfinder;
\c vacayfinder;

* CREATE TABLE places(
id serial PRIMARY KEY,
placeName VARCHAR,
placeLocation VARCHAR,
placeDescription VARCHAR,
imageUrl VARCHAR
);

* CREATE TABLE reviews(
id serial PRIMARY KEY,
reviewer VARCHAR,
reviewerLocation VARCHAR,
rating int,
reviewMessage VARCHAR,
placeId int,
createdAt timestamp);

#### TEST DATABASE SETUP
CREATE DATABASE vacayfinder_test WITH TEMPLATE vacayfinder;
## Technologies Used
* Java
* Spark
* Handlebars
* PostgreSQL
* Gradle
* Bootstrap
## Support and contribution purposes
* Fork the repo
* Create a new branch (git checkout -b feature)
* Make the appropriate changes in the files
* Add changes to reflect the changes made
* Commit your changes (git commit -m 'Improve/Add feature')
* Push to the branch (git push origin feature)
* Create a Pull Request [Make sure your code is properly commented]
* If you find a bug, kindly contact us. 
## License
MIT License

# Copyright (c) 2021 vacayFinder