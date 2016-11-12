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
--                DROPS
-- ****************************************


-- Aggregation tables

DROP TABLE IF EXISTS unit_abilities;
DROP TABLE IF EXISTS component_abilities;


-- Common tables

DROP TABLE IF EXISTS abilities;

-- Unit tables

DROP TABLE IF EXISTS units;

-- Component tables

DROP TABLE IF EXISTS component_positions;
DROP TABLE IF EXISTS unit_components;
DROP TABLE IF EXISTS component_locations;
