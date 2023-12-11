package chap06.Q02;

public class IntTypeData extends SpecificTypeData<Integer> {
    public IntTypeData(int data) {super(data);}
    // your code here

    @Override
    public void addData(Integer data) {
        if (super.data == null)
            throw new NullPointerException("Data in IntTypeData is null");
        super.data += data;
    }
}
