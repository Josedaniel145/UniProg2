package shapeStorage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ShapeFactory {
	private static final Pattern CIRCLE_PATTERN = Pattern.compile("^Circle: radius=([0-9]+\\.?[0-9]*)$");
	private static final Pattern RECTANGLE_PATTERN = Pattern.compile("^Rectangle: width=([0-9]+\\.?[0-9]*), length=([0-9]+\\.?[0-9]*)$");
	// 1. Define Regular Expression Patterns for each shape type
    //    - `^` and `$` ensure the entire string matches, not just a part of it.
    //    - `(...)` creates a "capturing group" for the parts we want to extract (the numbers).
    //    - `[0-9]+\\.?[0-9]*` matches a number:
    //        - `[0-9]+` : one or more digits
    //        - `\\.?`   : an optional decimal point (escaped because '.' is special in regex)
    //        - `[0-9]*` : zero or more digits after the decimal point
	public static Shape fromString(String input) throws IllegalArgumentException {
			if(input == null || input.trim().isEmpty()) {
				throw new IllegalArgumentException("Input string cannot be null or empty.");
			}
			String trimmedInput = input.trim(); 
			Matcher circleMatcher = CIRCLE_PATTERN.matcher(trimmedInput);
			if(circleMatcher.matches()) {
				try {
					String radiusStr = circleMatcher.group(1); // group(1) is the first capturing group (...)
					double radius = Double.parseDouble(radiusStr);
					return new Circle(radius);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("Invalid radius format in Circle string: \"" + trimmedInput + "\". Radius part: \"" + circleMatcher.group(1) + "\"", e);
				}catch(IllegalArgumentException e) {
					throw new IllegalArgumentException("Invalid radius value for Cricle \"" + trimmedInput + "\"." + e.getLocalizedMessage(), e);
				}
				
			}
			Matcher rectangleMatcher = RECTANGLE_PATTERN.matcher(trimmedInput);
			if(rectangleMatcher.matches()) {
				try {
					String widthStr = rectangleMatcher.group(1);
					String lengthStr = rectangleMatcher.group(2);
					double width = Double.parseDouble(widthStr);
					double length = Double.parseDouble(lengthStr);
					return new Rectangle(width, length);
				} catch (NumberFormatException e){
					throw new IllegalArgumentException("Invalid width/length format in Rectangle string: \"" + trimmedInput + "\". Width part: \"" + rectangleMatcher.group(1) + "\", Length part: \"" + rectangleMatcher.group(2) + "\"", e);
				} catch(IllegalArgumentException e) {
					throw new IllegalArgumentException("Invalid dimensions for Rectangle: \"" + trimmedInput  + "\"." + e.getMessage(), e);
				}
			}
			throw new IllegalArgumentException("Unknown or malformed shape string: \"" + trimmedInput + "\"");	
		}
		
	}
