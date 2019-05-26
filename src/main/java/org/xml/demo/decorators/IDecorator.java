package org.xml.demo.decorators;

import org.xml.demo.ui.Figure;

import java.awt.*;

public interface IDecorator {
    void doDecorate(Figure target, Graphics g);
}
