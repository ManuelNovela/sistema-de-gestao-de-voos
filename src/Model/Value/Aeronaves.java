package Model.Value;

import java.io.*;

public class Aeronaves implements Serializable   {
  

  private String NomeAeronave,QtdmaxAssetos,Companhia,CodAero,NrTotalAssentos,TipoAeronave,NrVoo;

  public Aeronaves(){
     
  }

    public String getNomeAeronave() {
        return NomeAeronave;
    }

    public void setNomeAeronave(String NomeAeronave) {
        this.NomeAeronave = NomeAeronave;
    }

    public String getQtdmaxAssetos() {
        return QtdmaxAssetos;
    }

    public void setQtdmaxAssetos(String QtdmaxAssetos) {
        this.QtdmaxAssetos = QtdmaxAssetos;
    }

    public String getCompanhia() {
        return Companhia;
    }

    public void setCompanhia(String Companhia) {
        this.Companhia = Companhia;
    }

    public String getCodAero() {
        return CodAero;
    }

    public void setCodAero(String CodAero) {
        this.CodAero = CodAero;
    }

    public String getNrTotalAssentos() {
        return NrTotalAssentos;
    }

    public void setNrTotalAssentos(String NrTotalAssentos) {
        this.NrTotalAssentos = NrTotalAssentos;
    }

    public String getTipoAeronave() {
        return TipoAeronave;
    }

    public void setTipoAeronave(String TipoAeronave) {
        this.TipoAeronave = TipoAeronave;
    }

    public String getNrVoo() {
        return NrVoo;
    }

    public void setNrVoo(String NrVoo) {
        this.NrVoo = NrVoo;
    }

    @Override
    public String toString() {
        return "Aeronaves{" + "NomeAeronave=" + NomeAeronave + ", QtdmaxAssetos=" + QtdmaxAssetos + ", Companhia=" + Companhia + ", CodAero=" + CodAero + ", NrTotalAssentos=" + NrTotalAssentos + ", TipoAeronave=" + TipoAeronave + ", NrVoo=" + NrVoo + '}';
    }
  
}