
package dominio;


public class JubiladoVejez extends Jubilado {
    private double pensionv;

    public JubiladoVejez(String cedula, String nombres, int aniosAporte) {
        super(cedula, nombres, aniosAporte);
    }
    
    @Override
    public void calcularPension(){
        this.pensionv = getPensioni()+(getSALARIOBASE()*0.15);
    }    
    @Override
    public String toString(){
        return "Jubilado por Vejez: \n"+super.toString()+"\nSu pension final es: "+this.pensionv+"\n\n";
    }
}
