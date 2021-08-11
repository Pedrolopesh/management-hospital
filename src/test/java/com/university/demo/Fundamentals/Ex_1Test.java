package com.university.demo.Fundamentals;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex_1Test {
    @Test
    public void SomarTest(){
        int resultado;
        Ex_1 calculos = new Ex_1();
        resultado = calculos.Somar(2, 2);

        Assert.assertEquals(4, resultado);
    }
}
