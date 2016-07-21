package com.eigenic.salix.world;

import com.eigenic.salix.graphics.SxRenderer;

/**
 * Created by HyunJun on 2016. 7. 21..
 */
public class SxWorld {

    public SxObject object;

    private SxRenderer renderer;

    public SxWorld() {
        object = new SxObject();
        renderer = new SxRenderer();
    }

    public void render(float delta) {
        renderer.render(object, delta);
    }


}
