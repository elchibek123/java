public enum Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    Days() {

    }

    public void someMethod() {
        System.out.println("This is enum method");
    }

    @Override
    public String toString() {
        return "Days{ " + Days.MONDAY;
    }
}
