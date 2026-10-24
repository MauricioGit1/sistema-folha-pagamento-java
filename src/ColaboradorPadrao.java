
public class ColaboradorPadrao extends Colaborador {

    public ColaboradorPadrao(int matricula, String nome) {
        super(matricula, nome);
    }

    @Override
    public double calcularSalarioFinal() {
        return getSalarioBase();
    }
}
