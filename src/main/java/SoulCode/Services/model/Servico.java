package SoulCode.Services.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Servico {

    @Id //chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServico;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(columnDefinition = "Date")
    private Date dataEntrada;

    //esse atributo vai ser um enum - é um atributo personalizado que nós vamos criar e daremos o nome de StatusServico
    @Enumerated(EnumType.STRING)
    private StatusServico status;

    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private Funcionario funcionario;

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServiço(Integer idServiço) {
        this.idServico = idServiço;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public StatusServico getStatus() {
        return status;
    }

    public void setStatus(StatusServico status) {
        this.status = status;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


}