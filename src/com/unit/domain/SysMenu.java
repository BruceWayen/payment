package com.unit.domain;

public class SysMenu {
    private Integer id;

    private Integer menuSuperId;

    private Integer menuStatus;

    private Integer menuSort;

    private String menuName;

    private String menuIconUrl;

    private String menuUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuSuperId() {
        return menuSuperId;
    }

    public void setMenuSuperId(Integer menuSuperId) {
        this.menuSuperId = menuSuperId;
    }

    public Integer getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Integer menuStatus) {
        this.menuStatus = menuStatus;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuIconUrl() {
        return menuIconUrl;
    }

    public void setMenuIconUrl(String menuIconUrl) {
        this.menuIconUrl = menuIconUrl == null ? null : menuIconUrl.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }
}