DELETE FROM recipe;
DELETE FROM ingredients;
DELETE FROM users;
DELETE FROM user_roles;
DELETE FROM user_recipe;
DELETE FROM recipe_ingredients;


-- USERS
INSERT INTO users (name, secondname, nickname, email, password, calories)
VALUES ('Artem', 'Wolynski', 'klevy paren', 'art.volynskiy@gmail.com', '$2a$10$ssZsVuSJU0KKhe2QnGbeb.CnoFQbBl0Uker5D.LHtJtNsjA0DsVAS', 1600);

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

INSERT INTO recipe (name, recipe, type, calories, servings, preptime, cookingtime, image) VALUES

  -- Breakfast
  ('Apple', 'Wash it', 'snack', 95, 1, 0, 2, 'http://www.kimmelorchard.org/img/icon_apple_gala.png'),
  ('Apple & pecan porridge', 'For the basic porridge, place the oats and the milk (or 600ml water) into a large pan over a medium heat, and add a tiny pinch of sea salt.
Bring to a steady simmer for 5 to 6 minutes, stirring often to give you a smooth, creamy porridge, and loosening with extra milk, if needed.
Serve as is, or while it’s blipping away in the pan, follow the next steps to prepare the apple and pecan topping.
Snap the pecans up into little pieces, then toast in a small dry non-stick frying pan over a medium heat for 3 to 4 minutes, or until lightly golden.
Remove the apple stalk, then use a box grater to coarsely grate it onto a chopping board (core and all).
Stir the grated apple and a little maple syrup through then porridge, then divide between bowls.
Scatter the pecans on top, then drizzle with a little extra maple syrup, if you like.', 'breakfast', 287, 3, 5, 10, 'https://lh5.googleusercontent.com/HS2fPu3BxG1lXnqhEyAWFJxTNsaYynNKfK31ucEEDcFNb8hiW6ZGaQUeppsSBp53qlBRo4nii8RDluQ=w2560-h1308-rw'),
  ('Banana & cinnamon porridge', 'For the basic porridge, place the oats and the milk (or 600ml water) into a large pan over a medium heat, and add a tiny pinch of sea salt.
Bring to a steady simmer for 5 to 6 minutes, stirring often to give you a smooth, creamy porridge, and loosening with extra milk, if needed.
Serve as is, or while it’s blipping away in the pan, follow the next steps to prepare the banana and cinnamon topping.
Peel and slice the bananas at an angle.
Toast the almonds in a dry non-stick frying pan over a medium heat for 3 to 4 minutes, or until lightly golden.
Stir the cinnamon, poppy seeds and a little maple syrup or honey through the porridge, then divide between bowls.
Scatter the bananas and almonds on top, then drizzle with a little extra maple syrup or honey, if you like.','breakfast', 315, 3, 5, 10, 'https://lh4.googleusercontent.com/D0SP-hOugk60MntTEOS9tEPcZoJxd7FyHowhjNXHw3FyBHU9gLXgmaWRYMkJ98FIYFI-2BpvqUP2_-E=w2560-h1308-rw'),
  ('Print Oat, pear & cardamom smoothie', 'The night before you want to make your smoothie, peel and core the pears. Pop them into the freezer.
Open the cardamom pods and extract the seeds, then crush up in a pestle and mortar.
Tip the crushed seeds into a blender, then add the frozen pears, oat milk, yoghurt and honey. Blitz until smooth.
Divide between two glasses and sprinkle over the bee pollen.', 'breakfast', 245, 2, 5, 10, 'https://lh6.googleusercontent.com/pte-LBuOQulEYWKcylvnJN5B42EFDfeWvIMJ_bbOWSmjQAgzH4Pt0d5fJhCWhTZWIc3q4C5eFiKJ2cg=w2560-h1308'),
  ('Pineapple pancake mess', 'Toast the cashews in a large non-stick frying pan on a medium heat until lightly golden, add the coconut for just 30 seconds, then tip both into a pestle and mortar and lightly crush.
Trim the ends off the pineapple, cut off the skin, quarter it lengthways and cut away the core. Chop the flesh into 1cm slices.
Return the dry pan to a medium-high heat and cook the pineapple for 5 to 10 minutes, or until caramelized, tossing regularly, then remove to a warm plate.
Meanwhile, crush the cardamom pods, putting just the inner seeds into a blender with the flour, milk, egg, vanilla extract, cinnamon and a tiny pinch of sea salt. Blitz until smooth.
Drizzle a little oil into the empty pineapple pan, then carefully wipe it around and out with a ball of kitchen paper. Add just enough batter to lightly cover the base of the pan, cook until golden on both sides, then remove to a second plate.
Repeat the process, stacking up the pancakes as you go and covering with a tea towel to keep warm.
Either make up individual portions, or do a sharing platter for the middle of the table. Randomly tear, fold and layer up the pancakes with the caramelized pineapple, spoonfuls of yoghurt and sprinklings of crushed cashews and coconut.
Repeat until you’ve used up all the ingredients, then finely grate over the lime zest. Nice served with a drizzle of honey, if you fancy.', 'breakfast', 309, 4, 15, 25, 'https://lh5.googleusercontent.com/Ym69-2KjY5-b6EvcLbt46O3ioNLg7xIyJB64oJRL2GHsjB2CykWNXKX3o5FzHuPfYYQXEOuXkRVHmUM=w2560-h1308-rw'),
  ('Hollandaise sauce', 'Get a saucepan and a heatproof mixing bowl that will sit stably over the pan. Half-fill the pan with water and bring to a simmer. Turn down the heat as low as it can go but still have the water simmering.
Place the butter in a medium pan over a low heat, so it starts to melt but doesn’t burn. When the butter has melted, take it off the heat.
Place the egg yolks in your heatproof mixing bowl, which you should then place over the pan of just-simmering water. It’s important that the saucepan is on a low heat, or the eggs will scramble.
Using a balloon whisk, start to beat your eggs, then whisk in your white wine vinegar.
Keep whisking, and then start adding the melted butter by slowly drizzling it in, whisking all the time, till all the butter has been incorporated. The result should be a lovely, smooth, thick sauce.
Season carefully with sea salt and black pepper, and loosen if necessary with little squeezes of lemon juice. Keep tasting the sauce until the flavour is to your liking.', 'breakfast', 94, 1, 10, 10, 'https://lh5.googleusercontent.com/iCP_Rhb89yS3L10Zc0905HZ9y0muh5oUrHry2ggE8DFlAlDvrfwrL6nprKn2F2KpV-pdQGJhbzCOBHg=w2560-h1308'),
  ('DIY oaty fruity cereal', 'To make the basic cereal, roughly chop any larger dried fruit and nuts, then place into a large bowl along with the seeds, oats and cinnamon (if using).
Tip into an airtight container.
Now you have two choices. To serve your cereal as it is, place a handful of cereal (roughly 50g) per person into your serving bowls.
Add milk or natural yoghurt and chopped fresh fruit, if you like, then serve.
To make bircher muesli for 4 people, add 200g of the cereal to a large bowl.
Place a box grater on a board, then coarsely grate the apple, discarding the core. Add it to your oaty cereal.
Pour over enough milk to cover, then mix well.
Cover the bowl with clingfilm, then pop in the fridge to soak overnight.
When you’re ready to eat, give the bircher a good stir, divide between your bowls, then serve with chopped fresh fruit, if you like.','breakfast,', 189,12 , 5, 5, 'https://lh6.googleusercontent.com/I0CBAJq4bqvj4hqQxymMhbricTKi3jezrwh8e9eRbuHst7N_UQpTlhLk-4-cO4lkT8XJZ_acUjM-KT8=w2560-h1308'),
  ('Mexican refried beans', 'Peel and finely slice the garlic, deseed and finely slice the chilli and pick the coriander leaves and finely slice the stalks. Drain and finely chop the peppers.
In a large frying pan, heat a splash of oil and fry the garlic, chilli and coriander stalks for 1 to 2 minutes, or until golden.
Drain the beans, then add along with the peppers, then season to taste. Fry for 15 to 20 minutes on a low heat, stirring occasionally, until crispy.
Poach the eggs. Finely chop the reserved coriander leaves, and cut the lime into wedges.
Serve a spoonful of beans topped with a poached egg, chopped coriander leaves and a wedge of lime for squeezing over.','breakfast', 297,4 , 15, 15, 'https://lh6.googleusercontent.com/HPxjW6ha1fjyW0o45xV4weiG2kVck3ANQenhAfWZPpjNt-MP9alxUSViIrwwG-p2HSL0AMIhb7aGB-A=w2560-h1308-rw'),
  ('Quick & Crispy Home Fries', 'Arrange potato pieces evenly on a microwave-safe plate. Microwave on high until just tender, about 4 minutes. Let cool to room temperature. Cut potatoes into bite-size chunks.
Heat butter and olive oil in a non-stick skillet over medium-high heat. When butter melts and starts to turn brown, swirl the pan and add the potatoes. Shake pan to arrange in an even layer. Season with salt, pepper, paprika, garlic powder, and onion powder.
As potatoes brown, toss them and keep turning them every few minutes until they are crusty and crispy-edged and a rich reddish-brown color, 10 to 12 minutes. If potatoes seem to be cooking too quickly, reduce heat to medium. Serve topped with chopped chives.', 'breakfast', 612, 2, 10, 15, 'https://lh3.googleusercontent.com/JmwRkbrqgUMrxNA4EcfMWGjau7U6GcCztbyFnUm0oBA3HoUTod5yVZ51B6_rwevKG-8TGW5dAZ-Zzsc=w2560-h1308'),
  ('Cheesy Ham and Hash Brown Casserole', 'Preheat oven to 375 degrees F (190 degrees C). Lightly grease a 9x13 inch baking dish.
In a large bowl, mix hash browns, ham, cream of potato soup, sour cream, and Cheddar cheese. Spread evenly into prepared dish. Sprinkle with Parmesan cheese.
Bake 1 hour in the preheated oven, or until bubbly and lightly brown. Serve immediately.', 'breakfast', 415, 12, 15, 60, 'https://lh5.googleusercontent.com/Xgt24oY4LIjjfXITJ3gODxMB4zZvFwTvNf0WKTwoizjCQYDxCA_iW4-SdRN2GV_iq5yooc-uGpmhbc0=w2560-h1308'),
  ('Overnight Blueberry French Toast', 'Lightly grease a 9x13 inch baking dish. Arrange half the bread cubes in the dish, and top with cream cheese cubes. Sprinkle 1 cup blueberries over the cream cheese, and top with remaining bread cubes.
In a large bowl, mix the eggs, milk, vanilla extract, and syrup. Pour over the bread cubes. Cover, and refrigerate overnight.
Remove the bread cube mixture from the refrigerator about 30 minutes before baking. Preheat the oven to 350 degrees F (175 degrees C).
Cover, and bake 30 minutes. Uncover, and continue baking 25 to 30 minutes, until center is firm and surface is lightly browned.
In a medium saucepan, mix the sugar, cornstarch, and water. Bring to a boil. Stirring constantly, cook 3 to 4 minutes. Mix in the remaining 1 cup blueberries. Reduce heat, and simmer 10 minutes, until the blueberries burst. Stir in the butter, and pour over the baked French toast', 'breakfast', 485, 10, 15, 75, 'https://lh6.googleusercontent.com/iDC1OvBolGUaLsk1jGZ0a1VF3XUobsblyUOTCG0n4XxeFt-JU3tKstRekLkhSCWDcOpFtdNXEL5M_kY=w2560-h1308-rw'),
  ('Monkey Bread', 'Preheat oven to 350 degrees F (175 degrees C). Grease one 9 or 10 inch tube/Bundt(R) pan.
Mix white sugar and cinnamon in a plastic bag. Cut biscuits into quarters. Shake 6 to 8 biscuit pieces in the sugar cinnamon mix. Arrange pieces in the bottom of the prepared pan. Continue until all biscuits are coated and placed in pan. If using nuts and raisins, arrange them in and among the biscuit pieces as you go along.
In a small saucepan, melt the margarine with the brown sugar over medium heat. Boil for 1 minute. Pour over the biscuits.
Bake at 350 degrees F (175 degrees C) for 35 minutes. Let bread cool in pan for 10 minutes, then turn out onto a plate. Do not cut! The bread just pulls apart.', 'breakfast', 418, 15, 15,35, 'https://lh3.googleusercontent.com/tCm_57-GIsWm56o-kRJKVwLvK8xk2IcqmwVpj08fc9TNgo9bOLgpR7dABUhOw2HVYpIp8Vz12XdqcZA=w2560-h1308'),
  ('Scrambled Eggs Done Right', 'In a cup or small bowl, whisk together the eggs, mayonnaise and water using a fork. Melt margarine in a skillet over low heat. Pour in the eggs, and stir constantly as they cook. Remove the eggs to a plate when they are set, but still moist. Do not over cook. Never add salt or pepper until eggs are on plate, but these are also good without.', 'breakfast', 210, 1, 2, 3, 'https://lh3.googleusercontent.com/_1V8JEEYkf0F1yb82K-rxFBoSIai87IIGw1Uq3ZD0gcbKIs2tCeS3CLlAdgVzcGo03S90CQR1q0UyBY=w2560-h1308-rw'),
  --Lunch
  ('muesli', 'Fill with water', 'lunch', 289, 1, 2, 2, 'https://lh6.googleusercontent.com/K0OZTO6H0e-XzvfEzXGLTqsXqfKWEkvJoWB-gG0h4Qc3o_tAoGkNNQ1isKVY1YTpc5w3Z11KayHHs1Y=w2560-h1308-rw'),
  ('Southern Dill Potato Salad', 'Place the potatoes in a large pot, cover them with water, and bring to a boil over high heat. Reduce the heat to medium-low, and simmer until the potatoes are cooked through but still firm, about 20 minutes. Remove from the water, let cool, and cut the potatoes into chunks. Set the potatoes aside.
In a bowl, stir together the sour cream, mayonnaise, apple cider vinegar, Dijon mustard, onion, celery, celery salt, and salt and pepper until well mixed.
Place the potatoes and eggs in a large salad bowl, and sprinkle with dried dill. Pour the dressing over the potatoes and eggs, and mix lightly. Cover and refrigerate the salad for at least 30 minutes. Serve cold.','lunch', 279, 8, 20, 20, 'https://lh6.googleusercontent.com/s1pskldfqXdd9D8HCUVsgIY-tRgeV2TCYG3PaQ0_-7z4I4ZWA-veehtStIIr7mkB0iRTPPUupydiYFc=w2560-h1308-rw'),
  ('Reuben Sandwich', 'Spread each slice of bread with thousand island dressing. Top 4 of the bread slices with sauerkraut, cheese and pastrami. Place remaining bread slices on sandwich. Spread margarine on the outsides of each sandwich.
Heat a large skillet over medium high heat. Grill until browned, then turn and grill until heated through, and cheese is melted.', 'lunch', 793, 4, 15, 10, 'https://lh6.googleusercontent.com/-eLMj2yP5sJxQ9IJu63Fp0HgJiiB_DJaAqJmmU_svYoeZWMpgdFK6-OoHDwFJHuoth2J4rgXYnq4rx0=w2560-h1308-rw'),
  ('Philly Cheesesteak Sandwich with Garlic Mayo', 'In a small bowl, combine mayonnaise and minced garlic. Cover, and refrigerate. Preheat oven to 500 degrees F (260 degrees C).
Heat oil in a large skillet over medium heat. Saute beef until lightly browned. Stir in green pepper and onion, and season with salt and pepper. Saute until vegetables are tender, and remove from heat.
Spread each bun generously with garlic mayonnaise. Divide beef mixture into the buns. Top with shredded cheese, and sprinkle with oregano. Place sandwiches on a baking pan.
Heat sandwiches in preheated oven, until cheese is melted or slightly browned.','lunch', 935, 4, 10, 20, 'https://lh5.googleusercontent.com/wKfV1pQaBXJgb1gFX--crZNY92D12zLQZLNhKywjpnGRA35ntyCXTTuixWnDtkHB8VvBKRdCY9pYeQA=w2560-h1308-rw'),
  ('Refreshing Lentil Salad', 'Bring the water and salt to a boil in a saucepan over high heat. Pour the lentils into the water while stirring constantly. Reduce heat to low, cover, and simmer until the lentils are tender but still hold their shape, about 30 minutes. Drain well.
Transfer the lentils to a mixing bowl and stir in the garlic, seeded tomatoes, red onion, green bell pepper, and chile pepper. Add the juice of 1 lemon plus 1 teaspoon of the zest. Mix in the shredded carrot, olives, and cilantro.
Season with salt and black pepper, and drizzle with olive oil; mix well. Refrigerate for at least an hour to allow the flavors to blend.
Before serving, mix the salad again and add more lemon juice or olive oil if needed. Transfer to a serving dish and garnish with sliced eggs.', 'lunch', 431, 4, 25, 30, 'https://lh4.googleusercontent.com/4ZYmMRmsA2c0OhLhyFLrC4RQtpD9PFaPPE1WM2LkMvafCmjhCgbrLa5_AHMIRoz6ayywMXMM1di4icY=w2560-h1308'),
  ('Black Bean and Corn Quesadillas', 'Heat oil in a large saucepan over medium heat. Stir in onion, and cook until softened, about 2 minutes. Stir in beans and corn, then add sugar, salsa, and pepper flakes; mix well. Cook until heated through, about 3 minutes.
Melt 2 teaspoons of the butter in a large skillet over medium heat. Place a tortilla in the skillet, sprinkle evenly with cheese, then top with some of the bean mixture. Place another tortilla on top, cook until golden, then flip and cook on the other side. Melt more butter as needed, and repeat with remaining tortillas and filling.', 'lunch', 363, 8, 10, 30, 'https://lh3.googleusercontent.com/uwyp7uvLtNAGPD5jhiWw_Of95lf3M12rGxOlQn1t9hEWls9gsMKFSb1afm0HYcXAFatrt1kfBQ_MvRM=w2560-h1308'),

  --Dinner
  ('Crispy Fried Chicken', 'Toss together chicken pieces, black pepper, salt, paprika, rosemary, thyme, oregano, sage, white pepper, and cayenne in a large bowl to coat.
Stir in buttermilk until chicken is coated. Refrigerate for 6 hours.
Combine flour, salt, paprika, cayenne, garlic powder, white pepper, and onion powder in a large shallow dish.
Remove chicken from the buttermilk and dredge each piece in the seasoned flour. Shake off any excess and transfer to a plate.
Heat peanut oil in a large Dutch oven to 350 degrees F (175 degrees C). Add all the chicken to the pan and cook for 10 minutes.
Turn chicken pieces and cook for another 10-15 minutes.
Remove chicken from the oil and transfer to a cooling rack set over a paper towel lined baking sheet. Let sit for 10 minutes before serving.','dinner', 489, 8, 10, 10, 'https://lh5.googleusercontent.com/Hr-qeH22uukc-9Ut7bsSlPzrdF2ym6jocN7CLZ2L1jVWb68VzLfvM1RLPlrASadnfV7E0aGhfTAEMjw=w2560-h1308-rw'),
  ('Steak Diane', 'Season steaks generously on both sides with salt. Allow steaks to come to room temperature while you make the sauce.
Stir together demi-glace (see Cook''s Note), mustard, Worcestershire sauce, tomato paste, and cayenne pepper in a bowl.
Heat oil in a skillet over very high heat, swirling carefully to evenly cover surface. When oil reaches a smoking point, transfer steaks to oil; add a few chunks of butter. Sear meat on high heat until brown on each side, 2 to 3 minutes per side; keep them on the rare side. An instant-read thermometer inserted into the center should read 125 degrees F (52 degrees C). Transfer steaks to a warm plate.
Stir shallots into skillet; cook until softened, 2 to 3 minutes. Remove skillet from heat; pour in Cognac. Carefully ignite with a fireplace lighter. When alcohol burns off and flames go out, return skillet to high heat and bring to a boil; cook, stirring, a few minutes to reduce slightly. Add cream and any accumulated juices from the steak. Cook on high heat just until sauce starts to thicken, 3 to 5 minutes. Transfer steaks back to pan and reduce heat to low. Gently simmer until meat is heated through and cooked to your desired level of doneness.
Transfer to hot plates and serve with a generous spoonful or two of sauce. Sprinkle with chives.','dinner', 543, 4, 20, 20, 'https://lh5.googleusercontent.com/UKwcT8zfpT9j6wD_vQ5L7OIWRBFbhM96M8JjE-TfLUaESzvr0LyNCj6ivEBI5UCjVXA9Ib_oDdJmwOM=w2560-h1308'),
  ('Coquilles Saint-Jacques', 'Melt butter in a large skillet over medium heat; saute shallots in the hot butter until translucent, 5 to 8 minutes. Stir mushrooms, salt, and black pepper into shallots. Turn heat to medium-high and cook, stirring often, until mushrooms are golden brown, about 10 minutes.
Pour white wine over mushroom mixture, dissolving any browned bits of food on bottom of skillet into wine; bring to a simmer. Gently place scallops into wine and poach in the mushroom mixture until barely firm, about 2 minutes per side. Transfer scallops to a bowl. Strain mushroom mixture into another bowl, reserving mushrooms and cooking liquid separately. Return strained liquid to skillet, pour in any accumulated juices from scallops, and stir in cream. Bring to a boil and cook until cream sauce is reduced by about half, about 10 minutes. Stir often. Turn off heat and let mixture cool for 1 minute.
Quickly whisk egg yolk into cream sauce until combined. Transfer skillet to a work surface (such as a heatproof countertop or cutting board) and stir cayenne pepper, 2 teaspoons tarragon, and lemon zest into sauce.
Divide mushroom mixture into scallop shells, spreading mushrooms out to cover bottoms of shells; place about 3 scallops onto each portion. Spoon cream sauce over scallops to coat; let sauce drizzle down into mushrooms. Sprinkle lightly with Gruyere cheese and paprika or cayenne.
Turn oven''s broiler to high. Slightly crinkle a large sheet of aluminum foil and place onto a baking sheet. Place filled shells onto foil and press lightly to help them stay level.
Broil about 10 inches from the heat source until sauce is bubbling and cheese is lightly browned, 5 to 6 minutes. Transfer to serving plates lined with napkins to prevent shells from tipping; garnish each portion with 2 crossed tarragon leaves.','dinner', 374, 4, 20, 30, 'https://lh3.googleusercontent.com/FnVArDUQ71i0p9ZM9noUY3eTAdMMpkggoU6v3BdBk-1cnmxWW0VB1viw_2BwJA7ZtU_J3h9hmI0Qv9A=w2560-h1308-rw'),
  ('Asian Grilled Chicken', 'Place the soy sauce, brown sugar, lime juice, orange juice, sweet chili sauce, chili-garlic sauce, garlic, and curry powder in a large plastic zipper bag. Seal and knead the bag with your fingers to mix all the ingredients and dissolve the sugar. Place the chicken thighs into the marinade, squeeze out the air from the bag, zip the bag closed, and refrigerate for 4 hours or overnight.
Preheat an outdoor grill for medium-low heat; lightly oil the grate.
Remove the chicken from the bag, pour the excess marinade into a small saucepan, and bring to a full boil for about 1 minute to sterilize the marinade.
Grill the chicken thighs until they are no longer pink in the middle and show grill marks, about 25 minutes, basting them generously with the sterilized marinade as they grill.','dinner', 287, 4, 15, 25, 'https://lh3.googleusercontent.com/zCJdQZ995nB5d_GR098mQZoiTbcuM4-R7JVGeL0fURi1t1AvxJdHtRZqbIvw_jqA4lfiXJNTe9rVIco=w2560-h1308'),
  ('The Best Meatballs', 'Combine beef, veal, and pork in a large bowl. Add garlic, eggs, cheese, parsley, salt and pepper.
Blend bread crumbs into meat mixture. Slowly add the water 1/2 cup at a time. The mixture should be very moist but still hold its shape if rolled into meatballs. (I usually use about 1 1/4 cups of water). Shape into meatballs.
Heat olive oil in a large skillet. Fry meatballs in batches. When the meatball is very brown and slightly crisp remove from the heat and drain on a paper towel. (If your mixture is too wet, cover the meatballs while they are cooking so that they hold their shape better.)','dinner', 613, 8, 30, 20, 'https://lh4.googleusercontent.com/6tNv7h0BJKgXLW5LvhrrSKJkUlSDbAZcmw5bbAO6Po7qntmOZrvbgTZxaURzOsNe4c9ZkkiOspPRNAc=w2560-h1308-rw'),
  ('Focaccia Bread', 'In a large bowl, stir together the flour, salt, sugar, yeast, garlic powder, oregano, thyme, basil and black pepper. Mix in the vegetable oil and water.
When the dough has pulled together, turn it out onto a lightly floured surface, and knead until smooth and elastic. Lightly oil a large bowl, place the dough in the bowl, and turn to coat with oil. Cover with a damp cloth, and let rise in a warm place for 20 minutes.
Preheat oven to 450 degrees F (230 degrees C). Punch dough down; place on greased baking sheet. Pat into a 1/2 inch thick rectangle. Brush top with olive oil. Sprinkle with Parmesan cheese and mozzarella cheese.
Bake in preheated oven for 15 minutes, or until golden brown. Serve warm.','dinner', 171, 12, 20, 15, 'https://lh3.googleusercontent.com/BM3LEas2FpcnV4VT1idcKpz5_kLowlwJVwmH7Gp7akEeX4kJexSsrKLGa75T9YD2SokJSaFMMJhfIu4=w2560-h1308'),
  ('Chinese Chicken Fried Rice', 'Heat oil in a large skillet over medium heat. Add onion and saute until soft, then add chicken and 2 tablespoons soy sauce and stir-fry for 5 to 6 minutes.
Stir in carrots, celery, red bell pepper, pea pods and green bell pepper and stir-fry another 5 minutes. Then add rice and stir thoroughly.
Finally, stir in scrambled eggs and 1/3 cup soy sauce, heat through and serve hot.','dinner', 425, 7, 25, 15, 'https://lh6.googleusercontent.com/5bhtgOd23ZDv_es1I5spse0SWtLkczFgip_T52UWiXRzC-G_GxsYC3tBzo1MeAC-r8N8DrshBxnjuTo=w2560-h1308'),
  ('Argentine Meat Empanadas', 'In a saute; pan melt the shortening and add the chopped onions. Cook the onions until just before they begin to turn golden. Remove from the heat and stir in the sweet paprika, hot paprika, crushed red pepper flakes and salt to taste.
Spread the meat on a sieve and pour boiling water on it for partial cooking. Allow meat to cool. Place meat in a dish add salt to taste, cumin and vinegar. Mix and add the meat to the onion mixture. Mix well and place on a flat to dish to cool and harden.
Cut puff pastry dough into 10 round shells. Place a spoonful of the meat mixture on each round; add some of the raisins, olives and hard boiled egg. Avoid reaching the edges of the pastry with the filling because its oiliness will prevent good sealing. Slightly wet the edge of the pastry, fold in two and stick edges together. The shape should resemble that of a half-moon. You should have a 2/3 to 1/2 inch flat edge of pastry to work with. Seal by twisting edge, step by step, between thumb and index finger, making sure to add pressure before releasing the pinch and moving on to the next curl. Other sealing procedures like pinching without curling or using a fork to seal will not prevent juice leaks during baking, and empanadas must be juicy.
Preheat oven to 350 degrees F (180 degrees C). Place empanadas on a parchment paper lined baking sheet. Be sure to prick each empanada with a fork near the curl to allow steam to escape during baking. Glaze with egg for shine and bake until golden, about 20 to 30 minutes.','dinner', 498, 10, 20, 30, 'https://lh6.googleusercontent.com/bWuhk4Oh-s8wVAcqI1c7UNcgz-GJ8IFqXjrI0O6mo2KDmhKARBElogiKCdDXDceARPO5D9Xc5i6BiFE=w2560-h1308-rw'),
  ('Sesame Beef', 'Mix soy sauce, sugar, oil, garlic, and onions in a large bowl. Set aside.
Cut steak into strips and add to bowl. Cover and refrigerate overnight, or at least 30 minutes.
Cook in wok or frying pan until brown, about 5 minutes. Add sesame seeds and cook for additional 2 minutes.','dinner', 354, 4, 5, 10, 'https://lh4.googleusercontent.com/3A6waWy58wfcBC-ENaoRxP-ZPYP3HtjYDZ6npoOipaQveulsUHNndezZeamcfZILjkbEPy1d8wHYoL0=w2560-h1308-rw'),
  ('Roasted Balsamic Chicken with Baby Tomatoes', 'Mix balsamic vinegar, olive oil, mustard, and garlic together in an oven-safe baking dish; season with salt and pepper. Lie the chicken breasts in the vinegar mixture.
Marinate chicken in the refrigerator for at least 4 hours.
Preheat oven to 400 degrees F (200 degrees C).
Roast chicken in the preheated oven for about 30 minutes. Add tomatoes to the baking dish and continue cooking until the chicken is no longer pink in the center and the juices run clear, about 10 minutes more. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C).
Sprinkle lemon zest and drizzle lemon juice over the chicken.','dinner', 321, 4, 10, 40, 'https://lh4.googleusercontent.com/qze8WhIkaufnzPzX8RtclDNBm0bp8ZDvM8ti1IM6nOq5qn08MQRZmrhIwDbg_Mb03BgNAD6BNrM_aus=w2560-h1308-rw'),
  ('Mongolian Beef from the Slow Cooker', 'Spread cornstarch into a wide, shallow bowl. Dredge flank steak in the cornstarch to coat completely; put into a large resealable plastic bag.
Stir water, soy sauce, brown sugar, carrots, green onions, olive oil, garlic, and ginger together in a bowl; pour into the bag with the beef and seal.
Put bag of marinating beef in the freezer until the day before you wish to prepare it.
Remove bag from freezer and put bag into a bowl and place in refrigerator to thaw, at least 24 hours before you wish to prepare the beef.
Empty bag into the crock of a slow cooker.
Cook on High until the beef is tender, 2 to 3 hours. Alternately, you can cook this on Low for 4 to 5 hours.','dinner', 320, 6, 5, 120, 'https://lh4.googleusercontent.com/73NOpmTOIVMomfPsTsHHSIrzBEknbde53x5RcYs369qzVy-8Dtg9Ky9AKTKbQxzb8spETfjv8zSBDh8=w2560-h1308-rw');



INSERT INTO drinks (name, calories) VALUES
  ('Milk coffee', 54),
  ('Tea with sugar',40),
  ('Glass of milk', 146),
  ('Glass of orange juice', 112),
  ('Glass of apple juice', 117);

INSERT INTO snacks (name, calories) VALUES
  ('Apple', 95),
  ('Banana', 105),
  ('Orange', 62),
  ('Oreo cookie', 105),
  ('Cracker',81),
  ('Dark chocolate', 524);

INSERT INTO recipe_drinks (recipe_id, drink_id) VALUES
  (100014, 100044),
  (100015, 100044),
  (100016, 100044),
  (100017, 100044),
  (100018, 100044),
  (100019, 100044),
  (100020, 100044),
  (100021, 100044),
  (100022, 100044),
  (100023, 100044),
  (100024, 100044),
  (100025, 100044),
  (100026, 100044),
  (100027, 100044),
  (100028, 100044),
  (100029, 100044),
  (100030, 100044),
  (100031, 100044),
  (100032, 100044),
  (100033, 100044),
  (100034, 100044),
  (100035, 100044),
  (100036, 100044),
  (100037, 100044),
  (100038, 100044),
  (100039, 100044),
  (100040, 100044),
  (100041, 100044),
  (100042, 100044),
  (100043, 100044),
  (100014, 100045),
  (100015, 100045),
  (100016, 100045),
  (100017, 100045),
  (100018, 100045),
  (100019, 100045),
  (100020, 100045),
  (100021, 100045),
  (100022, 100045),
  (100023, 100045),
  (100024, 100045),
  (100025, 100045),
  (100026, 100045),
  (100027, 100045),
  (100028, 100045),
  (100029, 100045),
  (100030, 100045),
  (100031, 100045),
  (100032, 100045),
  (100033, 100045),
  (100034, 100045),
  (100035, 100045),
  (100036, 100045),
  (100037, 100045),
  (100038, 100045),
  (100039, 100045),
  (100040, 100045),
  (100041, 100045),
  (100042, 100045),
  (100043, 100045),
  (100014, 100046),
  (100015, 100046),
  (100016, 100046),
  (100017, 100046),
  (100018, 100046),
  (100019, 100046),
  (100020, 100046),
  (100021, 100046),
  (100022, 100046),
  (100023, 100046),
  (100024, 100046),
  (100025, 100046),
  (100026, 100046),
  (100027, 100046),
  (100028, 100046),
  (100029, 100046),
  (100030, 100046),
  (100031, 100046),
  (100032, 100046),
  (100033, 100046),
  (100034, 100046),
  (100035, 100046),
  (100036, 100046),
  (100037, 100046),
  (100038, 100046),
  (100039, 100046),
  (100040, 100046),
  (100041, 100046),
  (100042, 100046),
  (100043, 100046),
  (100014, 100047),
  (100015, 100047),
  (100016, 100047),
  (100017, 100047),
  (100018, 100047),
  (100019, 100047),
  (100020, 100047),
  (100021, 100047),
  (100022, 100047),
  (100023, 100047),
  (100024, 100047),
  (100025, 100047),
  (100026, 100047),
  (100027, 100047),
  (100028, 100047),
  (100029, 100047),
  (100030, 100047),
  (100031, 100047),
  (100032, 100047),
  (100033, 100047),
  (100034, 100047),
  (100035, 100047),
  (100036, 100047),
  (100037, 100047),
  (100038, 100047),
  (100039, 100047),
  (100040, 100047),
  (100041, 100047),
  (100042, 100047),
  (100043, 100047),
  (100014, 100048),
  (100015, 100048),
  (100016, 100048),
  (100017, 100048),
  (100018, 100048),
  (100019, 100048),
  (100020, 100048),
  (100021, 100048),
  (100022, 100048),
  (100023, 100048),
  (100024, 100048),
  (100025, 100048),
  (100026, 100048),
  (100027, 100048),
  (100028, 100048),
  (100029, 100048),
  (100030, 100048),
  (100031, 100048),
  (100032, 100048),
  (100033, 100048),
  (100034, 100048),
  (100035, 100048),
  (100036, 100048),
  (100037, 100048),
  (100038, 100048),
  (100039, 100048),
  (100040, 100048),
  (100041, 100048),
  (100042, 100048),
  (100043, 100048);

INSERT INTO recipe_ingredients (recipe_id, ingredient_id, ingredient_quantity) VALUES
  (100031, 100009, 3);

