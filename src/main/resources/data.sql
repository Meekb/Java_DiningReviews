INSERT INTO users (id, username, city, state, zip_code, peanut_interest, egg_interest, dairy_interest) VALUES (1, 'LargeMarge', 'Joplin', 'MO', 64804, false, true, true);
INSERT INTO users (id, username, city, state, zip_code, peanut_interest, egg_interest, dairy_interest) VALUES (2, 'MisterBaby', 'Lakewood', 'CO', 80215, true, true, true);
INSERT INTO users (id, username, city, state, zip_code, peanut_interest, egg_interest, dairy_interest) VALUES (3, 'TheJanus', 'Lakewood', 'CO', 80215, true, true, false);
INSERT INTO users (id, username, city, state, zip_code, peanut_interest, egg_interest, dairy_interest) VALUES (4, 'Sergeant_Burgermarpher', 'Bronx', 'NY', 20012, true, false, true);

INSERT INTO restaurants (id, name, peanut_score, egg_score, dairy_score, overall_score) VALUES (1, 'Taco Toilet', 3, 2, 2, 2.33);
INSERT INTO restaurants (id, name, peanut_score, egg_score, dairy_score, overall_score) VALUES (2, 'Leftovers', 4, 2, 3, 3.00);
INSERT INTO restaurants (id, name, peanut_score, egg_score, dairy_score, overall_score) VALUES (3, 'Fresh Everything', 5, 5, 4, 4.66);
INSERT INTO restaurants (id, name, peanut_score, egg_score, dairy_score, overall_score) VALUES (4, 'The Buffet Depot', 1, 2, 2, 1.66);

INSERT INTO reviews (id, username, restaurant, peanut_score, egg_score, dairy_score, commentary) VALUES (1, 'LargeMarge', 1, 3, 2, 2, 'Wow! You sit on a toilet while eating the leftovers from Leftovers wrapped in a soft taco shell, smothered in day-old salsa, and served in a trough!');
INSERT INTO reviews (id, username, restaurant, peanut_score, egg_score, dairy_score, commentary) VALUES (2, 'Sergeant_Burgermarpher', 2, 4, 2, 3, 'Leftovers from The Buffet Depot scooped up and served hot or cold - your choice!');
INSERT INTO reviews (id, username, restaurant, peanut_score, egg_score, dairy_score, commentary) VALUES (3, 'MisterBaby', 3, 5, 5, 4,'Much Fresh. Really Yum.');
INSERT INTO reviews (id, username, restaurant, peanut_score, egg_score, dairy_score, commentary) VALUES (4, 'TheJanus', 4, 1, 2, 2, 'This place has a miniature train that pulls the buffet along the winding tracks. Put your table railroad crossing guard down for the train to stop for you and your sweetie to select the desserts. You wont have to lift a finger for romanace here!');