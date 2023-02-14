package controller;

import model.FuncionarioBase;
import model.FuncionarioComBeneficio;
import model.Vendedor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FuncionarioController {
    private List<FuncionarioBase> funcionariosBase =  new ArrayList<>();
    private List<FuncionarioComBeneficio> funcionariosComBeneficio = new ArrayList<>();
    private List<Vendedor> vendedores = new ArrayList<>();

    public FuncionarioController(List<FuncionarioBase> funcionariosBase,
                                 List<FuncionarioComBeneficio> funcionariosComBeneficio,
                                 List<Vendedor> vendedores) {
        this.funcionariosBase = funcionariosBase;
        this.funcionariosComBeneficio = funcionariosComBeneficio;
        this.vendedores = vendedores;
    }

    public List<FuncionarioBase> getFuncionariosBase() {
        return funcionariosBase;
    }

    public void setFuncionariosBase(List<FuncionarioBase> funcionariosBase) {
        this.funcionariosBase = funcionariosBase;
    }

    public List<FuncionarioComBeneficio> getFuncionariosComBeneficio() {
        return funcionariosComBeneficio;
    }

    public void setFuncionariosComBeneficio(List<FuncionarioComBeneficio> funcionariosComBeneficio) {
        this.funcionariosComBeneficio = funcionariosComBeneficio;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    // Um método que receba uma lista de funcionários,
    // mês e ano e retorne o valor total pago (salário e benefício) a esses funcionários no mês
    public Double valorTotalMensalDosSalariosComBeneficio(List<FuncionarioBase> funcionariosBase, Date data){
        Double soma = 0.0;
        for (FuncionarioBase fb: funcionariosBase)
            soma += fb.calcularSalarioComBeneficio(data);

        return soma;
    }

    // Um método que receba uma lista de funcionários,
    // mês e ano e retorne o total pago somente em salários no mês.
    public Double valorTotalMensalDosSalariosSemBeneficio(List<FuncionarioBase> funcionariosBase, Date data){
        Double soma = 0.0;
        for (FuncionarioBase fb: funcionariosBase)
            soma += fb.calcularSalarioSemBeneficio(data);
        return soma;
    }

    // Um método que receba uma lista somente com os funcionários que recebem benefícios,
    // mês e ano e retorne o total pago em benefícios no mês.
    public Double valorTotalMensalDosBeneficios(List<FuncionarioComBeneficio> funcionarioComBeneficio,
                                                Date data){
        Double soma = 0.0;
        for (FuncionarioComBeneficio fcb: funcionarioComBeneficio)
            soma += fcb.calcularBeneficio(data);
        return soma;
    }

    // Um método que receba uma lista de funcionários,
    // mês e ano e retorne o que recebeu o valor mais alto no mês.
    public String salarioMaisAlto(List<FuncionarioBase> funcionariosBase, Date data){
        Double soma = 0.0, maior = 0.0;
        String funcionario = "";
        for (FuncionarioBase fb: funcionariosBase) {
            soma += fb.calcularSalarioComBeneficio(data);
            if(soma > maior){
                maior = soma;
                funcionario = fb.getNome();
            }
        }
        return funcionario;
    }

    // Um método que receba uma lista somente com os funcionários que recebem benefícios,
    // mês e ano e retorne o nome do funcionário que recebeu o valor mais alto em benefícios no mês.
    public String beneficioMaisAlto(List<FuncionarioComBeneficio> funcionarioComBeneficio, Date data){
        Double soma = 0.0, maior = 0.0;
        String funcionario = "";
        for (FuncionarioComBeneficio fcb: funcionarioComBeneficio) {
            soma += fcb.calcularBeneficio(data);
            if(soma > maior){
                maior = soma;
                funcionario = fcb.getNome();
            }
        }
        return funcionario;
    }

    public String melhorVendedor(List<Vendedor> vendedores, Date data){
        int maior = 0;
        String funcionario = "";
        for (Vendedor v: vendedores) {
            if(v.getVendas().size() > maior){
                maior = v.getVendas().size();
                funcionario = v.getNome();
            }
        }
        return funcionario;
    }
}