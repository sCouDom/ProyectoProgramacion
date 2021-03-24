package gameObjects;

public class Cronometro {
    private long delta, ultimoTiempo;
    private long tiempo;
    private boolean funcionando;

    public Cronometro(){
        delta=0;
        ultimoTiempo =0;
        funcionando =false;
    }

    public void run(long time){
        funcionando =true;
        this.tiempo =time;
    }

    public void update(){
        if(funcionando)
            delta+=System.currentTimeMillis()- ultimoTiempo;
        if(delta>= tiempo){
            funcionando =false;
        }
        ultimoTiempo = System.currentTimeMillis();
    }

    public boolean isFuncionando(){
        return funcionando;
    }
}
