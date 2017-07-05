INSERT INTO types (name) VALUES ('Новости');
INSERT INTO types (name) VALUES ('События');
INSERT INTO types (name) VALUES ('Спецакции');
INSERT INTO types (name) VALUES ('Официальный текст');
INSERT INTO types (name) VALUES ('Английский текст');

INSERT INTO articles (name, typeId) VALUES ('Новость 1', 1);
INSERT INTO articles (name, typeId) VALUES ('Новость 2', 1);
INSERT INTO articles (name, typeId) VALUES ('Спецакция 1', 3);
INSERT INTO articles (name, typeId) VALUES ('Новость 3', 1);
INSERT INTO articles (name, typeId) VALUES ('Новость 4', 1);
INSERT INTO articles (name, typeId) VALUES ('Спецакция 2', 3);
INSERT INTO articles (name, typeId) VALUES ('Новость 5', 1);
INSERT INTO articles (name, typeId) VALUES ('Официальный текст к новости 2', 4);
INSERT INTO articles (name, typeId) VALUES ('Официальный текст к новости 4', 4);
INSERT INTO articles (name, typeId) VALUES ('Английский текст к новости 2', 5);
INSERT INTO articles (name, typeId) VALUES ('Английский текст к новости 3', 5);

INSERT INTO article_link (article1_id, article2_id) VALUES (2, 8);
INSERT INTO article_link (article1_id, article2_id) VALUES (5, 9);
INSERT INTO article_link (article1_id, article2_id) VALUES (2, 10);
INSERT INTO article_link (article1_id, article2_id) VALUES (4, 11);
