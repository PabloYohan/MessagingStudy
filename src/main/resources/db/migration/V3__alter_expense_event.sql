Alter table expense_created_event 
ADD COLUMN processed BOOLEAN NOT NULL DEFAULT FALSE,
ADD COLUMN processed_at TIMESTAMP NULL;