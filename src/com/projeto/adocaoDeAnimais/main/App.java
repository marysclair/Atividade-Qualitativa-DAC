package com.projeto.adocaoDeAnimais.main;

import com.projeto.adocaoDeAnimais.dao.AdocaoDao;
import com.projeto.adocaoDeAnimais.dao.AnimalDao;
import com.projeto.adocaoDeAnimais.dao.TutorDao;
import com.projeto.adocaoDeAnimais.entities.Adocao;
import com.projeto.adocaoDeAnimais.entities.Animal;
import com.projeto.adocaoDeAnimais.entities.Tutor;

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
            System.out.println("[2] - CRUD DE ANIMAL");
            System.out.println("[3] - CRUD DE ADOÇÃO");
            System.out.println("[0] - SAIR");
            opcao = inserir.nextInt();
            switch (opcao) {
                case 1:
                    do{
                        System.out.println("\n[1] - Cadastrar Tutor");
                        System.out.println("[2] - Buscar Tutor por ID");
                        System.out.println("[3] - Buscar todos os Tutores");
                        System.out.println("[4] - Atualizar telefone e endereco de tutor");
                        System.out.println("[5] - Excluir tutor");
                        System.out.println("[0] - Voltar para o menu principal");
                        opcao2 = inserir.nextInt();
                        System.out.println();
                        
                        switch (opcao2) {
                            case 1:
                                Tutor novoTutor = new Tutor();
                                inserir.nextLine();
                                System.out.println("Informe o nome do tutor: ");
                                novoTutor.setNome(inserir.nextLine());
                                System.out.println("Informe o endereco do tutor: ");
                                novoTutor.setEndereco(inserir.nextLine());
                                System.out.println("Informe o telefone do tutor: ");
                                novoTutor.setTelefone(inserir.nextLine());
                                System.out.println("Informe o cpf do tutor: ");
                                novoTutor.setCpf(inserir.nextLine());
                                Tutor tutorInserido = tutorDao.insereTutor(novoTutor);
                                if(tutorInserido != null){
                                    System.out.println("\nTutor " + tutorInserido.getNome() + " cadastrado com sucesso!");
                                } else{
                                    System.out.println("\nErro ao cadastrar tutor.");
                                }
                            break;
                            case 2:
                                inserir.nextLine();
                                System.out.println("Informe o ID do tutor a ser buscado: ");
                                long idBusca = inserir.nextLong();
                                Tutor tutorEncontrado = tutorDao.buscaTutorPorId(idBusca);
                                if (tutorEncontrado != null) {
                                    System.out.println("\nTutor encontrado: \n" + tutorEncontrado);
                                } else {
                                    System.out.println("\nTutor não encontrado.");
                                }
                            break;
                            case 3:
                                inserir.nextLine();
                                ArrayList<Tutor> todosTutores = tutorDao.buscaTodosTutores();
                                if (!todosTutores.isEmpty()) {
                                    for (Tutor tutor : todosTutores) {
                                        System.out.println(tutor);
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("Não há tutores cadastrados.");
                                }
                            break;
                            case 4:
                                inserir.nextLine();
                                System.out.println("Informe o ID do tutor a ser atualizado: ");
                                long idAtualizacao = inserir.nextLong();
                                Tutor tutorParaAtualizar = tutorDao.buscaTutorPorId(idAtualizacao);
                                if (tutorParaAtualizar != null) {
                                    System.out.println("Informe o novo telefone do tutor: ");
                                    tutorParaAtualizar.setTelefone(inserir.nextLine());
                                    System.out.println("Informe o novo endereco do tutor: ");
                                    tutorParaAtualizar.setEndereco(inserir.nextLine());
                                    tutorDao.atualizaTutor(tutorParaAtualizar);
                                    System.out.println("Tutor atualizado com sucesso.");
                                } else {
                                    System.out.println("Tutor não encontrado.");
                                }
                            break;
                            case 5:
                                inserir.nextLine();
                                System.out.println("Informe o ID do tutor a ser excluído: ");
                                long idExclusao = inserir.nextLong();
                                tutorDao.deletaTutor(idExclusao);
                            break;
                            default:
                            break;
                        }
                    }while(opcao2!=0);
                break;
                case 2:
                    do{
                            System.out.println();
                            System.out.println("[1] - Cadastrar Animal");
                            System.out.println("[2] - Buscar animal por ID");
                            System.out.println("[3] - Buscar todos os Animais");
                            System.out.println("[4] - Atualizar nome, data de nascimento, personalidade, espécie e raça");
                            System.out.println("[5] - Excluir Animal");
                            System.out.println("[0] - Voltar para o menu principal");
                            opcao2 = inserir.nextInt();
                            System.out.println();
        
                            switch (opcao2){
                                case 1:
                                    inserir.nextLine();
                                    Animal novoAnimal = new Animal();
                                    System.out.println("Informe a data de nascimento (yyyy-mm-dd): ");
                                    novoAnimal.setDataNascimento(LocalDate.parse(inserir.next(), DATEFORMATTER));
                                    inserir.nextLine();
                                    System.out.println("Informe o nome do animal: ");
                                    novoAnimal.setNome(inserir.nextLine());
                                    System.out.println("Informe a personalidade do animal: ");
                                    novoAnimal.setPersonalidade(inserir.nextLine());
                                    System.out.println("Informe a espécie do animal: ");
                                    novoAnimal.setEspecie(inserir.nextLine());
                                    System.out.println("Informe a raça do animal: ");
                                    novoAnimal.setRaca(inserir.nextLine());
                                    Animal animalInserido = animalDao.insereAnimal(novoAnimal);
                                    if(animalInserido != null){
                                        System.out.println("Animal " + animalInserido.getNome() + " cadastrado com sucesso!");
                                    } else{
                                        System.out.println("Erro ao cadastrar animal.");
                                    }
                                break;
                                case 2:
                                    inserir.nextLine();
                                    System.out.println("Informe o ID do animal a ser buscado: ");
                                    long idBusca = inserir.nextLong();
                                    Animal animalEncontrado = animalDao.buscaAnimalPorId(idBusca);
                                    if (animalEncontrado != null) {
                                        System.out.println("\nAnimal encontrado: \n" + animalEncontrado);
                                    } else {
                                        System.out.println("\nAnimal não encontrado.");
                                    }
                                break;
                                case 3:
                                    inserir.nextLine();
                                    ArrayList<Animal> todosAnimais = animalDao.buscaTodosAnimais();
                                    if (!todosAnimais.isEmpty()) {
                                        for (Animal animal : todosAnimais) {
                                            System.out.println(animal);
                                            System.out.println();
                                        }
                                    } else {
                                        System.out.println("Não há animais cadastrados.");
                                    }
                                    break;
                                case 4:
                                    inserir.nextLine();
                                    System.out.println("Informe o ID do animal a ser atualizado: ");
                                    long idAtualizacao = inserir.nextLong();
                                    Animal animalParaAtualizar = animalDao.buscaAnimalPorId(idAtualizacao);
                                    if (animalParaAtualizar != null) {
                                        System.out.println("Informe o novo nome do animal: ");
                                        animalParaAtualizar.setNome(inserir.nextLine());
                                        System.out.println("Informe a nova data de nascimento do animal (yyyy-mm-dd): ");
                                        animalParaAtualizar.setDataNascimento(LocalDate.parse(inserir.next(), DATEFORMATTER));
                                        System.out.println("Informe a nova personalidade do animal: ");
                                        animalParaAtualizar.setPersonalidade(inserir.nextLine());
                                        System.out.println("Informe a nova espécie do animal: ");
                                        animalParaAtualizar.setEspecie(inserir.nextLine());
                                        System.out.println("Informe a nova raça do animal: ");
                                        animalParaAtualizar.setRaca(inserir.nextLine());
                                        animalDao.atualizaAnimal(animalParaAtualizar);
                                        System.out.println("Animal atualizado com sucesso.");
                                    } else {
                                        System.out.println("Animal não encontrado.");
                                    }
                                    break;
                                case 5:
                                    inserir.nextLine();
                                    System.out.println("Informe o ID do animal a ser excluído: ");
                                    long idExclusao = inserir.nextLong();
                                    animalDao.deletaAnimal(idExclusao);
                                    break;
                                default:
                                    System.out.println("OPCAO INVALIDA");
                                break;
                        }
                    }while(opcao2!=0);
                break;
                case 3:
                    do{
                        System.out.println();
                        System.out.println("\n[1] - Cadastrar Adoção");
                        System.out.println("[2] - Buscar adoção por ID");
                        System.out.println("[3] - Buscar todos as Adoções");
                        System.out.println("[4] - Atualizar tutor, animal, data e motivo");
                        System.out.println("[5] - Excluir Adoção");
                        System.out.println("[0] - Voltar ao menu principal");
                        opcao2 = inserir.nextInt();
                        System.out.println();

                        switch (opcao2) {
                            case 1:
                                inserir.nextLine();
                                System.out.println("Informe o ID do tutor a ser buscado: ");
                                long idBusca = inserir.nextLong();
                                Tutor tutorEncontrado = tutorDao.buscaTutorPorId(idBusca);
                                if (tutorEncontrado == null) {
                                    System.out.println("\nTutor não encontrado.");
                                    break;
                                } 
                                System.out.println("Informe o ID do animal a ser buscado: ");
                                idBusca = inserir.nextLong();
                                Animal animalEncontrado = animalDao.buscaAnimalPorId(idBusca);
                                if (animalEncontrado == null) {
                                    System.out.println("Animal não encontrado.");
                                    break;
                                } 
                                Adocao novaAdocao = new Adocao();
                                inserir.nextLine();
                                System.out.println("Informe o motivo da adocao: ");
                                novaAdocao.setMotivo(inserir.nextLine());
                                novaAdocao.setTutor(tutorEncontrado);
                                novaAdocao.setAnimal(animalEncontrado);
                                novaAdocao.setData(LocalDate.now());
                                adocaoDao.insereAdocao(novaAdocao);
                                System.out.println("Adoção realizada!");
                            break;
                            case 2:
                                inserir.nextLine();
                                System.out.println("Informe o ID da adocao: ");
                                idBusca = inserir.nextLong();
                                Adocao adocaoEncontrada = adocaoDao.buscaAdocaoPorId(idBusca);
                                if (adocaoEncontrada != null) {
                                    System.out.println("\nAdocao encontrada: " + adocaoEncontrada);
                                } else {
                                    System.out.println("\nAdocao não encontrada.");
                                }
                            break;
                            case 3:
                                inserir.nextLine();
                                ArrayList<Adocao> todasAdocoes = adocaoDao.buscaTodasAdocoes();
                                if (!todasAdocoes.isEmpty()) {
                                    for (Adocao adocao : todasAdocoes) {
                                        System.out.println(adocao);
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("Não há adoções cadastradas.");
                                }
                            break;
                            case 4:
                                inserir.nextLine();
                                System.out.println("Informe o ID do tutor a ser atualizado: ");
                                long idAtualizacao = inserir.nextLong();
                                Tutor tutorParaAtualizar = tutorDao.buscaTutorPorId(idAtualizacao);
                                if (tutorParaAtualizar != null) {
                                    System.out.println("Informe o novo telefone do tutor: ");
                                    tutorParaAtualizar.setTelefone(inserir.nextLine());
                                    System.out.println("Informe o novo endereco do tutor: ");
                                    tutorParaAtualizar.setEndereco(inserir.nextLine());
                                    tutorDao.atualizaTutor(tutorParaAtualizar);
                                    System.out.println("Tutor atualizado com sucesso.");
                                } else {
                                    System.out.println("Tutor não encontrado.");
                                }
                            break;
                            case 5:
                                inserir.nextLine();
                                System.out.println("Informe o ID da adocao a ser excluída: ");
                                long idExclusao = inserir.nextLong();
                                adocaoDao.deletaAdocao(idExclusao);
                            break;
                            default:
                            break;
                        } 
                    }while(opcao!=0);   
                break;
                default:
                    break;
            }
        } while(opcao!=0);
        
    }
}
