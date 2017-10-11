package infoshareKurs;


public class Country {

    private String name;

    private Double latitude;

    private Double longitude;

    public Country(Double latitude, Double longitude, String name, String country) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = country;
    }

    public static class FilePath {
        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        private String filePath;

    }
}
