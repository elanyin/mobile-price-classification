-- schema.sql

-- Create table
CREATE TABLE IF NOT EXISTS devices (
                                       id BIGSERIAL PRIMARY KEY,
                                       battery_power INTEGER NOT NULL,
                                       blue BOOLEAN NOT NULL,
                                       clock_speed DOUBLE PRECISION NOT NULL,
                                       dual_sim BOOLEAN NOT NULL,
                                       fc INTEGER NOT NULL,
                                       four_g BOOLEAN NOT NULL,
                                       int_memory INTEGER NOT NULL,
                                       m_dep DOUBLE PRECISION NOT NULL,
                                       mobile_wt INTEGER NOT NULL,
                                       n_cores INTEGER NOT NULL,
                                       pc INTEGER NOT NULL,
                                       px_height INTEGER NOT NULL,
                                       px_width INTEGER NOT NULL,
                                       ram INTEGER NOT NULL,
                                       sc_h INTEGER NOT NULL,
                                       sc_w INTEGER NOT NULL,
                                       talk_time INTEGER NOT NULL,
                                       three_g BOOLEAN NOT NULL,
                                       touch_screen BOOLEAN NOT NULL,
                                       wifi BOOLEAN NOT NULL,
                                       price_range INTEGER
);

-- Create indexes
CREATE INDEX IF NOT EXISTS idx_price_range ON devices(price_range);
CREATE INDEX IF NOT EXISTS idx_ram ON devices(ram);
