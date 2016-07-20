package com.eigenic.salix.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HyunJun on 2016-07-20.
 */
public class SxFont {

    /**
     * 폰트 초기 로드를 수행했는지의 여부
     */
    private boolean initialized = false;

    /**
     * 로드된 폰트 저장
     */
    private Map<String, BitmapFont> fonts;

    /**
     * 폰트 로더
     */
    private SxFontLoader fontLoader;

    public SxFont() {
        fonts = new HashMap<String, BitmapFont>();
        fontLoader = new SxFontLoader();
    }

    /**
     * 저장된 폰트 데이터 로드
     *
     * @param fontName
     * @return
     */
    public BitmapFont get(String fontName) {
        return fonts.get(fontName);
    }

    public void load() {
        if (initialized) return;

        loadFont("NotoSans", 45, Gdx.files.internal("fonts/NotoSansKR.otf"));
        loadFont("NotoSansBig", 80, Gdx.files.internal("fonts/NotoSansKR.otf"));

        initialized = true;
    }

    /**
     * 폰트 파일에서 비트맵 폰트 정보 추출
     *
     * @param fontName
     * @param fontFile
     */
    private void loadFont(String fontName, int fontSize, FileHandle fontFile) {

        BitmapFont font = fontLoader.createFont(fontFile, fontName, fontSize);

        fonts.put(fontName, font);
    }

}
