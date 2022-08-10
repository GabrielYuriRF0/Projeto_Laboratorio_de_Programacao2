public class ActivityService {
    ActivityRepository ar;

    public String addActivity(Activity a){
        if(a.getStatus() == 0){
            this.ar.addActivity(a);
            return a.getID();
        }else{
            throw new IllegalArgumentException("Não é possivel adicionar uma nova atividade com a atividade indisponível");
        }
    }
    public void endActivity(String ID){
        var activity = this.ar.recoverActivity(ID);
        if(activity.getStatus() == 0){
            activity.setStatus(2);
        }else{
            throw new IllegalArgumentException("Não é possivel encerrar atividades já encerradas ou desativadas");
        }
    }

    public void disableActivity(String ID){
        var activity = this.ar.recoverActivity(ID);
        if(activity.getStatus() == 0){
            activity.setStatus(1);
        }else{
            throw new IllegalArgumentException("Não é possivel desabilitar atividades já encerradas ou desativadas");
        }
    }

    public void reopenActivity(String ID){
        var activity = this.ar.recoverActivity(ID);
        if(activity.getStatus() != 0){
            activity.setStatus(0);
        }else{
            throw new IllegalArgumentException("Não é possivel reabrir uma atividade já aberta");
        }
    }
    public String displayActivity(String ID){
        var activity = this.ar.recoverActivity(ID);
        return activity.toString();
    }
    public void changeActivityDescription(String ID, String descricao){
        var activity = this.ar.recoverActivity(ID);
        activity.setDescription(descricao);
    }

    public void changeActivityResponsable(String ID, String CPF){
        var activity = this.ar.recoverActivity(ID);
        activity.setCPF(CPF);
    }


}
