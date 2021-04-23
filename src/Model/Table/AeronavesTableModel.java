package Model.Table;

import Model.Value.Reservas;
import Model.Value.Aeronaves;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AeronavesTableModel extends AbstractTableModel {

    private String colunas[] = {"Nome Aeronave","Companhia","CodAero","Total Assentos","TipoAeronave","NrVoo"};
    private List<Aeronaves> dados;

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
        Aeronaves res = dados.get(l);
        switch (c) {
            case 0:
                return res.getNomeAeronave();
            case 1:
                return res.getCompanhia();
            case 2:
                return res.getCodAero();
            case 3:
                return res.getNrTotalAssentos();
            case 4:
                return res.getTipoAeronave();
            case 5:
                return res.getNrVoo();
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

    public void setDados(List<Aeronaves> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Aeronaves getRowValue(int l) {
        return dados.get(l);
    }
}
