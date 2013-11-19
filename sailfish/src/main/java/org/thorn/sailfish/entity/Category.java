package org.thorn.sailfish.entity;

/**
 * @Author: yfchenyun
 * @Since: 2013-10-30 13:58:11
 * @Version: 1.0
 */
public class Category {

    /**
     * 英文名称
     */
    private String enName;

    /**
     * 中文名称
     */
    private String cnName;

    /**
     * 访问路径
     */
    private String path;

    /**
     * 排序号
     */
    private Integer sort;

    /**
     * 上级分类
     */
    private String parent;

    /**
     * 文章模板
     */
    private String articleTemplate;

    /**
     * 栏目首页模板
     */
    private String indexTemplate;


    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getEnName() {
            return this.enName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
            return this.cnName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
            return this.path;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {
            return this.sort;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParent() {
            return this.parent;
    }

    public void setArticleTemplate(String articleTemplate) {
        this.articleTemplate = articleTemplate;
    }

    public String getArticleTemplate() {
            return this.articleTemplate;
    }

    public void setIndexTemplate(String indexTemplate) {
        this.indexTemplate = indexTemplate;
    }

    public String getIndexTemplate() {
            return this.indexTemplate;
    }

}