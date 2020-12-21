public class Phone
{
    protected String name;
    protected long number;

    public Phone() {
        this("None", -1);
    }

    public Phone(String name) {
        this(name, -1);
    }

    public Phone(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }
}
