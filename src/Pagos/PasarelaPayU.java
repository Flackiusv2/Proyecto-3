package Pagos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import logica.Galeria;
import usuario.Comprador;


public class PasarelaPayU implements PasarelaPagos{
	
	public static String obtenerNuevoIdTransaccionPayU() {
        StringBuilder idGenerado = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int digito = random.nextInt(10);
            idGenerado.append(digito);
        }

        return "TPU"+idGenerado.toString();
    }

    @Override
    public boolean procesarPago(String idComprador, String numeroTarjeta, int monto,  Galeria galeria) {
    	Comprador comprador=  galeria.getControladorUsuarios().getMapaCompradores().get(idComprador);
        int dinero  =  comprador.getDinero();
         if (comprador!= null && dinero >= monto && numeroTarjeta.length()>10){
            return true;
         }

        return false;
    }

    @Override
    public boolean RealizarTraza(String idComprador, String numeroTarjeta, int monto, Galeria galeria) {
        String nT=obtenerNuevoIdTransaccionPayU(); 
        String resultado= "";
        String nombreComprador="";
        boolean bool=procesarPago( idComprador,  numeroTarjeta,  monto,  galeria);
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy GGG hh:mm aaa");
        String fechaString = formatoFecha.format(fechaActual);

       
        if (bool){
            Comprador comprador=  galeria.getControladorUsuarios().getMapaCompradores().get(idComprador);
            resultado="Aprobada";
            nombreComprador= comprador.getNombre();
        }
        else {
            resultado="Rechazada";
            nombreComprador= "N/A";
        }   
            
    
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Datos//PayUTraza.txt" , true))) {
        writer.write("Fecha: "+fechaString+" | Numero de Transacción: "+nT+" | Nombre Comprador: " + nombreComprador + " | Tarjeta: " + numeroTarjeta + " | Monto: " + monto + " | Resultado: " + resultado + "\n");
    } catch (IOException e) {
        e.printStackTrace();
    }

    return bool;
    }
    }