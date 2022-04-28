package SoulCode.Services.model;

public enum StatusServico {

    RECEBIDO("Recebido"),
    ATRIBUIDO("Atribuido"),
    CONCLUIDO("Concluido"),
    ARQUIVADO ("Arquivado");

    private String descricao;

    private StatusServico(String descricao) {
        this.descricao = descricao;
    }

    //get do atributo descricao
    public String getDescricao() {
        return descricao;
    }




}
