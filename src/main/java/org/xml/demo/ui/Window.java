package org.xml.demo.ui;

import javax.swing.*;

import javafx.scene.paint.Color;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.xml.demo.states.AplicationWindowState;
import org.xml.demo.states.ApplicationMode;
import org.xml.demo.states.IWindowStateManager;

import java.awt.*;

@Getter
@Builder
@NoArgsConstructor
public class Window extends JFrame implements IWindowStateManager {

    private int windowHeight;
    private int windowWidth;
    private String workingDirectory;
    @ToString.Exclude
    private String windowTitle;
    private GraphicArea graphicArea;
    private AplicationWindowState state;
    private static AplicationWindowState INITIAL_STATE = new AplicationWindowState(ApplicationMode.DRAW_RECTANGLE,
            Color.BLUE);

    public void init() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(windowTitle);
        setSize(windowWidth, windowHeight);
        graphicArea = new GraphicArea();
        add(graphicArea);
        initWithButtons();
        add(graphicArea, BorderLayout.CENTER);
    }

    private void initWithButtons() {

        JPanel buttonPanel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();

        JToggleButton button = new JToggleButton("Rectangle");
        AplicationWindowState previous = provideState();

        button.addActionListener(e -> {
            changeState(new AplicationWindowState(ApplicationMode.DRAW_RECTANGLE, previous.getColor()));
        });

        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.PAGE_START);

        JToggleButton button2 = new JToggleButton("Circle");
        button2.addActionListener(e -> {
            changeState(new AplicationWindowState(ApplicationMode.DRAW_CIRCLE, previous.getColor()));
        });
        buttonPanel.add(button2);
        add(buttonPanel, BorderLayout.PAGE_START);

        JToggleButton button3 = new JToggleButton("Line");
        button3.addActionListener(e -> {
            changeState(new AplicationWindowState(ApplicationMode.DRAW_LINE, previous.getColor()));
        });
        buttonPanel.add(button3);
        add(buttonPanel, BorderLayout.PAGE_START);

        buttonGroup.add(button);
        buttonGroup.add(button2);
        buttonGroup.add(button3);
    }

    @Override
    public AplicationWindowState provideState() {
        return state == null ? INITIAL_STATE : state;
    }

    @Override
    public void changeState(AplicationWindowState state) {
        this.state = state;
    }

/*
    public static class WindowBuilder {

        private Window instance = new Window();

        public WindowBuilder windowTitle(String windowTitle) {
            instance.windowTitle = windowTitle;
            return this;
        }

        public WindowBuilder windowHeight(int windowHeight) {
            instance.windowHeight = windowHeight;
            return this;
        }

        public WindowBuilder windowWidth(int windowWidth) {
            instance.windowWidth = windowWidth;
            return this;
        }

        public WindowBuilder windowWorkingDirectory(String workingDirectory) {
            instance.workingDirectory = workingDirectory;
            return this;
        }

        public Window build() {

            if (instance.workingDirectory == null) {
                throw new RuntimeException("working directory is null!");
            }
            return instance;
        }
    }*/
}
