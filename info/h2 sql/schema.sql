drop table if exists authors;
CREATE TABLE authors (
                         id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         first_name VARCHAR(200) NOT NULL,
                         last_name VARCHAR(200) NOT NULL
);
drop table if exists book_genre;
CREATE TABLE book_genre (
                            id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
                            book_id INTEGER NOT NULL,
                            genre_id INTEGER NOT NULL
);
drop table if exists book_user;
CREATE TABLE book_user (
                           id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
                           book_id INTEGER NOT NULL,
                           user_id INTEGER NOT NULL,
                           start_date date DEFAULT NULL,
                           end_date date DEFAULT NULL,
                           status_pay VARCHAR(200)
);
drop table if exists books;
CREATE TABLE books (
                       id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
                       isbn VARCHAR(200) NOT NULL,
                       name VARCHAR(200) NOT NULL,
                       years VARCHAR(200) NOT NULL,
                       image VARCHAR(200),
                       publisher_id INTEGER NOT NULL,
                       count INTEGER NOT NULL
);
drop table if exists books_authors;
CREATE TABLE books_authors (
                               id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
                               book_id INTEGER NOT NULL,
                               author_id INTEGER NOT NULL
);
drop table if exists current_books;
CREATE TABLE current_books (
                               id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
                               book_id INTEGER NOT NULL,
                               count INTEGER NOT NULL
);
drop table if exists genres;
CREATE TABLE genres (
                        id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
                        name VARCHAR(200) NOT NULL
);
drop table if exists publishers;
CREATE TABLE publishers (
                            id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
                            name VARCHAR(200) NOT NULL,
                            address VARCHAR(200),
                            phone VARCHAR(200),
                            city VARCHAR(200)
);
drop table if exists roles;
CREATE TABLE roles (
                       id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
                       name VARCHAR(200) NOT NULL,
                       status VARCHAR(200) NOT NULL
);
drop table if exists users;
CREATE TABLE users (
                       id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
                       "number" VARCHAR(200) NOT NULL,
                       "password" VARCHAR(200),
                       first_name VARCHAR(200) NOT NULL,
                       last_name VARCHAR(200) NOT NULL,
                       date_of_birth date NOT NULL,
                       phone VARCHAR(200) NOT NULL,
                       status VARCHAR(200) NOT NULL,
                       photo VARCHAR(200),
                       role_id INTEGER NOT NULL,
                       locale VARCHAR(200),
                       email VARCHAR(200) NOT NULL
);