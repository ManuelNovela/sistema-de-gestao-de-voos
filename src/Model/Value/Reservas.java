package Model.Value;

import java.io.*;

public class Reservas implements Serializable   {
  

  private String NrVoo, NrTreco,Data,NrdoAssento,NomeCliente,TelefoneCliente;

  public Reservas(){
     
  }

    public String getNrVoo() {
        return NrVoo;
    }

    public void setNrVoo(String NrVoo) {
        this.NrVoo = NrVoo;
    }

    public String getNrTreco() {
        return NrTreco;
    }

    public void setNrTreco(String NrTreco) {
        this.NrTreco = NrTreco;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getNrdoAssento() {
        return NrdoAssento;
    }

    public void setNrdoAssento(String NrdoAssento) {
        this.NrdoAssento = NrdoAssento;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public String getTelefoneCliente() {
        return TelefoneCliente;
    }

    public void setTelefoneCliente(String TelefoneCliente) {
        this.TelefoneCliente = TelefoneCliente;
    }

    @Override
    public String toString() {
        return "Reservas{" + "NrVoo=" + NrVoo + ", NrTreco=" + NrTreco + ", Data=" + Data + ", NrdoAssento=" + NrdoAssento + ", NomeCliente=" + NomeCliente + ", TelefoneCliente=" + TelefoneCliente + '}';
    }
  
}