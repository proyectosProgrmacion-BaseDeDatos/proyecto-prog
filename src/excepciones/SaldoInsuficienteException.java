package excepciones;

public class SaldoInsuficienteException extends Exception{

    public SaldoInsuficienteException(){
        super("No tienes saldo suficiente para comprar el juego");
    }

}
