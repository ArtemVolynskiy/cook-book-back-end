ALTER TABLE IF EXISTS public.user_roles DROP CONSTRAINT IF EXISTS user_roles_user_id_fkey;
ALTER TABLE IF EXISTS public.user_recipe DROP CONSTRAINT IF EXISTS user_recipe_user_id_fkey;
ALTER TABLE IF EXISTS public.user_recipe DROP CONSTRAINT IF EXISTS user_recipe_recipe_id_fkey;
ALTER TABLE IF EXISTS public.recipe_ingredients DROP CONSTRAINT IF EXISTS recipe_ingredients_ingredient_id_fkey;
ALTER TABLE IF EXISTS public.recipe_ingredients DROP CONSTRAINT IF EXISTS recipe_ingredients_recipe_id_fkey;
DROP TABLE IF EXISTS public.user_roles;
DROP TABLE IF EXISTS public.user_recipe;
DROP TABLE IF EXISTS public.recipe_ingredients;
DROP TABLE IF EXISTS public.users;
DROP TABLE IF EXISTS public.recipe;
DROP TABLE IF EXISTS public.ingredients;
--
DROP SEQUENCE IF EXISTS public.global_seq RESTRICT;

CREATE SEQUENCE global_seq START 100000;


CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  secondname VARCHAR,
  nickname   VARCHAR UNIQUE,
  email      VARCHAR NOT NULL UNIQUE,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  calories   INTEGER,
  enabled    BOOL DEFAULT TRUE
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  user_role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, user_role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);


CREATE TABLE ingredients
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  price      INTEGER NOT NULL,
  quantity   INTEGER,
  available  BOOL DEFAULT TRUE
);

CREATE TABLE recipe
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR NOT NULL,
  type        VARCHAR NOT NULL,
  image       VARCHAR,
  recipe      VARCHAR NOT NULL,
  calories    INTEGER NOT NULL,
  cookingtime INTEGER NOT NULL
);

CREATE TABLE recipe_ingredients
(
  ingredient_id       INTEGER NOT NULL,
  recipe_id           INTEGER NOT NULL,
  ingredient_quantity VARCHAR NOT NULL,
  FOREIGN KEY (ingredient_id) REFERENCES ingredients (id),
  FOREIGN KEY  (recipe_id) REFERENCES recipe (id)
);

CREATE TABLE user_recipe
(
  user_id       INTEGER NOT NULL,
  recipe_id     INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (recipe_id) REFERENCES recipe(id)
);

-- CREATE UNIQUE INDEX users_unique_email_idx ON users (email);
-- CREATE UNIQUE INDEX meals_unique_user_datetime_idx ON meals(user_id, date_time)