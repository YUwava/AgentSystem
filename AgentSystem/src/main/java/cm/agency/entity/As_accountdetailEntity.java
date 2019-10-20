package cm.agency.entity;

import java.util.List;

public class As_accountdetailEntity {
    public  int id;
    public  int userId;
    public  int detailType;
    public  String detailTypeName;
    public  double money;
    public  double accountMoney;
    public  String memo;
    public  String detailDateTime;

    private List<as_user> as_users;

    public List<as_user> getAs_users() {
        return as_users;
    }

    public void setAs_users(List<as_user> as_users) {
        this.as_users = as_users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDetailType() {
        return detailType;
    }

    public void setDetailType(int detailType) {
        this.detailType = detailType;
    }

    public String getDetailTypeName() {
        return detailTypeName;
    }

    public void setDetailTypeName(String detailTypeName) {
        this.detailTypeName = detailTypeName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(double accountMoney) {
        this.accountMoney = accountMoney;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDetailDateTime() {
        return detailDateTime;
    }

    public void setDetailDateTime(String detailDateTime) {
        this.detailDateTime = detailDateTime;
    }

    @Override
    public String toString() {
        return "As_accountdetailEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", detailType=" + detailType +
                ", detailTypeName='" + detailTypeName + '\'' +
                ", money=" + money +
                ", accountMoney=" + accountMoney +
                ", memo='" + memo + '\'' +
                ", detailDateTime='" + detailDateTime + '\'' +
                '}';
    }

}
