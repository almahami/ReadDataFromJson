package json.mohammad.Models;

public class Entry {
    private String name;
    private int population;
    private ExtendedStatistics extendedStatistics;

    public Entry(String name, int population, ExtendedStatistics extendedStatistics) {
        this.name = name;
        this.population = population;
        this.extendedStatistics = extendedStatistics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public ExtendedStatistics getExtendedStatistics() {
        return extendedStatistics;
    }

    public void setExtendedStatistics(ExtendedStatistics extendedStatistics) {
        this.extendedStatistics = extendedStatistics;
    }

    @Override
    public String toString() {
        return "Entry [name=" + name + ", population=" + population + ", extendedStatistics=" + extendedStatistics
                + "]";
    }

}
