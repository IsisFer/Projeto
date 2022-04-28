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


    //relacionamento de muitos para um
    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private Funcionario funcionario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idOrcamento", unique = true)
    private Orcamento orcamento;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
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

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}