package cm.agency.entity;

public class as_systemconfigEntity {
    public  int id;
    public  int configType;
    public  String configTypeName;
    public  int configTypeValue;
    public  String configValue;
    public  int isStart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConfigType() {
        return configType;
    }

    public void setConfigType(int configType) {
        this.configType = configType;
    }

    public String getConfigTypeName() {
        return configTypeName;
    }

    public void setConfigTypeName(String configTypeName) {
        this.configTypeName = configTypeName;
    }

    public int getConfigTypeValue() {
        return configTypeValue;
    }

    public void setConfigTypeValue(int configTypeValue) {
        this.configTypeValue = configTypeValue;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public int getIsStart() {
        return isStart;
    }

    public void setIsStart(int isStart) {
        this.isStart = isStart;
    }

    @Override
    public String toString() {
        return "as_systemconfigEntity{" +
                "id=" + id +
                ", configType=" + configType +
                ", configTypeName='" + configTypeName + '\'' +
                ", configTypeValue=" + configTypeValue +
                ", configValue='" + configValue + '\'' +
                ", isStart=" + isStart +
                '}';
    }
}
