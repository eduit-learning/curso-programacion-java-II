package ServletsDB.Models;

public class ErrorKeyValuePair {
    private String propertyName;
    private String propertyValue;

    public ErrorKeyValuePair() {

    }

    public ErrorKeyValuePair(String propertyName, String propertyValue) {
        this.setPropertyName(propertyName);
        this.setPropertyValue(propertyValue);
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
