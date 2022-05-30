package com.example.spinnerpersonalizado;

public class ItemData {
    private String textCategoria;
    private String textDescripcion;
    private Integer imageId;

    public ItemData (String text1, String text2, Integer imageId){
        this.textCategoria=text1;
        this.textDescripcion=text2;
        this.imageId=imageId;
    }

    public String getTextCategoria(){
        return textCategoria;
    }
    public void setTextCategoria(String text){
        this.textCategoria=text;
    }

    public String getTextDescripcion(){
        return textDescripcion;
    }
    public void setTextDescripcion(String text){
        this.textDescripcion=text;
    }

    public Integer getImageId(){
        return imageId;
    }
    public void setTextImageId (Integer imageId){
        this.imageId=imageId;
    }
}
