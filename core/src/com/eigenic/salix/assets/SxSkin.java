package com.eigenic.salix.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by HyunJun on 2016-07-21.
 */
public class SxSkin extends Skin {

    public SxSkin() {

    }

    public void load() {
        this.add("button-up", new Texture(Gdx.files.internal("salix-button-up.png")));
        this.add("button-down", new Texture(Gdx.files.internal("salix-button-down.png")));


        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = getDrawable("button-up");
        textButtonStyle.down = getDrawable("button-down");
        textButtonStyle.font = SxAsset.font.get("NotoSansBig");
        textButtonStyle.fontColor = Color.GRAY;
        textButtonStyle.downFontColor = Color.WHITE;

        this.add("button", textButtonStyle, TextButton.TextButtonStyle.class);

    }

}
