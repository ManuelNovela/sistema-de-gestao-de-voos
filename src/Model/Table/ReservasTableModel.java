package Model.Table;

import Model.Value.Reservas;
import Model.Value.Voo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ReservasTableModel extends AbstractTableModel {

    private String colunas[] = {"Nr Voo", "Nr Treco"," Data ","Assento","NomeCliente","Telefone"};
    private List<Reservas> dados;

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
        Reservas res = dados.get(l);
        switch (c) {
            case 0:
                return res.getNrVoo();
            case 1:
                return res.getNrTreco();
            case 2:
                return res.getData();
            case 3:
                return res.getNrdoAssento();
            case 4:
                return res.getNomeCliente();
            case 5:
                return res.getTelefoneCliente();
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

    public void setDados(List<Reservas> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Reservas getRowValue(int l) {
        return dados.get(l);
    }
}
