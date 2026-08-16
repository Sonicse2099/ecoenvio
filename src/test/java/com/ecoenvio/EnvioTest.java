package com.ecoenvio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnvioTest {

    @Test
    public void testCalculoEstandar() {
        Dimensiones dim = new Dimensiones(10, 10, 10);
        Cliente cliente = new Cliente("Ana", "REGULAR");
        Envio envio = new Envio("E001", 3, 10, "EFECTIVO", dim, cliente);
        assertEquals(10.00, envio.calcularCostoTotal(), 0.001);
    }

    @Test
    public void testVolumenExcedido() {
        Dimensiones dim = new Dimensiones(40, 40, 40);
        Cliente cliente = new Cliente("Ana", "REGULAR");
        Envio envio = new Envio("E002", 3, 10, "EFECTIVO", dim, cliente);
        assertEquals(25.00, envio.calcularCostoTotal(), 0.001);
    }

    @Test
    public void testMembresiasEspeciales() {
        Dimensiones dim = new Dimensiones(10, 10, 10);

        Cliente premium = new Cliente("Beto", "PREMIUM");
        Envio envioPremium = new Envio("E003", 3, 10, "EFECTIVO", dim, premium);
        assertEquals(9.00, envioPremium.calcularCostoTotal(), 0.001);

        Cliente vip = new Cliente("Caro", "VIP");
        Envio envioVip = new Envio("E004", 3, 10, "EFECTIVO", dim, vip);
        assertEquals(8.00, envioVip.calcularCostoTotal(), 0.001);
    }

    @Test
    public void testMetodosPago() {
        Dimensiones dim = new Dimensiones(10, 10, 10);
        Cliente cliente = new Cliente("Ana", "REGULAR");

        Envio transferencia = new Envio("E005", 3, 10, "TRANSFERENCIA", dim, cliente);
        assertEquals(9.50, transferencia.calcularCostoTotal(), 0.001);

        Envio tarjeta = new Envio("E006", 3, 10, "TARJETA", dim, cliente);
        assertEquals(10.30, tarjeta.calcularCostoTotal(), 0.001);
    }

    @Test
    public void testDatosInvalidos() {
        Dimensiones dim = new Dimensiones(10, 10, 10);
        Cliente cliente = new Cliente("Ana", "REGULAR");
        Envio envio = new Envio("E007", -3, 10, "EFECTIVO", dim, cliente);
        assertEquals(0.0, envio.calcularCostoTotal(), 0.001);
    }
}