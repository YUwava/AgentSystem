package cm.agency.entity;

import java.math.BigDecimal;
import java.util.Date;

public class as_accountDetail {
    private Integer userId;
    private Integer detailType;
    private String  detailTypeName;
    private BigDecimal money;
    private BigDecimal accountMoney;
    private String memo;
    private Date detailDateTime;
    private String userName;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getDetailType() {
        return detailType;
    }
    public void setDetailType(Integer detailType) {
        this.detailType = detailType;
    }

    public String getDetailTypeName() {
        return detailTypeName;
    }
    public void setDetailTypeName(String detailTypeName) {
        this.detailTypeName = detailTypeName;
    }
    public BigDecimal getMoney() {
        return money;
    }
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    public BigDecimal getAccountMoney() {
        return accountMoney;
    }
    public void setAccountMoney(BigDecimal accountMoney) {
        this.accountMoney = accountMoney;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public Date getDetailDateTime() {
        return detailDateTime;
    }
    public void setDetailDateTime(Date detailDateTime) {
        this.detailDateTime = detailDateTime;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
