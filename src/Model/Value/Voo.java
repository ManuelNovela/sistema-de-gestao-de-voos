package Model.Value;

import java.io.*;

public class Voo implements Serializable   {
  

  private String NrVoo,NrTrecho,Data,AssentosDis,CodAeronave,Partida,Chegada,Activo,AeroPartida,AeroChegada;

  public Voo(){
     
  }

    public String getNrVoo() {
        return NrVoo;
    }

    public void setNrVoo(String NrVoo) {
        this.NrVoo = NrVoo;
    }

    public String getNrTrecho() {
        return NrTrecho;
    }

    public void setNrTrecho(String NrTrecho) {
        this.NrTrecho = NrTrecho;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getAssentosDis() {
        return AssentosDis;
    }

    public void setAssentosDis(String AssentosDis) {
        this.AssentosDis = AssentosDis;
    }

    public String getCodAeronave() {
        return CodAeronave;
    }

    public void setCodAeronave(String CodAeronave) {
        this.CodAeronave = CodAeronave;
    }

    public String getPartida() {
        return Partida;
    }

    public void setPartida(String Partida) {
        this.Partida = Partida;
    }

    public String getChegada() {
        return Chegada;
    }

    public void setChegada(String Chegada) {
        this.Chegada = Chegada;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String Activo) {
        this.Activo = Activo;
    }

    public String getAeroPartida() {
        return AeroPartida;
    }

    public void setAeroPartida(String AeroPartida) {
        this.AeroPartida = AeroPartida;
    }

    public String getAeroChegada() {
        return AeroChegada;
    }

    public void setAeroChegada(String AeroChegada) {
        this.AeroChegada = AeroChegada;
    }

    @Override
    public String toString() {
        return "Voo{" + "NrVoo=" + NrVoo + ", NrTrecho=" + NrTrecho + ", Data=" + Data + ", AssentosDis=" + AssentosDis + ", CodAeronave=" + CodAeronave + ", Partida=" + Partida + ", Chegada=" + Chegada + ", Activo=" + Activo + ", AeroPartida=" + AeroPartida + ", AeroChegada=" + AeroChegada + '}';
    }

    
    
}  