package org.xml.demo.ui;

import javax.swing.*;

public class Window extends JFrame {

    private String windowTitle;
    private int windowHeight;
    private int windowWidth;
    private String workingDirectory;

    public void init() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(windowTitle);
        setSize(windowWidth, windowHeight);
    }

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
    }

    public static void main(String[] args) {
        Window window = new Window.WindowBuilder().windowHeight(700).windowWidth(700).windowTitle("Test").build();
        window.init();


        window.add(new GraphicArea());

        window.setVisible(true);
    }
}
