package by.it.yakimovich.jd01_09;

class Scalar extends Var {

   private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }
      Scalar(String strScalar) {
          this.value = Double.parseDouble(strScalar);
      }

      Scalar(Scalar scalar){
          this.value=scalar.value;}


    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum=this.value+((Scalar) other).value;
        return new Scalar(sum);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double min=this.value-((Scalar) other).value;
            return new Scalar(min);
        }
        else
            return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double mul=this.value*((Scalar) other).value;
            return new Scalar(mul);
        }
        else
            return other.mul(this);
            }

   @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            if (this.value!=0){
            double div=this.value/((Scalar) other).value;
            return new Scalar(div);
        }
        else
                return super.div(this);

    }return super.div(this);
}
}

