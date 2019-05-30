package org.xml.demo.ui;

public class ApplicationDemo {
    public static void main(String[] args) {

        Window window  = Window.builder()
                .windowHeight(700)
                .windowWidth(700)
                .windowTitle("Paint")
                .build();

        window.init();
        window.setVisible(true);

    }
}
