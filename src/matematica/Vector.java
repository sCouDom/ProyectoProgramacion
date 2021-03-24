package matematica;
/**
 * Definición de operaciones matemáticas con vectores.
 */
public class Vector {


    private double x,y;
    /**
     * Constructor parametrizadod de Vector.
     * @param x
     * @param y
     */
    public Vector(double x, double y){
        this.x=x;
        this.y=y;
    }
    /**
     * Constructor por defecto.
     */
    public Vector(){
        x=0;
        y=0;
    }
    /**
     * Suma de vectores.
     * @param v
     * @return
     */
    public Vector sumar(Vector v){
        return new Vector(x + v.getX(), y + v.getY());
    }
    /**
     * Resta de vectores.
     * @param v
     * @return
     */
    public Vector restar(Vector v){
        return new Vector(x - v.getX(), y - v.getY());
    }

    /**
     * Multiplicacion de un vector por una magnitud escalar.
     * @param value
     * @return
     */
    public Vector porEscalar(double value){
        return new Vector(x*value,y*value);
    }
    /**
     * Limitación del modulo de un vector.
     * @param value
     */
    public void limitar(double value){
        if(x>value){
            x=value;
        }
        if(x< -value){
            x=-value;
        }
        if(y>value){
            y=value;
        }
        if(y< -value){
            y=-value;
        }
    }
    /**
     * Devuelve la magnitud de un vector.
     * @return
     */
    public double getMagnitud(){
        return Math.sqrt(x*x+y*y);
    }
    /**
     * Define la dirección de un vector.
     * @param angle
     * @return
     */
    public Vector setDireccion(double angle){
        return new Vector(Math.cos(angle)* getMagnitud(), Math.sin(angle)* getMagnitud());
    }
    /**
     * Getters y setters.
     * @return
     */
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


}
