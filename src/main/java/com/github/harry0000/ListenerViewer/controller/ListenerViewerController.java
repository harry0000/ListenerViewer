package com.github.harry0000.ListenerViewer.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class ListenerViewerController implements Initializable {

    private static String buildText(final Slider slider, final Number oldValue, final Number newValue) {
        final StringBuilder sb = new StringBuilder(64);
        sb.append(slider.getId())
          .append(" -> old:")
          .append(oldValue.intValue())
          .append(", new:")
          .append(newValue.intValue())
          .append('\n');
        return sb.toString();
    }

    @FXML
    private Slider slider1;
    @FXML
    private Slider slider2;
    @FXML
    private TextArea log;

    @FXML
    public void handleClear(final ActionEvent event) {
        log.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slider1.valueProperty().bindBidirectional(slider2.valueProperty());

        slider1.valueProperty().addListener(
            (observable, oldValue, newValue) -> {
                log.appendText(buildText(slider1, oldValue, newValue));
            }
        );
        slider2.valueProperty().addListener(
            (observable, oldValue, newValue) -> {
                log.appendText(buildText(slider2, oldValue, newValue));
            }
        );
    }

}
