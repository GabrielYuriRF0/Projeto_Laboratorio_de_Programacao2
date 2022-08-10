public class ActivityService {
    ActivityRepository ar;

    public String adicionaAtividade(Activity a){
        this.ar.adiciona(a);
        return a.getID();
    }
    public void encerrarAtividade(String ID){

    }

    public void desabilitarAtividade(String ID){

    }

    public void reabrirAtividade(String ID){

    }
}
