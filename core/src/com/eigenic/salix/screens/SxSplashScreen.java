package com.eigenic.salix.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.eigenic.salix.SxGame;
import com.eigenic.salix.assets.SxAsset;
import de.tomgrill.gdxdialogs.core.GDXDialogs;
import de.tomgrill.gdxdialogs.core.GDXDialogsSystem;
import de.tomgrill.gdxdialogs.core.dialogs.GDXProgressDialog;

/**
 * Created by HyunJun on 2016-07-20.
 */
public class SxSplashScreen implements Screen {

    public SxGame game;


    private GDXDialogs dialogs;

    public SxSplashScreen(SxGame game) {
        dialogs = GDXDialogsSystem.getDialogManager();
        this.game = game;
    }

    @Override
    public void show() {

        GDXProgressDialog progressDialog = dialogs.newDialog(GDXProgressDialog.class);

        progressDialog.setTitle("준비 중");
        progressDialog.setMessage("게임 리소스를 최적화하고 있습니다...");

        progressDialog.build().show();

        SxAsset.load();

        progressDialog.dismiss();

        game.setScreen(game.signinScreen);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
