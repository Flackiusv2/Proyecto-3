package Pagos;
import logica.Galeria;

public interface PasarelaPagos {

	 boolean procesarPago(String idComprador, String numeroTarjeta, int monto, Galeria galeria);
	 boolean RealizarTraza(String idComprador, String numeroTarjeta, int monto, Galeria galeria);
}