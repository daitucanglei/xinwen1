package com.pojo;

public class xiewen {
    private  String xinwen;
    private  String lanmu;

    public xiewen(String xinwen, String lanmu) {
        this.xinwen = xinwen;
        this.lanmu = lanmu;
    }

    public String getXinwen() {
        return xinwen;
    }

    public void setXinwen(String xinwen) {
        this.xinwen = xinwen;
    }

    public String getLanmu() {
        return lanmu;
    }

    public void setLanmu(String lanmu) {
        this.lanmu = lanmu;
    }
    @Override
    public String toString() {
        return "xiewen{" +
                "xinwen='" + xinwen + '\'' +
                ", lanmu='" + lanmu + '\'' +
                '}';
    }
}
