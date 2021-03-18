// Fig. 22.15: ThreeDimensionalShapesController.java
// Setting the material displayed on 3D shapes.
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Point3D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.image.Image;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

import java.security.SecureRandom;

public class ThreeDimensionalShapesController {
   // instance variables that refer to 3D shapes
   @FXML private Box box;       
   @FXML private Cylinder cylinder;       
   @FXML private Sphere sphere;
   @FXML private Pane pane;
   private int counter = 0;

   // set the material for each 3D shape
   public void initialize() {
      SecureRandom random = new SecureRandom();

      Timeline timelineAnimation = new Timeline(
              new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent actionEvent) {
                    int randShape = random.nextInt(3);
                    //int randShape = 0;
                    double randWidth = random.nextDouble() * 100;
                    double randHeight = random.nextDouble() * 100;
                    double randDepth = random.nextDouble() * 100;

                    Bounds bounds = pane.getBoundsInLocal();

                    double randX = randWidth + random.nextInt((int) bounds.getWidth()/2);
                    double randY = randHeight + random.nextInt((int)(bounds.getHeight() / 2));
                    double randZ = randDepth + random.nextInt((int) (400 - randDepth));

                    double randRotate = random.nextDouble() * 360;

                    PhongMaterial phongMaterial = new PhongMaterial();
                    phongMaterial.setDiffuseColor(
                            new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(),1));
                    switch (randShape){
                       case 0:
                          MyBox myBox = new MyBox(randWidth,randHeight,randDepth);
                          myBox.setTranslateX(randX);
                          myBox.setTranslateY(randY);
                          myBox.setTranslateZ(randZ);
                          myBox.setRotationAxis(new Point3D(1,1,1));
                          myBox.setRotate(randRotate);
                          myBox.setMaterial(phongMaterial);
                          pane.getChildren().add(myBox);
                          myBox.animate(pane);
                          break;
                       case 1:
                          MyCylinder cylinder = new MyCylinder(randWidth, randHeight);
                          cylinder.setTranslateX(randX);
                          cylinder.setTranslateY(randY);
                          cylinder.setTranslateZ(randZ);
                          cylinder.setRotationAxis(new Point3D(1,1,1));
                          cylinder.setRotate(randRotate);
                          cylinder.setMaterial(phongMaterial);
                          pane.getChildren().add(cylinder);
                          cylinder.animate(pane);
                          break;
                       case 2:
                          MySphere sphere = new MySphere(randWidth);
                          sphere.setTranslateX(randX);
                          sphere.setTranslateY(randY);
                          sphere.setTranslateZ(randZ);
                          sphere.setRotationAxis(new Point3D(1,1,1));
                          sphere.setRotate(randRotate);
                          sphere.setMaterial(phongMaterial);
                          pane.getChildren().add(sphere);
                          sphere.animate(pane);
                          break;
                    }
                 }
              })
      );

      timelineAnimation.setCycleCount(25);
      timelineAnimation.play();
   }
}
