package Model.Table;

import Model.Value.Voo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VooTableModel extends AbstractTableModel {

    private String colunas[] = {"NrVoo","NrTrecho","Data","Assentos Dis.","Cod Aeronave","Partida","Chegada","Aero Partida","Aero Chegada"};
    private List<Voo> dados;

    @Override
    public int getRowCount() {
        if(dados == null){
            return 0;
        }
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        Voo voo = dados.get(l);
        switch (c) {
            case 0:
                return voo.getNrVoo();
            case 1:
                return voo.getNrTrecho();
            case 2:
                return voo.getData();
            case 3:
                return voo.getAssentosDis();
            case 4:
                return voo.getCodAeronave();
            case 5:
                return voo.getPartida();
            case 6:
                return voo.getChegada();
            case 7:
                return voo.getAeroPartida(); 
            case 8:
                return voo.getAeroChegada(); 
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<Voo> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Voo getRowValue(int l) {
        return dados.get(l);
    }
}
