
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    private static final Scanner sc = new Scanner(System.in);

    private static final ArrayList<Colaborador> colaboradores =
            new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n===== FOLHA DE PAGAMENTO =====");
            System.out.println("1 - Cadastrar colaborador");
            System.out.println("2 - Listar colaboradores");
            System.out.println("3 - Calcular folha de pagamento");
            System.out.println("0 - Sair");

            opcao = lerInteiro("Escolha uma opção: ", 0);

            switch (opcao) {
                case 1:
                    cadastrarColaborador();
                    break;

                case 2:
                    listarColaboradores();
                    break;

                case 3:
                    calcularFolha();
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void cadastrarColaborador() {

        System.out.println("\n--- Cadastro ---");

        int matricula = lerInteiro(
                "Número de matrícula: ", 1);

        for (Colaborador c : colaboradores) {
            if (c.getMatricula() == matricula) {
                System.out.println(
                        "Essa matrícula já está cadastrada.");
                return;
            }
        }

        String nome;

        do {
            System.out.print("Nome completo: ");
            nome = sc.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("O nome não pode ficar vazio.");
            }
        } while (nome.isEmpty());

        System.out.println("\nTipo de colaborador:");
        System.out.println("1 - Padrão");
        System.out.println("2 - Comissionado");
        System.out.println("3 - Produção");

        int tipo = lerInteiro("Escolha o tipo: ", 1);

        switch (tipo) {

            case 1:
                colaboradores.add(
                        new ColaboradorPadrao(matricula, nome));
                break;

            case 2:
                double vendas = lerDouble(
                        "Valor total das vendas: R$ ", 0);

                double percentual = lerDouble(
                        "Percentual de comissão: ", 0);

                colaboradores.add(
                        new ColaboradorComissionado(
                                matricula, nome, vendas, percentual));
                break;

            case 3:
                int pecas = lerInteiro(
                        "Quantidade de peças produzidas: ", 0);

                double valorPeca = lerDouble(
                        "Valor por peça: R$ ", 0);

                colaboradores.add(
                        new ColaboradorProducao(
                                matricula, nome, pecas, valorPeca));
                break;

            default:
                System.out.println("Tipo inválido. Cadastro cancelado.");
                return;
        }

        System.out.println("Colaborador cadastrado com sucesso!");
    }

    private static void listarColaboradores() {

        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }

        System.out.println("\n--- Colaboradores cadastrados ---");

        for (Colaborador c : colaboradores) {
            System.out.println("\n-------------------------");
            c.exibirDados();
        }
    }

    private static void calcularFolha() {

        if (colaboradores.isEmpty()) {
            System.out.println("Não há colaboradores cadastrados.");
            return;
        }

        double total = 0;

        System.out.println("\n--- Folha de pagamento ---");

        for (Colaborador c : colaboradores) {
            double salario = c.calcularSalarioFinal();

            System.out.printf(
                    "%s - Salário: R$ %.2f%n",
                    c.getNome(), salario);

            total += salario;
        }

        System.out.println("-------------------------");
        System.out.printf("Total da folha: R$ %.2f%n", total);
    }

    private static int lerInteiro(String mensagem, int minimo) {

        while (true) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(sc.nextLine().trim());

                if (valor < minimo) {
                    System.out.println(
                            "Digite um número maior ou igual a "
                                    + minimo + ".");
                } else {
                    return valor;
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static double lerDouble(
            String mensagem, double minimo) {

        while (true) {
            try {
                System.out.print(mensagem);

                String entrada = sc.nextLine()
                        .trim()
                        .replace(",", ".");

                double valor = Double.parseDouble(entrada);

                if (!Double.isFinite(valor) || valor < minimo) {
                    System.out.println(
                            "Digite um valor válido maior ou igual a "
                                    + minimo + ".");
                } else {
                    return valor;
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Entrada inválida. Digite um número válido.");
            }
        }
    }
}
