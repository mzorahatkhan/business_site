--insert data into customer 
INSERT INTO customer (cust_id, first_name, last_name, email) VALUES
(NEXTVAL('customer_seq'), 'Jane', 'Smith', 'jane@example.com'),
(NEXTVAL('customer_seq'), 'Michael', 'Johnson', 'michael@example.com'),
(NEXTVAL('customer_seq'), 'Emily', 'Brown', 'emily@example.com'),
(NEXTVAL('customer_seq'), 'David', 'Wilson', 'david@example.com'),
(NEXTVAL('customer_seq'), 'Sarah', 'Miller', 'sarah@example.com'),
(NEXTVAL('customer_seq'), 'James', 'Davis', 'james@example.com'),
(NEXTVAL('customer_seq'), 'Olivia', 'Taylor', 'olivia@example.com'),
(NEXTVAL('customer_seq'), 'Daniel', 'Anderson', 'daniel@example.com'),
(NEXTVAL('customer_seq'), 'Sophia', 'Thomas', 'sophia@example.com'),
(NEXTVAL('customer_seq'), 'Liam', 'Johnson', 'liam@example.com');

--insert data into product
INSERT INTO Product (PRODUCT_ID, PROD_NAME, PROD_COLOR, PROD_DESCRIPTION, PROD_PRICE)
VALUES
  (NEXTVAL('product_seq'), 'Wallet', 'Black', 'Stylish wallet with multiple compartments', 29.99),
  (NEXTVAL('product_seq'), 'Card Holder', 'Brown', 'Sleek card holder for your essentials', 14.99),
  (NEXTVAL('product_seq'), 'Phone Case', 'Blue', 'Protective case for your smartphone', 19.99),
  (NEXTVAL('product_seq'), 'Handbag', 'Brown', 'Elegant handbag for everyday use', 49.99),
  (NEXTVAL('product_seq'), 'Belt', 'Black', 'Classic leather belt with buckle', 34.99),
  (NEXTVAL('product_seq'), 'Keychain', 'Black', 'Fashionable keychain with leather accents', 9.99),
  (NEXTVAL('product_seq'), 'Briefcase', 'Brown', 'Professional briefcase for business needs', 79.99),
  (NEXTVAL('product_seq'), 'Watch Strap', 'Black', 'Replaceable strap for your wristwatch', 24.99),
  (NEXTVAL('product_seq'), 'Messenger Bag', 'Brown', 'Stylish bag for carrying essentials', 59.99),
  (NEXTVAL('product_seq'), 'Travel Wallet', 'Blue', 'Organize your travel documents', 39.99);
---inset data into supplier
INSERT INTO Supplier (SUPPLIER_ID, SUPPLIER_NAME, SUPPLIER_COUNTRY)
VALUES
  (NEXTVAL('supplier_seq'), 'ABC Inc', 'USA'),
  (NEXTVAL('supplier_seq'), 'XYZ LLC', 'Canada'),
  (NEXTVAL('supplier_seq'), 'Leather Goods Inc', 'USA'),
  (NEXTVAL('supplier_seq'), 'Premium Leather LLC', 'Canada'),
  (NEXTVAL('supplier_seq'), 'Global Leather Inc', 'USA'),
  (NEXTVAL('supplier_seq'), 'Leather Crafters LLC', 'Canada'),
  (NEXTVAL('supplier_seq'), 'Luxury Leather Goods Inc', 'USA'),
  (NEXTVAL('supplier_seq'), 'Fine Leather LLC', 'Canada'),
  (NEXTVAL('supplier_seq'), 'Genuine Leather Inc', 'USA'),
  (NEXTVAL('supplier_seq'), 'Leather Experts LLC', 'Canada');

--insert into product_supplier
-- This is to insert data in product_supplier table
INSERT INTO product_supplier (product_id, supplier_id)
VALUES
  (1001, 500),
  (1002, 501),
  (1003, 501),
  (1004, 502),
  (1005, 502),
  (1006, 503),
  (1007, 503),
  (1008, 504),
  (1009, 505),
  (1001, 506),
  (1002, 507),
  (1003, 507),
  (1004, 508),
  (1005, 508),
  (1006, 509),
  (1007, 509);
