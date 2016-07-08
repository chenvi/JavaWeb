CREATE DATABASE hotel CHARACTER SET utf8;
USE hotel;

CREATE TABLE dinnerTable(
	id INT PRIMARY KEY AUTO_INCREMENT,
	table_name VARCHAR(20),
	table_status INT DEFAULT 0,
	order_date DATETIME
);

CREATE TABLE foodType(
	id INT PRIMARY KEY AUTO_INCREMENT,
	type_name VARCHAR(20)
);

CREATE TABLE food(
	id INT PRIMARY KEY AUTO_INCREMENT,
	food_name VARCHAR(20),
	food_type_id INT,
	price DOUBLE,
	mprice DOUBLE,
	remark VARCHAR(200),
	img VARCHAR(100)
);

ALTER TABLE food ADD CONSTRAINT food_foodType_id FOREIGN KEY(food_type_id) REFERENCES foodType(id);

CREATE TABLE orders(
	id INT PRIMARY KEY AUTO_INCREMENT,
	table_id INT, 
	order_date DATETIME,
	table_status INT DEFAULT 0
);

ALTER TABLE orders ADD CONSTRAINT orders_table_id FOREIGN KEY(table_id) REFERENCES dinnerTable(id);

CREATE TABLE orderDetail(
	id INT PRIMARY KEY AUTO_INCREMENT,
	order_id INT,
	food_id INT, 
	food_count INT
);

ALTER TABLE orderDetail ADD CONSTRAINT orderDetail_order_id FOREIGN KEY(order_id) REFERENCES orders(id);
ALTER TABLE orderDetail ADD CONSTRAINT orderDetail_food_id FOREIGN KEY(food_id) REFERENCES food(id);