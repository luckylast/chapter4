package com.ozwhver.eight.ancientbritain;

/**
 * Created by kyle on 02/02/2015.
 */
public class MainDataDef {

    int image;
    String name;
    String info;
    // int detailImage;
    // int detailText;
    // String detailWebLink;

    public MainDataDef(int image, String name, String info) {
        this.image = image;
        this.name = name;
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    //public int getDetailImage() {
    //  return detailImage;
    // }

    // public int getDetailText() {
    //    return detailText;
    // }

    // public String getDetailWebLink() {
    //    return detailWebLink;
    // }

}
