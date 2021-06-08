package com.michel.conroleveiculos.domain.enums;

public enum DiaSemana {
    DOMINGO(0),
    SEGUNDA_FEIRA(1),
    TERCA_FEIRA(2),
    QUARTA_FEIRA(3),
    QUINTA_FEIRA(4),
    SEXTA_FEIRA(5),
    SABADO(6);

    int value;

    DiaSemana(int dia){
        this.value = dia;
    }

    public String getNomeDia() {
        return this.toString();
    }

    public int getValue(){
        return this.value;
    }
}
