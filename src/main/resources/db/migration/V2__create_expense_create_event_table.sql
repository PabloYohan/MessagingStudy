CREATE TABLE expense_created_event (
    id UUID PRIMARY KEY,
    expense_id UUID NOT NULL,
    amount NUMERIC(15,2) NOT NULL, 
    expense_date TIMESTAMP NOT NULL,
    occurredat TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT fk_expense
        FOREIGN KEY (expense_id)
        REFERENCES expense(id)
)