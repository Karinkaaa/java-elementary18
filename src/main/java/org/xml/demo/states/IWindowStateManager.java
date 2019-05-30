package org.xml.demo.states;

public interface IWindowStateManager {

    AplicationWindowState provideState();
    void changeState(AplicationWindowState state);
}
