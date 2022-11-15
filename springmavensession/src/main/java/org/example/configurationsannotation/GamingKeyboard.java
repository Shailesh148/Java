package org.example.configurationsannotation;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class GamingKeyboard implements Keyboard{
    @Override
    public void showKeyboard() {
        System.out.println("showing gaming keyboard");
    }
}
