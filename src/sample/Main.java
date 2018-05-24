package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private static stickmanSetup stickman = new stickmanSetup();
    boolean jointsConnected = true;
    Stage window;
    public Group root;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    double x = 200, y = 200;
    int frame = 0;

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        stickman.namesToNumbers();
        stickman.createStickmanPoints();
        window = primaryStage;
        window.setTitle("Stickman Animation");
        root = new Group(createStickman());
        root.prefHeight(305);
        root.prefWidth(720);
        Scene scene = new Scene(root, 720, 405);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    EventHandler<ActionEvent> toggleJoints =
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    if (jointsConnected) {
                        jointsConnected = false;
                        System.out.println(jointsConnected);
                    } else {
                        jointsConnected = true;
                        System.out.println(jointsConnected);
                    }

                }
            };

    public Circle createCircle(String name, double x, double y) {
        Circle circle = new Circle(x, y, 10);
        circle.setCursor(Cursor.HAND);
        if (jointsConnected == false) {
            circle.setOnMousePressed(circleOnMousePressedEventHandler);
            circle.setOnMouseDragged(circleOnMouseDraggedEventHandler);
        }
        return circle;
    }

    public Circle createHead(String name, double x, double y) {
        Circle circle = new Circle(x, y, 10);
        circle.setCursor(Cursor.HAND);
        if (jointsConnected == false) {
            circle.setOnMousePressed(circleOnMousePressedEventHandler);
            circle.setOnMouseDragged(headOnMouseDraggedEventHandler);
        }
        return circle;
    }

    public Circle createChest(String name, double x, double y) {
        Circle circle = new Circle(x, y, 10);
        circle.setCursor(Cursor.HAND);
        if (jointsConnected == false) {
            circle.setOnMousePressed(circleOnMousePressedEventHandler);
            circle.setOnMouseDragged(chestOnMouseDraggedEventHandler);
        }
        return circle;
    }

    public Circle createLeftFoot(String name, double x, double y) {
        Circle circle = new Circle(x, y, 10);
        circle.setCursor(Cursor.HAND);
        if (jointsConnected == false) {
            circle.setOnMousePressed(circleOnMousePressedEventHandler);
            circle.setOnMouseDragged(leftFootOnMouseDraggedEventHandler);
        }
        return circle;
    }

    public Circle createRightFoot(String name, double x, double y) {
        Circle circle = new Circle(x, y, 10);
        circle.setCursor(Cursor.HAND);
        if (jointsConnected == false) {
            circle.setOnMousePressed(circleOnMousePressedEventHandler);
            circle.setOnMouseDragged(rightFootOnMouseDraggedEventHandler);
        }
        return circle;
    }

    public Circle createPost(String name, double x, double y) {
        Circle circle = new Circle(x, y, 10);
        circle.setCursor(Cursor.HAND);
        if (jointsConnected == false) {
            circle.setOnMousePressed(circleOnMousePressedEventHandler);
            circle.setOnMouseDragged(postOnMouseDraggedEventHandler);
        }
        return circle;
    }

    public Circle createLeftHand(String name, double x, double y) {
        Circle circle = new Circle(x, y, 10);
        circle.setCursor(Cursor.HAND);
        if (jointsConnected == false) {
            circle.setOnMousePressed(circleOnMousePressedEventHandler);
            circle.setOnMouseDragged(leftHandOnMouseDraggedEventHandler);
        }
        return circle;
    }

    public Circle createRightHand(String name, double x, double y) {
        Circle circle = new Circle(x, y, 10);
        circle.setCursor(Cursor.HAND);
        if (jointsConnected == false) {
            circle.setOnMousePressed(circleOnMousePressedEventHandler);
            circle.setOnMouseDragged(rightHandOnMouseDraggedEventHandler);
        }
        return circle;
    }

    public Line createLine(String name, double x1, double y1, double x2, double y2) {
        Line line = new Line(x1, y1, x2, y2);
        return line;
    }


    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    orgSceneX = e.getSceneX();
                    orgSceneY = e.getSceneY();
                    orgTranslateX = ((Circle) (e.getSource())).getTranslateX();
                    orgTranslateY = ((Circle) (e.getSource())).getTranslateY();
                    System.out.println(stickman.figure.get("head").getX());
                }
            };


    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    double offsetX = e.getSceneX() - orgSceneX;
                    double offsetY = e.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    double newX = stickman.figure.get("head").getX() + newTranslateX;
                    double newY = stickman.figure.get("head").getY() + newTranslateY;
                    stickman.figure.put("head", new Points(newX, newY));
//                    System.out.println("xtranlate" + newTranslateX);
//                    System.out.println(stickman.figure.get("head").getX()+ newTranslateX);
                    ((Circle) (e.getSource())).setTranslateX(newTranslateX);
                    ((Circle) (e.getSource())).setTranslateY(newTranslateY);
                }
            };

    EventHandler<MouseEvent> headOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    double offsetX = e.getSceneX() - orgSceneX;
                    double offsetY = e.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    double newX = stickman.figure.get("head").getX() + newTranslateX;
                    double newY = stickman.figure.get("head").getY() + newTranslateY;
                    stickman.figure.put("head", new Points(newX, newY));
//                    System.out.println("xtranlate" + newTranslateX);
//                    System.out.println(stickman.figure.get("head").getX()+ newTranslateX);
                    ((Circle) (e.getSource())).setTranslateX(newTranslateX);
                    ((Circle) (e.getSource())).setTranslateY(newTranslateY);
                    refresh();
                }
            };

    EventHandler<MouseEvent> chestOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    double offsetX = e.getSceneX() - orgSceneX;
                    double offsetY = e.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    double newX = stickman.figure.get("chest").getX() + newTranslateX;
                    double newY = stickman.figure.get("chest").getY() + newTranslateY;
                    stickman.figure.put("chest", new Points(newX, newY));
//                    System.out.println("xtranlate" + newTranslateX);
//                    System.out.println(stickman.figure.get("head").getX()+ newTranslateX);
                    ((Circle) (e.getSource())).setTranslateX(newTranslateX);
                    ((Circle) (e.getSource())).setTranslateY(newTranslateY);
                    refresh();
                }
            };

    EventHandler<MouseEvent> leftHandOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    double offsetX = e.getSceneX() - orgSceneX;
                    double offsetY = e.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    double newX = stickman.figure.get("leftHand").getX() + newTranslateX;
                    double newY = stickman.figure.get("leftHand").getY() + newTranslateY;
                    stickman.figure.put("leftHand", new Points(newX, newY));
//                    System.out.println("xtranlate" + newTranslateX);
//                    System.out.println(stickman.figure.get("head").getX()+ newTranslateX);
                    ((Circle) (e.getSource())).setTranslateX(newTranslateX);
                    ((Circle) (e.getSource())).setTranslateY(newTranslateY);
                    refresh();
                }
            };

    EventHandler<MouseEvent> postOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    double offsetX = e.getSceneX() - orgSceneX;
                    double offsetY = e.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    double newX = stickman.figure.get("post").getX() + newTranslateX;
                    double newY = stickman.figure.get("post").getY() + newTranslateY;
                    stickman.figure.put("post", new Points(newX, newY));
//                    System.out.println("xtranlate" + newTranslateX);
//                    System.out.println(stickman.figure.get("head").getX()+ newTranslateX);
                    ((Circle) (e.getSource())).setTranslateX(newTranslateX);
                    ((Circle) (e.getSource())).setTranslateY(newTranslateY);
                    refresh();
                }
            };

    EventHandler<MouseEvent> rightFootOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    double offsetX = e.getSceneX() - orgSceneX;
                    double offsetY = e.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    double newX = stickman.figure.get("rightFoot").getX() + newTranslateX;
                    double newY = stickman.figure.get("rightFoot").getY() + newTranslateY;
                    stickman.figure.put("rightFoot", new Points(newX, newY));
//                    System.out.println("xtranlate" + newTranslateX);
//                    System.out.println(stickman.figure.get("head").getX()+ newTranslateX);
                    ((Circle) (e.getSource())).setTranslateX(newTranslateX);
                    ((Circle) (e.getSource())).setTranslateY(newTranslateY);
                    refresh();
                }
            };

    EventHandler<MouseEvent> leftFootOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    double offsetX = e.getSceneX() - orgSceneX;
                    double offsetY = e.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    double newX = stickman.figure.get("leftFoot").getX() + newTranslateX;
                    double newY = stickman.figure.get("leftFoot").getY() + newTranslateY;
                    stickman.figure.put("leftFoot", new Points(newX, newY));
//                    System.out.println("xtranlate" + newTranslateX);
//                    System.out.println(stickman.figure.get("head").getX()+ newTranslateX);
                    ((Circle) (e.getSource())).setTranslateX(newTranslateX);
                    ((Circle) (e.getSource())).setTranslateY(newTranslateY);
                    refresh();
                }
            };

    EventHandler<MouseEvent> rightHandOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    double offsetX = e.getSceneX() - orgSceneX;
                    double offsetY = e.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    double newX = stickman.figure.get("rightHand").getX() + newTranslateX;
                    double newY = stickman.figure.get("rightHand").getY() + newTranslateY;
                    stickman.figure.put("rightHand", new Points(newX, newY));
//                    System.out.println("xtranlate" + newTranslateX);
//                    System.out.println(stickman.figure.get("head").getX()+ newTranslateX);
                    ((Circle) (e.getSource())).setTranslateX(newTranslateX);
                    ((Circle) (e.getSource())).setTranslateY(newTranslateY);
                    refresh();
                }
            };

    EventHandler<MouseEvent> groupOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent e) {
                    orgSceneX = e.getSceneX();
                    orgSceneY = e.getSceneY();
                    orgTranslateX = ((Group) (e.getSource())).getTranslateX();
                    orgTranslateY = ((Group) (e.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> groupOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    double offsetX = e.getSceneX() - orgSceneX;
                    double offsetY = e.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;
                    ((Group) (e.getSource())).setTranslateX(newTranslateX);
                    ((Group) (e.getSource())).setTranslateY(newTranslateY);
                }
            };


    public Group createStickman() {
        Group root = new Group();
        Button refresh = new Button("Refresh");
        Button toggleJoints = new Button("Toggle Joints");
        Button resetPoints = new Button("Reset points");
        Button screenshot = new Button("Screenshot");
        //refresh.setLayoutX(0);
        //refresh.setLayoutY(0);
        toggleJoints.setLayoutX(0);
        toggleJoints.setLayoutY(0);
        resetPoints.setLayoutX(109);
        resetPoints.setLayoutY(0);
        screenshot.setLayoutX(212);
        screenshot.setLayoutY(0);
        Circle head = createHead(stickman.namesAndNumbers.get(0), stickman.figure.get("head").getX(), stickman.figure.get("head").getY());
        Circle chest = createChest(stickman.namesAndNumbers.get(1), stickman.figure.get("chest").getX(), stickman.figure.get("chest").getY());
        Circle leftHand = createLeftHand(stickman.namesAndNumbers.get(2), stickman.figure.get("leftHand").getX(), stickman.figure.get("leftHand").getY());
        Circle rightHand = createRightHand(stickman.namesAndNumbers.get(3), stickman.figure.get("rightHand").getX(), stickman.figure.get("rightHand").getY());
        Circle post = createPost(stickman.namesAndNumbers.get(4), stickman.figure.get("post").getX(), stickman.figure.get("post").getY());
        Circle leftFoot = createLeftFoot(stickman.namesAndNumbers.get(5), stickman.figure.get("leftFoot").getX(), stickman.figure.get("leftFoot").getY());
        Circle rightFoot = createRightFoot(stickman.namesAndNumbers.get(6), stickman.figure.get("rightFoot").getX(), stickman.figure.get("rightFoot").getY());
        Line chestToHead = createLine("chestToHead", stickman.figure.get("chest").getX(), stickman.figure.get("chest").getY(), stickman.figure.get("head").getX(), stickman.figure.get("head").getY());
        Line chestToLeftHand = createLine("chestToLeftHand", stickman.figure.get("chest").getX(), stickman.figure.get("chest").getY(), stickman.figure.get("leftHand").getX(), stickman.figure.get("leftHand").getY());
        Line chestToRightHand = createLine("chestToRightHand", stickman.figure.get("chest").getX(), stickman.figure.get("chest").getY(), stickman.figure.get("rightHand").getX(), stickman.figure.get("rightHand").getY());
        Line chestToPost = createLine("chestToPost", stickman.figure.get("chest").getX(), stickman.figure.get("chest").getY(), stickman.figure.get("post").getX(), stickman.figure.get("post").getY());
        Line postToLeftFoot = createLine("postToLeftFoot", stickman.figure.get("post").getX(), stickman.figure.get("post").getY(), stickman.figure.get("leftFoot").getX(), stickman.figure.get("leftFoot").getY());
        Line postToRightFoot = createLine("postToRightFoot", stickman.figure.get("post").getX(), stickman.figure.get("post").getY(), stickman.figure.get("rightFoot").getX(), stickman.figure.get("rightFoot").getY());

        //Adding buttons
        //root.getChildren().add(refresh);
        root.getChildren().add(toggleJoints);
        root.getChildren().add(resetPoints);
        root.getChildren().add(screenshot);
        refresh.setOnAction(refreshScreen);
        toggleJoints.setOnAction(toggleJointsAction);
        resetPoints.setOnAction(pointsReset);
        screenshot.setOnAction(screenShot);

        //Adding the points
        root.getChildren().add(chest);
        root.getChildren().add(head);
        root.getChildren().add(leftHand);
        root.getChildren().add(rightHand);
        root.getChildren().add(post);
        root.getChildren().add(leftFoot);
        root.getChildren().add(rightFoot);
        //Adding the lines
        root.getChildren().add(chestToHead);
        root.getChildren().add(chestToLeftHand);
        root.getChildren().add(chestToRightHand);
        root.getChildren().add(chestToPost);
        root.getChildren().add(postToLeftFoot);
        root.getChildren().add(postToRightFoot);
        if (jointsConnected) {
            root.setOnMousePressed(groupOnMousePressedEventHandler);
            root.setOnMouseDragged(groupOnMouseDraggedEventHandler);
        }
        return root;
    }

    EventHandler<ActionEvent> refreshScreen =
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    refresh();
//                    System.out.println("hi");
//                    Group root = new Group(createStickman());
//                    root.prefHeight(305);
//                    root.prefWidth(720);
//                    Scene scene = new Scene(root, 720, 405);
//                    window.setScene(scene);
//                    window.show();
//                    System.out.println(stickman.figure.get("head").getX());
                }
            };

    EventHandler<ActionEvent> toggleJointsAction =
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    System.out.println("Joints toggled");
                    if (jointsConnected) {
                        jointsConnected = false;
                    } else {
                        jointsConnected = true;
                    }
                    refresh();

                }
            };

    EventHandler<ActionEvent> pointsReset =
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    stickman.figure.put("head", new Points(x, y - 40));
                    stickman.figure.put("chest", new Points(x, y));
                    stickman.figure.put("leftHand", new Points(x - 30, y));
                    stickman.figure.put("rightHand", new Points(x + 30, y));
                    stickman.figure.put("post", new Points(x, y + 50));
                    stickman.figure.put("leftFoot", new Points(x - 30, y + 70));
                    stickman.figure.put("rightFoot", new Points(x + 30, y + 70));
                    refresh();
                }
            };

    EventHandler<ActionEvent> screenShot =
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    saveAsPng();

                }
            };

    @FXML
    public void saveAsPng() {
        WritableImage image = root.snapshot(new SnapshotParameters(), null);

        // TODO: probably use a file chooser here
        File file = new File("frame" + frame + ".png");

        try {
            frame++;
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void refresh() {
        Group root = new Group(createStickman());
        root.prefHeight(305);
        root.prefWidth(720);
        Scene scene = new Scene(root, 720, 405);
        window.setScene(scene);
        window.show();
    }


}
