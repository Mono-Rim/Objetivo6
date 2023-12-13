package br.edu.ifsul.cstsi.objetivo6.veiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class VeiculoController {

    private static final Scanner input = new Scanner(System.in);
    private static VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService VeiculoService){
        VeiculoController.veiculoService = VeiculoService;
    }

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n\"-------  MENU veiculo -------\"");
            System.out.print(
                    """
    
                        1. Inserir novo veiculo
                        2. Atualizar um veiculo
                        3. Excluir um veiculo
                        4. Listar todos os veiculos
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectVeiculos();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    //opção 1
    private static void inserir() {
        Veiculo veiculo = new Veiculo();
        System.out.println("\n++++++ Cadastro de novo Veiculo ++++++");
        System.out.print("Digite o tipo do veiculo: ");
        veiculo.setTipo(input.nextLine());
        System.out.print("\nDigite a placa do veiculo: ");
        veiculo.setPlaca(input.nextLine());
        System.out.println("Veiculo salvo com sucesso:" + veiculoService.insert(veiculo));
    }

    //opção 2
    private static void atualizar() {
        System.out.println("\n++++++ Alterar um veiculo ++++++");
        Veiculo veiculo;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do veiculo (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                veiculo = veiculoService.getVeiculoById(codigo);
                if (veiculo == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Tipo: " + veiculo.getTipo());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo tipo do veiculo: ");
                        veiculo.setTipo(input.nextLine());
                    }
                    System.out.println("Placa: " + veiculo.getPlaca());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite a nova placa do veiculo: ");
                        veiculo.setPlaca(input.nextLine());
                    }
                    if(veiculoService.update(veiculo) != null) {
                        System.out.println("Veiculo atualizado com sucesso. " + veiculoService.getVeiculoById(veiculo.getId()));
                    } else {
                        System.out.println("Não foi possível atualizar este veiculo. Por favor, contate o administrador.");
                    }

                    opcao = 1;
                }
            }
        } while (opcao != 0);
    }
    //opção 3
    private static void excluir() {
        System.out.println("\n++++++ Excluir um veiculo ++++++");
        Veiculo veiculo;
        int opcao = 0;
        do {
            System.out.print("\nDigite o código do veiculo (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if(codigo > 0){
                veiculo = veiculoService.getVeiculoById(codigo);
                if (veiculo == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(veiculo);
                    System.out.print("Excluir este veiculo? (0-sim/1-não) ");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        veiculoService.delete(veiculo.getId());
                        System.out.println("veiculo excluído com sucesso:" + veiculo);
                    }

                }
            } else {
                System.out.println("Digite um código válido!!!");
            }
        } while (opcao != 0);
    }


    //opção 4
    private static void selectVeiculos() {
        System.out.println("\nLista de veiculos cadastrados no banco de dados:\n" + veiculoService.getVeiculos());
    }

    //opção 4
    private static void selectVeiculossById() {
        System.out.print("\nDigite o código do veiculo: ");
        Veiculo veiculo = veiculoService.getVeiculoById(input.nextLong());
        input.nextLine();
        if (veiculo != null) {
            System.out.println(veiculo);
        } else {
            System.out.println("Código não localizado.");
        }
    }

    }

