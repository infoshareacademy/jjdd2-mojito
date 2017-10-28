package infoshareKurs.web;

public class CityPlace {
    private String name;
    private Integer numOfPlaces;

    public CityPlace() {
    }

    public CityPlace(String name, Integer numOfPlaces) {
        this.name = name;
        this.numOfPlaces = numOfPlaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumOfPlaces() {
        return numOfPlaces;
    }

    public void setNumOfPlaces(Integer numOfPlaces) {
        this.numOfPlaces = numOfPlaces;
    }
}
