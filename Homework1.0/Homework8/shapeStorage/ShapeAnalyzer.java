package shapeStorage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShapeAnalyzer {
	public static List<Shape> filterByMinArea(Collection<? extends Shape> shapes, double minArea){
		List<Shape> filteredShapes = new ArrayList<>();
		if(shapes == null) {
			return filteredShapes;
		}
		for(Shape shape : shapes) {
			if(shape != null && shape.getArea() >= minArea) {
				filteredShapes.add(shape);
			}
		}
		return filteredShapes; 
	}
	public static Shape findShapeWithMaxArea(Collection<? extends Shape> shapes) {
		if(shapes == null || shapes.isEmpty()) {
			return null;
		}
		Shape maxAreaShape = null; 
		double maxArea = -1.0;
		for(Shape shape : shapes) {
			if(shape != null) {
				if(maxAreaShape == null || shape.getArea() > maxArea) {
					maxArea = shape.getArea();
					maxAreaShape = shape; 
				}
			}
		}
		return maxAreaShape; 
	}
	public static <T extends Shape> Map<String, List<T>> groupByType(Collection<T> shapes){
		Map<String, List<T>> groupedShapes = new HashMap<>();
		if(shapes == null) {
			return groupedShapes;
		}
		for(T shape : shapes) {
			if(shape != null) {
				String typeName = shape.getClass().getSimpleName();
				groupedShapes.computeIfAbsent(typeName, k -> new ArrayList<>()).add(shape);
			}
		}
		return groupedShapes;
	}
	
	

}
