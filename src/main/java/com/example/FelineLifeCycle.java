package com.example;

import java.util.List;

public interface FelineLifeCycle {
    List<String> getFood(String animalKind) throws Exception;
    int getKittens();
}
