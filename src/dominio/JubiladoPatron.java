/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Cesar Osorio Universidad de las Fuerzas Armadas ESPE
 */
public class JubiladoPatron extends Jubilado implements Finanzas{
    private double inflacion;
    private int tipoe;
    private double pensionp;
    private String empresa;
    
    public JubiladoPatron(String cedula, String nombres, int aniosAporte,double inflacion,int tipoe) {
        super(cedula, nombres, aniosAporte);
        this.inflacion = inflacion;
        this.tipoe = tipoe;
    }

    @Override
    public void calcularPension() {
        this.pensionp = getPensioni()+(getSALARIOBASE()*inflacion);
    }

    @Override
    public void bonoSueldo() {
        if(this.tipoe ==1){
            this.pensionp = this.pensionp*1.05;
            this.empresa="Publica";
        }else{
            this.pensionp = this.pensionp*1.10;
            this.empresa="Privada";
        }
    }
    @Override
    public String toString(){
        return super.toString()+"\nEmpresa: "+this.empresa+"\nSu pension final es: "+this.pensionp+"$"+"\n\n";
    }
    
    
}
