package shapeStorage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter; // Used for concisely clearing the file
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersistentShapeManager {
	public static void saveShapesToFile(Collection<? extends Shape> shapes, String filename) {
		if (shapes == null) {
			System.err.println("Error saving: The collection of shapes is null. Filename: " + filename);
			return;
		}
		if (filename == null || filename.trim().isEmpty()) {
			System.err.println("Error saving: Filename is null or empty.");
			return;
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
			for (Shape shape : shapes) {
				if (shape != null) {
					String shapeString = shape.toString();
					writer.write(shapeString);
					writer.newLine();
				} else {
					System.err.println("Skipping a null shape during save operation to file: " + filename);
				}
			}
		} catch (IOException e) {
			System.err.println("Error saving shapes to file '" + filename + "': " + e.getMessage());
		}
	}

	public static List<Shape> loadShapesFromFile(String filename) {
		List<Shape> loadedShapes = new ArrayList<>();
		if (filename == null || filename.trim().isEmpty()) {
			System.err.println("Error loading: Filename is null or empty.");
			return loadedShapes;
		}
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			int lineNumber = 0;
			while ((line = reader.readLine()) != null) {
				lineNumber++;
				if (line.trim().isEmpty()) {
					continue;
				}
				try {
					Shape shape = ShapeFactory.fromString(line);
					loadedShapes.add(shape);

				} catch (IllegalArgumentException e) {
					System.err.println("Skipping malformed line" + lineNumber + " in file " + filename + "': \"" + line
							+ "\" -Error: " + e.getMessage());
				}
			}
		} catch (IOException e) {
			System.err.println("Error loading shapes from file '" + filename + "':" + e.getMessage());
		}
		return loadedShapes;
	}

	public static void clearFile(String filename) {
		if (filename == null || filename.trim().isEmpty()) {
			System.err.println("Error clearing file: Filename is null or empty.");
			return;
		}
		try (PrintWriter writer = new PrintWriter(filename)) {

		} catch (IOException e) {
			System.err.println("Error clearing file '" + filename + "': " + e.getMessage());
		}
	}
}
