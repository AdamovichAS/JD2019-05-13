package by.it.tbabich.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        String[] arrayString = strVector.replace("{", "").replace("}", "").split(",");
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        this.value = Arrays.copyOf(arrayDouble, arrayDouble.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += s;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] v = ((Vector) other).value;
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += v[i];
            }
            return new Vector(res);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= s;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] v = ((Vector) other).value;
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= v[i];
            }
            return new Vector(res);
        } else return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] *= s;
            }
            return new Vector(res);
        } else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] vector1 = ((Vector) other).value;
            double[] vector2 = Arrays.copyOf(value, value.length);
            double result = 0;
            for (int i = 0; i < vector2.length; i++) {
                result += vector2[i] * vector1[i];
            }
            return new Scalar(result);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(value, value.length);
//            double result = 0;
            for (int i = 0; i < res.length; i++) {
                res[i] /= s;
            }
            return new Vector(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
            if (i == value.length - 1) {
                sb.append("}");
                break;
            }
            sb.append(", ");
        }
        return sb.toString();
    }
}
