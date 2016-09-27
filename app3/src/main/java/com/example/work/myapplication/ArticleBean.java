package com.example.work.myapplication;

import java.io.Serializable;

/**
 * Created by home on 2016/9/24.
 */
public class ArticleBean  implements Serializable {

//    id: "19",
//    cid: "1",
//    name: "filetype()",
//    args: "string $path",
//    output: "string",
//    example: "例子",
//    remark: "获取文件类型，$path中不能有中文",
//    hot: "0"
    //id
    private int id;
    //分类id
    private int cid;
    //名称
    private String name;
    //参数
    private String orgs;
    //返回值
    private String output;
    //例子
    private String example;
    //备注
    private String remark;
    //热度
    private int hot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgs() {
        return orgs;
    }

    public void setOrgs(String orgs) {
        this.orgs = orgs;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    @Override
    public String toString() {
        return "ArticleBean{" +
                "id=" + id +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                ", orgs='" + orgs + '\'' +
                ", output='" + output + '\'' +
                ", example='" + example + '\'' +
                ", remark='" + remark + '\'' +
                ", hot=" + hot +
                '}';
    }
}
