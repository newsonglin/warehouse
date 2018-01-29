package com.lin.horse;

public enum HorseLevel {
    TOP("上等马",1),
    MEDIUM("中等马",0),
    LOW("下等马",-1);

    private String levelName;
    private int value;

    HorseLevel(String name, int value) {
        this.levelName = name;
        this.value=value;
    }

    public String levelName() {
        return levelName;
    }

    public int value(){
        return value;
    }
}