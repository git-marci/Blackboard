package ires.corso.parttwo.compare;

import java.util.Objects;

public abstract class AbstractFruit
{
    private String theType;

    public String getTheType() {
        return theType;
    }

    public void setTheType(String theType) {
        this.theType = theType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFruit that = (AbstractFruit) o;
        return Objects.equals(getTheType(), that.getTheType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTheType());
    }
}
