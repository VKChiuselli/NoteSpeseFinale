package com.nsi.utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

/**
 * Created by felline on 13/09/2016.
 */
public class JfxUtility {
/**
 * spawnWindow
 *
 * @param fxmlResource path to the resource to load
 * @param ownerWindow  the windows that spawn the new scene
 * @param rootElement  the kind of the root element contained in the resource e.g. VBox VPanel...
 * @param modality     the mode of the new windows
 * @return null or the controller of the spawned windows to handle stuff in the caller
 */
public static <T> T spawnWindow(URL fxmlResource, Window ownerWindow, Pane rootElement, Modality modality) throws IOException {
    FXMLLoader loader = new FXMLLoader(fxmlResource);
    rootElement = loader.load();
    Stage childStage = new Stage();
    childStage.initOwner(ownerWindow);
    childStage.initModality(modality);
    Scene scene = new Scene(rootElement);
    childStage.setScene(scene);
    childStage.show();
    return  loader.getController();
}

}
