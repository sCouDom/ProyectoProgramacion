package matematica;

public class Vector {


    private double x,y;

    public Vector(double x, double y){
        this.x=x;
        this.y=y;
    }

    public Vector(){
        x=0;
        y=0;
    }

    /*
    public Vector sumar(Vector v);
    public Vector restar(Vector v);
    public Vector porEscalar(double valor);
    public Vector limitar(double valor);
    public Vector getMagnitud();
    public Vector setDireccion(double angulo);
    Getters y setters
    */



    public Vector sumar(Vector v){
        return new Vector(x + v.getX(), y + v.getY());
    }

    public Vector restar(Vector v){
        return new Vector(x - v.getX(), y - v.getY());
    }


    public Vector porEscalar(double value){
        return new Vector(x*value,y*value);
    }

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

    public double getMagnitud(){
        return Math.sqrt(x*x+y*y);
    }

    public Vector setDireccion(double angle){
        return new Vector(Math.cos(angle)* getMagnitud(), Math.sin(angle)* getMagnitud());
    }

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
