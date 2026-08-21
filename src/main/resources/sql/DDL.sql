CREATE TABLE IF NOT EXISTS users
(
    id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    username
    VARCHAR
(
    50
) NOT NULL UNIQUE,
    password VARCHAR
(
    50
) NOT NULL,
    first_name VARCHAR
(
    50
),
    last_name VARCHAR
(
    50
),
    zip_code VARCHAR
(
    20
)
    );

CREATE TABLE IF NOT EXISTS user_orders
(
    order_id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    user_id
    INT
    NOT
    NULL,
    item_name
    VARCHAR
(
    100
) NOT NULL,
    item_price DECIMAL
(
    10,
    2
) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY
(
    user_id
) REFERENCES users
(
    id
) ON DELETE CASCADE
    );