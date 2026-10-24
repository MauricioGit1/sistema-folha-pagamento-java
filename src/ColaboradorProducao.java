
public class ColaboradorProducao extends Colaborador {

    private int quantidadePecas;
    private double valorPorPeca;

    public ColaboradorProducao(
            int matricula,
            String nome,
            int quantidadePecas,
            double valorPorPeca) {

        super(matricula, nome);
        this.quantidadePecas = quantidadePecas;
        this.valorPorPeca = valorPorPeca;
    }

    public double calcularProdutividade() {
        return quantidadePecas * valorPorPeca;
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase() + calcularProdutividade();
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Quantidade de peças: "
                + quantidadePecas);
        System.out.printf("Valor por peça: R$ %.2f%n",
                valorPorPeca);
        System.out.printf("Produtividade: R$ %.2f%n",
                calcularProdutividade());
    }
}
