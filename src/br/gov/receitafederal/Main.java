package br.gov.receitafederal;

import br.gov.receitafederal.model.User;
import br.gov.receitafederal.repository.UserRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        save();
        System.out.println("CRUD Realizado");
    }

    public static void save(){
        User user = new User(1, "Vinicius Oliveira de Freitas", "vinicius.vof@outlook.com", "084.250.799-00", "123456");
        user.setFullName("Vinicius Oliveira de Freitas");
        user.setEmail("vinicius.vof@outlook.com");
        user.setCpf("084.250.799-00");
        user.setPassword("12345678");
        UserRepository.save(user);
    }

    public static void update(){
        User user = new User(1, "Vinicius Oliveira de Freitas", "084.250.799-00","vinicius.vof@outlook.com", "123456");
        UserRepository.update(user);
    }

    public static void delete(){
        User user = new User();
        user.setId(1);
        UserRepository.delete(user);
    }
}
