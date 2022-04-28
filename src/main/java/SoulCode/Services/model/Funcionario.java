package SoulCode.Services.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Funcionario {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer idFuncionario;

   @Column(nullable = false, length = 100)
   private String nome;

   @Column(nullable = false, length = 100, unique = true)
    private String email;

   @Column(nullable = true, length = 100)
   private String foto;

   @JsonIgnore
   @OneToMany(mappedBy = "funcionario")
   private List<Servico> servico = new ArrayList<>();

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}

