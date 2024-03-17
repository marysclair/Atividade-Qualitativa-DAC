package com.projeto.adocaoDeAnimais.main;

import com.projeto.adocaoDeAnimais.dao.AdocaoDao;
import com.projeto.adocaoDeAnimais.dao.AnimalDao;
import com.projeto.adocaoDeAnimais.dao.TutorDao;
import com.projeto.adocaoDeAnimais.entities.Animal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int opcao = 0, opcao2 = 0;
        @SuppressWarnings("resource")
        Scanner inserir = new Scanner(System.in);

        TutorDao tutorDao = new TutorDao();
        AnimalDao animalDao = new AnimalDao();
        AdocaoDao adocaoDao = new AdocaoDao();

        do{
            System.out.println("[1] - CRUD DE TUTOR");
            opcao = inserir.nextInt();
            if(opcao == 1){
                System.out.println("[1] - Cadastrar Tutor");
                System.out.println("[2] - Buscar Tutor por ID");
                System.out.println("[3] - Buscar todos os Tutores");
                System.out.println("[4] - Atualizar telefone e endereco de tutor");
                System.out.println("[5] - Excluir tutor");
                opcao2 = inserir.nextInt();
                
                if(opcao2 == 1){
                    tutorDao.insereTutor(null);
                } else if(opcao2 == 2){
                    tutorDao.buscaTutorPorId(null);
                } else if(opcao2 == 3){
                    tutorDao.buscaTodosTutores();
                } else if(opcao2 == 3){
                    tutorDao.atualizaTutor(null);
                } else if(opcao2 == 4){
                    tutorDao.deletaTutor(null);
                } else {
                    System.out.println("OPCAO INVALIDA");
                }
            }
        }while(opcao!=0);

        do{
            System.out.println("[2] - CRUD DE ANIMAL");
            opcao = inserir.nextInt();
            if(opcao == 1){
                System.out.println("[1] - Cadastrar Animal");
                System.out.println("[2] - Buscar animal por ID");
                System.out.println("[3] - Buscar todos os Animais");
                System.out.println("[4] - Atualizar nome, data de nascimento, personalidade, espécie e raça");
                System.out.println("[5] - Excluir Animal");
                opcao2 = inserir.nextInt();

                switch (opcao2){
                    case 1:
                    Animal novoAnimal = new Animal();
                    System.out.println("Informe a data de nascimento (yyyy-mm-dd): ");
                    novoAnimal.setDataNascimento(LocalDate.parse(inserir.next(), DATEFORMATTER));
                    System.out.println("Informe o nome do animal: ");
                    novoAnimal.setNome(inserir.next());
                    System.out.println("Informe a personalidade do animal: ");
                    novoAnimal.setPersonalidade(inserir.next());
                    System.out.println("Informe a espécie do animal: ");
                    novoAnimal.setEspecie(inserir.next());
                    System.out.println("Informe a raça do animal: ");
                    novoAnimal.setRaca(inserir.next());
                    animalDao.insereAnimal(novoAnimal);
                    break;
                    case 2:
                    System.out.println("Informe o ID do animal a ser buscado: ");
                    long idBusca = inserir.nextLong();
                    Animal animalEncontrado = animalDao.buscaAnimalPorId(idBusca);
                    if (animalEncontrado != null) {
                        System.out.println("Animal encontrado: " + animalEncontrado);
                    } else {
                        System.out.println("Animal não encontrado.");
                    }
                    break;
                 case 3:
                    ArrayList<Animal> todosAnimais = animalDao.buscaTodosAnimais();
                    if (!todosAnimais.isEmpty()) {
                        for (Animal animal : todosAnimais) {
                            System.out.println(animal);
                        }
                    } else {
                        System.out.println("Não há animais cadastrados.");
                    }
                    break;
                case 4:
                    System.out.println("Informe o ID do animal a ser atualizado: ");
                    long idAtualizacao = inserir.nextLong();
                    Animal animalParaAtualizar = animalDao.buscaAnimalPorId(idAtualizacao);
                    if (animalParaAtualizar != null) {
                        System.out.println("Informe o novo nome do animal: ");
                        animalParaAtualizar.setNome(inserir.next());
                        System.out.println("Informe a nova data de nascimento do animal (yyyy-mm-dd): ");
                        animalParaAtualizar.setDataNascimento(LocalDate.parse(inserir.next(), DATEFORMATTER));
                        System.out.println("Informe a nova personalidade do animal: ");
                        animalParaAtualizar.setPersonalidade(inserir.next());
                        System.out.println("Informe a nova espécie do animal: ");
                        animalParaAtualizar.setEspecie(inserir.next());
                        System.out.println("Informe a nova raça do animal: ");
                        animalParaAtualizar.setRaca(inserir.next());
                        animalDao.atualizaAnimal(animalParaAtualizar);
                        System.out.println("Animal atualizado com sucesso.");
                    } else {
                        System.out.println("Animal não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Informe o ID do animal a ser excluído: ");
                    long idExclusao = inserir.nextLong();
                    animalDao.deletaAnimal(idExclusao);
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
            }
        }}while(opcao!=0);

        do{
            System.out.println("[2] - CRUD DE ADOÇÃO");
            opcao = inserir.nextInt();
            if(opcao == 1){
                System.out.println("[1] - Cadastrar Adoção");
                System.out.println("[2] - Buscar adoção por ID");
                System.out.println("[3] - Buscar todos as Adoções");
                System.out.println("[4] - Atualizar tutor, animal, data e motivo");
                System.out.println("[5] - Excluir Adoção");
                opcao2 = inserir.nextInt();

                if(opcao2 == 1){
                    adocaoDao.insereAdocao(null);
                } else if(opcao2 == 2){
                    adocaoDao.buscaAdocaoPorId(null);
                } else if(opcao2 == 3){
                    adocaoDao.buscaTodasAdocoes();
                } else if(opcao2 == 3){
                    adocaoDao.atualizaAdocao(null);
                } else if(opcao2 == 4){
                    adocaoDao.deletaAdocao(null);
                } else {
                    System.out.println("OPCAO INVALIDA");
                }
            }
        }while(opcao!=0);
    }
}
