--changeset dillibabu:1733043767894-1

-- Create timesheets table with auditing fields
CREATE TABLE timesheets (
                            time_id UUID PRIMARY KEY,               -- The primary key column
                            date DATE,                              -- Date (without time)
                            start_time TIME,                        -- Start time (only time, no date)
                            end_time TIME,                          -- End time (only time, no date)
                            project VARCHAR(255),                   -- Project name
                            task VARCHAR(255),                      -- Task description
                            over_time BOOLEAN,                      -- Overtime
                            user_id uuid,

    -- Auditing fields
                            create_date TIMESTAMPTZ,                -- Created date
                            last_modified_date TIMESTAMPTZ,         -- Last modified date
                            create_by VARCHAR(255),                 -- Created by
                            last_modified_by VARCHAR(255)           -- Last modified by
);
