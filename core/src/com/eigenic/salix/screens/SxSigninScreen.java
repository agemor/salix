package com.eigenic.salix.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.eigenic.salix.SxGame;
import com.eigenic.salix.assets.SxAsset;
import de.tomgrill.gdxdialogs.core.GDXDialogs;
import de.tomgrill.gdxdialogs.core.GDXDialogsSystem;
import de.tomgrill.gdxdialogs.core.dialogs.GDXProgressDialog;
import de.tomgrill.gdxdialogs.core.dialogs.GDXTextPrompt;
import de.tomgrill.gdxdialogs.core.listener.TextPromptListener;

/**
 * Created by HyunJun on 2016-07-20.
 */
public class SxSigninScreen implements Screen, Input.TextInputListener {

    public SxGame game;

    public Stage stage;
    private Viewport viewport;

    private Image logoImage;
    private Button signinButton;
    private Button signupButton;


    private GDXDialogs dialogs;

    public SxSigninScreen(SxGame game) {

        // FHD 기준
        viewport = new FitViewport(1920, 1080);
        stage = new Stage(viewport);


        dialogs = GDXDialogsSystem.getDialogManager();

        this.game = game;

    }

    @Override
    public void input(String text) {
    }

    @Override
    public void canceled() {
    }


    @Override
    public void show() {

        logoImage = new Image(new Texture(Gdx.files.internal("salix-logo.png")));

        logoImage.setPosition((viewport.getWorldWidth() - 900) / 2, (viewport.getWorldHeight() - 448) / 2 + 230);

        signupButton = new TextButton("회원가입", SxAsset.skin.get("button",TextButton.TextButtonStyle.class));

        signupButton.setWidth(405);
        signupButton.setHeight(190);

        signupButton.setX((viewport.getWorldWidth() - (405 + 30 + 405)) / 2);
        signupButton.setY(200);

        signupButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
               Gdx.net.openURI("http://eigenic.com");
            }
        });

        signinButton = new TextButton("로그인", SxAsset.skin.get("button",TextButton.TextButtonStyle.class));

        signinButton.setWidth(405);
        signinButton.setHeight(190);

        signinButton.setX((viewport.getWorldWidth() - (405 + 30 + 405)) / 2 + 405 + 30);
        signinButton.setY(200);

        signinButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {

                GDXTextPrompt textPrompt = dialogs.newDialog(GDXTextPrompt.class);

                textPrompt.setTitle("");
                textPrompt.setMessage("아이디를 입력해 주세요.");

                textPrompt.setCancelButtonLabel("취소");
                textPrompt.setConfirmButtonLabel("다음으로");

                textPrompt.setTextPromptListener(new TextPromptListener() {

                    @Override
                    public void confirm(String text) {
                        // do something with the user input
                    }

                    @Override
                    public void cancel() {
                        // handle input cancel
                    }
                });

                textPrompt.build().show();



            }
        });

        Label test = new Label("Salix Engine 2.0.9", new Label.LabelStyle(SxAsset.font.get("NotoSans"), Color.GRAY));
        test.setX(viewport.getWorldWidth() - test.getWidth() - 10);
        test.setY(15);
        stage.addActor(logoImage);
        stage.addActor(test);
        stage.addActor(signupButton);
        stage.addActor(signinButton);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);


        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

        stage.getViewport().update(width, height, false);


        //stage.getViewport().update(width, height, true);
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
