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
-- This SQL script populates the tables with the latest Dreadball data.
--
-- It includes only data that is common for both the original and Xtreme
-- versions.
-- ****************************************

-- ****************************************
-- A note aboud ids.
--
-- For the units, the following id ranges have been used:
-- DBO players: 0 to 99
-- DBX players: 100 to 199
-- DBO MVPs and giants: 200 to 299
-- DBX MVPs, giants and free agents: 300 to 399
-- ****************************************


-- ****************************************
--                ABILITIES
-- ****************************************

INSERT INTO abilities (id, name) VALUES (1, '360_vision');
INSERT INTO abilities (id, name) VALUES (2, 'adaptable');
INSERT INTO abilities (id, name) VALUES (3, 'a_safe_pair_of_hands');
INSERT INTO abilities (id, name) VALUES (4, 'alert');
INSERT INTO abilities (id, name) VALUES (5, 'backflip');
INSERT INTO abilities (id, name) VALUES (6, 'backstab');
INSERT INTO abilities (id, name) VALUES (7, 'blood_money');
INSERT INTO abilities (id, name) VALUES (8, 'cant_feel_a_thing');
INSERT INTO abilities (id, name) VALUES (9, 'charge');
INSERT INTO abilities (id, name) VALUES (10, 'comin_through');
INSERT INTO abilities (id, name) VALUES (11, 'crowd_puller');
INSERT INTO abilities (id, name) VALUES (12, 'dirty_tricks');
INSERT INTO abilities (id, name) VALUES (13, 'does_this_hurt');
INSERT INTO abilities (id, name) VALUES (14, 'driller');
INSERT INTO abilities (id, name) VALUES (16, 'duck_and_weave');
INSERT INTO abilities (id, name) VALUES (17, 'even_the_odds');
INSERT INTO abilities (id, name) VALUES (18, 'explosive_collar');
INSERT INTO abilities (id, name) VALUES (19, 'fan_favourite');
INSERT INTO abilities (id, name) VALUES (20, 'fragile');
INSERT INTO abilities (id, name) VALUES (21, 'gotcha');
INSERT INTO abilities (id, name) VALUES (22, 'grizzled');
INSERT INTO abilities (id, name) VALUES (23, 'harmonics');
INSERT INTO abilities (id, name) VALUES (24, 'heal');
INSERT INTO abilities (id, name) VALUES (25, 'illegal');
INSERT INTO abilities (id, name) VALUES (26, 'illegal_modifications');
INSERT INTO abilities (id, name) VALUES (27, 'it_wasnt_me');
INSERT INTO abilities (id, name) VALUES (28, 'jump');
INSERT INTO abilities (id, name) VALUES (29, 'keeper');
INSERT INTO abilities (id, name) VALUES (30, 'klutz');
INSERT INTO abilities (id, name) VALUES (31, 'long_arms');
INSERT INTO abilities (id, name) VALUES (32, 'lucky');
INSERT INTO abilities (id, name) VALUES (33, 'mighty');
INSERT INTO abilities (id, name) VALUES (34, 'mind_control');
INSERT INTO abilities (id, name) VALUES (35, 'mind_like_water');
INSERT INTO abilities (id, name) VALUES (36, 'misdirect');
INSERT INTO abilities (id, name) VALUES (37, 'mutant_native');
INSERT INTO abilities (id, name) VALUES (38, 'nemesis');
INSERT INTO abilities (id, name) VALUES (39, 'one_mind');
INSERT INTO abilities (id, name) VALUES (40, 'pacifist');
INSERT INTO abilities (id, name) VALUES (41, 'phaser');
INSERT INTO abilities (id, name) VALUES (42, 'pile_driver');
INSERT INTO abilities (id, name) VALUES (43, 'poison_blade');
INSERT INTO abilities (id, name) VALUES (44, 'portal');
INSERT INTO abilities (id, name) VALUES (45, 'portal_master');
INSERT INTO abilities (id, name) VALUES (46, 'prima_donna');
INSERT INTO abilities (id, name) VALUES (47, 'pummel');
INSERT INTO abilities (id, name) VALUES (48, 'push');
INSERT INTO abilities (id, name) VALUES (49, 'quick_change_artist');
INSERT INTO abilities (id, name) VALUES (50, 'quick_recovery');
INSERT INTO abilities (id, name) VALUES (51, 'ram');
INSERT INTO abilities (id, name) VALUES (52, 'ray_gun');
INSERT INTO abilities (id, name) VALUES (53, 'really_lucky');
INSERT INTO abilities (id, name) VALUES (54, 'resilient');
INSERT INTO abilities (id, name) VALUES (55, 'resources');
INSERT INTO abilities (id, name) VALUES (56, 'roll');
INSERT INTO abilities (id, name) VALUES (57, 'rolling');
INSERT INTO abilities (id, name) VALUES (58, 'rule_of_law');
INSERT INTO abilities (id, name) VALUES (59, 'runaround');
INSERT INTO abilities (id, name) VALUES (60, 'running_interference');
INSERT INTO abilities (id, name) VALUES (61, 'shock_collar');
INSERT INTO abilities (id, name) VALUES (62, 'shove');
INSERT INTO abilities (id, name) VALUES (63, 'show_off');
INSERT INTO abilities (id, name) VALUES (64, 'slide');
INSERT INTO abilities (id, name) VALUES (65, 'slippery_customer');
INSERT INTO abilities (id, name) VALUES (66, 'snack');
INSERT INTO abilities (id, name) VALUES (67, 'spinner');
INSERT INTO abilities (id, name) VALUES (68, 'steady');
INSERT INTO abilities (id, name) VALUES (69, 'stench');
INSERT INTO abilities (id, name) VALUES (70, 'stretch');
INSERT INTO abilities (id, name) VALUES (71, 'stubborn');
INSERT INTO abilities (id, name) VALUES (72, 'tail');
INSERT INTO abilities (id, name) VALUES (73, 'taking_a_dive');
INSERT INTO abilities (id, name) VALUES (74, 'teleport');
INSERT INTO abilities (id, name) VALUES (75, 'threatening');
INSERT INTO abilities (id, name) VALUES (76, 'tongue');
INSERT INTO abilities (id, name) VALUES (77, 'toxic_immunity');
INSERT INTO abilities (id, name) VALUES (78, 'trail_blazer');
INSERT INTO abilities (id, name) VALUES (79, 'toxic');
INSERT INTO abilities (id, name) VALUES (80, 'uncontrolled');
INSERT INTO abilities (id, name) VALUES (81, 'vigour');
