package chap05.Q02;

public enum Grade {
    FRESH(1),
    SOPHOMORE(2),
    JUNIOR(3),
    SENIOR(4);

    private int gradeValue;

    private Grade(int gradeValue) {
        this.gradeValue = gradeValue;
    }

    public int getGradeValue() {
        return gradeValue;
    }

    public Grade upGrade() {
        switch (this) {
            case FRESH:
                return SOPHOMORE;
            case SOPHOMORE:
                return JUNIOR;
            case JUNIOR:
                return SENIOR;
            default:
                throw new IllegalStateException("Cannot upgrade from SENIOR");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(gradeValue);
    }
}
