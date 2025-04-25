import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Carro> carros = new ArrayList<>();
        ArrayList<Condutor> condutores = new ArrayList<>();

        boolean end = false;
        
        do {
            System.out.println("\nBem-vindo ao gerenciamento de garagem");
            System.out.println("1 - Cadastrar um veículo");
            System.out.println("2 - Cadastrar um condutor");
            System.out.println("3 - Associar um condutor à um veículo");
            System.out.println("4 - Associar um motor à um veículo");
            System.out.println("5 - Listar veículos cadastrados");
            System.out.println("6 - Listar condutores cadastrados");
            System.out.println("0 - Sair");
            System.out.print("> ");
            int op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 0:
                    System.out.println("Tchau tchau");
                    end = true;
                    break;

                case 1:
                    System.out.print("Marca: ");
                    String marca = scan.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scan.nextLine();

                    System.out.print("Placa do veículo: ");
                    String placa = scan.nextLine().toUpperCase();

                    System.out.print("Deseja cadastrar o motor agora? (1 - Sim, 2 - Não): ");
                    int opc = scan.nextInt();
                    scan.nextLine();

                    if (opc == 1) {
                        System.out.print("Tipo do motor: ");
                        String tipo = scan.nextLine();
                        System.out.print("Potência do motor: ");
                        double potencia = scan.nextDouble();
                        scan.nextLine();

                        Motor motor = new Motor(tipo, potencia);
                        carros.add(new Carro(marca, modelo, placa, motor));
                    } else {
                        carros.add(new Carro(marca, modelo, placa));
                    }
                    System.out.println("Carro cadastrado!");
                    break;

                case 2:
                    System.out.print("Nome do condutor: ");
                    String nome = scan.nextLine();
                    System.out.print("CNH do condutor: ");
                    String cnh = scan.nextLine();

                    condutores.add(new Condutor(nome, cnh));
                    System.out.println("Condutor cadastrado!");
                    break;

                case 3:
                    if (carros.isEmpty() || condutores.isEmpty()) {
                        System.out.println("Cadastre pelo menos um carro e um condutor primeiro.");
                        break;
                    }

                    Carro carroSelecionado = null;
                    while (carroSelecionado == null) {
                        System.out.println("\nCarros cadastrados:");
                        for (Carro c : carros) {
                            System.out.println("- Placa: " + c.getPlaca() + " | Modelo: " + c.getModelo());
                        }

                        System.out.print("Digite a placa do carro: ");
                        String placaBusca = scan.nextLine().toUpperCase();
                        for (Carro c : carros) {
                            if (c.getPlaca().equals(placaBusca)) {
                                carroSelecionado = c;
                                break;
                            }
                        }

                        if (carroSelecionado == null) {
                            System.out.println("Carro não encontrado! Tente novamente.");
                        }
                    }

                    Condutor condutorEncontrado = null;
                    while (condutorEncontrado == null) {
                        System.out.println("\nCondutores cadastrados:");
                        for (Condutor c : condutores) {
                            System.out.println("- Nome: " + c.getNome() + " | CNH: " + c.getCnh());
                        }

                        System.out.print("Digite o número da CNH do condutor: ");
                        String cnhBusca = scan.nextLine();
                        for (Condutor c : condutores) {
                            if (c.getCnh().equals(cnhBusca)) {
                                condutorEncontrado = c;
                                break;
                            }
                        }

                        if (condutorEncontrado == null) {
                            System.out.println("Condutor com CNH " + cnhBusca + " não encontrado! Tente novamente.");
                        }
                    }

                    carroSelecionado.setCondutor(condutorEncontrado);
                    System.out.println("Condutor associado ao veículo!");
                    break;

                case 4:
                    if (carros.isEmpty()) {
                        System.out.println("Cadastre um carro primeiro.");
                        break;
                    }

                    System.out.println("\nCarros cadastrados:");
                    for (Carro c : carros) {
                        System.out.println("- Placa: " + c.getPlaca() + " | Modelo: " + c.getModelo());
                    }

                    System.out.print("Digite a placa do carro: ");
                    String placaMotor = scan.nextLine().toUpperCase();
                    Carro carroMotor = null;
                    for (Carro c : carros) {
                        if (c.getPlaca().equals(placaMotor)) {
                            carroMotor = c;
                            break;
                        }
                    }

                    if (carroMotor == null) {
                        System.out.println("Carro não encontrado.");
                        break;
                    }

                    System.out.print("Tipo do motor: ");
                    String tipo = scan.nextLine();
                    System.out.print("Potência do motor: ");
                    double potencia = scan.nextDouble();
                    scan.nextLine();

                    Motor novoMotor = new Motor(tipo, potencia);
                    carroMotor.setMotor(novoMotor);
                    System.out.println("Motor associado ao carro!");
                    break;

                case 5:
                    if (carros.isEmpty()) {
                        System.out.println("Não há veículos cadastrados.");
                    } else {
                        System.out.println("Veículos cadastrados:");
                        for (Carro c : carros) {
                            System.out.println(c);
                            System.out.print("\n");
                        }
                    }
                    break;

                case 6:
                    if (condutores.isEmpty()) {
                        System.out.println("Não há condutores cadastrados.");
                    } else {
                        System.out.println("Condutores cadastrados:");
                        for (Condutor c : condutores) {
                            System.out.println(c);
                            System.out.print("\n");
                        }
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (!end);

        scan.close();
    }
}
