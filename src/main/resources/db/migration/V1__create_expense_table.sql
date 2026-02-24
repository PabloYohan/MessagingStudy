CREATE TABLE expense (
    id UUID PRIMARY KEY,
    amount NUMERIC(15,2) NOT NULL,
    expense_date TIMESTAMP NOT NULL
);