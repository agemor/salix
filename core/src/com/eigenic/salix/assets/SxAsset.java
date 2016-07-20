package com.eigenic.salix.assets;

/**
 * Created by HyunJun on 2016-07-20.
 */
public class SxAsset {

    /**
     * 폰트
     */
    public static SxFont font;

    /**
     * 스킨
     */
    public static SxSkin skin;

    public static void load() {
        font = new SxFont();
        font.load();

        skin = new SxSkin();
        skin.load();
    }

}
