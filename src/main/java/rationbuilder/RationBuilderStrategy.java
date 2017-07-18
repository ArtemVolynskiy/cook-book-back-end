package rationbuilder;


import model.Recipe;
import model.Snack;

import java.util.List;

public interface RationBuilderStrategy {
    List<Recipe> buildRation(int calories, List<Recipe> recipes, List<Snack> snacks);
}