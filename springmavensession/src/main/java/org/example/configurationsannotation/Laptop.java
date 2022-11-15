package org.example.configurationsannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Laptop {

    @Autowired
    @Qualifier("normalKeyboard")
    Keyboard keyboard;

    public void show() {
        System.out.println("show laptop");
        keyboard.showKeyboard();
    }
}
