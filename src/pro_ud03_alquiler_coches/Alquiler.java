/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro_ud03_alquiler_coches;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author dam1
 */
public class Alquiler 
{
    //ATRIBUTOS
    private final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss  .");
    private final double PRECIO_DIA = 50 ;
    private LocalDateTime fecha ;
    private int dias ;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private boolean baja;
    //CONSTRUCTORES

    public Alquiler(boolean baja) {
        this.baja = baja;
    }

    
    
    
    public Alquiler( Cliente cliente,Vehiculo vehiculo) 
    {
        this.fecha = LocalDateTime.now();
        this.dias = 0;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.vehiculo.setDisponible(false);
        
    }
    
    //GETERS ATRIBUTOS

    public boolean getBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }
    
    
    public DateTimeFormatter getFORMATO_FECHA() 
    {
        return FORMATO_FECHA;
    }

    public double getPRECIO_DIA() 
    {
        return PRECIO_DIA;
    }

    public LocalDateTime getFecha() 
    {
        return fecha;
    }

    public int getDias() 
    {
        return dias;
    }

     public Cliente getCliente() 
    {
        return cliente;
    }
    
    public Vehiculo getVehiculo() 
    {
        return vehiculo;
    }

   
    
    
   //METODO CERRAR 
    public void cerrar ()
    {
        LocalDateTime fechaDevolucion = LocalDateTime.now();
        this.dias = diferenciaDias(this.fecha, fechaDevolucion);
        this.vehiculo.setDisponible(true);
    }
    
    
    //METODO PRIVADO DIFERENCIA DÍAS
    private int diferenciaDias(LocalDateTime inicio, LocalDateTime fin)
    {
        long diasCalculados = ChronoUnit.DAYS.between(inicio, fin);
        return (diasCalculados == 0) ? 1 : (int) diasCalculados + 1;
        /**
         * if (diasCalculados == 0) {
    return 1;
} else {                            //OTRA MANERA DE HACERLO BASTANTE SENCILLA.
    return (int) diasCalculados + 1;
}
         */
    }
    
    public double precioAlquiler()
    {
        return dias * PRECIO_DIA;
    }

    @Override
    public String toString() 
    {
        String cadena = "";
        if(baja == false)
        {
           cadena = 
                   "\n FORMATO_FECHA :" + FORMATO_FECHA + 
                "\n PRECIO_DIA :" + PRECIO_DIA + 
                "\n fecha :" + fecha + 
                "\n dias :" + dias + 
                "\n vehiculo :" + vehiculo + 
                "\n cliente :" + cliente ;
        }
        return cadena;
    }  
}
