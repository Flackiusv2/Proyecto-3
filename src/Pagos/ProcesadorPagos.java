package Pagos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import logica.Galeria;

public class ProcesadorPagos {
	private List<PasarelaPagos> pasarelas;

    String pasarelasFilePath="datos/Pasarelas.txt";


    public ProcesadorPagos() {
        pasarelas = new ArrayList<>();
        cargarPasarelas();
    }

    private void cargarPasarelas( ) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pasarelasFilePath))) {
            String line;
            boolean bool=true;
            while ((line = reader.readLine()) != null) {
                if(line.equals("PayUPasarela") || line.equals("PayPalPasarela" )){
                    bool=true;

                }
                else{
                    bool=false;
                }
            }
            if (bool){
                PasarelaPagos payU =new PasarelaPayU();
                pasarelas.add(payU);
                PasarelaPagos payPal =new PasarelaPaypal();
                pasarelas.add(payPal);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String procesarPagoTraza(String pasarela, String idComprador, String numeroTarjeta, int monto, String pin, Galeria galeria) {
        for (PasarelaPagos tipo : pasarelas) {
            if (tipo.getClass().getSimpleName().equals(pasarela)) {

                boolean respuesta=tipo.RealizarTraza(idComprador, numeroTarjeta, monto, galeria);

                if (respuesta){
                    return "La transacción con la tarjeta numero: "+numeroTarjeta+", fue Aprobada, ya puede ver la traza de la transacción en el archivo correspondiente";
                }
                else {
                    return "La transacción con la tarjeta numero: "+numeroTarjeta+", fue Rechazada, ya puede ver la traza de la transacción en el archivo correspondiente";
                }
            }
            
        }
        return "Pasarela no encontrada";
	
	
}
}