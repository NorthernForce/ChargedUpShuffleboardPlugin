package frc.nfr.simplewidget.widget;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;

import frc.nfr.simplewidget.data.Point2D;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.effect.Light.Point;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

@Description(
    name = "Simple Point",
    dataTypes = Point2D.class,
    summary = "Displays the X and Y coordinates of a point"
)
@ParametrizedController("SimplePointWidget.fxml")
public final class PieceDisplayWidget extends SimpleAnnotatedWidget<Point2D> {

  @FXML
  private Pane root;
  @FXML
  private Canvas canvas;
  private GraphicsContext gc;

  @FXML
  private void drawCanvas(ActionEvent event) {
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    gc.setFill(Color.GREEN);
    double dataCoordX = dataOrDefault.get().getX();
    double dataCoordY = dataOrDefault.get().getY();
    double gridX = canvas.getWidth() / 9;
    double gridY = canvas.getHeight() / 3;
    gc.fillRect(dataCoordX * gridX, dataCoordY * gridY, gridX, gridY);
  }

  @FXML
  private void initialize() {
    gc = canvas.getGraphicsContext2D();
  }

  @Override
  public Pane getView() {
    return root;
  }
}
