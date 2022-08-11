package com.sapo.activity;

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
    public void endActivity(String id){
        var activity = this.ar.recoverActivity(id);
        if(activity.getStatus() == 0){
            activity.setStatus(2);
        }else{
            throw new IllegalArgumentException("Não é possivel encerrar atividades já encerradas ou desativadas");
        }
    }

    public void disableActivity(String id){
        var activity = this.ar.recoverActivity(id);
        if(activity.getStatus() == 0){
            activity.setStatus(1);
        }else{
            throw new IllegalArgumentException("Não é possivel desabilitar atividades já encerradas ou desativadas");
        }
    }

    public void reopenActivity(String id){
        var activity = this.ar.recoverActivity(id);
        if(activity.getStatus() != 0){
            activity.setStatus(0);
        }else{
            throw new IllegalArgumentException("Não é possivel reabrir uma atividade já aberta");
        }
    }
    public String displayActivity(String id){
        var activity = this.ar.recoverActivity(id);
        return activity.toString();
    }
    public void changeActivityDescription(String id, String descricao){
        var activity = this.ar.recoverActivity(id);
        activity.setDescription(descricao);
    }

    public void changeActivityResponsable(String id, String CPF){
        var activity = this.ar.recoverActivity(id);
        activity.setCPF(CPF);
    }


}
