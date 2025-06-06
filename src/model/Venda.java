package model;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Usuario cliente;
    private List<ItemVenda> itens = new ArrayList<>();

    public Venda(Usuario cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    public double getTotal() {
        return itens.stream().mapToDouble(ItemVenda::getSubtotal).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cliente.toString()).append("\n");
        for (ItemVenda item : itens) {
            sb.append("  ").append(item).append("\n");
        }
        sb.append("TOTAL: R$").append(getTotal()).append("\n");
        return sb.toString();
    }
}
