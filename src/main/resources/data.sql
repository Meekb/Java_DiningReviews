INSERT INTO users (id, username, city, state, zipCode, peanutInterest, eggInterest, dairyInterest) VALUES (1, 'LargeMarge', 'Joplin', 'MO', 64804, false, true, true);
INSERT INTO users (id, username, city, state, zipCode, peanutInterest, eggInterest, dairyInterest) VALUES (2, 'MisterBaby', 'Lakewood', 'CO', 80215, true, true, true);
INSERT INTO users (id, username, city, state, zipCode, peanutInterest, eggInterest, dairyInterest) VALUES (3, 'TheJanus', 'Lakewood', 'CO', 80215, true, true, false);
INSERT INTO users (id, username, city, state, zipCode, peanutInterest, eggInterest, dairyInterest) VALUES (4, 'Sergeant_Burgermarpher', 'Bronx', 'NY', 20012, true, false, true);

INSERT INTO restaurants (id, name, peanutRating, eggRating, dairyRating, overallRating) VALUES (1, 'Taco Toilet', 3, 2, 2, 2.33);
INSERT INTO restaurants (id, name, peanutRating, eggRating, dairyRating, overallRating) VALUES (2, 'Leftovers', 4, 2, 3, 3.00);
INSERT INTO restaurants (id, name, peanutRating, eggRating, dairyRating, overallRating) VALUES (3, 'The Buffet Depot', 1, 2, 2, 1.66);
INSERT INTO restaurants (id, name, peanutRating, eggRating, dairyRating, overallRating) VALUES (4, 'Fresh Everything', 5, 5, 4, 4.66);
INSERT INTO restaurants (id, name, peanutRating, eggRating, dairyRating, overallRating) VALUES (5, 'Golden Dagger Buffet', 0, 0, 0, 0);

INSERT INTO reviews (id, username, restaurant, peanutScore, eggScore, dairyScore, commentary, review_status) VALUES (1, 'LargeMarge', 1, 4, 2, 2, 'Wow! You sit on a toilet while eating the leftovers from Leftovers wrapped in a soft taco shell, smothered in day-old salsa, and served in a trough!', 'REJECTED');
INSERT INTO reviews (id, username, restaurant, peanutScore, eggScore, dairyScore, commentary, review_status) VALUES (2, 'Sergeant_Burgermarpher', 2, 4, null, 3, 'Leftovers from The Buffet Depot scooped up and served hot or cold - your choice!', 'APPROVED');
INSERT INTO reviews (id, username, restaurant, peanutScore, eggScore, dairyScore, commentary, review_status) VALUES (3, 'MisterBaby', 3, 5, 5, 4,'Much Fresh. Really Yum.', 'APPROVED');
INSERT INTO reviews (id, username, restaurant, peanutScore, eggScore, dairyScore, commentary, review_status) VALUES (4, 'TheJanus', 4, 1, 2, 2, 'This place has a miniature train that pulls the buffet along the winding tracks. Put your table railroad crossing guard down for the train to stop for you and your sweetie to select the desserts. You wont have to lift a finger for romanace here!', 'PENDING');