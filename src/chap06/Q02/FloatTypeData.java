package chap06.Q02;

public class FloatTypeData extends SpecificTypeData<Float> {
    public FloatTypeData(float data) {super(data);}
    // your code here

    @Override
    public void addData(Float data) {
        if (super.data == null)
            throw new NullPointerException("Data in FloatTypeData is null");
        super.data += data;
    }
}
