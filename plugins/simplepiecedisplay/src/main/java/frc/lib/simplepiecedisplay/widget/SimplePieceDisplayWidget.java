package frc.lib.simplepiecedisplay.widget;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import frc.lib.simplepiecedisplay.data.PieceLocation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

@Description(
    name = "Simple Piece Location",
    dataTypes = PieceLocation.class,
    summary = "Displays the X and Y coordinates of a piece"
)
@ParametrizedController("SimplePieceDisplayWidget.fxml")
public final class SimplePieceDisplayWidget extends SimpleAnnotatedWidget<PieceLocation> {

  @FXML
  private Pane root;
  @FXML
  private Canvas canvas;

  @FXML
  private void drawCanvas(ActionEvent event) {
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    gc.setFill(Color.GREEN);
    double gridW = canvas.getWidth() / 9;
    double gridH = canvas.getHeight() / 3;
    gc.fillRect(getData().getX() * gridW, getData().getY() * gridH, gridW, gridH);
  }  

  private GraphicsContext gc = null;

  @FXML
  private void initialize() {
    // Bind the text in the labels to the data
    // If you are unfamiliar with the -> notation used here, read the Oracle tutorial on lambda expressions:
    // https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
    System.out.printn("Initializing!");
    gc = canvas.getGraphicsContext2D();
    gc.setFill(Color.BLACK);
    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
  }

  @Override
  public Pane getView() {
    return root;
  }
}
