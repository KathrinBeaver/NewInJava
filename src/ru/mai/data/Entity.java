package ru.mai.data;

public class Entity {

    private int count = 0;
    private String key;
    private Integer value;

    public Entity(int count, String key, Integer value) {
        this.count = count;
        this.key = key;
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
