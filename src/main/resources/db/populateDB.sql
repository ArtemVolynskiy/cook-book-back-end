DELETE FROM recipe;
DELETE FROM ingredients;
DELETE FROM users;
DELETE FROM user_roles;
DELETE FROM user_recipe;
DELETE FROM recipe_ingredients;


-- USERS
INSERT INTO users (name, secondname, nickname, email, password, calories)
    VALUES ('Artem', 'Wolynski', 'klevy paren', 'art.volynskiy@gmail.com', '$2a$10$ssZsVuSJU0KKhe2QnGbeb.CnoFQbBl0Uker5D.LHtJtNsjA0DsVAS', 3000);

INSERT INTO users (name, secondname, nickname, email, password, calories)
VALUES ('Marina', 'Lytkina', 'objora', 'marina@gmail.com', '$2a$10$ssZsVuSJU0KKhe2QnGbeb.CnoFQbBl0Uker5D.LHtJtNsjA0DsVAS', 1800);

INSERT INTO users (name, secondname, nickname, email, password, calories)
VALUES ('Maxim', 'Matrenin', 'barrier', 'max@gmail.com', '$2a$10$ssZsVuSJU0KKhe2QnGbeb.CnoFQbBl0Uker5D.LHtJtNsjA0DsVAS', 3400);

INSERT INTO users (name, nickname, email, password, calories)
VALUES ('Eugine', 'kirgiz', 'tapki@gmail.com', '$2a$10$ssZsVuSJU0KKhe2QnGbeb.CnoFQbBl0Uker5D.LHtJtNsjA0DsVAS', 3000);

-- ROLES

INSERT INTO user_roles (user_id, user_role) VALUES
  (100000, 'ROLE_ADMIN'),
  (100000, 'ROLE_USER'),
  (100001, 'ROLE_USER'),
  (100002, 'ROLE_USER'),
  (100003, 'ROLE_USER');

-- INGREDIENTS

INSERT INTO ingredients (name, price, quantity) VALUES
  ('meat', '50', 10),
  ('beef', '80', 10),
  ('fries', '20', 10),
  ('chicken', '30', 10),
  ('corn', '5', 10),
  ('onion', '5', 10),
  ('milk', '40', 10),
  ('ice-cream', '15', 10),
  ('apple', '8', 10),
  ('garlic', '2', 10);


-- RECIPES

INSERT INTO recipe (name, recipe, type, calories, cookingtime) VALUES
  ('Crispy Fried Chicken', 'Toss together chicken pieces, black pepper, salt, paprika, rosemary, thyme, oregano, sage, white pepper, and cayenne in a large bowl to coat.
Stir in buttermilk until chicken is coated. Refrigerate for 6 hours.
Combine flour, salt, paprika, cayenne, garlic powder, white pepper, and onion powder in a large shallow dish.
Remove chicken from the buttermilk and dredge each piece in the seasoned flour. Shake off any excess and transfer to a plate.
Heat peanut oil in a large Dutch oven to 350 degrees F (175 degrees C). Add all the chicken to the pan and cook for 10 minutes.
Turn chicken pieces and cook for another 10-15 minutes.
Remove chicken from the oil and transfer to a cooling rack set over a paper towel lined baking sheet. Let sit for 10 minutes before serving.','dinner', 400, 60),
  ('Steak Diane', 'Season steaks generously on both sides with salt. Allow steaks to come to room temperature while you make the sauce.
Stir together demi-glace (see Cook''s Note), mustard, Worcestershire sauce, tomato paste, and cayenne pepper in a bowl.
Heat oil in a skillet over very high heat, swirling carefully to evenly cover surface. When oil reaches a smoking point, transfer steaks to oil; add a few chunks of butter. Sear meat on high heat until brown on each side, 2 to 3 minutes per side; keep them on the rare side. An instant-read thermometer inserted into the center should read 125 degrees F (52 degrees C). Transfer steaks to a warm plate.
Stir shallots into skillet; cook until softened, 2 to 3 minutes. Remove skillet from heat; pour in Cognac. Carefully ignite with a fireplace lighter. When alcohol burns off and flames go out, return skillet to high heat and bring to a boil; cook, stirring, a few minutes to reduce slightly. Add cream and any accumulated juices from the steak. Cook on high heat just until sauce starts to thicken, 3 to 5 minutes. Transfer steaks back to pan and reduce heat to low. Gently simmer until meat is heated through and cooked to your desired level of doneness.
Transfer to hot plates and serve with a generous spoonful or two of sauce. Sprinkle with chives.','dinner', 600, 80),
  ('Coquilles Saint-Jacques', 'Melt butter in a large skillet over medium heat; saute shallots in the hot butter until translucent, 5 to 8 minutes. Stir mushrooms, salt, and black pepper into shallots. Turn heat to medium-high and cook, stirring often, until mushrooms are golden brown, about 10 minutes.
Pour white wine over mushroom mixture, dissolving any browned bits of food on bottom of skillet into wine; bring to a simmer. Gently place scallops into wine and poach in the mushroom mixture until barely firm, about 2 minutes per side. Transfer scallops to a bowl. Strain mushroom mixture into another bowl, reserving mushrooms and cooking liquid separately. Return strained liquid to skillet, pour in any accumulated juices from scallops, and stir in cream. Bring to a boil and cook until cream sauce is reduced by about half, about 10 minutes. Stir often. Turn off heat and let mixture cool for 1 minute.
Quickly whisk egg yolk into cream sauce until combined. Transfer skillet to a work surface (such as a heatproof countertop or cutting board) and stir cayenne pepper, 2 teaspoons tarragon, and lemon zest into sauce.
Divide mushroom mixture into scallop shells, spreading mushrooms out to cover bottoms of shells; place about 3 scallops onto each portion. Spoon cream sauce over scallops to coat; let sauce drizzle down into mushrooms. Sprinkle lightly with Gruyere cheese and paprika or cayenne.
Turn oven''s broiler to high. Slightly crinkle a large sheet of aluminum foil and place onto a baking sheet. Place filled shells onto foil and press lightly to help them stay level.
Broil about 10 inches from the heat source until sauce is bubbling and cheese is lightly browned, 5 to 6 minutes. Transfer to serving plates lined with napkins to prevent shells from tipping; garnish each portion with 2 crossed tarragon leaves.','dinner', 500, 40),
  ('Asian Grilled Chicken', 'Place the soy sauce, brown sugar, lime juice, orange juice, sweet chili sauce, chili-garlic sauce, garlic, and curry powder in a large plastic zipper bag. Seal and knead the bag with your fingers to mix all the ingredients and dissolve the sugar. Place the chicken thighs into the marinade, squeeze out the air from the bag, zip the bag closed, and refrigerate for 4 hours or overnight.
Preheat an outdoor grill for medium-low heat; lightly oil the grate.
Remove the chicken from the bag, pour the excess marinade into a small saucepan, and bring to a full boil for about 1 minute to sterilize the marinade.
Grill the chicken thighs until they are no longer pink in the middle and show grill marks, about 25 minutes, basting them generously with the sterilized marinade as they grill.','dinner', 300, 30),
  ('The Best Meatballs', 'Combine beef, veal, and pork in a large bowl. Add garlic, eggs, cheese, parsley, salt and pepper.
Blend bread crumbs into meat mixture. Slowly add the water 1/2 cup at a time. The mixture should be very moist but still hold its shape if rolled into meatballs. (I usually use about 1 1/4 cups of water). Shape into meatballs.
Heat olive oil in a large skillet. Fry meatballs in batches. When the meatball is very brown and slightly crisp remove from the heat and drain on a paper towel. (If your mixture is too wet, cover the meatballs while they are cooking so that they hold their shape better.)','dinner', 600, 80),
  ('Focaccia Bread', 'In a large bowl, stir together the flour, salt, sugar, yeast, garlic powder, oregano, thyme, basil and black pepper. Mix in the vegetable oil and water.
When the dough has pulled together, turn it out onto a lightly floured surface, and knead until smooth and elastic. Lightly oil a large bowl, place the dough in the bowl, and turn to coat with oil. Cover with a damp cloth, and let rise in a warm place for 20 minutes.
Preheat oven to 450 degrees F (230 degrees C). Punch dough down; place on greased baking sheet. Pat into a 1/2 inch thick rectangle. Brush top with olive oil. Sprinkle with Parmesan cheese and mozzarella cheese.
Bake in preheated oven for 15 minutes, or until golden brown. Serve warm.','dinner', 250, 35),
  ('Chinese Chicken Fried Rice', 'Heat oil in a large skillet over medium heat. Add onion and saute until soft, then add chicken and 2 tablespoons soy sauce and stir-fry for 5 to 6 minutes.
Stir in carrots, celery, red bell pepper, pea pods and green bell pepper and stir-fry another 5 minutes. Then add rice and stir thoroughly.
Finally, stir in scrambled eggs and 1/3 cup soy sauce, heat through and serve hot.','dinner', 350, 80),
  ('Argentine Meat Empanadas', 'In a saute; pan melt the shortening and add the chopped onions. Cook the onions until just before they begin to turn golden. Remove from the heat and stir in the sweet paprika, hot paprika, crushed red pepper flakes and salt to taste.
Spread the meat on a sieve and pour boiling water on it for partial cooking. Allow meat to cool. Place meat in a dish add salt to taste, cumin and vinegar. Mix and add the meat to the onion mixture. Mix well and place on a flat to dish to cool and harden.
Cut puff pastry dough into 10 round shells. Place a spoonful of the meat mixture on each round; add some of the raisins, olives and hard boiled egg. Avoid reaching the edges of the pastry with the filling because its oiliness will prevent good sealing. Slightly wet the edge of the pastry, fold in two and stick edges together. The shape should resemble that of a half-moon. You should have a 2/3 to 1/2 inch flat edge of pastry to work with. Seal by twisting edge, step by step, between thumb and index finger, making sure to add pressure before releasing the pinch and moving on to the next curl. Other sealing procedures like pinching without curling or using a fork to seal will not prevent juice leaks during baking, and empanadas must be juicy.
Preheat oven to 350 degrees F (180 degrees C). Place empanadas on a parchment paper lined baking sheet. Be sure to prick each empanada with a fork near the curl to allow steam to escape during baking. Glaze with egg for shine and bake until golden, about 20 to 30 minutes.','dinner', 500, 120),
  ('Sesame Beef', 'Mix soy sauce, sugar, oil, garlic, and onions in a large bowl. Set aside.
Cut steak into strips and add to bowl. Cover and refrigerate overnight, or at least 30 minutes.
Cook in wok or frying pan until brown, about 5 minutes. Add sesame seeds and cook for additional 2 minutes.','dinner', 400, 70),
  ('Roasted Balsamic Chicken with Baby Tomatoes', 'Mix balsamic vinegar, olive oil, mustard, and garlic together in an oven-safe baking dish; season with salt and pepper. Lie the chicken breasts in the vinegar mixture.
Marinate chicken in the refrigerator for at least 4 hours.
Preheat oven to 400 degrees F (200 degrees C).
Roast chicken in the preheated oven for about 30 minutes. Add tomatoes to the baking dish and continue cooking until the chicken is no longer pink in the center and the juices run clear, about 10 minutes more. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C).
Sprinkle lemon zest and drizzle lemon juice over the chicken.','dinner', 300, 380),
  ('Mongolian Beef from the Slow Cooker', 'Spread cornstarch into a wide, shallow bowl. Dredge flank steak in the cornstarch to coat completely; put into a large resealable plastic bag.
Stir water, soy sauce, brown sugar, carrots, green onions, olive oil, garlic, and ginger together in a bowl; pour into the bag with the beef and seal.
Put bag of marinating beef in the freezer until the day before you wish to prepare it.
Remove bag from freezer and put bag into a bowl and place in refrigerator to thaw, at least 24 hours before you wish to prepare the beef.
Empty bag into the crock of a slow cooker.
Cook on High until the beef is tender, 2 to 3 hours. Alternately, you can cook this on Low for 4 to 5 hours.','dinner', 300, 1050),
  ('Apple', 'Wash it', 'breakfast', 50, 2),
  ('muesli', 'Fill with water', 'lunch', 100, 5);