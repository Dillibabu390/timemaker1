--changeset dillibabu:1732968373921-1
CREATE TABLE user_info (
                           user_id UUID PRIMARY KEY,        -- UUID as the primary key
                           name VARCHAR(255) NOT NULL,       -- Name column with not null constraint
                           email VARCHAR(255) NOT NULL,      -- Email column with not null constraint
                           password VARCHAR(255) NOT NULL,   -- Password column with not null constraint
                           roles VARCHAR(255)               -- Roles column, nullable
);
