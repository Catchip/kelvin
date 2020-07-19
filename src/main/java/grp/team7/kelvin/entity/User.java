package grp.team7.kelvin.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import grp.team7.kelvin.utils.*;

public class User {
    @JSONField(name="userId")
    private Integer userId;// 用户ID
    @JSONField(name="userName")
    private String userName;// 用户姓名
    @JSONField(name="userSex")
    private Integer userSex;// 用户性别，1为男性，0为女性
    @JSONField(name="userAccount")
    private String userAccount;// 用户名称
    @JSONField(name="userPasswordsha256")
    private String userPasswordsha256; // 用户密码
    @JSONField(name="userMail")
    private String userMail;// 用户邮箱
    @JSONField(name="userPicture")
    private String userPicture; //用户头像图片
    @JSONField(name="userTelephone")
    private String userTelephone; // 用户电话
    @JSONField(name="userCreatetime")
    private Date userCreatetime;// 用户注册时间
    @JSONField(name="userUpdatetime")
    private Date userUpdatetime;// 用户最后一次修改时间

    public User() {
        Date date = new Date();
        setUserCreatetime(date);
        setUserUpdatetime(date);
    }

    public User(String userName, Integer userSex, String userAccount, String userPassword, String userMail,
                String userTelephone) {
        this.userName = userName;
        this.userSex = userSex;
        this.userAccount = userAccount;
        this.userPasswordsha256 = userPassword;
        this.userMail = userMail;
        this.userTelephone = userTelephone;
        Date date = new Date();
        setUserCreatetime(date);
        setUserUpdatetime(date);
    }

    public User(String userName, Integer userSex, String userAccount, String userPasswordsha256, String userTelephone) {
        this.userName = userName;
        this.userSex = userSex;
        this.userAccount = userAccount;
        this.userPasswordsha256 = userPasswordsha256;
        this.userTelephone = userTelephone;
        Date date = new Date();
        setUserCreatetime(date);
        setUserUpdatetime(date);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserSex() {
        return userSex;
    }
    public String getUserSexStr() {
        switch (userSex) {
        case 0:
            return "女";
        case 1:
            return "男";
        }
        return "错误";
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPasswordsha256() {
        return userPasswordsha256;
    }

    public void setUserPasswordsha256(String userPassword) {
        this.userPasswordsha256 = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public Date getUserCreatetime() {
        return userCreatetime;
    }

    public void setUserCreatetime(Date userCreatetime) {
        this.userCreatetime = userCreatetime;
    }


    public void setUserUpdatetime(Date userUpdatetime) {
        this.userUpdatetime = userUpdatetime;
    }

    public String getUserCreatetimeStr() {
        if (null != this.userCreatetime) {
            return DateFormat.dataFormatToStr(userCreatetime);
        }
        return null;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public String getUserUpdatetimeStr() {
        if (null != this.userUpdatetime) {
            return DateFormat.dataFormatToStr(userUpdatetime);
        }
        return null;
    }

    public Date getUserUpdatetime() {
        return userUpdatetime;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + ", userAccount="
               + userAccount + ", userPassword=" + userPasswordsha256 + ", userMail=" + userMail + ", userTelephone="
               + userTelephone + ", userCreatetime=" + userCreatetime + ", userUpdatetime=" + userUpdatetime + "]";
    }
}
