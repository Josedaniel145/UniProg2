package preazenzuebung2;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.List;
import java.util.function.Consumer;

public class Main2 {
	public static void main(String[] args) {
		Consumer<List<Food>> clean = (list) -> list.removeIf(food -> food.isFoul());

		BiConsumer<Food, List<Food>> addFood = (food, list) -> {
			if (!food.isFoul()) {
				list.add(food);
			}
		};
		Consumer<List<Food>> display = (list) -> list.stream().forEach(food -> System.out.println(food.getType()));

		ArrayList<Food> pantry = new ArrayList<>();
		addFood.accept(new Food("Apple", false), pantry);
		addFood.accept(new Food("Banana", true), pantry);
		addFood.accept(new Food("Bread", false), pantry);
		addFood.accept(new Food("Potatoes", true), pantry);
		
		System.out.println("Pantry before cleaning:");
		display.accept(pantry);
		clean.accept(pantry);
		System.out.println("\nPantry after cleaning: ");
		display.accept(pantry);

	}
}
