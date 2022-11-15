package org.example.configurationsannotation;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class NormalKeyboard implements Keyboard{
    @Override
    public void showKeyboard() {
        System.out.println("showing normal keyboard");
    }
}
