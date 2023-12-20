package com.logate.academy.zima23.Filters;

public class UserFilter {

    Integer fromAge;
    Integer toAge;
    String name;

    @Override
    public String toString() {
        return "UserFilter{" +
                "fromAge=" + fromAge +
                ", toAge=" + toAge +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getFromAge() {
        return fromAge;
    }

    public void setFromAge(Integer fromAge) {
        this.fromAge = fromAge;
    }

    public Integer getToAge() {
        return toAge;
    }

    public void setToAge(Integer toAge) {
        this.toAge = toAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
