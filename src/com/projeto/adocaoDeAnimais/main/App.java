package com.projeto.adocaoDeAnimais.main;

import java.util.Scanner;

import com.projeto.adocaoDeAnimais.dao.TutorDao;

public class App {
    public static void main(String[] args) throws Exception {
        int opcao = 0, opcao2 = 0;
        @SuppressWarnings("resource")
        Scanner inserir = new Scanner(System.in);

        TutorDao tutorDao = new TutorDao();

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
    }
}
