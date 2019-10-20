package cm.agency.entity;

import java.util.Date;

public class as_role_premission {
    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String functionName;
    private String funcUrl;
    private Integer roleId;
    private Integer functionId;
    private Date creationTime;
    private String createdBy;
    private Date lastUpdateTime;
    private Integer isStart;
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getFunctionId() {
        return functionId;
    }
    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }
    public Date getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    public Integer getIsStart() {
        return isStart;
    }
    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }
}
