package org.example.service;
import org.example.model.Animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class AnimalService {
    public static void main(String[] args) {

        List<Animal> animais = new ArrayList<>();
        animais.add(new Animal("herbivoro", "oviparo", "terrestre", 50.0));
        animais.add(new Animal("carnivoro", "viviparo", "aquatico", 10.0));
        animais.add(new Animal("herbivoro", "oviparo", "aereo", 100.0));
        animais.add(new Animal("carnivoro", "oviparo", "aereo", 200.0));
        animais.add(new Animal("herbivoro", "viviparo", "terrestre", 20.0));
        animais.add(new Animal("carnivoro", "oviparo", "aquatico", 5.0));


        double x = 30.0;
        List<Animal> herbivorosPesados = animais.stream()
                .filter(a -> a.getAlimentacao().equals("herbivoro") && a.getPeso() > x)
                .collect(Collectors.toList());
        System.out.println("Herbivoros com peso maior que " + x + ":\n");
        herbivorosPesados.forEach(System.out::println);

        List<Animal> oviparosNaoRepteis = animais.stream()
                .filter(a -> a.getReproducao().equals("oviparo") && !a.getLocomocao().equals("terrestre"))
                .collect(Collectors.toList());
        System.out.println("Oviparos nao repteis:\n");
        oviparosNaoRepteis.forEach(System.out::println);


        Animal maiorVoadorCarnivoro = animais.stream()
                .filter(a -> a.getAlimentacao().equals("carnivoro") && a.getLocomocao().equals("aereo"))
                .max(Comparator.comparingDouble(Animal::getPeso))
                .orElse(null);
        System.out.println("Maior animal voador carnívoro:\n");
        System.out.println(maiorVoadorCarnivoro);
    }
}