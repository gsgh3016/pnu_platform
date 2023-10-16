package chap05.Q03;

public class Professor extends Person {
    private String _major;
    private String _schoolName;

    public Professor(String name, int age, String address, String schoolName, String major) {
        super(name, age, address);
        this._schoolName = schoolName;
        this._major = major;
    }

    public void setMajor(String major) {this._major = major;}
    public String major() {return this._major;}
    public void setSchoolName(String schoolName) {this._schoolName = schoolName;}
    public String schoolName() {return this._schoolName;}

    @Override
    public String toString() {
        return String.format("%s, %d, %s, %s, %s",
                getName(), getAge(), getAddress(), _schoolName, _major);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Professor p = (Professor) obj;
        return (this._major.equals(p._major)) && (this._schoolName.equals(p._schoolName));
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
