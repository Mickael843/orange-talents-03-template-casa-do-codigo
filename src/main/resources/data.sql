INSERT INTO AUTHOR(id, name, email, description, create_at)
    VALUES (1, 'exemplo da silva', 'exemplo.silva@gmail.com', 'Descrição super simples', '2020-05-02');

INSERT INTO CATEGORY(id, name) VALUES (1, 'fantasia');

INSERT INTO BOOK(id, isbn, title, synopsis, summary, price, page_number, publication_date, author_id, category_id)
    VALUES(1, '9788594120007', 'Um titulo duvidoso', 'Uma sinopse mais duvidosa ainda', 'sumario legal', 233, 123, '2023-08-12', 1, 1);

INSERT INTO COUNTRY(id, name) VALUES(1, 'Brasil');