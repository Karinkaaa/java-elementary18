package org.xml.demo.states;

import javafx.scene.paint.Color;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AplicationWindowState {

    private final ApplicationMode mode;
    private final Color color;
}
