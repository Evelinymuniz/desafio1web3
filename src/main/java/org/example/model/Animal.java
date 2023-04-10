package org.example.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Animal {
    private String alimentacao;
    private String reproducao;
    private String locomocao;
    private double peso;

}