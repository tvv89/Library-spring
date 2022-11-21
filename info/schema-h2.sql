DROP TABLE IF EXISTS 'authors';
CREATE TABLE 'authors' (
                           'id' int NOT NULL AUTO_INCREMENT,
                           'first_name' text NOT NULL,
                           'last_name' text NOT NULL,
                           PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS 'book_genre';
CREATE TABLE 'book_genre' (
                              'id' int NOT NULL AUTO_INCREMENT,
                              'book_id' int NOT NULL,
                              'genre_id' int NOT NULL,
                              PRIMARY KEY ('id'),
                              KEY 'book_genre_fk1' ('genre_id'),
                              KEY 'book_genre_fk0' ('book_id'),
                              CONSTRAINT 'book_genre_fk0' FOREIGN KEY ('book_id') REFERENCES 'books' ('id') ON DELETE CASCADE,
                              CONSTRAINT 'book_genre_fk1' FOREIGN KEY ('genre_id') REFERENCES 'genres' ('id')
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS 'book_user';
CREATE TABLE 'book_user' (
                             'id' int NOT NULL AUTO_INCREMENT,
                             'book_id' int NOT NULL,
                             'user_id' int NOT NULL,
                             'start_date' date DEFAULT NULL,
                             'end_date' date DEFAULT NULL,
                             'status_pay' text,
                             PRIMARY KEY ('id'),
                             KEY 'book_user_fk1' ('user_id'),
                             KEY 'book_user_fk0' ('book_id'),
                             CONSTRAINT 'book_user_fk0' FOREIGN KEY ('book_id') REFERENCES 'books' ('id') ON DELETE CASCADE,
                             CONSTRAINT 'book_user_fk1' FOREIGN KEY ('user_id') REFERENCES 'users' ('id')
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS 'books';
CREATE TABLE 'books' (
                         'id' int NOT NULL AUTO_INCREMENT,
                         'isbn' text NOT NULL,
                         'name' text NOT NULL,
                         'year' text NOT NULL,
                         'image' text,
                         'publisher_id' int NOT NULL,
                         'count' int NOT NULL,
                         PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS 'books_authors';
CREATE TABLE 'books_authors' (
                                 'id' int NOT NULL AUTO_INCREMENT,
                                 'book_id' int NOT NULL,
                                 'author_id' int NOT NULL,
                                 PRIMARY KEY ('id'),
                                 KEY 'books_authors_fk1' ('author_id'),
                                 KEY 'books_authors_fk0' ('book_id'),
                                 CONSTRAINT 'books_authors_fk0' FOREIGN KEY ('book_id') REFERENCES 'books' ('id') ON DELETE CASCADE,
                                 CONSTRAINT 'books_authors_fk1' FOREIGN KEY ('author_id') REFERENCES 'authors' ('id')
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS 'current_books';
CREATE TABLE 'current_books' (
                                 'id' int NOT NULL AUTO_INCREMENT,
                                 'book_id' int NOT NULL,
                                 'count' int NOT NULL,
                                 PRIMARY KEY ('id'),
                                 KEY 'current_books_fk0' ('book_id'),
                                 CONSTRAINT 'current_books_fk0' FOREIGN KEY ('book_id') REFERENCES 'books' ('id') ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS 'genres';
CREATE TABLE 'genres' (
                          'id' int NOT NULL AUTO_INCREMENT,
                          'name' text NOT NULL,
                          PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS 'publishers';
CREATE TABLE 'publishers' (
                              'id' int NOT NULL AUTO_INCREMENT,
                              'name' text NOT NULL,
                              'address' text,
                              'phone' text,
                              'city' text,
                              PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS 'roles';
CREATE TABLE 'roles' (
                         'id' int NOT NULL AUTO_INCREMENT,
                         'name' text NOT NULL,
                         'status' text NOT NULL,
                         PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS 'users';
CREATE TABLE 'users' (
                         'id' int NOT NULL AUTO_INCREMENT,
                         'number' text NOT NULL,
                         'password' text,
                         'first_name' text NOT NULL,
                         'last_name' text NOT NULL,
                         'date_of_birth' date NOT NULL,
                         'phone' text NOT NULL,
                         'status' text NOT NULL,
                         'photo' text,
                         'role_id' int NOT NULL,
                         'locale' text,
                         'email' text NOT NULL,
                         PRIMARY KEY ('id'),
                         KEY 'users_fk0' ('role_id'),
                         CONSTRAINT 'users_fk0' FOREIGN KEY ('role_id') REFERENCES 'roles' ('id')
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
