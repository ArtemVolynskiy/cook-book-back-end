package rationbuilder;


import model.Recipe;
import model.Snack;

import java.util.List;

public interface RationBuilderStrategy {
    List<List> buildRation(int calories, List<Recipe> recipes, List<Snack> snacks);
}