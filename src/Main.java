import controller.FuncionarioController;
import model.*;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        Venda vendaAna1 = new Venda("12/2021", 5200.0);
        Venda vendaAna2 = new Venda("01/2022", 4000.0);
        Venda vendaAna3 = new Venda("02/2022", 4200.0);
        Venda vendaAna4 = new Venda("03/2022", 5850.0);
        Venda vendaAna5 = new Venda("04/2022", 7000.0);
        List<Venda> vendasAnaList =  new ArrayList<>();
        vendasAnaList.add(vendaAna1);
        vendasAnaList.add(vendaAna2);
        vendasAnaList.add(vendaAna3);
        vendasAnaList.add(vendaAna4);
        vendasAnaList.add(vendaAna5);

        Venda vendaJoao1 = new Venda("12/2021", 5200.0);
        Venda vendaJoao2 = new Venda("01/2022", 4000.0);
        Venda vendaJoao3 = new Venda("02/2022", 4200.0);
        Venda vendaJoao4 = new Venda("03/2022", 5850.0);
        Venda vendaJoao5 = new Venda("04/2022", 7000.0);
        List<Venda> vendasJoaoList =  new ArrayList<>();
        vendasJoaoList.add(vendaJoao1);
        vendasJoaoList.add(vendaJoao2);
        vendasJoaoList.add(vendaJoao3);
        vendasJoaoList.add(vendaJoao4);
        vendasJoaoList.add(vendaJoao5);

        Secretario Jorge = new Secretario("Jorge", "Secretario", 7000.0, "01/2018");
        Secretario Maria = new Secretario("Maria", "Secretario", 7000.0, "12/2015");
        Vendedor Ana = new Vendedor("Ana", "Vendedor", 7000.0, "12/2021",
                vendasAnaList);
        Vendedor Joao = new Vendedor("Joao", "Vendedor", 7000.0, "12/2021",
                vendasJoaoList);
        Gerente Juliana = new Gerente("Juliana", "Gerente", 7000.0, "07/2017");
        Gerente Bento = new Gerente("Bento", "Gerente", 7000.0, "03/2014");


        List<FuncionarioBase> funcionarioBaseList =  new ArrayList<>();
        funcionarioBaseList.add(Jorge);
        funcionarioBaseList.add(Maria);
        funcionarioBaseList.add(Ana);
        funcionarioBaseList.add(Joao);
        funcionarioBaseList.add(Juliana);
        funcionarioBaseList.add(Bento);

        List<FuncionarioComBeneficio> funcionarioComBeneficioList =  new ArrayList<>();
        funcionarioComBeneficioList.add(Jorge);
        funcionarioComBeneficioList.add(Maria);
        funcionarioComBeneficioList.add(Ana);
        funcionarioComBeneficioList.add(Joao);

        List<Vendedor> vendedorList =  new ArrayList<>();
        vendedorList.add(Ana);
        vendedorList.add(Joao);

        DecimalFormat decimalFormat = new DecimalFormat("#0.0");

        FuncionarioController funcionarioController =  new FuncionarioController(funcionarioBaseList,
                funcionarioComBeneficioList, vendedorList);

        System.out.println("Valor total com benefícios: " + decimalFormat.format(
                funcionarioController.valorTotalMensalDosSalariosComBeneficio("01/2018")));

        System.out.println("Valor total sem benefícios: " + decimalFormat.format(
                funcionarioController.valorTotalMensalDosSalariosSemBeneficio("01/2018")));

        System.out.println("Valor total mensal dos beneficios: " + decimalFormat.format(
                funcionarioController.valorTotalMensalDosBeneficios("01/2018")));

        System.out.println("Salario mais alto: " +
                funcionarioController.salarioMaisAlto("01/2018"));

        System.out.println("Beneficio mais alto: " +
                funcionarioController.beneficioMaisAlto("01/2018"));

        System.out.println("Melhor vendedor: " +
                funcionarioController.melhorVendedor("12/2021"));
    }
}