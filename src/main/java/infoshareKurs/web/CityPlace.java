package infoshareKurs.web;

class CityPlace {
    String name;
    Integer numOfPlaces;

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