package Pagos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import logica.Galeria;
import usuario.Comprador;

public class PasarelaPaypal implements PasarelaPagos{
	
	public static String obtenerNuevoIdTransaccionPayPal() {
        StringBuilder idGenerado = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int digito = random.nextInt(10);
            idGenerado.append(digito);
        }

        return "TPP"+idGenerado.toString();
    }
	
	@Override
	public boolean procesarPago(String usuario, String numeroTarjeta, int monto, String pin, Galeria galeria) {
        Comprador comprador=  galeria.getControladorUsuarios().getMapaCompradores().get(usuario);
        int credito =comprador.getLimiteCompras();
         if (comprador!= null && credito>= monto && numeroTarjeta.length()==16 && pin.length()==3){
            return true;
         }

        return false;
    }
	
	@Override
    public boolean RealizarTraza(String usuario, String numeroTarjeta, int monto, String pin, Galeria galeria) {
        String nT=obtenerNuevoIdTransaccionPayPal(); 
        String resultado= "";
        String nombreComprador="";
        boolean bool=procesarPago( usuario,  numeroTarjeta,  monto,  pin,  galeria);
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy GGG hh:mm aaa");
        String fechaString = formatoFecha.format(fechaActual);

       
        if (bool){
            Comprador comprador=  galeria.getControladorUsuarios().getMapaCompradores().get(usuario);
            resultado="Aprobada";
            nombreComprador= comprador.getNombre();
        }
        else {
            resultado="Rechazada";
            nombreComprador= "N/A";
        } 
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datos/PaypalTransacc.txt" , true))) {
            writer.write("Fecha: "+fechaString+" | Numero de Transacción: "+nT+" | Nombre Comprador: " + nombreComprador + " | Tarjeta: " + numeroTarjeta + " | Monto: " + monto + " | Resultado: " + resultado + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bool;
       

        }
	
	
}
