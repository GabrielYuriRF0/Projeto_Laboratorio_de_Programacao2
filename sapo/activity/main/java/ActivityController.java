public class ActivityController {
    private ActivityService as;

    public String cadastrarAtividade(String nome, String descricao, String CPF){
        return this.as.adicionaAtividade(new Activity(nome, descricao, CPF));
    }

    public void encerrarAtividade(String ID){
        this.as.encerrarAtividade(ID);
    }

    public void desabilitarAtividade(String ID){
        this.as.desabilitarAtividade(ID);
    }

    public void reabrirAtividade(String ID){
        this.as.reabrirAtividade(ID);
    }

    public String exibirAtividade(String ID){
        return this.as.exibirAtividade(ID);
    }

    public void alterarDescricaoAtividade(String ID, String descricao){
        this.as.alterarDescricaoAtividade(ID, descricao);
    }

    public void alterarResponsavelAtividade(String ID, String CPF){
        this.as.alterarResponsavelAtividade(ID, CPF);
    }
}
