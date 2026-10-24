
public class ColaboradorComissionado extends Colaborador {

    private double valorVendas;
    private double percentualComissao;

    public ColaboradorComissionado(
            int matricula,
            String nome,
            double valorVendas,
            double percentualComissao) {

        super(matricula, nome);
        this.valorVendas = valorVendas;
        this.percentualComissao = percentualComissao;
    }

    public double calcularComissao() {
        return valorVendas * percentualComissao / 100.0;
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularComissao();
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.printf("Valor das vendas: R$ %.2f%n",
                valorVendas);
        System.out.printf("Percentual de comissão: %.2f%%%n",
                percentualComissao);
        System.out.printf("Comissão: R$ %.2f%n",
                calcularComissao());
    }
}
