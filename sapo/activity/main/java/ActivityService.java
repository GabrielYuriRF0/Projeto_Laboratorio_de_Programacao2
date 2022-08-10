public class ActivityService {
    ActivityRepository ar;

    public String adicionaAtividade(Activity a){
        this.ar.add(a);
        return a.getID();
    }
    public void encerrarAtividade(String ID){
        var activity = this.ar.recoverActivity(ID);
        activity.setStatus(2);
    }

    public void desabilitarAtividade(String ID){
        var activity = this.ar.recoverActivity(ID);
        activity.setStatus(1);
    }

    public void reabrirAtividade(String ID){
        var activity = this.ar.recoverActivity(ID);
        activity.setStatus(0);
    }

    public void alterarDescricaoAtividade(String ID, String descricao){
        var activity = this.ar.recoverActivity(ID);
        activity.setDescription(descricao);
    }

    public void alterarResponsavelAtividade(String ID, String CPF){
        var activity = this.ar.recoverActivity(ID);
        activity.setCPF(CPF);
    }
    public String exibirAtividade(String ID){
        var activity = this.ar.recoverActivity(ID);
        return activity.toString();
    }
}
