package teste.Aula3;

import java.util.ArrayList;

public class Principal2 {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.nome = "Luís";
        funcionario1.sobrenome = "Silva";
        funcionario1.horasTrabalhadas = 150;
        funcionario1.valorPorHora = 10.50;
        funcionario1.valorVale = 50.00;
        funcionario1.cargo = "Lixeiro";

        String cargo = funcionario1.informarCargo("Vendedor"); // Caso seja "Gerente" irá ter um incremento de 500R$
        System.out.println(cargo);

        String nomeCompleto = funcionario1.nomeCompleto();
        System.out.println(nomeCompleto);

        double salario = funcionario1.calcularSalario();
        System.out.println(salario);

        funcionario1.incrementarHoras(21);
        double novoSalario = funcionario1.calcularSalario();
        System.out.println("Salário 21 horas à mais: " + novoSalario);

        Funcionario funcionario2 = new Funcionario();
        funcionario2.nome = "Gabriel";
        funcionario2.sobrenome = "Rodrigues";
        funcionario2.horasTrabalhadas = 180;
        funcionario2.valorPorHora = 11.00;
        funcionario2.valorVale = 35.00;
        funcionario2.cargo = "Professor";

        Funcionario funcionario3 = new Funcionario();
        funcionario3.nome = "João";
        funcionario3.sobrenome = "Otávio";
        funcionario3.horasTrabalhadas = 130;
        funcionario3.valorPorHora = 9.50;
        funcionario3.valorVale = 90.00;
        funcionario3.cargo = "Entregador";

        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.nomeCompleto());
            System.out.println(funcionario.calcularSalario());
        }
    }

}
