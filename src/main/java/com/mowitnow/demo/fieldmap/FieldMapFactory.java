package com.mowitnow.demo.fieldmap;

import com.mowitnow.demo.fieldmap.exception.FieldMapException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldMapFactory {
  private static final Pattern rectangularMapPattern = Pattern.compile("(\\d+) (\\d+)");
  public static FieldMap create(String format){
    Matcher rectangularMatcher = rectangularMapPattern.matcher(format);
    if (rectangularMatcher.matches()) {
      int x = Integer.parseInt(rectangularMatcher.group(1));
      int y = Integer.parseInt(rectangularMatcher.group(2));
      return new RectangularFieldMap(x, y);
    }
    else {
      throw new FieldMapException("Le format de la map n'est pas connu.");
    }
  }

}
