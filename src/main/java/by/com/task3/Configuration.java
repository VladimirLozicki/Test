package by.com.task3;


public class Configuration {

    private String path;
    private String fileNames;
    private String suffix;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileNames() {
        return fileNames;
    }

    public void setFileNames(String fileNames) {
        this.fileNames = fileNames;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "path='" + path + '\'' +
                ", filename='" + fileNames + '\'' +
                ", suffix='" + suffix + '\'' + '}';
    }
}
