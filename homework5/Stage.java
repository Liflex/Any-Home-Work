package geekbrains.homework5;

/**
 * Created by Tom on 10.08.2017.
 */
public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}

