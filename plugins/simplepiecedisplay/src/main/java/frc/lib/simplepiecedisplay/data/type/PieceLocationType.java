package frc.lib.simplepiecedisplay.data.type;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;
import edu.wpi.first.shuffleboard.api.util.Maps;

import frc.lib.simplepiecedisplay.data.PieceLocation;

import java.util.Map;
import java.util.function.Function;

/**
 * Represents data of the {@link PieceLocation} type.
 */
public final class PieceLocationType extends ComplexDataType<PieceLocation> {

  /**
   * The name of data of this type as it would appear in a WPILib sendable's {@code .type} entry; a differential drive
   * base a {@code .type} of "DifferentialDrive", a sendable chooser has it set to "String Chooser"; a hypothetical
   * 2D point would have it set to "Point2D".
   */
  private static final String TYPE_NAME = "PieceLocation";

  /**
   * The single instance of the point type. By convention, this is a {@code public static final}
   * field and the constructor is private to ensure only a single instance of the data type exists.
   */
  public static final PieceLocationType Instance = new PieceLocationType();

  private PieceLocationType() {
    super(TYPE_NAME, PieceLocation.class);
  }

  @Override
  public Function<Map<String, Object>, PieceLocation> fromMap() {
    return map -> new PieceLocation(
        Maps.getOrDefault(map, "x", 0.0),
        Maps.getOrDefault(map, "y", 0.0)
    );
  }

  @Override
  public PieceLocation getDefaultValue() {
    return new PieceLocation(0, 0);
  }
}
