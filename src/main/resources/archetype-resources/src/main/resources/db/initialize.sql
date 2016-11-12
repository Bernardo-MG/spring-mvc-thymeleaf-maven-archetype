--
--  Copyright 2015 the original author or authors
--
--  Licensed under the Apache License, Version 2.0 (the "License"); you may not
--  use this file except in compliance with the License. You may obtain a copy of
--  the License at
--
--  http://www.apache.org/licenses/LICENSE-2.0
--
--  Unless required by applicable law or agreed to in writing, software
--  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
--  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
--  License for the specific language governing permissions and limitations under
--  the License.
--


-- ****************************************
-- This SQL script creates the tables to hold the data shared by DBO and DBX.
-- ****************************************


-- ****************************************
--                CREATION
-- ****************************************


-- Common tables

CREATE TABLE abilities (
    id                      INTEGER PRIMARY KEY,
    name                    VARCHAR(30) NOT NULL UNIQUE
);


-- Unit tables

CREATE TABLE units (
    id                      INTEGER PRIMARY KEY,
    unit_type               VARCHAR(30) NOT NULL,
    name                    VARCHAR(30) NOT NULL,
    template_name           VARCHAR(30) NOT NULL UNIQUE,
    cost                    INTEGER NOT NULL DEFAULT 0,
    armor                   INTEGER NOT NULL DEFAULT 0,
    movement                INTEGER NOT NULL DEFAULT 0,
    skill                   INTEGER NOT NULL DEFAULT 0,
    speed                   INTEGER NOT NULL DEFAULT 0,
    strength                INTEGER NOT NULL DEFAULT 0,
    position                VARCHAR(30) NOT NULL DEFAULT 'JACK',
    giant                   BOOLEAN NOT NULL DEFAULT FALSE,
    mvp                     BOOLEAN NOT NULL DEFAULT FALSE
);


-- Component tables

CREATE TABLE component_locations (
    id                      INTEGER PRIMARY KEY,
    name                    VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE unit_components (
    id                      INTEGER PRIMARY KEY,
    name                    VARCHAR(30) NOT NULL UNIQUE,
    location_id             INTEGER NOT NULL DEFAULT 0,
    cost                    INTEGER NOT NULL DEFAULT 0,
    armor                   INTEGER NOT NULL DEFAULT 0,
    movement                INTEGER NOT NULL DEFAULT 0,
    skill                   INTEGER NOT NULL DEFAULT 0,
    speed                   INTEGER NOT NULL DEFAULT 0,
    strength                INTEGER NOT NULL DEFAULT 0,
    FOREIGN KEY (location_id) REFERENCES component_locations (id) ON DELETE CASCADE
);

CREATE TABLE component_positions (
    component_id            INTEGER,
    position                VARCHAR(30) NOT NULL DEFAULT 'JACK',
    FOREIGN KEY (component_id) REFERENCES unit_components (id) ON DELETE CASCADE
);


-- Aggregation tables

CREATE TABLE unit_abilities (
    unit_id                 INTEGER,
    ability_id              INTEGER,
    FOREIGN KEY (ability_id) REFERENCES abilities (id) ON DELETE CASCADE,
    FOREIGN KEY (unit_id) REFERENCES units (id) ON DELETE CASCADE
);

CREATE TABLE component_abilities (
    component_id            INTEGER,
    ability_id              INTEGER,
    FOREIGN KEY (ability_id) REFERENCES abilities (id) ON DELETE CASCADE,
    FOREIGN KEY (component_id) REFERENCES unit_components (id) ON DELETE CASCADE
);
