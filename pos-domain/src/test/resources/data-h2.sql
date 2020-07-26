INSERT INTO category(id, name) VALUES(11, 'yellow');
INSERT INTO category(id, name) VALUES(12, 'white');

INSERT INTO product(id, name, price, description, image, category_id)
    VALUES (101, 'red_1', 250, 'desc1', 'image1', 11);
INSERT INTO product(id, name, price, description, image, category_id)
    VALUES (102, 'red_2', 1250, 'desc2', 'image2', 11);
INSERT INTO product(id, name, price, description, image, category_id)
    VALUES (103, 'white_1', 2500, 'desc3', 'image3', 12);