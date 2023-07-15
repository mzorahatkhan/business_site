CREATE SEQUENCE IF NOT EXISTS customer_seq;
CREATE SEQUENCE IF NOT EXISTS product_seq START WITH 1000;
CREATE SEQUENCE IF NOT EXISTS supplier_seq START WITH 500;


-- Create customer table
CREATE TABLE IF NOT EXISTS customer (
  cust_id BIGINT DEFAULT NEXTVAL('customer_seq') PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL
);

-- Create product table
CREATE TABLE IF NOT EXISTS product (
  product_id BIGINT DEFAULT NEXTVAL('product_seq') PRIMARY KEY,
  prod_name VARCHAR(50) NOT NULL,
  prod_price DECIMAL(10, 2) NOT NULL,
  prod_description VARCHAR(500) NOT NULL,
  prod_color VARCHAR(50) NOT NULL
);

-- Create supplier table
CREATE TABLE IF NOT EXISTS supplier (
  supplier_id BIGINT DEFAULT NEXTVAL('supplier_seq') PRIMARY KEY,
  supplier_name VARCHAR(50) NOT NULL,
  supplier_country VARCHAR(50) NOT NULL
);

-- Create product_supplier table for many-to-many relationship
CREATE TABLE IF NOT EXISTS product_supplier (
  product_id BIGINT REFERENCES product(product_id),
  supplier_id BIGINT REFERENCES supplier(supplier_id),
  PRIMARY KEY (product_id, supplier_id)
);
