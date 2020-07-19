INSERT INTO category(id, name) VALUES(1, 'red');
INSERT INTO category(id, name) VALUES(2, 'white');

INSERT INTO product(id, name, price, description, image, category_id)
    VALUES (1, 'red_1', 250, 'desc1', 'image1', 1);
INSERT INTO product(id, name, price, description, image, category_id)
    VALUES (2, 'red_2', 1250, 'desc2', 'image2', 1);
INSERT INTO product(id, name, price, description, image, category_id)
    VALUES (3, 'white_1', 2500, 'desc3', 'image3', 2);