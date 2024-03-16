CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    phone_number VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    registration_time DATETIME NOT NULL,
    last_login_time DATETIME,
);


CREATE TABLE inventory (
    inventory_id INT PRIMARY KEY AUTO_INCREMENT,
    isbn VARCHAR(20) NOT NULL,
    store_time DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL
);

CREATE TABLE book (
    isbn VARCHAR(20) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(100) NOT NULL,
    introduction TEXT
);

CREATE TABLE borrowing_record (
    user_id INT,
    inventory_id INT,
    borrowing_time DATETIME NOT NULL,
    return_time DATETIME,
    PRIMARY KEY (user_id, inventory_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (inventory_id) REFERENCES inventory(inventory_id)
);