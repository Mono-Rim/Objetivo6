
import br.edu.ifsul.cstsi.objetivo6.corridas.CorridaController;
import br.edu.ifsul.cstsi.objetivo6.motoristas.MotoristaController;
import br.edu.ifsul.cstsi.objetivo6.usuarios.UsuarioController;
import br.edu.ifsul.cstsi.objetivo6.veiculos.VeiculoController;

import java.util.Scanner;

public class HomeController {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n-------  Home -------");
            System.out.print(
                    """
    
                        1. VeiculoController
                        2. UsuarioController
                        3. MotoristaController
                        4. CorridaController
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> VeiculoController.main(null);
               // case 2 -> UsuarioController.main(null);
               // case 3 -> MotoristaController.main(null);
              //  case 4 -> CorridaController.main(null); //ItemController.main(null);
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0) ;
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
        input.close(); //libera o recurso
    }
}
