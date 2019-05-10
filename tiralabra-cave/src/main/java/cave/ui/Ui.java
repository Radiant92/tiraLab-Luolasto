package cave.ui;

import cave.domain.*;
import cave.util.MyList;
import java.awt.Color;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * The user interface class provides options on how the caverns will be created.
 * The user interface automatically creates a list of sleeves which are chosen
 * at random and then populated by rooms. Adjusting the deep value let's you
 * control the depth of the cave in increments of 100. After choosing the depth
 * of the cavern the user can choose to either see a visualisation of the
 * building process (rooms main=red sub=green and paths main=blue sub=pink), or
 * opt to simply see the stats of said depth.
 *
 * @author strohm
 */
public class Ui extends Application {

    private int deep;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage window) {
        deep = 100;
        BorderPane pane = new BorderPane();

        Button add100 = new Button("+100");
        Button add1K = new Button("+1k");
        Button add10K = new Button("+10k");
        Button add100K = new Button("+100k");
        Button add1mil = new Button("+1mil");
        Button reset = new Button("reset");
        Button sub = new Button("-100");
        Button activate = new Button("Activate");
        Button noDraw = new Button("dont draw");

        TextField depth = new TextField("100");
        depth.setEditable(false);

        TextField mainCavernTime = new TextField("0");
        TextField subCavernTime = new TextField("0");
        TextField totalTime = new TextField("0");
        TextField mainCount = new TextField("0");
        TextField subCount = new TextField("0");

        mainCavernTime.setEditable(false);
        subCavernTime.setEditable(false);
        totalTime.setEditable(false);
        mainCount.setEditable(false);
        subCount.setEditable(false);

        Label mainCountLabel = new Label("Main caves");
        Label subCountLabel = new Label("Sub caves");
        Label mainLabel = new Label("Main-cavern build time/msec");
        Label subLabel = new Label("Sub-cavern build time/msec");
        Label totalLabel = new Label("Total build time/msec");
        Label explanation = new Label("Increase/Decrease depth (min 100).\n"
                + "choose 'activate' to see a visual representation of the cavern"
                + " or 'dont draw' to just see the stats of the built cavern.\n\n"
                + "red room = main room \n"
                + "green room = sub room \n"
                + "blue lines = main path \n"
                + "pink lines = sub path");

        HBox setDepth = new HBox(20);
        setDepth.getChildren().addAll(sub, depth, add100, add1K, add10K, add100K, add1mil, reset, activate, noDraw);

        VBox results = new VBox(10);
        results.getChildren().addAll(mainLabel, mainCavernTime, subLabel,
                subCavernTime, totalLabel, totalTime, mainCountLabel, mainCount,
                subCountLabel, subCount, explanation);

        add100.setOnAction((event) -> {
            deep += 100;
            depth.setText(deep + "");
        });
        add1K.setOnAction((event) -> {
            deep += 1000;
            depth.setText(deep + "");
        });
        add10K.setOnAction((event) -> {
            deep += 10000;
            depth.setText(deep + "");
        });
        add100K.setOnAction((event) -> {
            deep += 100000;
            depth.setText(deep + "");
        });
        add1mil.setOnAction((event) -> {
            deep += 1000000;
            depth.setText(deep + "");
        });
        reset.setOnAction((event) -> {
            deep = 100;
            depth.setText("100");
        });
        sub.setOnAction((event) -> {
            if (deep > 100) {
                deep -= 100;
                depth.setText(deep + "");
            }
        });
        activate.setOnAction((event) -> {
            createCavern(deep, true, mainCavernTime, subCavernTime, totalTime, mainCount, subCount);
        });
        noDraw.setOnAction((event) -> {
            createCavern(deep, false, mainCavernTime, subCavernTime, totalTime, mainCount, subCount);
        });

        pane.setTop(setDepth);
        pane.setCenter(results);

        Scene scene = new Scene(pane, 1200, 800);

        window.setScene(scene);
        window.setTitle("Cave");
        window.show();
    }

    public static void createCavern(int deep, boolean draw, TextField main, TextField sub, TextField total, TextField mainCount, TextField subCount) {
        CaveMapper cMapper = new CaveMapper(deep);

        long time = System.currentTimeMillis();
        MyList mainCaves = cMapper.mainCaves();
        time = System.currentTimeMillis() - time;
        main.setText("" + time);

        long entireTime = time;

        time = System.currentTimeMillis();
        MyList subCaves = cMapper.subCaves();
        time = System.currentTimeMillis() - time;
        sub.setText("" + time);
        entireTime += time;
        total.setText("" + entireTime);

        mainCount.setText("" + mainCaves.size());
        subCount.setText("" + subCaves.size());
        if (draw) {
            Draw d = new Draw(1920, 1200, "Cavern");
            d.drawRooms(Color.RED, mainCaves);
            d.drawRooms(Color.GREEN, subCaves);
            d.drawPaths(mainCaves, Color.BLUE);
            d.drawPaths(subCaves, Color.PINK);
        }
    }

    public static double inSeconds(long time) {
        return (double) time / 1000;
    }

}
