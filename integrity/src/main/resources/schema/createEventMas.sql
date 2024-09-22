DROP TABLE IF EXISTS EVENT_MAS;

-- Create the events table
CREATE TABLE EVENT_MAS (
   event_id      SERIAL PRIMARY KEY,
   event_name    VARCHAR(255) NOT NULL,
   user_id       VARCHAR(255) NOT NULL,
   event_content TEXT,
   manual        CHAR(1) CHECK (manual IN ('Y', 'N')),
   created_at    TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_events_user_id ON EVENT_MAS(user_id);
CREATE INDEX idx_events_event_name ON EVENT_MAS(event_name);
CREATE INDEX idx_events_manual ON EVENT_MAS(manual);

-- Create a composite index for common query patterns
CREATE INDEX idx_events_user_event_date ON EVENT_MAS(user_id, event_name, created_at);

-- Add a comment to the table
COMMENT ON TABLE EVENT_MAS IS 'Stores event data with user information and content';


insert into EVENT_MAS (event_name, user_id, event_content, manual, created_at) values ('JobPrep', 'I0103083', '{json test message}', 'Y', now());
select * from event_mas;

