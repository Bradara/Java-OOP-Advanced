package GenericcScale;

public class Scale<T extends Comparable>{
    private T left;
    private T rigth;

    public Scale(T left, T rigth){
        this.left = left;
        this.rigth = rigth;
    }

    public T getHeavier(){
        if (this.rigth.compareTo(this.left) > 0) {
            return this.rigth;
        } else if(this.rigth.compareTo(this.left) < 0) {
            return this.left;
        }

        return null;
    }

}
