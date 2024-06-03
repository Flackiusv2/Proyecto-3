package Pagos;
import logica.Galeria;

public interface PasarelaPagos {
	 boolean procesarPago(String usuario, String numeroTarjeta, int monto, String pin, Galeria galeria);
	 boolean RealizarTraza(String usuario, String numeroTarjeta, int monto, String pin, Galeria galeria);
	}
