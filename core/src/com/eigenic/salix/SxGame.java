package com.eigenic.salix;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.eigenic.salix.assets.SxAsset;
import com.eigenic.salix.screens.SxSigninScreen;
import com.eigenic.salix.screens.SxSplashScreen;
import de.tomgrill.gdxdialogs.core.GDXDialogsSystem;

public class SxGame extends Game {

    public Screen splashScreen;
    public Screen signinScreen;

    public SxGame() {
    }

    @Override
    public void create() {

        GDXDialogsSystem.install();

        // 에셋 로드


        splashScreen = new SxSplashScreen(this);
        signinScreen = new SxSigninScreen(this);

        setScreen(splashScreen);
    }
}
