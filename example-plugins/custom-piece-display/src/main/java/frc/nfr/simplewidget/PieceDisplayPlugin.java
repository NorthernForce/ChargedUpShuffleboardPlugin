package frc.nfr.simplewidget;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

import frc.nfr.simplewidget.data.type.PointType;
import frc.nfr.simplewidget.widget.PieceDisplayWidget;

import java.util.List;
import java.util.Map;

/**
 * An example plugin that provides a custom data type (a 2D point) and a simple widget for viewing such data.
 */
@Description(
    group = "frc.nfr",
    name = "PieceDisplayPlugin",
    version = "2023.1.1",
    summary = "An example plugin that provides a simple data type and a widget for viewing it"
)
public final class PieceDisplayPlugin extends Plugin {
  @Override
  public List<DataType> getDataTypes() {
    return List.of(
        PointType.Instance
    );
  }

  @Override
  public List<ComponentType> getComponents() {
    return List.of(
        WidgetType.forAnnotatedWidget(PieceDisplayWidget.class)
    );
  }

  @Override
  public Map<DataType, ComponentType> getDefaultComponents() {
    return Map.of(
        PointType.Instance, WidgetType.forAnnotatedWidget(PieceDisplayWidget.class)
    );
  }
}
