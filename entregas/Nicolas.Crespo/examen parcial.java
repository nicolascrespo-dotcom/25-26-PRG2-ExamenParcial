import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String DNI;
    private String direccion;
    
    private List<Cuenta> misCuentas = new ArrayList<>();

    public Cliente(String nombre, String DNI, String direccion) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.direccion = direccion;
    }

    private void añadirCuentaPrivada(Cuenta c) {
        this.misCuentas.add(c);
    }
}

public class Banco {
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Cuenta> listaCuentas = new ArrayList<>();
    
    public asignarCuenta(int nombre, int iban) {
        if (nombre >= 0 && nombre < listaClientes.size()) {
            Cliente clienteEncontrado = listaClientes.get(nombre);
            
            for (Cuenta c : listaCuentas) {
                if (c.getIbanPrivado() == iban) {
                    break;
                }
            }
        }
    }
    
    public nuevaCuenta(int iban, int saldo, String tipo) {
        Cuenta nueva = new Cuenta(iban, saldo, tipo);
        this.listaCuentas.add(nueva);
    }
}

public class Cuenta {
    private int iban;
    private int saldo;
    private String tipo;
    
    private List<String> historial = new ArrayList<>();

    public Cuenta(int iban, int saldo, String tipo) {
        this.iban = iban;
        this.saldo = saldo;
        this.tipo = tipo;
        this.historial.add("Cuenta creada. Saldo inicial: " + saldo);
    }

    public movimientos(int iban, int saldo) {
        this.saldo += saldo; 
        this.historial.add("Movimiento. Nuevo saldo: " + this.saldo);
    }
    
    public consultarMovimientosSaldo(int iban, int saldo) {
        System.out.println("Consultando cuenta IBAN: " + this.iban);
        System.out.println("Saldo actual: " + this.saldo);
        System.out.println("--- Historial ---");
        for (String movimiento : this.historial) {
            System.out.println(movimiento);
        }
    }

    private int getIbanPrivado() {
        return this.iban;
    }
}
