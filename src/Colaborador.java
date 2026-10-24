public abstract class Colaborador {

    public static final double SALARIO_BASE = 2000.00;

    private int matricula;
    private String nome;
    private double salarioBase;

    public Colaborador(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = SALARIO_BASE;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public abstract double calcularSalarioFinal();

    public void exibirDados() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.printf("Salário base: R$ %.2f%n", salarioBase);
        System.out.printf("Salário final: R$ %.2f%n",
                calcularSalarioFinal());
    }
}
