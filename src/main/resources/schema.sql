CREATE TABLE IF NOT EXISTS RECEIPT (
    id serial PRIMARY KEY,
    record_creation_datetime DATETIME NOT NULL,
    transaction_datetime DATETIME NOT NULL,
    store_location_id BIGINT NOT NULL,
    total_cost DECIMAL(19,4) NOT NULL,
    subtotal_cost DECIMAL(19,4) NOT NULL,

    CONSTRAINT fk_receipt_store_location
    FOREIGN KEY (store_location_id)
    REFERENCES store_location (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS STORE_LOCATION (
    id serial PRIMARY KEY,
    store_name VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    number_of_visits INT NOT NULL
);

CREATE TYPE item_category AS ENUM ('food', 'cookware', 'furniture', 'household item', 'other')

CREATE TABLE IF NOT EXISTS COMMODITY (
    id serial PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    category item_category DEFAULT 'other',
    times_purchased INT NOT NULL
    latest_purchase_datetime DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS GROCERY_ITEM (
    id serial PRIMARY KEY,
    receipt_id BIGINT NOT NULL,
    commodity_id BIGINT NOT NULL,
    store_location_id BIGINT NOT NULL,
    cost_at_purchase DECIMAL(19,4) NOT NULL,

    CONSTRAINT fk_receipt
    FOREIGN KEY (receipt_id)
    REFERENCES receipt (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    CONSTRAINT fk_commodity
    FOREIGN KEY (commodity_id)
    REFERENCES commodity (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    CONSTRAINT fk_store_location
    FOREIGN KEY (store_location_id)
    REFERENCES store_location (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );