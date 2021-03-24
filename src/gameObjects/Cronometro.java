package gameObjects;
/**
 * Clase encargada del contador de tiempo que pasa en cada partida.
 */
public class Cronometro {
    private long delta, ultimoTiempo;
    private long tiempo;
    private boolean funcionando;
    /**
     * Constructor de cronómetro con valores por defecto.
     */
    public Cronometro(){
        delta=0;
        ultimoTiempo =0;
        funcionando =false;
    }
    /**
     * Método que hace que el juego empiece a contar el tiempo que pasa.
     */
    public void run(long time){
        funcionando =true;
        this.tiempo =time;
    }
    /**
     * Método encargado de actualizar el contador.
     */
    public void update(){
        if(funcionando)
            delta+=System.currentTimeMillis()- ultimoTiempo;
        if(delta>= tiempo){
            funcionando =false;
        }
        ultimoTiempo = System.currentTimeMillis();
    }
    /**
     * Método que se asegura de que el cronómetro esté funcionando.
     * @return
     */
    public boolean isFuncionando(){
        return funcionando;
    }
}
