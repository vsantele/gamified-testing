package be.thibber.gamification;

public class Person {
    private String name;

    public Person(String name) {
        setName(name);
    }

    /**
     * @return Get name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Set name
     */
    public void setName(String name) {
        this.name = name;
    }
}
