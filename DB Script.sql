
-------------- account table ------------
CREATE TABLE account(
   id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
   user_name VARCHAR(255) NOT NULL UNIQUE,
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255),
   balance DOUBLE DEFAULT 0.0
)

--------------- transaction table --------

CREATE TABLE transaction (
   id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
   sender_account INTEGER,
   receiver_account INTEGER,
   password VARCHAR(255),
   transaction_date DATE,
   amount DOUBLE
)

ALTER TABLE transaction
ADD CONSTRAINT fk_transaction_account_sender FOREIGN KEY (sender_account) REFERENCES account(id);

ALTER TABLE transaction
ADD CONSTRAINT fk_transaction_account_receiver FOREIGN KEY (receiver_account) REFERENCES account(id);

