package teste.Aula3;

public class Funcionario {

    String nome;
    String sobrenome;
    String cargo;

    int horasTrabalhadas;
    double valorPorHora;
    double valorVale;

    public String nomeCompleto() {
        return nome + " " + sobrenome;
    }

    public String informarCargo(String novoCargo) {
        cargo = novoCargo;
        return cargo;
    }

    public double calcularSalario() {
        double salario = (horasTrabalhadas * valorPorHora) - valorVale;
        // equalsIgnoreCase = se for igual (não considera letras maiúsculas, transforma
        // todas as maiúsculas em minúsculas).
        if (cargo.equalsIgnoreCase("Gerente")) {
            return salario + 500;
        } else {
            return salario;
        }
    }

    public void incrementarHoras(int horas) {
        horasTrabalhadas = horasTrabalhadas + horas;
    }
}
