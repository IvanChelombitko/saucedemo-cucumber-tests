INSERT INTO users (username, password, first_name, last_name, zip_code)
VALUES ('standard_user', 'secret_sauce', 'John', 'Doe', '12345'),
       ('locked_out_user', 'secret_sauce', 'Jane', 'Smith', '67890'),
       ('problem_user', 'secret_sauce', 'Bob', 'Jones', '11111'),
       ('performance_glitch_user', 'secret_sauce', 'Alice', 'White', '22222');

INSERT INTO user_orders (user_id, item_name, item_price)
VALUES (1, 'Sauce Labs Backpack', 29.99),
       (1, 'Sauce Labs Bike Light', 9.99),
       (1, 'Sauce Labs Bolt T-Shirt', 15.99);

INSERT INTO user_orders (user_id, item_name, item_price)
VALUES (3, 'Sauce Labs Fleece Jacket', 49.99),
       (3, 'Sauce Labs Onesie', 7.99);

INSERT INTO user_orders (user_id, item_name, item_price)
VALUES (4, 'Test.allTheThings() T-Shirt (Red)', 15.99),
       (4, 'Sauce Labs Backpack', 29.99)